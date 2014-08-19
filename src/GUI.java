import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame{

    public GUI(){
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4,3,2,2));

        for(int i = 0; i < 9; i++){
            GameButton button = new GameButton();
            p1.add(button);
        }
        ClearButton clearButton = new ClearButton();
        p1.add(clearButton);

        JLabel message = new JLabel("Ready");
        p1.add(message);

        ExitButton exit = new ExitButton();
        p1.add(exit);

        add(p1, BorderLayout.CENTER);
    }
}
