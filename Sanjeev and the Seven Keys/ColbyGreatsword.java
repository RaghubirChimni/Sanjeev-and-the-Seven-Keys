/**
 * Represents a Colby's Greatsword weapon.
 * 
 * @author Brendan Kirtlan
 * @author Raghubir Chimni
 * @version 1.0
 */
import java.util.*;
public class ColbyGreatsword extends Item{
    private Scanner scan = new Scanner(System.in);
    
    /**
     * Constructor for ColbysGreatsword. Sets stats to specified values.
     */
    public ColbyGreatsword()
    {
        super.setPower(5);
        super.setName("Colby's Greatsword");
        super.setDescription("| Infused love, purity, and Claire | Power 5.");
    }

    /**
     * Adds this object to the weapon array and prompts the user if they want to equip it.
     */
    public void addToInv()
    {
        String input = "";
        System.out.print("Would you like to equip " + this.getName() + " | Power 5? (Y/N):");
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