import javax.swing.*;

/**
 * Created by Teioch on 03.08.2014.
 */
public class Game {
    public static void main(String[] args){
        GUI frame = new GUI();
        frame.setTitle("Test");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250,250);
        frame.setVisible(true);
    }
}
