package cn.edu.gxu.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.view
 * @date 2021/3/17 22:56
 * @Description
 */
public class AdvertPanel extends JPanel implements ActionListener {

    private int year;

    private JTextField advertText;
    private JButton searchBtn;
    private JTable advertResult;
    private Vector vFilecolumnNames1;
    private Vector vSearchFileData;
    private DefaultTableModel model1;

    public AdvertPanel(int year) {
        this.year = year;
        setBounds(10, 10, 900, 700);
        init();
    }


    public void init() {
        JLabel keywordInputLabel = new JLabel("广告信息：");
        keywordInputLabel.setBounds(20, 20, 80, 25);
        this.add(keywordInputLabel);

        advertText = new JTextField();
        advertText.setBounds(20, 40, 180, 300);
        this.add(advertText);

        searchBtn = new JButton("生成");
        searchBtn.setBounds(60, 350, 60, 30);
        searchBtn.addActionListener(this);
        this.add(searchBtn);

//        JPanel panel = new JPanel(new BorderLayout());
//        panel.setBounds(100, 50, 900, 700);
        // 设置表格内容颜色
        vSearchFileData = new Vector();
        vFilecolumnNames1 = new Vector();
        vFilecolumnNames1.add("排名");
        vFilecolumnNames1.add("组名");
        vFilecolumnNames1.add("广告效用");
//            vFilecolumnNames1.add("修改时间");
        model1 = new DefaultTableModel(vSearchFileData, vFilecolumnNames1);
        advertResult = new JTable();
        advertResult.setModel(model1);
        advertResult.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        advertResult.setBounds(35, 80, 650, 420);
        advertResult.setForeground(Color.BLACK);                   // 字体颜色
        advertResult.setFont(new Font(null, Font.PLAIN, 14));      // 字体样式
        advertResult.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
        advertResult.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
        advertResult.setGridColor(Color.GRAY);                     // 网格颜色
        // 设置表头
        advertResult.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // 设置表头名称字体样式
        advertResult.getTableHeader().setForeground(Color.BLACK);                // 设置表头名称字体颜色
        advertResult.getTableHeader().setResizingAllowed(false);               // 设置不允许手动改变列宽
        advertResult.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列
        advertResult.setRowHeight(20);      // 设置行高
        // 第一列列宽设置为40
//            fileTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
        advertResult.setPreferredScrollableViewportSize(new Dimension(400, 300));
        // 把 表格 放到 滚动面板 中（表头将自动添加到滚动面板顶部）
        JScrollPane scrollPane = new JScrollPane(advertResult);
        // 添加 滚动面板 到 内容面板
//        panel.add(scrollPane);
        this.add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == searchBtn) {

        }
    }
}
