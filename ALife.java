import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class ALife extends JFrame {
    private JPanel components;
    

    public ALife(String name) {
        super(name);
        components = new JPanel();
        add(components);
    }

    public void draw() {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addComponent(JComponent component) {
        components.add(component);
    }

    public abstract void init();
    public abstract void init(boolean randomGeneration);
    public abstract void update();
}