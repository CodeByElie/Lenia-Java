public class Cell {
    private boolean alive; 
    private double color;

    public Cell() {
        this(20);
    }
    public Cell(int size) {
        this.alive = false;
        setColor(0);
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

    public void setColor(double color) {
        this.color = color;
    }
    public int getColorRGB() {
        int b = (int)(color < 0.5 ? 0 : 255*color);
        int r = (int)(color < 0.5 ? color*255 : 255*(1-color));
        int g = 0;
        return 0xFF000000 | (r << 16) | (g << 8) | b;
    }
    public double getColor() {return color;};
    public boolean isAlive() {return alive;}

}
