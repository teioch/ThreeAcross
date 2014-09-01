import javax.swing.WindowConstants;

public class ThreeAcross {
    public static void main(String[] args){
        Game frame = new Game();
        frame.setTitle("Test");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(250,250);
        frame.setVisible(true);
    }
}
