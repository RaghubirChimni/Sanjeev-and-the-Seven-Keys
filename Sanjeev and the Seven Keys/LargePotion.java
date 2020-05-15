/**
 * Represents a large potion usable.
 * 
 * @author Brendan Kirtlan
 * @author Raghubir Chimni
 * @version 1.0
 */
import java.util.*;
public class LargePotion extends Item{
    
    /**
     * Constructor for LargePotion. Sets stats to specified values.
     */
    public LargePotion()
    {
        super.setPower(50);
        super.setName("Large Potion");
        super.setDescription("| Restores 50 health");
        super.setPrice(50);
    }
    
    /**
     * Adds this object to the usables array.
     */
    public void addToInv()
    {
        super.getUsables().add(this);
    }
}