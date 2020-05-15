/**
 * Represents an item.
 * 
 * @author Brendan Kirtlan
 * @author Raghubir Chimni
 * @version 1.0
 */
import java.util.*;
public abstract class Item extends NamedThing{

    private double power = 1;
    private int price;
    private boolean burn = false;

    /**
     * Sets the power of the item.
     * @param double x the power
     */
    public void setPower(double x){
        power = x;
    }

    /**
     * Returns the weapon array.
     * @return ArrayList the weapon array
     */
    public ArrayList getWeapons()
    {
        return super.getWeapons();
    }

    /**
     * Returns the usable items array.
     * @return ArrayList the usable items array
     */
    public ArrayList getUsables()
    {
        return super.getUsables();
    }

    /**
     * Sets the name of the item.
     * @param String n the name
     */
    public void setName(String n)
    {
        super.setName(n);
    }

    /**
     * Sets the description of the item.
     * @param String n the description
     */
    public void setDescription(String n)
    {
        super.setDescription(n);
    }

    /**
     * Returns the power of an item.
     * @return double the item power
     */
    public double getPower(){
        return power;
    }

    /**
     * Returns the price of an item.
     * @return int the item price
     */
    public int getPrice(){
        return price;
    }

    /**
     * Sets the price of the item.
     * @param int x the price
     */
    public void setPrice(int x){
        price = x;
    }

    /**
     * Abstract method that adds the item to the inventory.
     */
    public abstract void addToInv();

    /**
     * Returns the burn status of an item.
     * @return bolean whether or not the item burns.
     */
    public boolean getBurn()
    {
        return burn;
    }

    /**
     * Sets the burn to true of an item
     */
    public void burnTrue()
    {
        burn = true;
    }
}