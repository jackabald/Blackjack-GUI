public class Hand {
    String name;
    int handValue = 0;
    int numAces = 0;
    int[] cardValues = new int[]{2,3,4,5,6,7,8,9,10,10,10,10,11};
    public Hand(String name){
        this.name = name;
    }

    public void nextCard(){
        int i = (int)(Math.random() * 13);
        handValue += cardValues[i];
        if(cardValues[i] == 11){
            numAces++;
        }
        if(handValue > 21 && numAces > 0){
            handValue = handValue - 10;
            numAces--;
        }
        System.out.print(name + " DREW ");
        if(i == 0){
            System.out.println("A TWO");
        }
        if(i == 1){
            System.out.println("A THREE");
        }
        if(i == 2){
            System.out.println("A FOUR");
        }
        if(i == 3){
            System.out.println("A FIVE");
        }
        if(i == 4){
            System.out.println("A SIX");
        }
        if(i == 5){
            System.out.println("A SEVEN");
        }
        if(i == 6){
            System.out.println("AN EIGHT");
        }
        if(i == 7){
            System.out.println("A NINE");
        }
        if(i == 8){
            System.out.println("A TEN");
        }
        if(i == 9){
            System.out.println("A JACK");
        }
        if(i == 10){
            System.out.println("A QUEEN");
        }
        if(i == 11){
            System.out.println("A KING");
        }if(i == 12){
            System.out.println("AN ACE");
        }
        if(handValue > 21){
            System.out.println("BUSTED");
        }
    }
    public void dealerDraw(){
        // Dealer must stand on 17
        while(handValue < 17){
            nextCard();
        }
    }
    public int getHandValue(){
        return handValue;
    }

}
