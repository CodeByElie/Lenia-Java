import java.awt.Color;

public class Conway extends ALife {
    private Grid grid;

    public Conway() {
        super("Conway");
    }

    public void init() {
        grid = new Grid(10, 10);
        grid.getCell(1, 1).setBackground(Color.BLACK);
        grid.getCell(1, 2).setBackground(Color.BLACK);
        grid.getCell(2, 1).setBackground(Color.BLACK);
        grid.getCell(2, 2).setBackground(Color.BLACK);
        addComponent(grid);
    }

    public void update() {

    }
}
