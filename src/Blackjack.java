import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Blackjack implements ActionListener {
    // value of hands
    Hand usersHand = new Hand("YOU");
    Hand dealersHand = new Hand("DEALER");
    // frame and panel
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    // buttons
    JButton hitButton = new JButton("Hit");
    JButton standButton = new JButton("Stand");
    JButton startButton = new JButton("Start");
    JButton dealNext = new JButton("Next");
    // labels
    JLabel usersHandText = new JLabel(Integer.toString(usersHand.getHandValue()));
    JLabel dealersHandText = new JLabel(Integer.toString(dealersHand.getHandValue()));
    // text areas
    JTextArea resetText = new JTextArea("PRESS START TO PLAY AGAIN");
    JTextArea win = new JTextArea("YOU WIN!!");
    JTextArea lose = new JTextArea("YOU LOSE :(");
    JTextArea tie = new JTextArea("YOU TIE");
    public Blackjack() {
        setup();
        buttons();
        textFields();
    }
    public void setup(){
        // Setting frame and panel
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        panel.setBackground(Color.BLACK);
        panel.setLayout(null);

    }
    public void buttons(){
        startButton.setBackground(Color.green); // sets button color to green
        hitButton.setBackground(Color.green);
        standButton.setBackground(Color.green);
        dealNext.setBackground(Color.green);

        startButton.setFocusable(false); // removes rectangle around button text
        hitButton.setFocusable(false);
        standButton.setFocusable(false);
        dealNext.setFocusable(false);

        panel.add(startButton); // add buttons to panel
        panel.add(hitButton);
        panel.add(standButton);
        panel.add(dealNext);

        startButton.setBounds(200,200,80,25); // set bounds of button
        hitButton.setBounds(250,400,80,25);
        standButton.setBounds(150,400,80,25);
        dealNext.setBounds(300,70,80,25);

        startButton.addActionListener(this); // add listener to give function
        hitButton.addActionListener(this);
        standButton.addActionListener(this);
        dealNext.addActionListener(this);

        hitButton.setEnabled(false); // disable hit, stand, and dealNext buttons
        standButton.setEnabled(false);
        dealNext.setEnabled(false);
    }
    public void textFields(){
        // usersHand label setup
        usersHandText.setForeground(Color.green);
        usersHandText.setBounds(237,350,165,25);
        panel.add(usersHandText);

        // Add "DEALER" Label
        JLabel dealerLabel = new JLabel("DEALER");
        dealerLabel.setForeground(Color.green);
        dealerLabel.setBounds(218,70,165,25);
        panel.add(dealerLabel);

        // dealersHand label setup
        dealersHandText.setForeground(Color.green);
        dealersHandText.setBounds(237,100,165,25);
        panel.add(dealersHandText);

        // Win/lose/tie and reset text area after game
        win.setForeground(Color.green);
        win.setBackground(Color.black);
        lose.setForeground(Color.green);
        lose.setBackground(Color.black);
        tie.setForeground(Color.green);
        tie.setBackground(Color.black);
        win.setBounds(210,300,100,25);
        lose.setBounds(210,300,100,25);
        tie.setBounds(215,300,100,25);
        win.setVisible(false);
        lose.setVisible(false);
        tie.setVisible(false);
        panel.add(win);
        panel.add(lose);
        panel.add(tie);
        resetText.setForeground(Color.green);
        resetText.setBackground(Color.black);
        resetText.setBounds(150,325,180,25);
        resetText.setVisible(false);
        panel.add(resetText);
    }
    public void init(){
        startButton.setEnabled(true);
        usersHandText.setText("0");
        dealersHandText.setText("0");
        hitButton.setEnabled(false);
        standButton.setEnabled(false);
        panel.add(resetText);
        resetText.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            usersHand = new Hand("YOU");
            dealersHand = new Hand("DEALER");
            usersHandText.setText(Integer.toString(usersHand.getHandValue()));
            dealersHandText.setText(Integer.toString(dealersHand.getHandValue()));
            dealersHand.nextCard();
            dealersHandText.setText(Integer.toString(dealersHand.getHandValue()));
            hitButton.setEnabled(true);
            standButton.setEnabled(true);
            resetText.setVisible(false);
            win.setVisible(false);
            lose.setVisible(false);
            tie.setVisible(false);
            startButton.setEnabled(false);
        }
        if (e.getSource() == hitButton) {
            if(usersHand.checkIfBusted()){
                System.out.println("YOU BUSTED");
                System.out.println("YOU LOSE");
                lose.setVisible(true);
                init();
            }
            usersHand.nextCard();
            usersHandText.setText(Integer.toString(usersHand.getHandValue()));
        }
        if (e.getSource() == standButton) {
            if (usersHand.checkIfBusted()) {
                System.out.println("YOU BUSTED");
                System.out.println("YOU LOSE");
                lose.setVisible(true);
                init();
            }
            standButton.setEnabled(false);
            hitButton.setEnabled(false);
            dealNext.setEnabled(true);
        }
        if(e.getSource() == dealNext){
            if(dealersHand.checkIfBusted()){
                System.out.println("DEALER BUSTED");
                System.out.println("YOU WIN");
                win.setVisible(true);
                init();
            }
            // dealer must stand on 17
            if(dealersHand.getHandValue() >= 17){
                if(dealersHand.getHandValue() > usersHand.getHandValue()){
                    System.out.println("DEALER: " + dealersHand.getHandValue() + " YOU: " + usersHand.getHandValue());
                    System.out.println("YOU LOSE");
                    lose.setVisible(true);
                    init();
                }
                if(dealersHand.getHandValue() < usersHand.getHandValue()){
                    System.out.println("DEALER: " + dealersHand.getHandValue() + " YOU: " + usersHand.getHandValue());
                    System.out.println("YOU WIN");
                    win.setVisible(true);
                    init();
                }
                if(dealersHand.getHandValue() == usersHand.getHandValue()){
                    System.out.println("DEALER: " + dealersHand.getHandValue() + " YOU: " + usersHand.getHandValue());
                    System.out.println("YOU TIE");
                    tie.setVisible(true);
                    init();
                }
            }
            dealersHand.nextCard();
            dealersHandText.setText(Integer.toString(dealersHand.getHandValue()));
        }
    }
    public static void main(String[] args){
        Blackjack newGame = new Blackjack();
    }
}