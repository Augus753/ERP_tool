package cn.edu.gxu.view;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

    /**

     *

     * @author Administrator

     * 文本编译器

     */

    public class TextEditor {

        private Frame f;

        private MenuBar mb;

        private Menu mFile,mEdit,mHelp,mTools;

        private MenuItem mOpen,mSave,mExit,mCopy,mPaste,mReplace,mWeb,mPaint,mDefine;

        private FileDialog fd;

        private String fileName;

        private char ch;

        private String s="";

        private TextArea ta;

        private MenuListener menuListener;

        private FileOutputStream fos;

        private OutputStreamWriter osw;

        private FileInputStream fis;

        private InputStreamReader isr;

        private BufferedReader br;

        public TextEditor() {

            f=new Frame("简单文本编译器");

            mb=new MenuBar();

            mFile=new Menu("文件");

            mEdit=new Menu("编辑");

            mHelp=new Menu("帮助");

            mTools=new Menu("工具栏");

            mOpen=new MenuItem("打开");

            mSave=new MenuItem("保存");

            mExit=new MenuItem("退出");

            mCopy=new MenuItem("复制");

            mPaste=new MenuItem("粘贴");

            mReplace=new MenuItem("替换");

            mWeb=new MenuItem("Web工具");

            mPaint=new MenuItem("绘图");

            mDefine=new MenuItem("自定义");

            f.setMenuBar(mb);

            mb.add(mFile);

            mb.add(mEdit);

            mb.setHelpMenu(mHelp);

            mFile.add(mOpen);

            mFile.add(mSave);

            mFile.addSeparator();

            mFile.add(mExit);

            mEdit.add(mCopy);

            mEdit.add(mPaste);

            mEdit.add(mReplace);

            mEdit.addSeparator();

            mEdit.add(mTools);

            mTools.add(mWeb);

            mTools.add(mPaint);

            mTools.add(mDefine);

            ta=new TextArea("",10,10);

            f.add("Center",ta);

            ta.setForeground(Color.black);//设置文本颜色

            ta.addKeyListener(new KeyAdapter() {

                public void keyTyped(KeyEvent ev) {

                    s+=ev.getKeyChar();

                }

            });

            f.setSize(400,200);

            f.setVisible(true);

            menuListener=new MenuListener();

            mExit.addActionListener(menuListener);

            mOpen.addActionListener(menuListener);

            mSave.addActionListener(menuListener);

            f.addWindowListener(new WindowAdapter() {

                public void windowClosing(WindowEvent e) {

                    System.exit(1);

                }

            });

        }

        public static void main(String[] args) {

            TextEditor te=new TextEditor();

        }

        class MenuListener implements ActionListener {

            public void actionPerformed(ActionEvent ev) {

                MenuItem i=(MenuItem)ev.getSource();

                String label=i.getLabel();

                if(label=="退出") System.exit(1);

                else if(label=="保存") saveFile();

            }

        }

        void saveFile() {

            fd=new FileDialog(f,"请输入要保存的文件名",FileDialog.SAVE);

            fd.setVisible(true);

            fileName=fd.getFile();

            try {

                fos=new FileOutputStream(fileName);

                osw=new OutputStreamWriter(fos);

                System.out.println(s);

                osw.write(s);

                osw.flush();

                osw.close();

                fos.close();

            }catch(Exception e) {}

        }

    }

