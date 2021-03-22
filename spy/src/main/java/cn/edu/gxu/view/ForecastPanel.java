package cn.edu.gxu.view;

import cn.edu.gxu.config.MainConfig;
import cn.edu.gxu.persist.CacheManager;
import cn.edu.gxu.pojo.*;
import cn.edu.gxu.stat.orderStat;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.view
 * @date 2021/3/22 10:09
 * @Description 经营预测, 第一年预测值与实际值差异比率太大，不进行经营预测
 */
public class ForecastPanel extends JPanel {

    private String[] vName = {"组名", "上一年权益", "上一年资金", "毛利", "可贷款额度", "财务支出", "滞留产品", "预计权益", "最大剩余资金"};

    private static String year;

    public ForecastPanel(String key) {
        year = key;
        String last_year = getLastYear(year);
        List<GroupScoresPo> scores = CacheManager.getScore(last_year);
        if (scores == null) {
            JOptionPane.showMessageDialog(this, "缺少上一年度的经营数据，无法预测", "经营预测失败",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
//        分数已经有序
        ForecastPo[] profitData = scores.stream()
                .map(profitDao -> {
                    ForecastPo forecast = new ForecastPo();
                    forecast.setGroupName(profitDao.getGroupName());
                    forecast.setLastYearRights(profitDao.getGroupRights());
                    return forecast;
                })
                .toArray(ForecastPo[]::new);

        Map<String, ProfitDao> profitMap = orderStat.calProfit(year);
        if (profitMap.size() == 0) {
            JOptionPane.showMessageDialog(this, "缺少年度订单信息，无法预测", "经营预测失败",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (ForecastPo forecast : profitData) {
            SpyPo spyPo = CacheManager.getSpy(forecast.getGroupName());
            if (spyPo == null) continue;

            forecast.setLastYearCash(spyPo.getCash());
            ProfitDao profitDao = profitMap.get(forecast.getGroupName());
            if (profitDao != null)
                forecast.setProfit(profitDao.getProfit());
//            剩余贷款额度
            forecast.setRemainTemLoan(CacheManager.getConfig().getLoanTimes() * profitDao.getProfit() - (spyPo.getShorttemLoan() + spyPo.getLongtermLoan()));
//             预计滞留产品
            int totalNum = (int) (spyPo.getProdLine().getQzd() * (360 / (float) CacheManager.getConfig().getQzdProductTimes())
                    + spyPo.getProdLine().getRx() * (360 / (float) CacheManager.getConfig().rxProductTimes)
                    + spyPo.getProdLine().getRx() * (360 / (float) CacheManager.getConfig().sgxProductTimes));
            forecast.setRemainProduct(totalNum - profitDao.getNum());

            Finance finance = new Finance();
            finance.setAdministration(CacheManager.getConfig().administration);
            finance.setDepreciation(spyPo.getProdLine().getRx() * CacheManager.getConfig().rxDepreciation
                    + spyPo.getProdLine().getQzd() * CacheManager.getConfig().qzdDepreciation
                    + spyPo.getProdLine().getSgx() * CacheManager.getConfig().sgxDepreciation);
            finance.setInterest((int) (spyPo.getLongtermLoan() * MainConfig.longLoanRate + spyPo.getShorttemLoan() * MainConfig.shortLoanRate));
            finance.setUpkeep(spyPo.getProdLine().getRx() * CacheManager.getConfig().rxUpKeep
                    + spyPo.getProdLine().getQzd() * CacheManager.getConfig().qzdUpKeep
                    + spyPo.getProdLine().getSgx() * CacheManager.getConfig().sgxUpKeep);
            forecast.setFinance(finance);
            forecast.calForecastRights();
            forecast.calRemainMaxCash();
        }

        Object[][] data = Arrays.stream(profitData)
                .map(forecast -> {
                    Object[] row = new Object[vName.length];
                    row[0] = forecast.getGroupName();
                    row[1] = forecast.getLastYearRights();
                    row[2] = forecast.getLastYearCash();
                    row[3] = forecast.getProfit();
                    row[4] = forecast.getRemainTemLoan();
                    row[5] = forecast.getFinance().sum();
                    row[6] = forecast.getRemainProduct();
                    row[7] = forecast.getForecastRights();
                    row[8] = forecast.getRemainMaxCash();
                    return row;
                })
                .toArray(Object[][]::new);
        loadTable(data);
    }

    private String getLastYear(String year) {
        int idx = Arrays.binarySearch(MainConfig.RUN_YEAR, year);
        return idx > 0 ? MainConfig.RUN_YEAR[idx - 1] : null;
    }


    private void loadTable(Object[][] data) {
        if (data == null) return;

        TableModel table = new TableModel(data, vName);
//        table.setEnabled(false);
//        DefaultTableColumnModel thr = new DefaultTableColumnModel();
//        thr.setColumnSelectionAllowed(JLabel.CENTER);
//        table.getTableHeader().setDefaultRenderer(thr);

//        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
//        r.setHorizontalAlignment(JLabel.RIGHT);
//        table.setDefaultRenderer(Object.class, r);
//        table.setRowHeight(25);// 设置表格行高
//        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        table.getTableHeader().setFont(new Font("Dialog", 0, 14));
//        table.setFont(new Font("Menu.font", Font.PLAIN, 15));

        for (int i = 1; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setPreferredWidth(130);
        }

        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(60, 60, 800, 600);
        add(jp);
    }
}
