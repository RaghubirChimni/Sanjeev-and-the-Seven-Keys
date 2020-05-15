/**
 * Represents a slime enemy.
 * 
 * @author Brendan Kirtlan
 * @author Raghubir Chimni
 * @version 1.0
 */
public class Slime extends Entity
{
    /**
     * Constructor for Slime. Sets stats to specified values.
     */
    public Slime(int playerLev)
    {
        super.setLevel(1 + (int)(Math.random()*playerLev));
        super.setHealth(10 + (3 * (super.getLevel()-1)));
        super.setAttackPower(2 + (1 * (super.getLevel()-1)));
        super.setName("Slime");
        super.addEnemy(this);
        super.setGold(4 + (super.getLevel()-1)*1);
        super.setExp((int)((Math.random()+.7)*(super.getLevel() * 3 * super.getAttackPower())));
    }
    
    /**
     * Returns a string representation of object.
     * @return String representation of the slime
     */
    public String toString()
    {
        return "\n" + super.toString() + "\n";
    }
}
