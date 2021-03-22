package cn.edu.gxu.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author atom.hu
 * @version V1.0
 * @Package cn.edu.gxu.view
 * @date 2021/3/21 16:58
 * @Description
 */
public class BlackPicPanel extends JPanel {

    private BufferedImage image;
    private int w, h;

    public BlackPicPanel(String fname) {

        //reads the image
        try {
            System.out.println(new File(fname).getAbsolutePath());
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
