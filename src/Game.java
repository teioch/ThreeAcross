import javax.swing.WindowConstants;

public class Game {
    public static void main(String[] args){
        GUI frame = new GUI();
        frame.setTitle("Test");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(250,250);
        frame.setVisible(true);
    }
}
