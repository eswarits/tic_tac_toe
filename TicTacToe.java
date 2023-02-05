// imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//tictactoe class
public class TicTacToe implements ActionListener{
    JFrame window = new JFrame("Tic-Tac-Toe");

    // create a panel
    JPanel titlePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JPanel reloadPanel = new JPanel();
    JPanel scorePanel = new JPanel();

    JLabel textField = new JLabel();
    JButton [] buttons = new JButton[9];
    JButton reloadButton = new JButton("Reload");
    JButton closeButton = new JButton("Close");
    JLabel scoreLabelPlayerA = new JLabel();
    JLabel scoreLabelPlayerB = new JLabel();

    int playerAScore = 0;
    int playerBScore = 0;
    Boolean playerATurn;

    TicTacToe(){
        window.setSize(1000, 800);
        window.getContentPane ().setBackground(new Color(50,50,50));
        window.setLayout(new BorderLayout());
        window.setVisible(true);

        textField.setBackground(new Color(50, 50, 50));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 1000, 100);
        titlePanel.add(textField);
        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150, 150, 150));
        for(int i=0; i<9; i++){
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        reloadPanel.setLayout(new GridLayout(1,2));
        reloadPanel.setBackground(new Color(150, 150, 150));

        reloadButton.setBackground(new Color(0,0,225));
        reloadButton.setFocusable(false);
        reloadButton.addActionListener(this);

        closeButton.setBackground(new Color(255, 0, 0));
        closeButton.setFocusable(false);
        closeButton.addActionListener(this);

        reloadPanel.add(reloadButton);
        reloadPanel.add(closeButton);

        scorePanel.setLayout(new GridLayout(2, 1));
        scorePanel.setBackground(new Color(255, 0, 0));

        scoreLabelPlayerA.setFont(new Font("MV Boli", Font.BOLD, 20));
        scoreLabelPlayerA.setText("Player A:" + playerAScore);

        scoreLabelPlayerB.setFont(new Font("MV Boli", Font.BOLD, 20));
        scoreLabelPlayerB.setText("Player B:" + playerBScore);

        scorePanel.add(scoreLabelPlayerA);
        scorePanel.add(scoreLabelPlayerB);

        // add all the panels to the window
        window.add(titlePanel, BorderLayout.NORTH);
        window.add(buttonPanel);
        window.add(reloadPanel, BorderLayout.SOUTH);
        window.add(scorePanel,BorderLayout.EAST);
        
        firstTurn();
    }

    public void firstTurn(){
        try{
            Thread.sleep(1500);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        if(Math.random() < 0.5){
            playerATurn = true;
            textField.setText("A Turn");
        }
        else{
            playerATurn = false;
            textField.setText("B Turn");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        for(int i=0; i<9; i++){
            if(e.getSource() == buttons[i]){
                if(playerATurn){
                    if(buttons[i].getText() ==""){
                        buttons[i].setForeground(new Color(0, 255,0));
                        buttons[i].setText("A");
                        playerATurn = false;
                        textField.setText("A Turn");
                        textField.setForeground(new Color(0, 0, 255));
                        check();
                    }
                }
                else{
                    if(buttons[i].getText() ==""){
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("B");
                        playerATurn = true;
                        textField.setText("B Turn");
                        textField.setForeground(new Color(0, 255, 0));
                        check();
                    }
                }
            }
        }
        if(e.getSource() == reloadButton){
            reload();
        }
        if(e.getSource() == closeButton){
            window.dispose();
        }
    }
    private void reload() {
        for(int i=0; i<9; i++){
            buttons[i].setText("");
            buttons[i].setBackground(new Color(240,240,240));
            buttons[i].setEnabled(true);
        }
        firstTurn();
    }

    private void check() {
        //---------------------------Horizondal Conditions--------------------------------
        if(buttons[0].getText() == "A" && buttons[1].getText() == "A" && buttons[2].getText() == "A"){
            aWins(0,1,2);
        }
        if(buttons[3].getText() == "A" && buttons[4].getText() == "A" && buttons[5].getText() == "A"){
            aWins(3,4,5);
        }
        if(buttons[6].getText() == "A" && buttons[7].getText() == "A" && buttons[8].getText() == "A"){
            aWins(6,7,8);
        }
        //---------------------------Vertical Conditions-----------------------------
        if(buttons[0].getText() == "A" && buttons[3].getText() == "A" && buttons[6].getText() == "A"){
            aWins(0,3,6);
        }
        if(buttons[1].getText() == "A" && buttons[4].getText() == "A" && buttons[7].getText() == "A"){
            aWins(1,4,7);
        }
        if(buttons[2].getText() == "A" && buttons[5].getText() == "A" && buttons[8].getText() == "A"){
            aWins(2,5,8);
        }
        //---------------------------Diagonal Conditions-------------------------------
        if(buttons[0].getText() == "A" && buttons[4].getText() == "A" && buttons[8].getText() == "A"){
            aWins(0,4,8);
        }
        if(buttons[2].getText() == "A" && buttons[4].getText() == "A" && buttons[6].getText() == "A"){
            aWins(2,4,6);
        }

        //---------------------------Horizondal Conditions--------------------------------
        if(buttons[0].getText() == "B" && buttons[1].getText() == "B" && buttons[2].getText() == "B"){
            bWins(0,1,2);
        }
        if(buttons[3].getText() == "B" && buttons[4].getText() == "B" && buttons[5].getText() == "B"){
            bWins(3,4,5);
        }
        if(buttons[6].getText() == "B" && buttons[7].getText() == "B" && buttons[8].getText() == "B"){
          bWins(6,7,8);
        }
        //---------------------------Vertical Conditions-----------------------------
        if(buttons[0].getText() == "B" && buttons[3].getText() == "B" && buttons[6].getText() == "B"){
            bWins(0,3,6);
        }
        if(buttons[1].getText() == "B" && buttons[4].getText() == "B" && buttons[7].getText() == "B"){
            bWins(1,4,7);
        }
        if(buttons[2].getText() == "B" && buttons[5].getText() == "B" && buttons[8].getText() == "B"){
            bWins(2,5,8);
        }
        //---------------------------Diagonal Conditions-------------------------------
        if(buttons[0].getText() == "B" && buttons[4].getText() == "B" && buttons[8].getText() == "B"){
            bWins(0,4,8);
        }
        if(buttons[2].getText() == "B" && buttons[4].getText() == "B" && buttons[6].getText() == "B"){
            bWins(2,4,6);
        }
    }

    private void aWins(int i, int j, int k){
        buttons[i].setBackground(Color.green);
        buttons[j].setBackground(Color.green);
        buttons[k].setBackground(Color.green);
        for(int q=0; q<9; q++){
            buttons[q].setEnabled(false);
        }
        textField.setText("A Wins");
        playerAScore++;
        scoreLabelPlayerA.setText("Player A: " +playerAScore);
    }
    private void bWins(int i, int j, int k){
        buttons[i].setBackground(Color.green);
        buttons[j].setBackground(Color.green);
        buttons[k].setBackground(Color.green);
        for(int q=0; q<9; q++){
            buttons[q].setEnabled(false);
        }
        textField.setText("B Wins");
        playerBScore++;
        scoreLabelPlayerB.setText("Player B: " +playerBScore);
    }




}
