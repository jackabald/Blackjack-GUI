public class Deck {
    int handValue = 0;
    int numAces = 0;
    int[] cardValues = new int[]{2,3,4,5,6,7,8,9,10,10,10,10,11};

    public void nextCard(){
        int i = (int)(Math.random() * 13);
        handValue += cardValues[i];
        if(cardValues[i] == 11){
            numAces++;
        }
        if(handValue > 21 && numAces > 0){
            handValue = handValue - 10;
        }
    }
    public int getHandValue(){
        return handValue;
    }

}
