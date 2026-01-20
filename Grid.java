import javax.swing.JPanel;
import java.awt.*;

public class Grid extends JPanel{
    private Cell[][] cells;
    private int width, height;
    
    public Grid(int width, int height) {
        this.width = width;
        this.height = height;

        setLayout(new GridLayout(height, width, 5, 5));

        cells = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cells[i][j] = new Cell();
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