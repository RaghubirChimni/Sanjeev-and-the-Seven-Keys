/**
 * Represents the boss Flavian Blastna
 * 
 * @author Brendan Kirtlan
 * @author Raghubir Chimni
 * @version 1.0
 */
public class Flavian extends Boss
{
    /**
     * Constructor for Flavian. Sets stats to specified values.
     */
    public Flavian()
    {
        super("Flavian Blastna the Lighting Deity", 90, 15, 15);
        super.addBoss(0,this);
        super.setGold(150);
    }

    /**
     * Returns the exp of the boss.
     * @return int exp
     */
    public int giveExp()
    {
        return 150;
    }

    /**
     * Initializes a battle with the player against the boss.
     * @param Sanjeev player the player
     */
    public int battle(Sanjeev player)
    {
        boolean dead = false;
        boolean enemyDead = false;
        Flavian h = new Flavian(); 

        System.out.println("\nYou are being attacked by " + h.getName() + "!\n-------------------------------------------------\n");
        System.out.println(h);
        System.out.println();
        while(!dead){
            System.out.println("-------------------------------------------------");
            System.out.print("What do you want to do? (fight, run, item): ");
            String input = scan.next();
            System.out.print("-------------------------------------------------");
            if (input.equalsIgnoreCase("run")){
                runBoss();
                System.out.print("\nWhat do you want to do? (fight, run, item): ");
                input = super.scan.next();
            }
            if (input.equalsIgnoreCase("fight")){
                attack();
                if(h.getHealth() >= 1)
                    System.out.println(h.getName() + "'s health is now " + h.getHealth() + ".");
                if(h.getHealth() < 1){
                    dead = true;
                    enemyDead = true;
                    System.out.println("The " + h.getName() + "'s health is 0");
                    System.out.println("You killed " + h.getName() + "!");
                    player.setGold(player.getGold() + h.getGold());
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("You received " + h.getGold() + " gold! You now have " + player.getGold() + " gold.");
                    die();
                    System.out.println("You have gained " + h.giveExp() + " exp points.");
                    player.setExp(h.giveExp());
                    System.out.println("You are now " + (player.getExpNeeded() - player.getExp()) + " exp away from level " + (player.getLevel() + 1) + ".");
                    System.out.println("-------------------------------------------------\n");
                    bosses.remove(0);
                    return 1;
                }
                else{
                    h.attack();
                    if(player.getHealth() < 1){
                        Story.die();
                        return -1;
                    }
                }
                System.out.println("Your health is now " + player.getHealth());
            }
            if(input.equalsIgnoreCase("item")){
                useItem(player);
            }
        }
        return 0;
    }

    /**
     * The attack for both the player and the boss
     */
    public void attack()
    {
        int x = ((int)(Math.random() * 102));
        int z;
        if(this != bosses.get(0)){
            if(x < 20){
                System.out.println("\nThe Lightning Deity bolted past your move! No Damage was dealt!");
            } 
            else
            {
                bosses.get(0).setHealth((bosses.get(0).getHealth() - (int)(entities.get(0).getAttackPower()*((Item)(getWeapons().get(0))).getPower())));
                System.out.println("\nYou" + " attacked for " 
                    + (int)(entities.get(0).getAttackPower()*((Item)(getWeapons().get(0))).getPower()) + " damage!"); //player's attack
            }
        }
        else {
            int y = ((int)(Math.random() * 102));
            if(y< 36){
                z = 12;
                System.out.println("\n" + bosses.get(0).getName() + " paralyzes you for a few seconds!");
                super.entities.get(0).setHealth(entities.get(0).getHealth() - z);

            }
            else if(y < 70 && y> 40){
                z = 16;
                System.out.println("\n" + bosses.get(0).getName() + " has struck you with a lighting bolt...");
                super.entities.get(0).setHealth(entities.get(0).getHealth() - z);
            }
            else
            {
                z = 12;
                super.entities.get(0).setHealth(entities.get(0).getHealth() - z);
                System.out.println("\n" + bosses.get(0).getName() + " creates an orb of electricity and\n"
                + "throws it at the ground, shocking everything in touch with it.");

            }
            System.out.println(bosses.get(0).getName() + " attacked for " + z + " damage!"); //enemy attack
        }

    }

    /**
     * Called when boss dies. Adds a key to the players inventory.
     */
    public void die()
    {
        super.die();
        System.out.println("You have gained the Lightning Key.");
    }
}
