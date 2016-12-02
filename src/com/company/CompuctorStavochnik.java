package com.company;

/**
 * Created by student2 on 28.11.16.
 */
public class CompuctorStavochnik extends Stavochnik {
    @Override
    public int sdelatstavku(int ballance) {
        int stavka=50;
        while(Math.random()<0.5 && stavka+50<=ballance)
            stavka+=50;
        return stavka;
    }
}
