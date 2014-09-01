import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JOptionPane.PLAIN_MESSAGE;

public class Game extends JFrame implements ActionListener{

    private JButton button1;
    private JButton button2;
    private JButton button3;

    private JButton button4;
    private JButton button5;
    private JButton button6;

    private JButton button7;
    private JButton button8;
    private JButton button9;

    private JButton[] grid;

    private final String X_ICON = "resources/x.png";
    private final String O_ICON = "resources/o.png";
    private final String REFRESH_ICON = "resources/refresh.png";
    private final String EXIT_ICON = "resources/exit.png";

    private ImageIcon xIcon;
    private ImageIcon oIcon;
    private ImageIcon refreshIcon;
    private ImageIcon exitIcon;

    private JPanel panel;
    private JButton clearButton;
    private JLabel label;
    private JButton exit;

    private boolean turn; //false = X's turn, true = O's turn.
    private boolean gameover;

    public Game(){
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 3, 2, 2));

        xIcon = new ImageIcon(this.getClass().getResource(X_ICON));
        oIcon = new ImageIcon(this.getClass().getResource(O_ICON));
        refreshIcon = new ImageIcon(this.getClass().getResource(REFRESH_ICON));
        exitIcon = new ImageIcon(this.getClass().getResource(EXIT_ICON));

        xIcon = resize(xIcon);
        oIcon = resize(oIcon);
        refreshIcon = resize(refreshIcon);
        exitIcon = resize(exitIcon);
        resetGame();
    }



    public void resetGame(){
        turn = false;
        gameover = false;

        panel.removeAll();

        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();

        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();

        grid = new JButton[]{button1, button2, button3, button4, button5, button6, button7, button8, button9};

        label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setText("X's turn!");

        clearButton = new JButton();
        clearButton.setIcon(refreshIcon);
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        exit = new JButton();
        exit.setIcon(exitIcon);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        for(int i = 0; i < 9; i++){
            final int temp = i;
            grid[i].addActionListener(new ActionListener() {
                                          @Override
                                          public void actionPerformed(ActionEvent e) {
                                              JFrame frame = new JFrame();
                                              if(gameover){
                                                  JOptionPane.showMessageDialog(frame, "The game is over. A winner has been declared. Restart the game for a rematch", "Game Over", PLAIN_MESSAGE);
                                              }
                                              else if(cellAvailable(temp)) {
                                                  if (!turn) {
                                                      grid[temp].setIcon(xIcon);
                                                      label.setText("O's turn!");
                                                      turn = true;
                                                  } else {
                                                      grid[temp].setIcon(oIcon);
                                                      label.setText("X's turn!");
                                                      turn = false;
                                                  }
                                              checkForWinner();
                                              }
                                              else{
                                                  JOptionPane.showMessageDialog(frame, "Occupied cell. Choose a blank cell to place your piece", "Illegal move", PLAIN_MESSAGE);
                                              }
                                          }
                                      });
            panel.add(grid[i]);
        }

        panel.add(clearButton);
        panel.add(label);

        panel.add(exit);
        panel.revalidate();
        repaint();

        add(panel, BorderLayout.CENTER);
    }

    public ImageIcon resize(ImageIcon icon) {
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }

    private String iconToString(Icon icon){
        if(icon == xIcon){
            return "X";
        }
        else{
            return "O";
        }
    }

    private boolean containsNull(Icon one, Icon two, Icon three){
        if(one == null || two == null || three == null){
            return true;
        }
        else{
            return false;
        }
    }

    private void checkRowForWinner(Icon one, Icon two, Icon three){
        JFrame frame = new JFrame();
        if(one == two && two == three){
            if(!containsNull(one, two, three)) {
                gameover = true;
                label.setText(iconToString(one) + " won!");
                JOptionPane.showMessageDialog(frame, iconToString(one) + " is the winner! Press reset to start new game.", "Winner!", PLAIN_MESSAGE);
            }
        }
    }

    private void checkForWinner() {
        //check top row:
        checkRowForWinner(grid[0].getIcon(), grid[1].getIcon(), grid[2].getIcon());

        //check middle row (horizontal):
        checkRowForWinner(grid[3].getIcon(), grid[4].getIcon(), grid[5].getIcon());

        //check bottom row:
        checkRowForWinner(grid[6].getIcon(), grid[7].getIcon(), grid[8].getIcon());

        //check left row:
        checkRowForWinner(grid[0].getIcon(), grid[3].getIcon(), grid[6].getIcon());

        //check middle row (vertical):
        checkRowForWinner(grid[1].getIcon(), grid[4].getIcon(), grid[7].getIcon());

        //check right row:
        checkRowForWinner(grid[2].getIcon(), grid[5].getIcon(), grid[8].getIcon());

        //check diagonal left:
        checkRowForWinner(grid[0].getIcon(), grid[4].getIcon(), grid[8].getIcon());

        //check diagonal right:
        checkRowForWinner(grid[6].getIcon(), grid[4].getIcon(), grid[2].getIcon());
    }

    private boolean cellAvailable(int temp) {
        if(grid[temp].getIcon() == xIcon){
            return false;
        }
        else if(grid[temp].getIcon() == oIcon){
            return false;
        }
        else{
            return true;
        }
    }

    public void actionPerformed(ActionEvent event){

    }
}
