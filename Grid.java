import java.util.Random;
import java.awt.image.BufferedImage;

public class Grid extends BufferedImage{
    private Cell[][] cells;
    private int width, height;

    public Grid(int width, int height) {
        this(width,height,false);
    }
    
    public Grid(int width, int height,boolean randomGeneration) {
        super(width,height,BufferedImage.TYPE_INT_RGB);
        this.width = width;
        this.height = height;
        Random random = new Random();
        int mx = Math.max(height,width);
        cells = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cells[i][j] = new Cell(Math.max(600/mx,1));
                if(randomGeneration && random.nextBoolean()) cells[i][j].toggle();
                this.setRGB(i, j, cells[i][j].getColorRGB());
            }
        }
    }
    
    public Cell getCell(int x, int y) {
        return cells[y][x];
    }
    public int getGridWidth() {return width;}
    public int getGridHeight() {return height;}
}