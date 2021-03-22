package cn.edu.gxu.view;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.view
 * @date 2021/3/21 16:34
 * @Description
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class imagebut extends JFrame {

    public static void main(String args[]) {
        imagebut w = new imagebut();
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        w.setSize(1200, 700);
        w.setVisible(true);

    }

    public imagebut() {

        setLayout(null); // :-)
        PicPanel mainPanel = new PicPanel("background.jpg");
        mainPanel.setBounds(0, 0, 1200, 700);
        add(mainPanel);


    }

    class PicPanel extends JPanel {

        private BufferedImage image;
        private int w, h;

        public PicPanel(String fname) {

            //reads the image
            try {
                System.out.println(new File(fname).getAbsolutePath());
                System.out.println(new File(fname).exists());
                image = ImageIO.read(new File(fname));
                w = image.getWidth();
                h = image.getHeight();

            } catch (IOException ioe) {
                ioe.printStackTrace();
                System.out.println("Could not read in the pic");
                //System.exit(0);
            }

        }

        public Dimension getPreferredSize() {
            return new Dimension(w, h);
        }

        //this will draw the image
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }
    }

}

