/**
 * Represents the boss Sohan Kancherla
 * 
 * @author Brendan Kirtlan
 * @author Raghubir Chimni
 * @version 1.0
 */
public class Sohan extends Boss
{
    /**
     * Constructor for Sohan. Sets stats to specified values.
     */
    public Sohan()
    {
        super("Sohan Kancherla the Prophet", 250, 50, 100);
        super.addBoss(0,this);
        super.setGold(1000);
    }

    /**
     * Returns the exp of the boss.
     * @return int exp
     */
    public int giveExp()
    {
        return 10000;
    }

    /**
     * Initializes a battle with the player against the boss.
     * @param Sanjeev player the player
     */
    public int battle(Sanjeev player)
    {
        boolean dead = false;
        boolean enemyDead = false;
        Sohan h = new Sohan(); 

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
                System.out.println("Your health is now " + player.getHealth() );
            }
            if(input.equalsIgnoreCase("item")){
                useItem(player);
            }
        }
        return 0;
    }

    /**
     * Called when boss dies. Adds a key to the players inventory.
     */
    public void die()
    {
        System.out.println("You have broken Sohan's ankles!");
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
                System.out.println("\nThe Prophet shifts your move! No Damage was dealt!");
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
                z = 30;
                System.out.println("\n" + bosses.get(0).getName() + " hit you with his beloved clipboard!");
                super.entities.get(0).setHealth(entities.get(0).getHealth() - z);

            }
            else if(y > 40 && y < 70){
                z = 35;
                System.out.println("\n" + bosses.get(0).getName() + " entangled you with his mustache!");
                super.entities.get(0).setHealth(entities.get(0).getHealth() - z);
            }
            else
            {
                z = 40;
                super.entities.get(0).setHealth(entities.get(0).getHealth() - z);
                System.out.println("\n" + bosses.get(0).getName() + " broke your ankles!");

            }
            System.out.println(bosses.get(0).getName() + " attacked for " + z + " damage!"); //enemy attack

        }
    }

}