import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitButton extends JButton implements ActionListener {

    JButton exitButton;

    public ExitButton(){
        exitButton = new JButton("Exit");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
