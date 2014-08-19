import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearButton extends JButton implements ActionListener{

    JButton clearButton;

    public ClearButton(){
        clearButton = new JButton("Clear");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event){

    }
}
