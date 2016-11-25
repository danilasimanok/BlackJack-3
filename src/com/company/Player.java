package com.company;

/**
 * Created by falyanguzov on 14.11.2016.
 */
public abstract class Player {
    public final String name;
    Hand hand = new Hand();
    private Intellect intellect;
    public Pobedunstvo pobedunstvo=Pobedunstvo.IN_GAME;

    public  Player(Intellect intellect,String name){
        this.intellect=intellect;
        this.name=name;
    }

    public void take(Card current) {
        hand.add(current);
    }

    public Command desision() {
        int score=hand.getScore();
        if(score>21)return Command.STAND;
        return intellect.decide(score);
    }
}
