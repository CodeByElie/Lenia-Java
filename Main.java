public class Main {
    public static void main(String[] args) {
        Lenia c = new Lenia(100,100);
        c.init();
        c.setConvolutionRadius(20);
        c.addConvolutionFilter(20,20);
        c.addConvolutionFilter(60,60);
        c.setConvolutionRadius(20);
        c.computeKernel();
        c.draw();
        try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        while(true) {
            c.update();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        } 
    }
}