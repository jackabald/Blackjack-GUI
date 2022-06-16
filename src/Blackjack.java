import javax.swing.*;
import java.awt.*;

public class Blackjack {
    int hand = 0;
    int dealersHand = 0;
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    public Blackjack() {
        button();
        setup();
    }
    public void setup(){
        // Setting frame and panel
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(null);

    }
    public void button(){
        // Create Buttons
        JButton hitButton = new JButton("Hit");
        JButton standButton = new JButton("Stand");

        // Add Buttons to panel
        panel.add(hitButton);
        panel.add(standButton);
        hitButton.setBounds(250,400,80,25);
        standButton.setBounds(150,400,80,25);

        // Add usersHand text field
        JLabel usersHand = new JLabel(Integer.toString(hand));
        usersHand.setBounds(237,350,165,25);
        panel.add(usersHand);
    }
    public static void main(String[] args){
        new Blackjack();
    }
}
