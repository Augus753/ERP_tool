package cn.edu.gxu.view;

import cn.edu.gxu.constant.Constant;
import cn.edu.gxu.constant.Constant;
import cn.edu.gxu.persist.CacheManager;
import cn.edu.gxu.pojo.*;
import cn.edu.gxu.stat.orderStat;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static cn.edu.gxu.constant.enums.ProdLine;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.view
 * @date 2021/3/22 10:09
 * @Description 经营预测, 第一年预测值与实际值差异比率太大，不进行经营预测
 */
public class ForecastPanel extends JPanel {

    private String[] vName = {"组名", "上一年权益", "上一年资金", "毛利", "可贷款额度", "财务支出", "最大滞留产品", "预计权益", "最大剩余资金"};

//    private static String year;

    public ForecastPanel(String year) {
        this.setBounds(0, 0, 1200, 610);
        this.setLayout(null);

//        year = key;
        String last_year = getLastYear(year);
        List<GroupScoresPo> scores = CacheManager.getScore(last_year);
        if (scores == null) {
            JOptionPane.showMessageDialog(this, "缺少上一年度的经营数据，无法预测." + last_year, "经营预测失败",
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
        if (profitMap == null || profitMap.size() == 0) {
            JOptionPane.showMessageDialog(this, "缺少" + year + "订单信息，无法预测", "经营预测失败",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (ForecastPo forecast : profitData) {
            String spyKey = CacheManager.generateGroupKey(last_year, forecast.getGroupName());
            SpyPo spyPo = CacheManager.getSpy(spyKey);
            if (spyPo == null) continue;

            forecast.setLastYearCash(spyPo.getCash());
            ProfitDao profitDao = profitMap.get(forecast.getGroupName());
            if (profitDao == null)
                profitDao = new ProfitDao();
            forecast.setProfit(profitDao.getProfit());

            forecast.setRemainTemLoan(
                    Math.max(CacheManager.getConfig().getLoanTimes() * forecast.getLastYearRights() - (spyPo.getShorttemLoan() + spyPo.getLongtermLoan()), 0));
//             预计滞留产品
            int totalNum = spyPo.getProdLine().getQzd() * (360 / CacheManager.getConfig().getQzdProductTimes())
                    + spyPo.getProdLine().getRx() * (360 / CacheManager.getConfig().rxProductTimes)
                    + spyPo.getProdLine().getSgx() * (360 / CacheManager.getConfig().sgxProductTimes);
            forecast.setRemainProduct(totalNum - profitDao.getNum());

            Finance finance = new Finance();
            finance.setAdministration(CacheManager.getConfig().administration);


            Map<String, Integer> lines = spyPo.getProdLine().CompletedNum();
            if (lines != null && lines.size() > 0) {
                finance.setDepreciation((int) (lines.getOrDefault(ProdLine.RX_X4.name, 0) * CacheManager.getConfig().rxDepreciation
                        + lines.getOrDefault(ProdLine.QZD_X3.name, 0) * CacheManager.getConfig().qzdDepreciation
                        + lines.getOrDefault(ProdLine.SGX_X1.name, 0) * CacheManager.getConfig().sgxDepreciation));
            }

            finance.setInterest((int) (spyPo.getLongtermLoan() * Constant.longLoanRate + spyPo.getShorttemLoan() * Constant.shortLoanRate));
            finance.setUpkeep(spyPo.getProdLine().getRx() * CacheManager.getConfig().rxUpKeep
                    + spyPo.getProdLine().getQzd() * CacheManager.getConfig().qzdUpKeep
                    + spyPo.getProdLine().getSgx() * CacheManager.getConfig().sgxUpKeep);
            finance.setFactoryRent(CacheManager.getConfig().getFactoryRent() * spyPo.getFactory().rentNum);
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
                    if (forecast.getFinance() == null) return row;
                    row[5] = forecast.getFinance().sumRight();
                    row[6] = forecast.getRemainProduct();
                    row[7] = forecast.getForecastRights();
                    row[8] = forecast.getRemainMaxCash();
                    return row;
                })
                .toArray(Object[][]::new);
        loadTable(data);
        this.setVisible(true);
    }

    private String getLastYear(String year) {
        for (int i = 1; i < Constant.RUN_YEAR.length; i++) {
            if (Constant.RUN_YEAR[i].equals(year))
                return Constant.RUN_YEAR[i - 1];
        }
        return null;
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
        jp.setBounds(50, 10, 1000, 600);
        add(jp);
    }
}
