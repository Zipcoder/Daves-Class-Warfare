package io.classwarfare;


import java.util.ArrayList;

public class Hand {
    ArrayList<Card> cardList=new ArrayList<Card>();

    Hand(ArrayList<Card> cardList){
        this.cardList=cardList;
    }
    //pass card in and add all the value together

    public double checkValue(){
        double totalValue=0;
        for (Card each: cardList) {
            totalValue+=each.getValue();
        }

        return totalValue;
    }


}
