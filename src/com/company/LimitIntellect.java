package com.company;

/**
 * Created by student2 on 18.11.16.
 */
public class LimitIntellect extends Intellect {
    public LimitIntellect(int limit) {
        this.limit = limit;
    }

    private int limit;

    @Override
    public Command decide(Player player){
        if(player.hand.getScore()<limit)
            if((player.hand.getScore()==11||(Math.random()<0.5))&&(player.hand.stavka*2<=player.ballance))
                return Command.DOUBLE;
            else return Command.HIT;

        else
            return Command.STAND;
    }
}
