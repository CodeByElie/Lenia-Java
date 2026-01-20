public class Conway extends ALife {
    private Grid grid;
    private int width,height;

    public Conway() {
        this(40,40);
    }

    public Conway(int width, int height) {
        super("Conway");
        this.width = width;
        this.height = height;
    }

    public void init() {
        grid = new Grid(width, height,true);
        addComponent(grid);
    }

    public void update() {
        boolean[][] willBeAlive = new boolean[height][width];
        for(int y = 0;y<height;y++) {
            for(int x = 0;x<width;x++) {
                Cell[] neighbors = getNeighbors(x,y);
                int countAliveNeighbors = 0;
                for(Cell cell:neighbors) {
                    if(cell.isAlive()) countAliveNeighbors++;
                }
                if(grid.getCell(x, y).isAlive() && countAliveNeighbors<2) willBeAlive[y][x] = false;
                else if(grid.getCell(x, y).isAlive() && countAliveNeighbors>=2 && countAliveNeighbors<=3) willBeAlive[y][x] = true;
                else if(grid.getCell(x, y).isAlive() && countAliveNeighbors>3) willBeAlive[y][x] = false;
                else if(grid.getCell(x, y).isAlive() && countAliveNeighbors>=2 && countAliveNeighbors<=3) willBeAlive[y][x] = true;
                else if(!grid.getCell(x, y).isAlive() && countAliveNeighbors==3) willBeAlive[y][x] = true;
            }
        }

        for(int y = 0;y<height;y++) {
            for(int x = 0;x<width;x++) {
                if(willBeAlive[y][x]) grid.getCell(x, y).live();
                else grid.getCell(x, y).kill();
            }
        }


    }

    public Cell[] getNeighbors(int x,int y) {
        Cell[] neighbors = new Cell[8];

        int index = 0;

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) {
                    continue; 
                }
                int nx = (x + dx + width) % width;
                int ny = (y + dy + height) % height;

                neighbors[index++] = grid.getCell(nx, ny);
            }
        }
        return neighbors;
    }

}
