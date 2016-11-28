package com.company;

/**
 * Created by falyanguzov on 14.11.2016.
 */
public abstract class Player {
    public final String name;
    Hand hand = new Hand();
    public int ballance=500;
    private Intellect intellect;
    private Stavochnik stavochnik;
    public Pobedunstvo pobedunstvo=Pobedunstvo.IN_GAME;
    public int k=1;

    public  Player(Intellect intellect,String name,Stavochnik stavochnik){
        this.intellect=intellect;
        this.name=name;
        this.stavochnik=stavochnik;
    }

    public void take(Card current) {
        hand.add(current);
    }

    public Command desision() {
        int score=hand.getScore();
        if(score>21)return Command.STAND;
        return intellect.decide(score);
    }

    public int tvoyastavka(int ballance) {
        return stavochnik.sdelatstavku(ballance);
    }
}
