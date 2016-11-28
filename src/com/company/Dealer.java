package com.company;

/**
 * Created by falyanguzov on 14.11.2016.
 */
public class Dealer extends Computer {
    Deck deck = new Deck();

    public Dealer(String name) {
        super(new DealerIntellect(),name, null);
    }

    public void deal(Player player) {
        Card current=deck.pop();
        player.take(current);
    }
}
