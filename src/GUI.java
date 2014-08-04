import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by Teioch on 03.08.2014.
 */
public class GUI extends JFrame{

    public GUI(){
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4,3,2,2));
        CellHandler cellHandler = new CellHandler();
        ClearHandler clearHandler = new ClearHandler();
        ExitHandler exitHandler = new ExitHandler();

        for(int i = 0; i < 9; i++){
            JButton button = new JButton("-");
            p1.add(button);
            button.addActionListener(cellHandler);
        }
        JButton clearButton = new JButton("Clear");
        p1.add(clearButton);
        clearButton.addActionListener(clearHandler);

        JLabel message = new JLabel("Ready");
        p1.add(message);

        JButton exitButton = new JButton("Exit");
        p1.add(exitButton);
        exitButton.addActionListener(exitHandler);

        add(p1, BorderLayout.CENTER);
    }
}
