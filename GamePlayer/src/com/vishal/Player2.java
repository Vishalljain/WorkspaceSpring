package com.vishal;

public class Player2  extends Player1{
	    private boolean armour;

	    public Player2(String name, String weapon, int health, boolean armour) {
	        super(name, weapon, health);
	        this.armour = armour;
	    }

	    @Override
	    public void damageByGun1() {
	        if(armour){
	            super.health -= 20;
	            if(super.health <=0) super.health = 0;
	            System.out.println("Armour is on. Got hit by gun 1. Health is reduced by 20." +
	                    "New health is "+ super.health);
	        } if(!armour){
	            super.health -= 30;
	            if(super.health <=0) super.health = 0;
	            System.out.println("Armour is off. Got hit by gun 1. Health is reduced by 30." +
	                    "New health is "+ super.health);
	        }
	        if(super.health == 0){
	            System.out.println(getName() + " is dead");
	        }
	    }

	    @Override
	    public void damageByGun2() {
	        if(armour){
	            super.health -= 40;
	            if(super.health <=0) super.health = 0;
	            System.out.println("Armour is on. Got hit by gun 1. Health is reduced by 40." +
	                    "New health is "+ super.health);
	        } if(!armour){
	            super.health -= 50;
	            if(super.health <=0) super.health = 0;
	            System.out.println("Armour is off. Got hit by gun 1. Health is reduced by 50." +
	                    "New health is "+ super.health);
	        }
	        if(super.health == 0){
	            System.out.println(getName() + " is dead");
	        }
	    }

	    @Override
	    public void heal() {
	        super.heal();
	    }
	}


