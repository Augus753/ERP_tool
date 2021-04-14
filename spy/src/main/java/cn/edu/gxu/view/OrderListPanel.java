package cn.edu.gxu.view;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.view
 * @date 2021/3/18 11:56
 * @Description 间谍
 */

import cn.edu.gxu.collect.CollectManager;
import cn.edu.gxu.constant.Constant;
import cn.edu.gxu.constant.enums;
import cn.edu.gxu.persist.CacheManager;
import cn.edu.gxu.pojo.OrderPo;
import cn.edu.gxu.pojo.ProfitDao;
import cn.edu.gxu.stat.JsonParser;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class OrderListPanel extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private Object[][] data;
    private JScrollPane faceTable = null;

    private String[] vName = {"市场", "单号", "组号", "产品", "数量", "单价", "应交货期", "账期", "违约"};
    private static final boolean[] editableVName = new boolean[]{false, false, false, false, false, false, false, false, true};
    private String[] vProfitName = {"组名", "销售额", "利润", "排名"};
    private String[] vShareName = {"组名", "本地", "区域", "国内", "亚洲", "国际"};
    private String[] vProductNumName = {"组名", "产品", "本地", "区域", "国内", "亚洲", "国际", "总数"};

    JTextField orderTf = new JTextField("请输入订单json报文");

    JButton orderButton = new JButton("添加订单");
    private JPanel optionJp = new JPanel();    //创建面板
    private JPanel numOptionJp = new JPanel();    //创建面板

    JButton orderListButton = new JButton("订单列表");
    JButton profitButton = new JButton("毛利");
    JButton marketShareButton = new JButton("市场份额");
    JButton productNumButton = new JButton("产品数量");
    JButton deliveryMonthNumButton = new JButton("交货期数量");

    Font cmbFont = new Font("黑体", Font.BOLD, 14);
    Font font = new Font("黑体", Font.PLAIN, 14);
    private String defaultMarketCmd = "所有市场";
    private String defaultProductCmd = "所有产品";
    private String defaultGroupCmd = "所有组";
    private String defaultMonthCmd = "所有月";
    private String defaultBreach = "违约情况";
    private static String year;

    public OrderListPanel(String year) {
        OrderListPanel.year = year;
//        this.setBounds(0, 0, 1200, 700);

        this.setBounds(0, 0, 1100, 700);
        this.setLayout(null);


        JLabel yearLabel = new JLabel(year);
        yearLabel.setFont(new Font("黑体", Font.PLAIN, 26));
        yearLabel.setBounds(30, 0, 100, 60);

        {//添加订单
            orderTf.setBounds(200, 0, 300, 50);
            // 给文本框加上鼠标单击事件监听
            orderTf.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // TODO Auto-generated method stub
                    orderTf.setText("");
                }
            });
            orderButton.setBounds(550, 0, 100, 50);
            orderButton.setFont(font);
            // 给按钮加上监听
            orderButton.addActionListener(e -> {
                String s = orderTf.getText().trim();
                addOrder(s);
            });
            drawOrderListOptionCmb();
            drawOrderNumOptionCmb();

        }
        {
            //订单列表
            orderListButton.setBounds(0, 100, 100, 80);
            orderListButton.setFont(font);
            orderListButton.setOpaque(false); // 设置为透明
            // 给按钮加上监听
            orderListButton.addActionListener(e -> {
                loadTable(data, vName);
            });
        }
        {
            //毛利
            profitButton.setBounds(0, 180, 100, 80);
            profitButton.setFont(font);
            orderListButton.setOpaque(false); // 设置为透明

            // 给按钮加上监听
            profitButton.addActionListener(e -> {
                showProfit();
            });
        }
        {
            //市场销售额占比
            marketShareButton.setBounds(0, 260, 100, 80);
            marketShareButton.setFont(font);
            // 给按钮加上监听
            marketShareButton.addActionListener(e -> {
                showMarketShare();
            });
        }
        {
            //市场订单数量占比
            productNumButton.setBounds(0, 340, 100, 80);
            productNumButton.setFont(font);
            // 给按钮加上监听
            productNumButton.addActionListener(e -> {
                showProductNum(data, enums.Product.values());
            });

            //市场订单数量占比
            deliveryMonthNumButton.setBounds(0, 420, 100, 80);
            deliveryMonthNumButton.setFont(font);
            // 给按钮加上监听
            deliveryMonthNumButton.addActionListener(e -> {
                showDeliveryMonthNum(enums.Product.values());
            });
        }

        {
            //市场销售额占比
            marketShareButton.setBounds(0, 260, 100, 80);
            marketShareButton.setFont(font);
            // 给按钮加上监听
            marketShareButton.addActionListener(e -> {
                showMarketShare();
            });
        }

        reloadData();

        this.add(yearLabel);
        this.add(orderTf);
        this.add(orderButton);
        this.add(orderListButton);
        this.add(profitButton);
        this.add(marketShareButton);
        this.add(productNumButton);
        this.setVisible(true);
    }

    private void showDeliveryMonthNum(enums.Product[] values) {
        List<OrderPo> orders = CacheManager.getOrder(year);
//        MONTH_NAME
//                组名_产品名称_月份
    }

    private void drawOrderNumOptionCmb() {
        //市场下拉框
        JComboBox cmb = new JComboBox();    //创建JComboBox
        cmb.addItem(defaultProductCmd);    //向下拉列表中添加一项
        for (enums.Product m : enums.Product.values()) {
            cmb.addItem(m.product);
        }
        cmb.setBounds(0, 0, 100, 10);
        numOptionJp.add(cmb);
        numOptionJp.setVisible(false);
        numOptionJp.setBounds(100, 60, 600, 30);
        this.add(numOptionJp);
        // 给按钮加上监听
        cmb.addActionListener(e -> {
            filterOrderNumTable(cmb.getSelectedItem().toString());
        });
    }

    private void filterOrderNumTable(String product) {
        Object[][] filterDatas = Arrays.stream(data)
                .filter(objects -> defaultProductCmd.equals(product) || product.equals(objects[3])
                ).toArray(Object[][]::new);
        enums.Product[] aa;
        if (defaultProductCmd.equals(product)) {
            aa = enums.Product.values();
        } else {
            aa = new enums.Product[]{enums.Product.exchange(product)};
        }
        showProductNum(filterDatas, aa);
    }

    private void drawOrderListOptionCmb() {
        //[市场，]
        String[] filterCmd = new String[]{defaultMarketCmd, defaultProductCmd, defaultGroupCmd, defaultMonthCmd, null, defaultBreach};
        {
            //市场下拉框
            JComboBox cmb = new JComboBox();    //创建JComboBox
            cmb.addItem(defaultMarketCmd);    //向下拉列表中添加一项
            for (enums.Market m : enums.Market.values()) {
                cmb.addItem(m.marketName);
            }
            cmb.setBounds(0, 0, 100, 10);
            optionJp.add(cmb);
            // 给按钮加上监听
            cmb.addActionListener(e -> {
                filterCmd[0] = Objects.requireNonNull(cmb.getSelectedItem()).toString();
                filterOrderTable(filterCmd);
            });
        }
        //产品下拉框
        {
            //市场下拉框
            JComboBox cmb = new JComboBox();    //创建JComboBox
            cmb.addItem(defaultProductCmd);    //向下拉列表中添加一项
            for (enums.Product m : enums.Product.values()) {
                cmb.addItem(m.product);
            }
            cmb.setBounds(20, 0, 100, 10);
            optionJp.add(cmb);
            // 给按钮加上监听
            cmb.addActionListener(e -> {
                filterCmd[1] = Objects.requireNonNull(cmb.getSelectedItem()).toString();
                filterOrderTable(filterCmd);
            });
        }
        {
            //组下拉框
            JComboBox cmb = new JComboBox();    //创建JComboBox
            cmb.addItem(defaultGroupCmd);    //向下拉列表中添加一项
            for (String g : CacheManager.getConfig().getGroupNames()) {
                cmb.addItem(g);
            }
            cmb.setBounds(30, 0, 100, 10);
            optionJp.add(cmb);
            // 给按钮加上监听
            cmb.addActionListener(e -> {
                filterCmd[2] = Objects.requireNonNull(cmb.getSelectedItem()).toString();
                filterOrderTable(filterCmd);
            });
        }
        {
            //交货期下拉框
            JComboBox cmb = new JComboBox();    //创建JComboBox
            cmb.addItem(defaultMonthCmd);    //向下拉列表中添加一项
            for (String g : Constant.MONTH_NAME) {
                cmb.addItem(g);
            }
            cmb.setBounds(30, 0, 100, 10);
            optionJp.add(cmb);
            // 给按钮加上监听
            cmb.addActionListener(e -> {
                filterCmd[3] = Objects.requireNonNull(cmb.getSelectedItem()).toString();
                filterOrderTable(filterCmd);
            });
        }
        {
            //输入框订单号匹配
            JTextField orderNumberTf = new JTextField("输入订单号", 15);
            orderNumberTf.setBounds(40, 0, 100, 40);
            optionJp.add(orderNumberTf);
            // 给文本框加上鼠标单击事件监听
            orderNumberTf.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // TODO Auto-generated method stub
                    orderNumberTf.setText("");
                }
            });
            // 给按钮加上监听
            orderNumberTf.getDocument().addDocumentListener(new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    filterCmd[4] = Objects.requireNonNull(orderNumberTf.getText().trim());
                    filterOrderTable(filterCmd);
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    filterCmd[4] = Objects.requireNonNull(orderNumberTf.getText().trim());
                    filterOrderTable(filterCmd);
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    filterCmd[4] = Objects.requireNonNull(orderNumberTf.getText().trim());
                    filterOrderTable(filterCmd);
                }
            });
        }
        {
            //是否违约下拉框
            JComboBox cmb = new JComboBox();    //创建JComboBox
            cmb.addItem(defaultBreach);    //向下拉列表中添加一项
            cmb.addItem("违约");
            cmb.addItem("不违约");
            cmb.setBounds(30, 0, 100, 10);
            optionJp.add(cmb);
            // 给按钮加上监听
            cmb.addActionListener(e -> {
                filterCmd[5] = Objects.requireNonNull(cmb.getSelectedItem()).toString();
                filterOrderTable(filterCmd);
            });
        }
        optionJp.setFont(cmbFont);
//        optionJp.setForeground(Color.red);//设置字体颜色
        optionJp.setBounds(100, 60, 600, 30);
        optionJp.setVisible(true);
        this.add(optionJp);
    }

    private void filterOrderTable(String[] filterCmd) {
        System.out.println("过滤条件：" + Arrays.toString(filterCmd));
        Object[][] filterData = Arrays.stream(data)
                .filter(objects -> {
                    boolean flag = true;
                    if (!defaultMarketCmd.equals(filterCmd[0])) {
                        flag = filterCmd[0].equals(objects[0]);
                    }
                    if (flag & !defaultProductCmd.equals(filterCmd[1])) {
                        flag = filterCmd[1].equals(objects[3]);
                    }
                    if (flag & !defaultGroupCmd.equals(filterCmd[2])) {
                        flag = filterCmd[2].equals(objects[2]);
                    }
                    if (flag & !defaultMonthCmd.equals(filterCmd[3])) {
                        String month = objects[6].toString().split("月")[0];
                        String[] monthCondition = filterCmd[3].split("，");
                        flag = StringUtils.equalsAny(month, monthCondition[0], monthCondition[1]);
                    }
                    if (flag & StringUtils.isNotEmpty(filterCmd[4])) {
                        flag = StringUtils.containsIgnoreCase(objects[1].toString(), filterCmd[4]);
                    }
                    if (flag & !defaultBreach.equals(filterCmd[5])) {
                        if ("违约".equals(filterCmd[5])) {
                            flag = (boolean) objects[8];
                        } else {
                            flag = !(boolean) objects[8];
                        }
                    }
                    return flag;
                })
                .toArray(Object[][]::new);
        loadTable(filterData, vName);
    }

    private void showProductNum(Object[][] data, enums.Product[] products) {
        if (data == null) {
            JOptionPane.showMessageDialog(null, "请输入的订单数据", "输入错误",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        Map<String, ProfitDao> numMap = new HashMap<>();//<市场_组名_产品,v>
        Map<String, ProfitDao> squenceMap = new HashMap<>();//<组名_产品,v>
        Map<String, ProfitDao> shareSequenceData = new HashMap<>();//记录顺序
        System.out.println("违约情况：" + data[0][8]);
        for (Object[] row : data) {
            //市场_组名_产品
            String marketName = row[0] + "";
            String groupName = row[2] + "";
            String productName = row[3] + "";
            String key = groupName + "_" + marketName + "_" + productName;
            ProfitDao p = numMap.getOrDefault(key, new ProfitDao());
            p.setGroupName(groupName);
            int num = NumberUtils.toInt(row[4] + "");
            p.setMarketName(marketName);
            p.setSales(p.getSales() + num);
            p.setProductName(productName);
            numMap.put(key, p);

            String key2 = groupName + "_" + productName;
            ProfitDao p2 = squenceMap.getOrDefault(key2, new ProfitDao());
            p2.setGroupName(groupName);
            p2.setSales(p2.getSales() + num);
            p2.setProductName(productName);
            squenceMap.put(key2, p2);

            ProfitDao p3 = shareSequenceData.getOrDefault(groupName, new ProfitDao());
            p3.setSales(p3.getSales() + num * NumberUtils.toInt(row[5] + ""));
            p3.setGroupName(groupName);
            shareSequenceData.put(groupName, p3);
        }

        String[] sequenceGroupName = shareSequenceData.values().stream()
                .filter(p -> p.getSales() > 0)
                .sorted((o1, o2) -> o2.getSales() - o1.getSales())
                .map(ProfitDao::getGroupName)
                .toArray(String[]::new);
        int num = (int) squenceMap.values().stream().filter(p -> p.getSales() > 0).count();
        Object[][] productData = new Object[num][vProductNumName.length];
        int groupNameIdx = 0;
        boolean firstGroupName = true;
        for (int i = 0; i < num; ) {
            for (enums.Product product : products) {
                String key1 = sequenceGroupName[groupNameIdx] + "_" + enums.Market.LOCAL_MARKET_1.marketName + "_" + product.product;
                ProfitDao p1 = numMap.get(key1);

                String key2 = sequenceGroupName[groupNameIdx] + "_" + enums.Market.REGIONAL_MARKET_2.marketName + "_" + product.product;
                ProfitDao p2 = numMap.get(key2);

                String key3 = sequenceGroupName[groupNameIdx] + "_" + enums.Market.DOMESTIC_MARKET_3.marketName + "_" + product.product;
                ProfitDao p3 = numMap.get(key3);

                String key4 = sequenceGroupName[groupNameIdx] + "_" + enums.Market.ASIA_MARKET_4.marketName + "_" + product.product;
                ProfitDao p4 = numMap.get(key4);

                String key5 = sequenceGroupName[groupNameIdx] + "_" + enums.Market.GLOBAL_MARKET_5.marketName + "_" + product.product;
                ProfitDao p5 = numMap.get(key5);

                int totalNum = (p1 == null ? 0 : p1.getSales())
                        + (p2 == null ? 0 : p2.getSales())
                        + (p3 == null ? 0 : p3.getSales())
                        + (p4 == null ? 0 : p4.getSales())
                        + (p5 == null ? 0 : p5.getSales());
                if (totalNum == 0 || i >= productData.length) {
                    continue;
                }
                if (firstGroupName) {
                    productData[i][0] = sequenceGroupName[groupNameIdx];
                }
                productData[i][1] = product.product;
                productData[i][2] = p1 == null ? 0 : p1.getSales();
                productData[i][3] = p2 == null ? 0 : p2.getSales();
                productData[i][4] = p3 == null ? 0 : p3.getSales();
                productData[i][5] = p4 == null ? 0 : p4.getSales();
                productData[i][6] = p5 == null ? 0 : p5.getSales();
                productData[i][7] = (p1 == null ? 0 : p1.getSales())
                        + (p2 == null ? 0 : p2.getSales())
                        + (p3 == null ? 0 : p3.getSales())
                        + (p4 == null ? 0 : p4.getSales())
                        + (p5 == null ? 0 : p5.getSales());
                i++;
                firstGroupName = false;
            }
            firstGroupName = true;
            groupNameIdx++;
        }
        loadTable(productData, vProductNumName);
        numOptionJp.setVisible(true);

    }

    private void showMarketShare() {
        if (data == null) {
            JOptionPane.showMessageDialog(null, "请输入的订单数据", "输入错误",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        Map<String, ProfitDao> shareMap = new HashMap<>();//<市场_组名,v>
        Map<String, ProfitDao> shareSequenceData = new HashMap<>();//记录顺序
        Map<String, Integer> marketData = new HashMap<>();//记录市场总额

        for (Object[] row : data) {
            //市场_组名
            String groupName = row[2] + "";
            String marketName = row[0] + "";
            String key = groupName + "_" + marketName;
            ProfitDao p = shareMap.getOrDefault(key, new ProfitDao());
            p.setGroupName(groupName);
            int totalPrice = NumberUtils.toInt(row[4] + "") * NumberUtils.toInt(row[5] + "");
            p.setMarketName(marketName);
            if (!(boolean) row[8]) {//违约单不计入市场份额
                p.setSales(p.getSales() + totalPrice);
            }
            shareMap.put(key, p);

            ProfitDao p2 = shareSequenceData.getOrDefault(groupName, new ProfitDao());
            if (!(boolean) row[8]) {//违约单不计入市场份额
                p2.setSales(p2.getSales() + totalPrice);
            }
            p2.setGroupName(groupName);
            shareSequenceData.put(groupName, p2);

            int marketPrice = marketData.getOrDefault(marketName, 0);
            if (!(boolean) row[8]) {//违约单不计入市场份额
                marketPrice += totalPrice;
            }
            marketData.put(marketName, marketPrice);
        }
        String[] sequenceGroupName = shareSequenceData.values().stream()
                .sorted((o1, o2) -> o2.getSales() - o1.getSales())
                .map(ProfitDao::getGroupName)
                .toArray(String[]::new);
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");

        Object[][] shareData = Arrays.stream(sequenceGroupName).map(groupName -> {
            Object[] group = new Object[6];
            group[0] = groupName;
//            销售额
//            group[1] = shareMap.getOrDefault(groupName + "_" + enums.Market.LOCAL_MARKET.marketName, new ProfitDao()).getSales();
//            group[2] = shareMap.getOrDefault(groupName + "_" + enums.Market.REGIONAL_MARKET.marketName, new ProfitDao()).getSales();
//            group[3] = shareMap.getOrDefault(groupName + "_" + enums.Market.DOMESTIC_MARKET.marketName, new ProfitDao()).getSales();
//            group[4] = shareMap.getOrDefault(groupName + "_" + enums.Market.ASIA_MARKET.marketName, new ProfitDao()).getSales();
//            group[5] = shareMap.getOrDefault(groupName + "_" + enums.Market.GLOBAL_MARKET.marketName, new ProfitDao()).getSales();
//            销售额占比
            ProfitDao p1 = shareMap.get(groupName + "_" + enums.Market.LOCAL_MARKET_1.marketName);
            group[1] = p1 == null ? 0 : df.format(p1.getSales() / (float) marketData.get(p1.getMarketName()));
            ProfitDao p2 = shareMap.get(groupName + "_" + enums.Market.REGIONAL_MARKET_2.marketName);
            group[2] = p2 == null ? 0 : df.format(p2.getSales() / (float) marketData.get(p2.getMarketName()));
            ProfitDao p3 = shareMap.get(groupName + "_" + enums.Market.DOMESTIC_MARKET_3.marketName);
            group[3] = p3 == null ? 0 : df.format(p3.getSales() / (float) marketData.get(p3.getMarketName()));
            ProfitDao p4 = shareMap.get(groupName + "_" + enums.Market.ASIA_MARKET_4.marketName);
            group[4] = p4 == null ? 0 : df.format(p4.getSales() / (float) marketData.get(p4.getMarketName()));
            ProfitDao p5 = shareMap.get(groupName + "_" + enums.Market.GLOBAL_MARKET_5.marketName);
            group[5] = p5 == null ? 0 : df.format(p5.getSales() / (float) marketData.get(p5.getMarketName()));
            return group;
        }).toArray(Object[][]::new);

        loadTable(shareData, vShareName);
    }

    private void showProfit() {
        if (data == null) {
            JOptionPane.showMessageDialog(null, "请输入的订单数据", "输入错误",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        //这代码看的好难受
        Map<String, ProfitDao> profitDaos = new HashMap<>();
        for (Object[] row : data) {
            ProfitDao p = profitDaos.getOrDefault(row[2], new ProfitDao());
            p.setGroupName(row[2] + "");
            if (!(boolean) row[8]) {//违约单不计入市场份额
                int num = NumberUtils.toInt(row[4] + "");
                int price = NumberUtils.toInt(row[5] + "");
                p.setSales(p.getSales() + num * price);
                p.setProfit(p.getProfit() + (price - CacheManager.getConfig().getCost(row[3] + "")) * num);
            }
            profitDaos.put(p.getGroupName(), p);
        }
        AtomicInteger i = new AtomicInteger();
        Object[][] profitData = profitDaos.values().stream()
                .sorted((o1, o2) -> o2.getProfit() - o1.getProfit())
                .map(profitDao -> {
                    Object[] group = new Object[4];
                    group[0] = profitDao.getGroupName();
                    group[1] = profitDao.getSales();
                    group[2] = profitDao.getProfit();
                    group[3] = i.getAndIncrement() + 1;
                    return group;
                }).toArray(Object[][]::new);

        loadTable(profitData, vProfitName);
    }

    private void reloadData() {
        loadOrderList();
        loadTable(data, vName);
    }

    private void addOrder(String text) {
        //文本框输入
        System.out.println("输入框：" + text);

        List<OrderPo> orderPos;
        try {
            orderPos = new JsonParser().parseOrder(text);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "输入的订单数据错误", "输入错误",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
//        年
        CollectManager.getInstance().record(year + "_订单", text);

        CacheManager.setOrder(year, orderPos);
        loadOrderList();
        loadTable(data, vName);
    }

    private void loadOrderList() {
        List<OrderPo> orderPos = CacheManager.getOrder(year);
        if (orderPos == null || orderPos.size() == 0) return;

        //        "市场", "单号", "组号", "产品", "数量", "单价", "应交货期", "账期"
        data = new Object[orderPos.size()][vName.length];
        for (int j = 0; j < orderPos.size(); j++) {
            OrderPo orderPo = orderPos.get(j);
            data[j][0] = orderPo.getsSysId();
            data[j][1] = orderPo.getpOrderNum();
            data[j][2] = orderPo.getOrderResult();
            data[j][3] = orderPo.getpSysId();
            data[j][4] = orderPo.getMyOrderCount();
            data[j][5] = orderPo.getpPerFee();
            data[j][6] = String.format("%s月%s日", orderPo.getpDeliveryMonth(), orderPo.getpDeliveryDay());
            data[j][7] = orderPo.getpPaymentTerm();
            data[j][8] = orderPo.isBreach();
        }
    }

    private void loadTable(Object[][] data, String[] vName) {
        if (data == null) return;
//        JTable table = new JTable(data, vName);
//        table.setEnabled(false);
//        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
//        r.setHorizontalAlignment(JLabel.CENTER);
//        table.setDefaultRenderer(Object.class, r);
//        table.setRowHeight(25);// 设置表格行高
//        table.getTableHeader().setFont(new Font("Dialog", 0, 14));
//        table.setFont(new Font("Menu.font", Font.PLAIN, 13));


        JTable table = new TableModel(data, vName);
        if (vName.length == this.vName.length) {
            DefineTableModel model = new DefineTableModel(data, vName);
            table = new TableModel(model, editableVName);

//            处理违约复选框
            JTable finalTable = table;
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {//仅当鼠标单击时响应
                    //得到选中的行列的索引值
                    int r = finalTable.getSelectedRow();
                    int c = finalTable.getSelectedColumn();
                    if (c == 8) {
                        //得到选中的单元格的值，表格中都是字符串
                        Object value = finalTable.getValueAt(r, c);
//                        String info = r + "行" + c + "列值 : " + value.toString();
                        List<OrderPo> orderPos = CacheManager.getOrder(year);
                        for (OrderPo order : orderPos) {
                            if (data[r][1].equals(order.getpOrderNum()) && data[r][2].equals(order.getOrderResult())) {
                                order.setBreach((Boolean) value);
                                break;
                            }
                        }
                    }
                }
            });
        }


        JScrollPane jp = new JScrollPane(table);
        jp.setBounds(100, 100, 1000, 580);
        if (faceTable != null) {
            this.remove(faceTable);
            if (vName == this.vName) {
                optionJp.setVisible(true);
            } else optionJp.setVisible(false);
        }
        numOptionJp.setVisible(false);

        // 匿名内部类调用this 需要类名的this
        OrderListPanel.this.add(jp, jp);
        faceTable = jp;
    }
}
