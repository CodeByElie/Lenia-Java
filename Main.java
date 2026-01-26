public class Main {
    public static void main(String[] args) {
        Lenia c = new Lenia(400,400);
        c.init(true);
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