/**
 * Represents fists, the default weapon.
 * 
 * @author Brendan Kirtlan
 * @author Raghubir Chimni
 * @version 1.0
 */
import java.util.*;
public class Fists extends Item{

    /**
     * Constructor for Fists. Sets stats to specified values.
     */
    public Fists()
    {
        super.setPower(1);
        super.setName("Fists");
        super.getWeapons().add(this);
    }

    /**
     * Overrides abstract parent method. Not used.
     */
    public void addToInv()
    {
    }
}