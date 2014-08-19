import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.PLAIN_MESSAGE;

public class GameButton extends JButton implements ActionListener{
    ImageIcon x,o;
    byte value; //0 = blank, 1 = x, 2 = o
    JButton button;

    public GameButton(){
        value = 0;
        x = new ImageIcon(this.getClass().getResource("resources/x.png"));
        o = new ImageIcon(this.getClass().getResource("resources/o.png"));
        this.button = new JButton();
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent event){
        JFrame frame = new JFrame();

        if(value==0){
            //Do something
        }
        else{
            JOptionPane.showMessageDialog(frame, "Occupied cell. Choose a blank cell to place your piece", "Illegal move", PLAIN_MESSAGE);
        }
    }
}
