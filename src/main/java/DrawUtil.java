import org.junit.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class DrawUtil {
    public static void paintRectList(List<Block> blockList,
                                     double scalingRatio, int width, int height,
                                     boolean saveImg) {
        int offset = 50; //设置偏移量使画面好看点
        double alpha = (int) 1e+5 * scalingRatio; //缩放比例
        class MyCanvas extends JComponent {
            public void paint(Graphics g) {
                // 在此处调用方法画图
                for (Block block : blockList) {
                    g.setColor(new Color(168,182,194));
                    g.fillRoundRect(
                            (int) (block.getX() * alpha + offset),
                            (int) (block.getY() * alpha + offset),
                            (int) (block.getWidth() * alpha),
                            (int) (block.getHeight() * alpha),
                            (int) (10), (int) (10)
                    );
                    g.setColor(new Color(98, 102, 117));
                    g.drawRoundRect(
                            (int) (block.getX() * alpha + offset),
                            (int) (block.getY() * alpha + offset),
                            (int) (block.getWidth() * alpha),
                            (int) (block.getHeight() * alpha),
                            (int) (10), (int) (10));
                }
                //画个边框
                g.setColor(Color.BLACK);
                g.drawRoundRect(offset, offset,
                        (int) (width * alpha),
                        (int) (height * alpha), 0, 0);

                //写字
                g.drawString("width = " + width + ",   " +
                                "height = " + height + ",   " +
                                "area = " + width * height,
                        offset, offset / 2);
            }
        }

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(200, 200, (int) (width * alpha) + offset * 2, (int) (height * alpha) + offset * 2);
        window.setTitle("visual result");
        window.getContentPane().add(new MyCanvas());
        window.setVisible(true);

        if (saveImg == true) {
            BufferedImage bi = new BufferedImage(width + offset * 2,
                    height + offset * 2, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bi.createGraphics();
            window.paint(g2d);
            try {
                ImageIO.write(bi, "PNG", new File("result.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
