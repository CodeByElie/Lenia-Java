import javax.swing.JPanel;
import java.awt.*;
import java.util.Random;

public class Grid extends JPanel{
    private Cell[][] cells;
    private int width, height;

    public Grid(int width, int height) {
        this(width,height,false);
    }
    
    public Grid(int width, int height,boolean randomGeneration) {
        this.width = width;
        this.height = height;
        Random random = new Random();

        setLayout(new GridLayout(height, width));

        int mx = Math.max(height,width);
        cells = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cells[i][j] = new Cell(600/mx);
                if(randomGeneration && random.nextBoolean()) cells[i][j].toggle();
                add(cells[i][j]);
            }
        }
    }
    
    public Cell getCell(int x, int y) {
        return cells[y][x];
    }

    public int getGridWidth() {return width;}
    public int getGridHeight() {return height;}
}