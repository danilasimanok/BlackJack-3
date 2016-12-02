package com.company;

import java.util.Scanner;

/**
 * Created by student2 on 21.11.16.
 */
public class ConsoleIntellect extends Intellect {
    private Scanner in=new Scanner(System.in);

    @Override
    public  Command decide(Player player){
        while(true){
            System.out.println("HIT/Stand/Double?");
            String c=in.nextLine();
            if("double".startsWith(c.toLowerCase()) && player.ballance>=player.hand.stavka*2)
                return Command.DOUBLE;
            if("hit".startsWith(c.toLowerCase()))
                return Command.HIT;
            if("stand".startsWith(c.toLowerCase()))
                return Command.STAND;

            if("double".startsWith(c.toLowerCase())) System.out.println("U tebya stolko net.");
            else System.out.println("Can't understand. Please, repeat");
        }
    }
}
