package cn.edu.gxu.view;

import cn.edu.gxu.pojo.SpyDao;
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

    public SpyDetailDialog(JFrame frame, SpyDao spyDao, JSONObject content) {
        super(frame, spyDao.getGroupName() + " 详情_排名：" + content.get("rank"));


        Container conn = getContentPane();
//        content.put("groupRights", groupRights);
//        content.put("rank", rank);
        JLabel l1 = new JLabel("权益：" + content.get("groupRights"));
        l1.setBounds(30, 20, 100, 30);
        l1.setFont(font);
        conn.add(l1);

        JLabel l2 = new JLabel("资金：" + spyDao.getCash());
        l2.setBounds(230, 20, 100, 30);
        conn.add(l2);
        l2.setFont(font);

        JLabel l3 = new JLabel("长贷：" + spyDao.getLongtermLoan());
        l3.setBounds(30, 70, 100, 30);
        conn.add(l3);
        l3.setFont(font);

        JLabel l4 = new JLabel("短贷：" + spyDao.getShorttemLoan());
        l4.setBounds(230, 70, 100, 30);
        conn.add(l4);
        l4.setFont(font);

        JLabel l5 = new JLabel("市场：" + spyDao.getCertificate().showMarket());
        l5.setBounds(30, 120, 300, 30);
        conn.add(l5);
        l5.setFont(font);

        JLabel l51 = new JLabel("产品研发：" + spyDao.getCertificate().showProduct());
        l51.setBounds(30, 170, 470, 30);
        conn.add(l51);
        l51.setFont(font);

        JLabel l6 = new JLabel("库存：" + spyDao.getProduct().show().replace(",", "，  "));
        l6.setBounds(30, 220, 300, 30);
        conn.add(l6);
        l6.setFont(font);

        JLabel l7 = new JLabel("生产线：" + spyDao.getProdLine().showDetail());
        l7.setBounds(30, 270, 300, 30);
        conn.add(l7);
        l7.setFont(font);

        JLabel l8 = new JLabel("在产产品：" + spyDao.getProdLine().showOnLine());
        l8.setBounds(30, 320, 300, 30);
        conn.add(l8);
        l8.setFont(font);
        JLabel l9 = new JLabel("");
        l9.setBounds(30, 370, 10, 10);
        conn.add(l9);
        l9.setFont(font);
        setBounds(500, 0, 500, 400);
        setBackground(Color.orange);
        System.out.println("test succesfully");
    }
}
