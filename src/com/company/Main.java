package com.company;
public class Main {

    public static void main(String[] args) {
        Table table=new Table();
        while(table.konec()){
        table.stavki();
        table.rasdacha();
        table.igra();
        table.pobedun();
        table.platit();
        table.sbros();
        table.losers();}
        System.out.println("TADAM!");
    }
}
