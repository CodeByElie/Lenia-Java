public abstract class ALife {
    private Grid grid;

    public abstract void init();
    public abstract void update();
    public Grid getGrid() {return grid;};
}