import java.util.ArrayList;
import java.util.Arrays;

public class Deck {
    ArrayList<String> card = new ArrayList<String>(Arrays.asList("Ace", "Two","Three","Four","Five","Six","Seven",
            "Eight", "Nine", "Ten", "Jack", "Queen", "King"));

    public String nextCard(){
        int i = (int)(Math.random() * 13);
        return card.get(i);
    }

}
