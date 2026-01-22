import java.util.Random;


public class Lenia extends ALife{
    private Grid grid;
    private int width,height;
    private double mu,sigma;
    private int convolutionRadius;

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
        addComponent(grid);
        for(int y = 0;y<height;y++) {
            for(int x = 0;x<width;x++) {
                grid.getCell(x, y).setColor(random.nextDouble());
            }
        }
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

    public void addSpot() {
        for(int y = 0;y<height;y++) {
            for(int x = 0;x<width;x++) {
                grid.getCell(x, y).setColor(
                        1/* -Math.min(Math.sqrt(
                            (width/2-x)*(width/2-x) + (height/2-y)*(height/2-y)
                        )/convolutionRadius,1) */
                );
            }
        }
    }



    public void update() {
        double dt = 0.1;
        double[][] newColors = new double[height][width];

        double u,g,growth;

        for(int y =0;y<height;y++){
            for(int x =0;x<width;x++){
                u = 0;
                if(x==40 && y==40) System.out.println(grid.getCell(x, y).getColor());
                for(int dx=-convolutionRadius;dx<=convolutionRadius;dx++) {
                    for(int dy=-convolutionRadius;dy<=convolutionRadius;dy++) {
                        g = gauss(
                            Math.sqrt(
                                dx*dx+dy*dy
                            )/convolutionRadius
                        );
                        u+=g*grid.getCell((x + dx + width) % width, (y + dy + height) % height).getColor();
                    }
                }
                if(x==40 && y==40) System.out.println(u);

                growth = (-1+2.0*gauss(u));

                if(x==40 && y==40) System.out.println(growth);

                newColors[y][x]+=dt*growth;

                newColors[y][x] = Math.min(Math.max(newColors[y][x],0),1);
            }
        }




        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid.getCell(x, y).setColor(newColors[y][x]);
            }
        }
    }

    

    public void setMu(double mu) {this.mu = mu;}
    public void setSigma(double sigma) {this.sigma = sigma;}
    public void setConvolutionRadius(int convolutionRadius) {this.convolutionRadius = convolutionRadius;}
}
