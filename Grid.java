public class Grid {
    private Cell[][] cells;
    private int width, height;
    
    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        cells = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                cells[i][j] = new Cell();
            }
        }
    }
    
    public Cell getCell(int x, int y) {
        return cells[y][x];
    }

    public int getWidth() {return width;}
    public int getHeight() {return height;}
}