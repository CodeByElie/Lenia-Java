import javax.swing.JPanel;
import java.awt.*;

public class Cell extends JPanel{
    private boolean alive; 
    private double color;

    public Cell() {
        this(20);
    }
    public Cell(int size) {
        this.alive = false;
        setPreferredSize(new Dimension(size, size));
        setColor(0);
        setOpaque(true);
    }

    public void live() {
        this.alive = true;
        setColor(1);
    }

    public void kill() {
        this.alive = false;
        setColor(0);
    }

    public void toggle() {
        this.alive = !alive;
        setColor(this.alive ? 1 : 0);
    }

    private static final int[][] INFERNO_PALETTE = {
        {0, 0, 4}, {31, 12, 72}, {85, 15, 109}, {136, 34, 106}, {186, 54, 85}, {227, 89, 51}, {249, 140, 10}, {252, 195, 50}, {240, 249, 33}
    };


    public void setColor(double color) {
        double scaled = color * (INFERNO_PALETTE.length - 1);
        int index = (int) scaled;
        double t = scaled - index;

        int[] c0 = INFERNO_PALETTE[index];
        int[] c1 = INFERNO_PALETTE[Math.min(index + 1, INFERNO_PALETTE.length - 1)];

        int r = (int) (c0[0] + t * (c1[0] - c0[0]));
        int g = (int) (c0[1] + t * (c1[1] - c0[1]));
        int b = (int) (c0[2] + t * (c1[2] - c0[2]));

        setBackground(new Color(r, g, b));
    }
    public double getColor() {return color;}
    public boolean isAlive() {return alive;}

}
