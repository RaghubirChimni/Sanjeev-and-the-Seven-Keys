/**
 * Represents the boss Cicero Homer
 * 
 * @author Brendan Kirtlan
 * @author Raghubir Chimni
 * @version 1.0
 */
public class Homer extends Boss
{
    /**
     * Constructor for Homer. Sets stats to specified values.
     */
    public Homer()
    {
        super("Cicero Homo the First Visionary", 60, 7, 10);
        super.addBoss(0,this);
        super.setGold(100);
    }

    /**
     * Returns the exp of the boss.
     * @return int exp
     */
    public int giveExp()
    {
        return 100;
    }

    /**
     * Called when boss dies. Adds a key to the players inventory.
     */
    public void die()
    {
        super.die();
        System.out.println("You have gained the Crimson Key.");
    }

    /**
     * Initializes a battle with the player against the boss.
     * @param Sanjeev player the player
     */
    public int battle(Sanjeev player)
    {
        boolean dead = false;
        boolean enemyDead = false;
        Homer h = new Homer(); 

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
            if(x < 25){
                System.out.println("\nThe Visionary predicted your move! No Damage was dealt!");
            }
         
                else
            {
                bosses.get(0).setHealth((bosses.get(0).getHealth() - (int)(entities.get(0).getAttackPower()*((Item)(getWeapons().get(0))).getPower())));
                System.out.println("\nYou" + " attacked for " 
                    + (int)(entities.get(0).getAttackPower()*((Item)(getWeapons().get(0))).getPower()) + " damage!"); //player's attack
            }
            
        }
        else
        {
            int y = ((int)(Math.random() * 102));
            if(y < 36){
                z = 5;
                System.out.println("\n" + bosses.get(0).getName() + " shot lasers at you with his staff.");
                super.entities.get(0).setHealth(entities.get(0).getHealth() - z);

            }
            else if(y > 40 && y < 70){
                z = 8;
                System.out.println("\n" + bosses.get(0).getName() + " hit you with his boomerang-staff.");
                super.entities.get(0).setHealth(entities.get(0).getHealth() - z);
            }
            else
            {
                z = 6;
                super.entities.get(0).setHealth(entities.get(0).getHealth() - z);
                System.out.println("\n" + bosses.get(0).getName() + " threw a poisoned potion at you.");

            }
            System.out.println(bosses.get(0).getName() + " attacked for " + z + " damage!"); //enemy attack

        }
    }
}
