package com.africa.semicolon.learn.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionShuffleMain {
    public static void main(String[] args) {
       CollectionShuffleMain shuffle= new CollectionShuffleMain();
       shuffle.printCards();
    }
    private final List<CollectionShuffle> list;

    public CollectionShuffleMain(){
        CollectionShuffle[] cardShuffle = new CollectionShuffle[52];
        int count = 0;

        for(CollectionShuffle.Suit suit: CollectionShuffle.Suit.values()){
            for (CollectionShuffle.Face face:CollectionShuffle.Face.values()){
                cardShuffle[count] = new CollectionShuffle(face, suit);
                ++count;
            }
        }
        list= Arrays.asList(cardShuffle);
        Collections.shuffle(list);
    }

    public void printCards(){
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%-19s%s", list.get(i).toString(),((i+1)%4 == 0)? "\n": "");
        }
    }
}
