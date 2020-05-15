/**
 * Represents a snowman enemy.
 * 
 * @author Brendan Kirtlan
 * @author Raghubir Chimni
 * @version 1.0
 */
public class Snowman extends Entity
{
    /**
     * Constructor for Snowman. Sets stats to specified values.
     */
    public Snowman(int playerLev)
    {
        super.setLevel(1 + (int)(Math.random()*playerLev));
        super.setHealth(65 + (15 * (super.getLevel()-1)));
        super.setAttackPower(8 + (2 * (super.getLevel()-1)));
        super.setName("Snowman");
        super.addEnemy(this);
        super.setGold(35 + (super.getLevel()-1)*5);
        super.setExp((int)((Math.random()+.7)*(super.getLevel() * 7 * super.getAttackPower())));
    }
    
    /**
     * Returns a string representation of object.
     * @return String representation of the snowman
     */
    public String toString()
    {
        return "\n" + super.toString() + "\n";
    }
}
