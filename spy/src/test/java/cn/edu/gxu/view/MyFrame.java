package test1;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 与awt组件不同，Swing组件不能直接的添加到顶层容器中，他必须天骄到一个与Swing顶层容器相关联的
 * 内容模板(content pane)上;内容面板是顶层容器包含的一个普通容器，它是一个轻量级组件。基本规则如下：
 * （1）把Swing组件放入一个顶层Swing容器的内容面板上
 * （2）避免使用非Swing的重量级组件。
 */
public class MyFrame extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public void CreatFrame() {
        JFrame jf = new JFrame();
        //一般情况下，他不能被直接放在顶层容器中
        Container con = jf.getContentPane();
        JLabel jb = new JLabel("this is a pane");
        JButton jt = new JButton("alert a new window");
        jt.setBounds(10, 10, 100, 21);
        jt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                new MyDialog1(MyFrame.this).setVisible(true);
            }
        });
        jb.setHorizontalAlignment(MAXIMIZED_HORIZ);
        con.add(jt);
        con.add(jb);
        con.setBackground(Color.RED);
        jf.setVisible(true);
        jf.setSize(200, 150);
        jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyFrame().CreatFrame();
    }
}

class MyDialog1 extends JDialog {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public MyDialog1(JFrame frame) {
        super(frame, "alert the window");
        Container conn = getContentPane();
        conn.add(new JLabel("test lable"));
        setBounds(100, 100, 100, 100);
        System.out.println("test succesfully");
    }
}