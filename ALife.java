import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public abstract class ALife extends JFrame {
    private JLabel Limg;
    

    public ALife(String name) {
        super(name);
        Limg = new JLabel();
    }

    public void draw() {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setImage(BufferedImage img) {
        setSize(img.getWidth(),img.getHeight());
        Limg.setIcon(new ImageIcon(img));
        getContentPane().add(Limg,BorderLayout.CENTER);
    }

    public abstract void init();
    public abstract void init(boolean randomGeneration);
    public abstract void update();
}