public class Cell {
    private boolean alive;

    public Cell() {
        this.alive = false;
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
