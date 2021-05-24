package cn.edu.gxu.view;

import cn.edu.gxu.pojo.SpyPo;
import com.alibaba.fastjson.JSONObject;

import javax.swing.*;
import java.awt.*;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.view
 * @date 2021/3/20 20:33
 * @Description
 */
public class SpyDetailDialog extends JDialog {
    Font font = new Font("黑体", Font.PLAIN, 15);
    //标签默认宽度
    private int LABEL_WIDTH = 620;
    private int HALF_LABEL_WIDTH = 100;
    private int LABEL_HEIGHT = 30;

    private int LABEL_START = 30;
    private int HALF_LABEL_START = 350;

    private int LABEL_START_Y = 20;
    private int LABEL_SPACE_Y = 50;

    public SpyDetailDialog(JFrame frame, SpyPo spyPo, JSONObject content) {
        super(frame, spyPo.getGroupName() + " 详情_排名：" + content.get("rank"));
        Container conn = getContentPane();
//        content.put("groupRights", groupRights);
//        content.put("rank", rank);
        JLabel l1 = new JLabel("权益：" + content.get("groupRights"));
        l1.setBounds(LABEL_START, LABEL_START_Y, HALF_LABEL_WIDTH, LABEL_HEIGHT);
        l1.setFont(font);
        conn.add(l1);

        JLabel l2 = new JLabel("资金：" + spyPo.getCash());
        l2.setBounds(HALF_LABEL_START, LABEL_START_Y, HALF_LABEL_WIDTH, LABEL_HEIGHT);
        conn.add(l2);
        l2.setFont(font);

        JLabel l3 = new JLabel("长贷：" + spyPo.getLongtermLoan());
        l3.setBounds(LABEL_START, LABEL_START_Y + LABEL_SPACE_Y, HALF_LABEL_WIDTH, LABEL_HEIGHT);
        conn.add(l3);
        l3.setFont(font);

        JLabel l4 = new JLabel("短贷：" + spyPo.getShorttemLoan());
        l4.setBounds(HALF_LABEL_START, LABEL_START_Y + LABEL_SPACE_Y, HALF_LABEL_WIDTH, LABEL_HEIGHT);
        conn.add(l4);
        l4.setFont(font);

        JLabel l5 = new JLabel("市场：" + spyPo.getCertificate().showMarket() + spyPo.getCertificate().showDevelopMarket());
        l5.setBounds(LABEL_START, LABEL_START_Y + LABEL_SPACE_Y * 2, LABEL_WIDTH, LABEL_HEIGHT);
        conn.add(l5);
        l5.setFont(font);

        JLabel l51 = new JLabel("产品研发：" + spyPo.getCertificate().showProduct());
        l51.setBounds(LABEL_START, LABEL_START_Y + LABEL_SPACE_Y * 3, LABEL_WIDTH, LABEL_HEIGHT);
        conn.add(l51);
        l51.setFont(font);

        JLabel l6 = new JLabel("库存：" + spyPo.getProduct().show().replace(",", "，  "));
        l6.setBounds(LABEL_START, LABEL_START_Y + LABEL_SPACE_Y * 4, LABEL_WIDTH, LABEL_HEIGHT);
        conn.add(l6);
        l6.setFont(font);

        JLabel l7 = new JLabel("生产线：" + spyPo.getProdLine().showDetail());
        l7.setBounds(LABEL_START, LABEL_START_Y + LABEL_SPACE_Y * 5, LABEL_WIDTH, LABEL_HEIGHT);
        conn.add(l7);
        l7.setFont(font);

        JLabel l8 = new JLabel("在产产品：" + spyPo.getProdLine().showOnLine());
        l8.setBounds(LABEL_START, LABEL_START_Y + LABEL_SPACE_Y * 6, LABEL_WIDTH, LABEL_HEIGHT);
        conn.add(l8);
        l8.setFont(font);
        JLabel l9 = new JLabel("");
        l9.setBounds(LABEL_START, LABEL_START_Y + LABEL_SPACE_Y * 7, 10, LABEL_HEIGHT);
        conn.add(l9);
        l9.setFont(font);
        setBounds(450, 0, 650, 400);
//        setBackground(Color.orange);
        getContentPane().setBackground(new Color(0xcde6c7));
        System.out.println("test succesfully");
    }
}
