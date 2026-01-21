public class Lenia extends ALife{
    private Grid grid;
    private int width,height;
    private double mu,sigma;

    double gauss(double x) {
        return Math.exp(-0.5*Math.pow((x-mu)/sigma, 2));
    }

    public Lenia() {
        this(40,40);
    }

    public Lenia(int width, int height) {
        super("Lenia");
        this.width = width;
        this.height = height;
        mu = 0.5;
        sigma = 0.15;
    }

    public void init() {
        grid = new Grid(width, height);
        addComponent(grid);
    }

    public void addConvolutionFilter() {
        for(int y = 0;y<height;y++) {
            for(int x = 0;x<width;x++) {
                grid.getCell(x, y).setColor(
                    gauss(
                        1-
                        Math.sqrt(
                            (width/2-x)*(width/2-x) + (height/2-y)*(height/2-y)
                        )/Math.sqrt(
                            (width/4)*(width/4) + (height/4)*(height/4)
                        )
                    )
                );
            }
        }
    }

    public void update() {

    }

    public void setMu(double mu) {this.mu = mu;}
    public void setSigma(double sigma) {this.sigma = sigma;}
}
