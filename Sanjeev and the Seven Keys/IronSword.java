/**
 * Represents an iron sword weapon.
 * 
 * @author Brendan Kirtlan
 * @author Raghubir Chimni
 * @version 1.0
 */
import java.util.*;
public class IronSword extends Item{
    private Scanner scan = new Scanner(System.in);
    
    /**
     * Constructor for IronSword. Sets stats to specified values.
     */
    public IronSword()
    {
        super.setPower(1.5);
        super.setName("Iron Sword");
        super.setDescription("| Power 1.5");
        super.setPrice(500);
    }

    /**
     * Adds this object to the weapon array and prompts the user if they want to equip it.
     */
    public void addToInv()
    {
        String input = "";
        System.out.print("Would you like to equip the " + this.getName() + "? (Y/N):");
        input = scan.next();
        if(input.equalsIgnoreCase("Y")){
            super.getWeapons().add(0,this);
            System.out.println(this.getName() + " has been equipped!");
        }
        else{
            super.getWeapons().add(this);
            System.out.println(this.getName() + " has been put in your inventory.");
        }
    }
}