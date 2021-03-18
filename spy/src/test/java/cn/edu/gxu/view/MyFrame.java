package cn.edu.gxu.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.BadLocationException;

public class MyFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTable table;
    private JPanel panel;
    private JScrollPane scrollpane;
    private JButton button1, button2, button3;
    private JTextArea text1, text2, text3;
    private List<Student> stu;

    public MyFrame() throws BadLocationException, SQLException {
        super("学生信息");
        this.setSize(500, 340);
        this.add(getJScrollPane(stu), BorderLayout.CENTER);
        this.add(getJPanel(), BorderLayout.SOUTH);
        this.setResizable(true);
        this.setLocation(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // 设置JScrollPane方法
    private JScrollPane getJScrollPane(List<Student> stu) throws SQLException {
        if (scrollpane == null) {
            scrollpane = new JScrollPane();
            scrollpane.setViewportView(getJTable(stu));
        }
        return scrollpane;
    }

    // 设置JPanel方法
    private JPanel getJPanel() {
        if (panel == null) {
            panel = new JPanel();
            panel.setLayout(new GridLayout(2, 3));
            text1 = new JTextArea();
            text2 = new JTextArea();
            text3 = new JTextArea();
            button1 = new JButton("添加");
            button2 = new JButton("删除");
            button3 = new JButton("更新");
            button1.addActionListener(new insert());
            button2.addActionListener(new delete());
            button3.addActionListener(new update());
            text1.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
            text2.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
            text3.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
            text1.setFont(new Font("宋体", Font.BOLD, 16));
            text2.setFont(new Font("宋体", Font.BOLD, 16));
            text3.setFont(new Font("宋体", Font.BOLD, 16));
            text1.setText("id");
            text2.setText("name");
            text3.setText("age");
            panel.add(text1);
            panel.add(text2);
            panel.add(text3);
            panel.add(button1);
            panel.add(button2);
            panel.add(button3);

        }
        return panel;

    }

    // 设置Jtable方法
    private void setJTable(JTable table) {
        table.setFont(new Font("宋体", Font.BOLD, 18));
        table.setRowHeight(30);
    }

    // 获取Jtable对象方法（该方法具体就是获得jtable对象的时候 一并从数据取出学生信息并放入Jtable表格中）
    private JTable getJTable(List<Student> stu) throws SQLException {
        if (table == null) {
            JDBCDaoImpl jdbc = new JDBCDaoImpl();
            ResultSet rs = jdbc.search();
            stu = select(rs);
            jdbc.closeConnection();
            table = new JTable(new Table(stu));
            setJTable(table);
        }
        return table;
    }

    // 设置学生信息方法（该方法是用户增加 删除 更新用户操作的具体实现方法 包含了完整性检查）
    private Student setStu() {
        if (text1.getText().equals("") || text2.getText().equals("") || text3.getText().equals("")) {
            return null;
        } else {
            Student sd = new Student();
            sd.setId(text1.getText());
            sd.setName(text2.getText());
            sd.setAge(text3.getText());
            return sd;

        }

    }

    // 重置输入框为空
    private void resetText() {
        text1.setText("");
        text2.setText("");
        text3.setText("");
    }

    // 刷新学生信息方法（该方法是重新读取数据库学生的信息 然后返回一个学生的集合 用于刷新Jtable表格对象中的数据）
    private List<Student> select(ResultSet rs) throws SQLException {
        List<Student> st = new ArrayList<Student>();
        while (rs.next()) {
            Student s = new Student();
            s.setId(rs.getString(1));
            s.setName(rs.getString(2));
            s.setAge(rs.getString(3));
            st.add(s);
        }
        return st;

    }

    // 添加按钮-监听器（该方法是对添加按钮实现的具体方法 ）
    class insert implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            stu = new ArrayList<Student>();
            Student sd = new Student();
            JDBCDaoImpl jdbc = new JDBCDaoImpl();
            sd = setStu();
            if (sd != null) {
                jdbc.insert(sd);
                ResultSet rs = jdbc.search();
                try {
                    stu = select(rs);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                jdbc.closeConnection();
                JTable table = new JTable(new Table(stu));//新建一个Jtable 对象 用来盛放增加后的学生信息
                setJTable(table);//设置Jtable信息
                MyFrame.this.scrollpane.setViewportView(table);//把Jtable设置到Panel
                resetText();
            } else {
                JOptionPane.showMessageDialog(MyFrame.this, "输入数据不完整");

            }

        }

    }

    // 删除按钮-监听器（该方法是对删除按钮实现的具体方法）
    class delete implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            stu = new ArrayList<Student>();
            Student sd = new Student();
            JDBCDaoImpl jdbc = new JDBCDaoImpl();
            sd = setStu();
            if (sd != null) {
                jdbc.delete(sd);
                ResultSet rs = jdbc.search();
                try {
                    stu = select(rs);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                jdbc.closeConnection();
                JTable table = new JTable(new Table(stu));//新建一个Jtable 对象 用来盛放增加后的学生信息
                setJTable(table);//设置Jtable信息
                MyFrame.this.scrollpane.setViewportView(table);//把Jtable设置到Panel
                resetText();
            } else {
                JOptionPane.showMessageDialog(MyFrame.this, "输入数据不完整");

            }

        }

    }

    // 更新按钮-监听器（该方法是对更新按钮实现的具体方法）
    class update implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            stu = new ArrayList<Student>();
            Student sd = new Student();
            JDBCDaoImpl jdbc = new JDBCDaoImpl();
            sd = setStu();
            if (sd != null) {
                jdbc.update(sd);
                ResultSet rs = jdbc.search();
                try {
                    stu = select(rs);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                jdbc.closeConnection();
                JTable table = new JTable(new Table(stu));//新建一个Jtable 对象 用来盛放增加后的学生信息
                setJTable(table);//设置Jtable信息
                MyFrame.this.scrollpane.setViewportView(table);//把Jtable设置到Panel
                resetText();
            } else {
                JOptionPane.showMessageDialog(MyFrame.this, "输入数据不完整");

            }

        }

    }

    // Student类 （用于封装数据信息和数据库表进行映射）
    public class Student {
        // 学生的id name age信息
        private String id;
        private String name;
        private String age;

        // get&set方法
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }

    // JTable 表模式类 （JTable对象 初始化的时候通过 这个Table获取表格的行数、列数、列标题、以及每个单元格存放的数据 具体使用原因放在开头的备注了）
    public class Table extends AbstractTableModel {
        List<Student> stu = new ArrayList<Student>();

        public Table(List s) {
            this.stu = s;

        }
        public List<Student> getStu() {
            return stu;
        }

        public void setStu(List<Student> stu) {
            this.stu = stu;
        }

        @Override
        // 获取行数
        public int getRowCount() {
            return stu.size();
        }

        @Override
        // 获取列数
        public int getColumnCount() {
            // TODO Auto-generated method stub
            return 3;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }

        @Override
        // 获取列名字
        public String getColumnName(int col) {
            String res = "";
            switch (col) {
                case 0:
                    res = "ID";
                    break;
                case 1:
                    res = "Name";
                    break;
                case 2:
                    res = "Age";
                    break;
                default:
                    break;
            }
            return res;
        }

        @Override
        // 获取具体值
        public Object getValueAt(int rowIndex, int columnIndex) {
            // TODO Auto-generated method stub
            Object res = "";
            Student temp = stu.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    res = temp.getId();
                    break;
                case 1:
                    res = temp.getName();
                    break;
                case 2:
                    res = temp.getAge();
                    break;
                default:
                    break;
            }
            return res;
        }

    }

    // JDBCDAO类 配置连接数据的信息，链接释放操作和基本增删改查操作
    public class JDBCDaoImpl {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/MyFrame1?useUnicode=true&characterEncoding=utf-8&useSSL=false";
        String user = "root";
        String passwd = "123456";
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        // 数据库连接开始
        public Connection getConnection() {
            try {
//                Class.forName("com.mysql.jdbc.Driver");
//                conn = DriverManager.getConnection(url, user, passwd);
//                stmt = conn.createStatement();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return conn;
        }

        // 数据库连接释放
        public void closeConnection() {
            if (rs != null) {
                try {
                    rs.close();
                    stmt.close();
                    conn.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            if (rs == null) {
                try {
                    stmt.close();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        // 查找操作
        public ResultSet search() {
            getConnection();
            try {
                String sql = "SELECT * FROM student";
                rs = stmt.executeQuery(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return rs;
        }

        // 添加操作
        public void insert(Student sd) {
            // TODO Auto-generated method stub
            getConnection();
            try {
                String sql = "INSERT INTO student(id,name,age)" + "VALUES('" + sd.getId() + "','" + sd.getName() + "','"
                        + sd.getAge() + "')";
                int count = stmt.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // 删除操作
        public void delete(Student sd) {
            // TODO Auto-generated method stub
            getConnection();
            try {
                String sql = "DELETE FROM student WHERE id = '" + sd.getId() + "'";
                int count = stmt.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // 更新操作
        public void update(Student sd) {
            // TODO Auto-generated method stub
            getConnection();
            try {
                String sql = "UPDATE student SET name='" + sd.getName() + "',age= '" + sd.getAge() + "'WHERE id = '"
                        + sd.getId() + "'";
                int count = stmt.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    // main 方法
    public static void main(String[] args) throws BadLocationException, SQLException {
        new MyFrame().setVisible(true);

    }
}
