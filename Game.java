import java.util.Scanner;
import java.util.Random;

public class Game {
    private static final int PLAYER_HEALTH_MIN = 100;
    private static final int PLAYER_HEALTH_MAX = 200;
    private static final int ENEMY_HEALTH_MIN = 100;
    private static final int ENEMY_HEALTH_MAX = 200;
    private static final int ENEMY_DAMAGE_MIN = 20;
    private static final int ENEMY_DAMAGE_MAX = 50;
    
    private static final Items[] items = {
            new Items("Sword", 10, 0),
            new Items("Axe", 15, 0),
            new Items("Bow", 8, 0),
            new Items("Potion", 0, 20),
            new Items("Bandage", 0, 15),
            new Items("Herb", 0, 10),
            new Items("Amulet", 5, 10),
            new Items("Ring", 3, 15),
            new Items("Staff", 12, 5),
            new Items("Shield", 5, 20)
        };
	 public static void main(String[] args) {
		
		Champ ch1 = new Champ("Demon", "Hell", 60);
        Champ ch2 = new Champ("Marcus", "Old Trafford", 45);
        Champ ch3 = new Champ("Antony", "Old Trafford", 30); 
        Champ ch4 = new Champ("Sucre", "Prison", 50);
        Champ ch5 = new Champ("T-BAG", "Prison", 25);
	    
	       Scanner scan = new Scanner(System.in);
	       Random random = new Random();
	        
	        System.out.println("Welcome to League of Legends - Text Edition!");
	        
	        System.out.println("Choose a champion:");
	        System.out.println("1."+ ch1.name);
	        System.out.println("2."+ ch2.name);
	        System.out.println("3."+ ch3.name);
	        System.out.println("4."+ ch4.name);
	        System.out.println("5."+ ch5.name);
	        System.out.println("6. Quit");

	        int championChoice = scan.nextInt();

	        if (championChoice == 1) {
	            System.out.println("You chose " + ch1.name +" from "+ ch1.regions);
	        } else if (championChoice == 2) {
	            System.out.println("You chose "+ ch2.name +" from "+ ch2.regions);
	        } else if (championChoice == 3) {
	            System.out.println("You chose "+ ch3.name +" from "+ ch3.regions);
	        } else if (championChoice == 4) {
	            System.out.println("You chose "+ ch4.name +" from "+ ch4.regions);
	        } else if (championChoice == 5) {
	            System.out.println("You chose "+ ch5.name +" from "+ ch5.regions);
	        } else if (championChoice == 6) {
	            System.out.println("Thank you for playing!");
	            return;
	        } else {
	            System.out.println("Invalid choice. Exiting the game.");
	            return;
	        }	        
	       
	        int playerHealth = random.nextInt(PLAYER_HEALTH_MAX - PLAYER_HEALTH_MIN + 1) + PLAYER_HEALTH_MIN;
	        int enemyHealth = random.nextInt(ENEMY_HEALTH_MAX - ENEMY_HEALTH_MIN + 1) + ENEMY_HEALTH_MIN; 	        
	        int damageDealt = 0;
	         while (playerHealth > 0 && enemyHealth > 0) {
	            System.out.println("Choose an action:");
	            System.out.println("1. Attack");
	            System.out.println("2. Craft an item");
	            System.out.println("3. Quit");

	            int choice = scan.nextInt();

	            if (choice == 1) {
	            	 damageDealt = attackEnemy(championChoice);       
	            	 int damageReceived = random.nextInt(ENEMY_DAMAGE_MAX - ENEMY_DAMAGE_MIN + 1) + ENEMY_DAMAGE_MIN;

	            	    enemyHealth -= damageDealt;
	            	    playerHealth -= damageReceived;

	            	    System.out.println("You dealt " + damageDealt + " damage to the enemy!");
	            	    System.out.println("You received " + damageReceived + " damage from the enemy!");
	            	    System.out.println("Player Health: " + playerHealth);
	            	    System.out.println("Enemy Health: " + enemyHealth);
	            	
	            
	            } else if (choice == 2) {
	                System.out.println("Crafting Menu:");
	                for (int i = 0; i < items.length; i++) {
	                    System.out.println((i + 1) + ". " + items[i].getName());
	                }

	                int craftChoice = scan.nextInt();

	                if (craftChoice >= 1 && craftChoice <= items.length) {
	                    Items craftedItem = items[craftChoice - 1];
	                    playerHealth += craftedItem.getHealthBoost();
	                    damageDealt += craftedItem.getDamageBoost();
	                    System.out.println("You crafted a " + craftedItem.getName() + "!");
	                    System.out.println("Player Health: " + playerHealth);
	                    System.out.println("Damage Dealt: " + damageDealt);
	                } else {
	                    System.out.println("Invalid choice. Please try again.");
	                }
	            } else if (choice == 3) {
	                System.out.println("Thank you for playing!");
	                break;
	            } else {
	                System.out.println("Invalid choice. Please try again.");
	            }
	        }
	       
	        if (playerHealth <= 0) {
	            System.out.println("Game Over! You were defeated.");
	        } else if (enemyHealth <= 0) {
	            System.out.println("Congratulations! You defeated the enemy.");
	        }
	    }

	    private static int attackEnemy(int championChoice) {
	    
	        int damage = 0;

	        if (championChoice == 1) {
	            damage = 60;
	        } else if (championChoice == 2) {
	            damage = 45;  
	        } else if (championChoice == 3) {
	            damage = 30;  
	        } else if (championChoice == 4) {
	            damage = 50;
	        } else if (championChoice == 5) {
	            damage = 35;   
	        }

	        return damage;
	    }
 }
  
	   