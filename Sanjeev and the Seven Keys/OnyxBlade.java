/**
 * Represents an onyx blade weapon.
 * 
 * @author Brendan Kirtlan
 * @author Raghubir Chimni
 * @version 1.0
 */
import java.util.*;
public class OnyxBlade extends Item{
    private Scanner scan = new Scanner(System.in);
    
    /**
     * Constructor for OnyxBlade. Sets stats to specified values.
     */
    public OnyxBlade()
    {
        super.setPower(2);
        super.setName("Onyx Blade");
        super.setDescription("| Power 2 | 20% Chance to Burn Enemies");
        super.burnTrue();
    }

    /**
     * Adds this object to the weapon array and prompts the user if they want to equip it.
     */
    public void addToInv()
    {
        String input = "";
        System.out.print("Would you like to equip the " + this + "? (Y/N):");
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