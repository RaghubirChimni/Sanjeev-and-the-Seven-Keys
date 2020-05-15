/**
 * Represents a small potion usable.
 * 
 * @author Brendan Kirtlan
 * @author Raghubir Chimni
 * @version 1.0
 */
import java.util.*;
public class SmallPotion extends Item{
    
    /**
     * Constructor for SmallPotion. Sets stats to specified values.
     */
    public SmallPotion()
    {
        super.setPower(20);
        super.setName("Small Healing Potion");
        super.setDescription("| Restores 20 health");
        super.setPrice(30);
    }
    
    /**
     * Adds this object to the usables array.
     */
    public void addToInv()
    {
        super.getUsables().add(this);
    }
}