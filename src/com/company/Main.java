package com.company;
import java.util.LinkedList;
import java.util.List;
public class Main {

    public static void main(String[] args) {
        List<Player> players = new LinkedList<>();
        players.add(new Computer(new LimitIntellect(14),"Vasya"));
        players.add(new Computer(new LimitIntellect(20),"Compuctor"));
        players.add(new Human(new ConsoleIntellect(),"Ya"));
        Dealer dealer=new Dealer("Dealer");
        players.add(dealer);

        for(Player player:players){
            dealer.deal(player);
            dealer.deal(player);
            System.out.println(player.name+" "+player.hand);
        }

        for(Player player:players){
            while (true){
                System.out.println(player.name);
                System.out.println(player.hand.getScore()+""
                +player.hand);
                Command command=player.desision();
                System.out.println(command);
                if(command==Command.STAND)
                    break;
                if(command==Command.HIT)
                    dealer.deal(player);
            }
        }

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
}
