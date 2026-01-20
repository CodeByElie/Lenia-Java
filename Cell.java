import javax.swing.JPanel;
import java.awt.*;

public class Cell extends JPanel{
    private boolean alive;

    public Cell() {
        this(20);
    }
    public Cell(int size) {
        this.alive = false;
        setPreferredSize(new Dimension(size, size));
        setBackground(Color.WHITE);
        setOpaque(true);
    }

    public void live() {
        this.alive = true;
        setBackground(Color.BLACK);
    }

    public void kill() {
        this.alive = false;
        setBackground(Color.WHITE);
    }

    public void toggle() {
        this.alive = !alive;
        setBackground(this.alive ? Color.BLACK : Color.WHITE);
    }

    public boolean isAlive() {return alive;}

}
