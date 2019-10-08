import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.awt.Canvas;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class generateImage extends Canvas {

    private BufferedImage img = null;
    private String baseURL = "./Images/Piano_Key_";
    JFrame f = new JFrame();
    JPanel jPanel = new JPanel();

    public void showImage(String path) {
        String finalURL = baseURL + path + ".png";
        //Load the image URL
        try {
            img = ImageIO.read(new File(finalURL));
        } catch (
                IOException e) {
            System.out.println("error reading image");
        }
        //Create JLabel with our image
        JLabel picLabel = new JLabel(new ImageIcon(img));
        //create panel for our label
        jPanel = new JPanel();
        jPanel.add(picLabel);
        //Create a frame and add the panel to it.
        f = new JFrame();
        //f.setSize(new Dimension(img.getWidth(),img.getHeight()));
        //for some reason getwidth and getheight are too small... who knows.
        f.setSize(new Dimension(500,220));
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.add(jPanel);
        f.setVisible(true);
        f.setAlwaysOnTop(true);
    }

    public void closeImage(){
        f.setVisible(false);
        f.dispose();
    }
}
