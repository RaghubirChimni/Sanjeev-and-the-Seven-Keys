/**
 * Represents a place.
 * 
 * @author Brendan Kirtlan
 * @author Raghubir Chimni
 * @version 1.0
 */
public class Places extends NamedThing{
    private String name;
    private static int placenum = 1;
    private int i = 0;
    
    /**
     * Constructor for Places. Sets the place number to 0.
     */
    public Places()
    {
        this.name = "";
        placenum = 0;
    }
    
    /**
     * Constructor for Places with paramters of name and place number.
     * @param String name the name of the place
     * @param int num the place number
     */
    public Places(String name, int num)
    {
        this.name = name;
        placenum = num;
    }

    /**
     * Returns the current place number of the player.
     * @return int the current place number
     */
    public int currentPlaceNum()
    {
        return placenum; 
    }
    
    /**
     * Returns the current place of the player.
     * @return String the current place name
     */
    public String getPlaceName()
    {
        return this.name;
    }
}