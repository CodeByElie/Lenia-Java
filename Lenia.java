import java.util.Random;


public class Lenia extends ALife{
    private Grid grid;
    private int width,height;
    private double mu,sigma;
    private int convolutionRadius;

    private double[][] kernel;

    public void computeKernel() {
        kernel = new double[2 * convolutionRadius + 1][2 * convolutionRadius + 1];
        double sum = 0;
        for (int dy = -convolutionRadius; dy <= convolutionRadius; dy++) {
            for (int dx = -convolutionRadius; dx <= convolutionRadius; dx++) {
                double dist = Math.sqrt(dx*dx + dy*dy) / convolutionRadius;
                double g = gauss(dist);
                kernel[dy + convolutionRadius][dx + convolutionRadius] = g;
                sum += g;
            }
        }
        for (int dy = 0; dy < kernel.length; dy++) {
            for (int dx = 0; dx < kernel[0].length; dx++) {
                kernel[dy][dx] /= sum;
            }
        }
    }

    double gauss(double x) {
        return Math.exp(-0.5*Math.pow((x-mu)/sigma, 2));
    }

    double gauss(double x,double mu, double sigma) {
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
        convolutionRadius = 10;
    }

    public void init() {
        init(false);
    }

    public void init(boolean randomGeneration) {
        Random random = new Random();
        grid = new Grid(width, height);
        setImage(grid);
        for(int y = 0;y<height;y++) {
            for(int x = 0;x<width;x++) {
                grid.getCell(x, y).setColor(randomGeneration ? random.nextDouble() : 0);
                grid.setRGB(x, y, grid.getCell(x, y).getColorRGB());
            }
        }
        computeKernel();
    }

    public void addConvolutionFilter() {
        for(int y = 0;y<height;y++) {
            for(int x = 0;x<width;x++) {
                grid.getCell(x, y).setColor(
                    gauss(
                        Math.sqrt(
                            (width/2-x)*(width/2-x) + (height/2-y)*(height/2-y)
                        )/convolutionRadius
                    )
                );
            }
        }
    }

    public void addConvolutionFilter(int X,int Y) {
        for(int y = X-convolutionRadius;y<=X+convolutionRadius;y++) {
            for(int x = X-convolutionRadius;x<=X+convolutionRadius;x++) {
                grid.getCell(x, y).setColor(
                    gauss(
                        Math.sqrt(
                            (X-x)*(X-x) + (Y-y)*(Y-y)
                        )/convolutionRadius
                    )
                );
            }
        }
    }

    public void addSpot() {
        for(int y = 0;y<height;y++) {
            for(int x = 0;x<width;x++) {
                grid.getCell(x, y).setColor(
                        1 -Math.min(Math.sqrt(
                            (width/2-x)*(width/2-x) + (height/2-y)*(height/2-y)
                        )/convolutionRadius,1) 
                );
            }
        }
    }



    public void update() {
        double dt = 0.1;
        double[][] newColors = new double[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                double u = 0;
                for (int dy = -convolutionRadius; dy <= convolutionRadius; dy++) {
                    for (int dx = -convolutionRadius; dx <= convolutionRadius; dx++) {
                        int nx = (x + dx + width) % width;
                        int ny = (y + dy + height) % height;
                        u += kernel[dy + convolutionRadius][dx + convolutionRadius] * grid.getCell(nx, ny).getColor();
                    }
                }
                double growth = -1 + 2.0 * gauss(u,0.15,0.015);
                newColors[y][x] = Math.min(Math.max(grid.getCell(x, y).getColor() + dt * growth, 0), 1);
            }
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid.getCell(x, y).setColor(newColors[y][x]);
                grid.setRGB(x, y, grid.getCell(x, y).getColorRGB());
            }
        }

        repaint();
    }

    

    public void setMu(double mu) {this.mu = mu;}
    public void setSigma(double sigma) {this.sigma = sigma;}
    public void setConvolutionRadius(int convolutionRadius) {this.convolutionRadius = convolutionRadius;}
}
