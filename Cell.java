import javax.swing.JPanel;
import java.awt.*;

public class Cell extends JPanel{
    private boolean alive;

    public Cell() {
        this.alive = false;
        setPreferredSize(new Dimension(40, 40));
        setBackground(Color.WHITE);
        setOpaque(true);
    }

    public void live() {
        this.alive = true;
    }

    public void kill() {
        this.alive = false;
    }

    public void toggle() {
        this.alive = !alive;
    }

}
