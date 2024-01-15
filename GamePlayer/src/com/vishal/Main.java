package com.vishal;

public class Main {
	
	    public static void main(String[] args) {
	        Player1 player = new Player1("Abhay","sword",300);
	        System.out.println(player.getName());
	        player.damageByGun1();
	        player.damageByGun2();
	        player.heal();
	        player.damageByGun2();
	        player.heal();

	        System.out.println("----------*******************-----------");
	    
	    Player2 player2 = new Player2("nirbhay","gun",900,true);
	    System.out.println(player2.getName());
        player2.damageByGun1();
        player2.damageByGun2();
        player2.heal();
        player2.damageByGun2();
        player.heal();


    }
}

	


