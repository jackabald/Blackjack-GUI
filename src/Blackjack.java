import javax.swing.*;

public class Blackjack {
    // value of hands
    int usersHand = 0;
    int dealersHand = 0;
    // frame and panel
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    // buttons
    JButton hitButton = new JButton("Hit");
    JButton standButton = new JButton("Stand");
    // labels
    JLabel usersHandText = new JLabel();
    JLabel dealersHandText = new JLabel();

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
        panel.setLayout(null);
    }
    public void buttons(){
        // Add Buttons to panel
        panel.add(hitButton);
        panel.add(standButton);
        hitButton.setBounds(250,400,80,25);
        standButton.setBounds(150,400,80,25);
    }
    public void textFields(){
        // Add usersHand text field
        JLabel usersHandText = new JLabel(Integer.toString(usersHand));
        usersHandText.setBounds(237,350,165,25);
        panel.add(usersHandText);

        // Add dealersHand text field
        JLabel dealerLabel = new JLabel("DEALER");
        dealerLabel.setBounds(215,70,165,25);
        JLabel dealersHandText = new JLabel(Integer.toString(dealersHand));
        dealersHandText.setBounds(237,100,165,25);
        panel.add(dealerLabel);
        panel.add(dealersHandText);
    }
    public static void main(String[] args){
        Blackjack newGame = new Blackjack();
    }
}
