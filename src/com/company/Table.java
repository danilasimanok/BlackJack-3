package com.company;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by student2 on 28.11.16.
 */
public class Table {
    List<Player> players = new LinkedList<>();
    Dealer dealer=new Dealer("Dealer");

    public Table() {
        players.add(new Computer(new LimitIntellect(14),"Vasya",new CompuctorStavochnik()));
        players.add(new Computer(new LimitIntellect(20),"Compuctor",new CompuctorStavochnik()));
        players.add(new Human(new ConsoleIntellect(),"Ya",new ConsoleStavochnik()));
        players.add(dealer);
    }

    public void stavki(){
    for(Player player:players){
        if(player!=dealer){player.hand.stavka=player.tvoyastavka(player.ballance);
        System.out.println("Player "+player.name+" postavil "+player.hand.stavka);}
    }
    }

    public void rasdacha(){
        for(Player player:players){
            dealer.deal(player);
            dealer.deal(player);
            System.out.println(player.name+" "+player.hand);
        }
    }

    public void igra(){
        for(Player player:players){
            while (true){
                System.out.println(player.name);
                System.out.println(player.hand.getScore()+""
                        +player.hand);
                Command command=player.desision();
                if(player==dealer&&command==Command.DOUBLE)command=Command.HIT;
                System.out.println(command);
                if(command==Command.DOUBLE){
                    player.hand.stavka=player.hand.stavka*2;
                    dealer.deal(player);
                    command=Command.STAND;
                }
                if(command==Command.STAND)
                    break;
                if(command==Command.HIT)
                    dealer.deal(player);
            }
        }
    }

    public void pobedun(){
        for(Player player:players){
            if(player !=dealer) {
                boolean f = true;
                if (player.hand.getScore() > 21) {
                    player.pobedunstvo = Pobedunstvo.LOSER;
                    f = false;
                }
                if (f && dealer.hand.getScore() > 21) {
                    player.pobedunstvo = Pobedunstvo.NAGIBATOR;
                    f = false;
                }
                if (f)
                    if (dealer.hand.getScore() > player.hand.getScore()) player.pobedunstvo = Pobedunstvo.LOSER;
                    else if (dealer.hand.getScore() < player.hand.getScore())
                        player.pobedunstvo = Pobedunstvo.NAGIBATOR;
                    else player.pobedunstvo = Pobedunstvo.NICHYA;
                System.out.println(player.name + "-" + player.pobedunstvo+" whith "+player.hand.getScore());
            }
        }
    }

    public void platit(){
        for(Player player:players){
            boolean f=true;
            if(player.pobedunstvo==Pobedunstvo.NAGIBATOR){
                player.ballance=player.ballance+(player.k*player.hand.stavka);
                player.hand.stavka=0;
                f=false;
                player.k=1;
            }
            if(player.pobedunstvo==Pobedunstvo.LOSER){
                player.ballance=player.ballance-player.hand.stavka;
                player.hand.stavka=0;
                f=false;
                player.k=1;
            }
            if(f)player.k++;
        }
    }

    public void sbros(){
        for(Player player:players)player.hand.clear();
    }

    public void losers() {
        List<Player>bankrupts=new LinkedList<>();
        System.out.println("Ballance");
        for (Player player: players)if(player!=dealer){
            System.out.println(player.name+" "+player.ballance);
            if (player.ballance <= 0)bankrupts.add(player);
        }
        for (Player player:bankrupts) players.remove(player);
    }

    public boolean konec() {
        boolean f=true;
        for(Player player:players)
            if(player!=dealer)f=false;
        return !f;
    }
}
