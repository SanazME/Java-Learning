package com.sanaz;

public class Main {

    public static void main(String[] args) {
//	    Player player = new Player();
//        player.name = "Tim";
//        player.health = 20;
//        player.weapon = "Sword";
//
//        int damage = 10;
//        player.loseHealth(damage);
//        System.out.println("Remaining health =  " + player.healthRemaining());
//
//        damage = 11;
//        player.loseHealth(damage);
//        System.out.println("Remaining health =  " + player.healthRemaining());

        EnhancedPlayer player = new EnhancedPlayer("Tim", 50, "sword");
        System.out.println("Initial health is " + player.getHealth());

        EnhancedPlayer player2 = new EnhancedPlayer("Tim", 300, "sword");
        System.out.println("Initial health is " + player2.getHealth());
    }
}
