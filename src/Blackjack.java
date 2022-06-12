import javax.swing.*;
import java.awt.*;

public class Blackjack {
    public Blackjack() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(500, 500, 175, 500));
        panel.setLayout(new GridLayout(0,1));

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Blackjack");
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args){
        new Blackjack();
    }
}
