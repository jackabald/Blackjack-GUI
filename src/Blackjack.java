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
    // labels
    JLabel usersHandText = new JLabel(Integer.toString(usersHand.getHandValue()));
    JLabel dealersHandText = new JLabel(Integer.toString(dealersHand.getHandValue()));

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
        // Add Buttons to panel
        startButton.setBackground(Color.green); // sets button color to green
        hitButton.setBackground(Color.green);
        standButton.setBackground(Color.green);
        startButton.setFocusable(false); // removes rectangle around button text
        hitButton.setFocusable(false);
        standButton.setFocusable(false);
        panel.add(startButton); // add buttons to panel
        panel.add(hitButton);
        panel.add(standButton);
        startButton.setBounds(200,250,80,25);
        hitButton.setBounds(250,400,80,25);
        standButton.setBounds(150,400,80,25);
        startButton.addActionListener(this); // add listener to give function
        hitButton.addActionListener(this);
        standButton.addActionListener(this);
        hitButton.setEnabled(false); // disable hit and stand buttons to be enabled after start
        standButton.setEnabled(false);
    }
    public void textFields(){
        // usersHand label setup
        usersHandText.setForeground(Color.green);
        usersHandText.setBounds(237,350,165,25);
        panel.add(usersHandText);

        // Add "DEALER" Label
        JLabel dealerLabel = new JLabel("DEALER");
        dealerLabel.setForeground(Color.green);
        dealerLabel.setBounds(215,70,165,25);
        panel.add(dealerLabel);

        // dealersHand label setup
        dealersHandText.setForeground(Color.green);
        dealersHandText.setBounds(237,100,165,25);
        panel.add(dealersHandText);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==startButton){
            dealersHand.nextCard();
            dealersHandText.setText(Integer.toString(dealersHand.getHandValue()));
            hitButton.setEnabled(true);
            standButton.setEnabled(true);
        }
        if(e.getSource()==hitButton){
            usersHand.nextCard();
            usersHandText.setText(Integer.toString(usersHand.getHandValue()));
        }
        if(e.getSource()==standButton){
            dealersHand.dealerDraw();
        }
    }
    public static void main(String[] args){
        Blackjack newGame = new Blackjack();
    }
}
