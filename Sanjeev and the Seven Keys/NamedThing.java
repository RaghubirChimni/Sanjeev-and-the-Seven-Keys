/**
 * Represents any named thing.
 * 
 * @author Brendan Kirtlan
 * @author Raghubir Chimni
 * @version 1.0
 */
import java.util.*;
public abstract class NamedThing
{
    private String name = "";
    private String description = "";
    private static ArrayList<NamedThing> weapons = new ArrayList<NamedThing>();
    private static ArrayList<Item> usables = new ArrayList<Item>();

    /**
     * Returns the name.
     * @return String name
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Sets the name to the paramter.
     * @param String name the name.
     */
    public void setName(String n)
    {
        name = n;
    }
    
    /**
     * Sets the description to the paramter.
     * @param String description the description.
     */
    public void setDescription(String d)
    {
        description = d;
    }
    
    /**
     * Returns a string representation of the object with name and description.
     * @return String with name and description
     */
    public String toString()
    {
        return name + " " + description;
    }
    
    /**
     * Returns the array of weapons the player has.
     * @return ArrayList with weapons
     */
    public ArrayList getWeapons()
    {
        return weapons;
    }
    
    /**
     * Returns the array of usable items the player has.
     * @return ArrayList with usable items
     */
    public ArrayList getUsables()
    {
        return usables;
    }
}
