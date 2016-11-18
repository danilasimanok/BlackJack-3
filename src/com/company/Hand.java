package com.company;

import java.util.LinkedList;

/**
 * Created by falyanguzov on 14.11.2016.
 */
public class Hand extends LinkedList<Card> {
    public int score;{
        score=0;
        for(Card card:Hand.this){
            switch (card.value){
                case TWO:{score+=2;break;}
                case THREE:{score+=3;break;}
                case FOUR:{score+=4;break;}
                case FIVE:{score+=5;break;}
                case SIX:{score+=6;break;}
                case SEVEN:{score+=7;break;}
                case EIGHT:{score+=8;break;}
                case NINE:{score+=9;break;}
                case ACE:{score+=1;break;}
                default:score+=10;
            }
        }
    }
}
