/**
 * Represents the player, an enemy, or a boss.
 * 
 * @author Brendan Kirtlan
 * @author Raghubir Chimni
 * @version 1.0
 */
import java.util.*;
public abstract class Entity extends NamedThing
{
    private int health;
    private int attackPower;
    private int level;
    private int gold;
    private int exp;
    public static ArrayList<Entity> entities = new ArrayList<Entity>();
    private Scanner scan = new Scanner(System.in);
    private boolean burned = false;
    private static int burnCounter = 0;

    /**
     * Determines which object calls the method, player or enemy, then attacks accordingly, subtracting the attack
     * power times the weapon power from the enemy's health.
     */
    public void attack()
    {
        if(this == entities.get(0)){
            entities.get(1).setHealth((entities.get(1).getHealth() - (int)(this.attackPower*((Item)(getWeapons().get(0))).getPower())));
            System.out.println("\n" + this.getName() + " attacked for " 
                + (int)(this.attackPower*((Item)(getWeapons().get(0))).getPower()) + " damage!"); //player's attack
            burn();
        }
        else{
            entities.get(0).setHealth(entities.get(0).getHealth() - entities.get(1).getAttackPower());
            System.out.println("\nThe " + this.getName() + " attacked for " + this.attackPower + " damage!"); //enemy attack
        }
    }

    /**
     * Determines if the weapon has burn then gives a 20% chance to burn the enemy then subtracts 10 health for 3 turns.
     */
    public void burn()
    {
        if(entities.get(1).getBurn())
        {
            entities.get(1).setHealth(entities.get(1).getHealth() - 10);
            System.out.println("The " + entities.get(1).getName() + " lost 10 health from their burn!");
            burnCounter++;
            if(burnCounter == 2){
                entities.get(1).setBurn(false);
                System.out.println("The " + entities.get(1).getName() + "'s burn wore off.");
                burnCounter = 0;
            }
        }
        else if(((Item)(getWeapons().get(0))).getBurn())
        {
            int x = (int)(Math.random()*5);
            if(x==0)
                {
                    System.out.println("The " + entities.get(1).getName() + " has been burned!");
                    entities.get(1).setHealth(entities.get(1).getHealth() - 10);
                    System.out.println("The " + entities.get(1).getName() + " lost 10 health from their burn!");
                    entities.get(1).setBurn(true);
                }
        }
    }
    
    /**
     * Sets the burn status of an enemy.
     */
    public void setBurn(boolean x){
        burned = x;
    }
    
    /**
     * Returns true if enemy is burned, false if not.
     * @return boolean wether or not enemy is burned.
     */
    public boolean getBurn(){
        return burned;
    }
    
    /**
     * Returns an enemy based on a random number generated in the battle method.
     * @param int x a random number if place is not eerie lake, tundra, or volcano
     * @param Sanjeev player the player
     */
    public Entity initializeEnemy (int x, Sanjeev player)
    {
        if(x==0 || x==1){
            Slime e = new Slime(player.getLevel());
            return e;
        }
        else if(x==2){
            Goblin e = new Goblin(player.getLevel());
            return e;
        }
        else if(x==10){
            MudMonster e = new MudMonster(player.getLevel());
            return e;
        }
        else if (x==11){
            Demon e = new Demon(player.getLevel());
            return e;
        }
        else if (x==12){
            Snowman e = new Snowman(player.getLevel());
            return e;
        }
        else {
            Knight e = new Knight(player.getLevel());
            return e;
        }
    }

    /**
     * Starts a battle with an enemy then loops until one is dead.
     * @param Sanjeev player the player
     */
    public int battle(Sanjeev player)
    {
        int x = 1;
        if(List.getCurrentPlace() == 2){
            x = 10;
        }
        else if(List.getCurrentPlace() == 5){
            x = 9;
        }
        else if(List.getCurrentPlace() == 6){
            x = 11;
        }
        else if(List.getCurrentPlace() == 8){
            x = 12;
        }
        else if(List.getCurrentPlace() < 4){
            x = (int)(Math.random()*3);
        }
        else
        {
            x = (int)(Math.random() * 3) + 2;
        }
        boolean dead = false;
        boolean enemyDead = false;
        Entity enemy = initializeEnemy(x, player);

        System.out.println("\nYou are being attacked by a " + enemy.getName() + "!");
        System.out.println("-------------------------------------------------");
        System.out.println(enemy);
        while(!dead){
            System.out.println("-------------------------------------------------");
            System.out.print("What do you want to do? (fight, run, item): ");
            String input = scan.next();
            System.out.print("-------------------------------------------------");
            if (input.equalsIgnoreCase("run")){
                if (run()){
                    System.out.println("");
                    entities.remove(1);
                    return 1;
                }
                else{
                    enemy.attack();
                    System.out.println("Your health is now " + this.getHealth() + ".\n");
                }
            }
            if (input.equalsIgnoreCase("fight")){
                attack();
                if(enemy.getHealth() >= 1)
                    System.out.println("The " + enemy.getName() + "'s health is now " + enemy.getHealth() + ".");
                if(enemy.getHealth() < 1){
                    dead = true;
                    enemyDead = true;
                    System.out.println("The " + enemy.getName() + "'s health is 0.");
                    System.out.println("You killed the " + enemy.getName() + "!");
                    player.setGold(player.getGold() + enemy.getGold());
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
                    System.out.println("You received " + enemy.getGold() + " gold! You now have " + player.getGold() + " gold.");
                    drop(enemy);
                    System.out.println("You have gained " + enemy.getExp() + " exp points.");
                    player.setExp(enemy.getExp());
                    System.out.println("You are now " + (player.getExpNeeded() - player.getExp() + 1) + " exp away from level " + (player.getLevel() + 1));
                    System.out.println("-------------------------------------------------\n");
                    entities.remove(1);
                    Story.sleep(2000);
                    return 1;
                }
                else{
                    enemy.attack();
                    if(this.getHealth() < 1){
                        Story.die();
                    }
                }
                System.out.println("Your health is now " + this.getHealth());
            }
            if(input.equalsIgnoreCase("item")){
                useItem(player);
            }
        }
        return 0;
    }

    /**
     * Deteremines wether or not the enemy will drop a potion.
     * @param Entity enemy the current enemy
     */
    public void drop(Entity enemy)
    {
        int x = ((int)(Math.random() * 101));
        SmallPotion e = new SmallPotion();
        LargePotion l = new LargePotion();
        if(x < 7)
        {
            getUsables().add(e);
            System.out.println("The " + enemy.getName() + " dropped a small potion! Added to inventory.");
        }
        else if(x > 98)
        {
            getUsables().add(l);
            System.out.println("The " + enemy.getName() + " dropped a lagre potion! Added to inventory.");
        }
    }
    
    /**
     * Lets the player use a potion to regenerate their health.
     * @param Sanjeev player the player
     */
    public int useItem(Sanjeev player)
    {
        int x = 0;
        System.out.println("");
        if(super.getUsables().size() != 0)
        {
            for(int n = 0; n < super.getUsables().size(); n++)
            {
                System.out.println((n+1) + " - " + super.getUsables().get(n));
            }
            System.out.print("What item would you like to use?(0 to go back): ");
            x = scan.nextInt();
            if(x==0)
                return 1;
            if((player.getHealth() + ((Item)super.getUsables().get(x-1)).getPower()) > player.getMaxHealth())
                player.setHealth(player.getMaxHealth());
            else
                player.setHealth(player.getHealth() + (int)((Item)super.getUsables().get(x-1)).getPower());
            System.out.println("\nYou took the " + ((Item)super.getUsables().get(x-1)).getName() + ". Your health is now " + player.getHealth() + "\n");
            super.getUsables().remove(x-1);
        }
        else
            System.out.println("You have no usable items!\n");
        return 1;
    }

    /**
     * Gives the player a chance to run.
     * @return boolean wether or not the player escaped.
     */
    public boolean run()
    {
        int x = (int)(Math.random() * 11);
        if(x > 4){
            System.out.println("\nYou ran!");
            return true;
        }
        else{
            System.out.println("\nYou failed to run!");
            return false;
        }
    }

    /**
     * Adds the player to the array.
     * @param Entity e the player
     */
    public void addPlayer(Entity e){
        entities.add(e);
    }

    /**
     * Adds the enemy to the array.
     * @param Entity e the enemy
     */
    public void addEnemy(Entity e){
        entities.add(e);
    }

    /**
     * Returns the attack power.
     * @return int attack power of enemy/player
     */
    public int getAttackPower()
    {
        return attackPower;
    }   

    /**
     * Returns the health.
     * @return int health of enemy/player
     */
    public int getHealth()
    {
        return health;
    }

    /**
     * Returns the level.
     * @return int level of enemy/player
     */
    public int getLevel()
    {
        return level;
    }

    /**
     * Sets the level.
     * @param int x level of enemy/plaer
     */
    public void setLevel(int x)
    {
        level = x;
    }

    /**
     * Sets the health.
     * @param int x health of enemy/plaer
     */
    public void setHealth(int x)
    {
        health = x;
    }

    /**
     * Sets the attack power.
     * @param int x attack power of enemy/plaer
     */
    public void setAttackPower(int x)
    {
        attackPower = x;
    }

    /**
     * Sets the name.
     * @param String n name of enemy/plaer
     */
    public void setName(String n)
    {
        super.setName(n);
    }

    /**
     * Sets the description.
     * @param String d description of enemy/plaer
     */
    public void setDescription(String d)
    {
        super.setDescription(d);
    }

    /**
     * Returns string representation of object with name, description, health, level, and attack power.
     * @return String with name, description, health, level, and attack power
     */
    public String toString()
    {
        return super.toString() + "\n" + "HP: " + health + " | Lv: " + level + " |  Atk Pwr: " + attackPower;
    }

    /**
     * Returns weapons array.
     * @return ArrayList the weapon array
     */
    public ArrayList getWeapons()
    {
        return super.getWeapons();
    }

    /**
     * Returns the gold.
     * @return int gold amount
     */
    public int getGold(){
        return gold;
    }

    /**
     * Sets the gold.
     * @param int x gold
     */
    public void setGold(int x){
        gold = x;
    }
    
    /**
     * Sets the exp.
     * @param int x exp
     */
    public void setExp(int x){
        exp = x;
    }
    
    /**
     * Returns the exp.
     * @return int x exp
     */
    public int getExp()
    {
        return exp;
    }
    
    /**
     * Returns the entities array.
     * @return ArrayList entities array
     */
    public ArrayList getEntities()
    {
        return entities;
    }
}
