public class Main {
    public static void main(String[] args) {
        Conway c = new Conway(100,100);
        c.init();
        c.draw();
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