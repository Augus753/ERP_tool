package cn.edu.gxu.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.view
 * @date 2021/3/21 17:10
 * @Description
 */
public class AboutDetailDialog extends JDialog {
    Font font = new Font("黑体", Font.PLAIN, 15);
    public AboutDetailDialog(JFrame frame) {
        super(frame, " 关于");

        JPanel p = new JPanel(new BorderLayout());
        String disText = "<html><HTML><body style=color:red>" +
                "<br> 版&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本：v0.1" +
                "<br>制&nbsp;&nbsp;作&nbsp;&nbsp;人：第九空间 " +
                "<br> 时&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;间：2021年3月 " +
                "<br> 联系方式：Augus753@outlook.com" +
                "<br>" +
                "<br> <a href='http://note.youdao.com/noteshare?id=07cb9c431bf917bc1a33620bdfa2cdd8&sub=719E506C12FB4C41B5C05AD7C56BAE32'>打开帮助文档</a>" +
                "</body></html>";
        JLabel label = new JLabel(disText, JLabel.CENTER);
        label.setFont(font);
        label.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int opt = JOptionPane.showConfirmDialog(frame,
                        "确认打开帮助文档?", "确认信息",
                        JOptionPane.YES_NO_OPTION);
                if (opt == JOptionPane.YES_OPTION) {
                    try {
                        Runtime.getRuntime().exec("cmd.exe /c start " + "http://note.youdao.com/noteshare?id=07cb9c431bf917bc1a33620bdfa2cdd8&sub=719E506C12FB4C41B5C05AD7C56BAE32");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        p.add(label, BorderLayout.CENTER);

        p.setBackground(Color.white);
        setVisible(true);
        getContentPane().add(p);
        setBounds(100, 100, 400, 300);
    }
}
