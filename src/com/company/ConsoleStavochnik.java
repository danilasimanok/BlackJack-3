package com.company;

import java.util.Scanner;

/**
 * Created by student2 on 28.11.16.
 */
public class ConsoleStavochnik extends Stavochnik{
    public static Scanner in=new Scanner(System.in);
    @Override
    public int sdelatstavku(int ballance) {
        System.out.println("Sdelayte vashu stavku.");
        while(true){
            int stavka=in.nextInt();
            if(stavka<=ballance)
                return stavka;
            System.out.println("U tebya stolko net.");
        }
    }
}
