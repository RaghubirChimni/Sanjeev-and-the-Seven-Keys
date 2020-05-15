/**
 * Represents the player.
 * 
 * @author Brendan Kirtlan
 * @author Raghubir Chimni
 * @version 1.0
 */
import java.util.*;
public class Sanjeev extends Entity{

    private int expNeeded = 50;
    private int maxHealth = 100;
    public static ArrayList<Boolean> keys = new ArrayList<Boolean>(7);
    private static int i = 0;

    Scanner scan = new Scanner(System.in);

    /**
     * Constructor for Sanjeev. Sets stats to specified values and gives him fists.
     */
    public Sanjeev(){
        super.setHealth(100);
        super.setAttackPower(200);
        super.setLevel(1);
        super.setExp(0);
        super.setName("Sanjeev Babu");
        super.setDescription("the Demigod");
        super.addPlayer(this);
        super.setGold(30);
        Fists fists = new Fists();
        for(int l = 0; l < 7; l++){
            keys.add(false);
        }
    }

    /**
     * Levels the player up. Adds 3 attack power, 20 health, restores full health, and sets needed exp to 3*needed exp
     */
    public void levelUp()
    {
        super.setLevel(super.getLevel()+1);
        System.out.println("You leveled up!");
        super.setAttackPower(super.getAttackPower() + 3);
        maxHealth += 20;
        super.setHealth(maxHealth);
        System.out.println("\n" + this);
        super.setExp(super.getExp() - expNeeded);
        expNeeded *= 3;
    }

    /**
     * Returns a string representation of Sanjeev with weapon, gold, and power.
     * @return String with weapon, gold, and power
     */
    public String toString()
    {
        return "=================================\n" + super.toString() + "\nWeapon: " + ((NamedThing)(super.getWeapons().get(0))).getName()
        + " | Power: " + ((Item)(super.getWeapons().get(0))).getPower() + "\nGold: " + super.getGold() + "\n=================================\n";
    }

    /**
     * Adds exp to the current exp and levels up if he has enough exp.
     * @param int x amount of xp to add
     */
    public void setExp(int x)
    {
        super.setExp(super.getExp() + x);
        while(super.getExp() > expNeeded){
            levelUp();
        }
    }

    /**
     * Prints out inventory then allows user to switch weapons.
     */
    public void inventory(){
        int x = 1;    
        while(x < getWeapons().size()){
            System.out.println(x + " - " + getWeapons().get(x));
            x++;
        }
        switchItems();
    }

    /**
     * Lets user switch weapons.
     */
    public void switchItems()
    {
        if(getWeapons().size() > 1){
            System.out.print("Which item would you like to equip? (number): ");
            int x = scan.nextInt();
            if (x > 0 && x <= getWeapons().size()){
                Collections.swap(getWeapons(), (x-1), 0);
                System.out.print("You equipped your " + ((Item)(getWeapons().get(0))).getName() + "\n");
            }
            else{
                System.out.println("Invalid number, please choose again");
                switchItems();
            }
        }
    }

    /**
     * Returns exp needed to level up.
     * @return int exp needed to level up
     */
    public int getExpNeeded(){
        return expNeeded;
    }

    /**
     * Returns max health.
     * @return int maximum health
     */
    public int getMaxHealth(){
        return maxHealth;
    }

    /**
     * Returns the keys array.
     * @return ArrayList keys array
     */
    public ArrayList getKeys(){
        return keys;
    }
    
    /**
     * Adds a key to the keys array.
     */
    public static void getKey(){
        keys.set(i, true);
        i++;
    }
}

