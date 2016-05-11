package io.classwarfare;


import java.util.ArrayList;

public class Hand {
   ArrayList<Card> cardList=new ArrayList<Card>();


    public double checkValue(){
        double totalValue=0;
        for (Card each: cardList) {
            totalValue+=each.getValue();
        }

        return totalValue;
    }


}
