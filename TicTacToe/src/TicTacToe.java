import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe {
    static JButton[][] buttons;
    static String CurrentPlayer = "X";
    static int move=0;
    static JTextField txtf2 = new JTextField(CurrentPlayer);

    private TicTacToe(){
        buttons = new JButton[3][3];
        JFrame frame = new JFrame("XOX");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.white);
        frame.setSize(400,400);
        frame.setResizable(false);
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel boardPanel = new JPanel(new GridLayout(3,3));
        JPanel textPanel = new JPanel();
        textPanel.setBounds(300,0,100,100);
        boardPanel.setSize(300,300);
        textfields(textPanel);
        addButtons(boardPanel);
        mainPanel.add(boardPanel);
        mainPanel.add(textPanel,BorderLayout.EAST);
        frame.add(mainPanel);


        frame.setVisible(true);
    }
    private void textfields(JPanel panel){
        JTextField txtf1=new JTextField("Current player");//Current player text
        txtf1.setBounds(50,50,95,20);
        txtf1.setEditable(false);
        txtf1.setFont(new Font("Arial",Font.PLAIN,12));
        txtf1.setBorder(null);
        panel.add(txtf1);

        txtf2.setBounds(340,75,20,30);
        txtf2.setEditable(false);
        txtf2.setBorder(null);
        txtf2.setForeground(Color.RED);
        panel.add(txtf2);


    }
    private void addButtons(JPanel panel){
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                JButton button = new JButton();
                buttons[i][j] = button;
                panel.add(button);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(button.getText().equals("")){
                            button.setText(CurrentPlayer);
                            button.setEnabled(false);
                            move++;
                        }
                        if(move > 4){
                            if(isFinished()){
                                JOptionPane.showMessageDialog(panel,CurrentPlayer+" Win");
                                resetGame();
                            }
                            else if(move == 9){
                                JOptionPane.showMessageDialog(panel,"Tie");
                                resetGame();
                            }
                            else
                                changePlayer();
                        }
                        else
                            changePlayer();
                    }
                });

            }
        }



    }
    private boolean isFinished(){
        return (checkRows()||checkColumns()||checkDiagonal());

    }
    private boolean checkRows(){
        for(int i=0;i<3;i++){
            if(buttons[i][0].getText().equals(buttons[i][1].getText()) && buttons[i][0].getText().equals(buttons[i][2].getText())&& buttons[i][0].getText().equals(CurrentPlayer) )
                return true;
        }
        return false;
    }
    private boolean checkColumns(){
        for(int i=0;i<3;i++){
            if(buttons[0][i].getText().equals(buttons[1][i].getText()) && buttons[0][i].getText().equals(buttons[2][i].getText())&& buttons[0][i].getText().equals(CurrentPlayer) )
                return true;
        }
        return false;
    }
    private boolean checkDiagonal(){
        if(buttons[0][0].getText().equals(buttons[1][1].getText()) && buttons[0][0].getText().equals(buttons[2][2].getText()) && buttons[0][0].getText().equals(CurrentPlayer))
            return true;
        if(buttons[0][2].getText().equals(buttons[1][1].getText()) && buttons[0][2].getText().equals(buttons[2][0].getText()) && buttons[0][2].getText().equals(CurrentPlayer))
            return true;
        return false;
    }
    private void resetGame(){
        for (int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
        move = 0;
        CurrentPlayer ="X";
        txtf2.setText(CurrentPlayer);
    }
    private void changePlayer(){
        CurrentPlayer = (CurrentPlayer.equals("X")) ? "0":"X";
        txtf2.setText(CurrentPlayer);
    }








    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToe());

    }




}

