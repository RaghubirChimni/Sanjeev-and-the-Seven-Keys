/**
 * Represents a demon enemy.
 * 
 * @author Brendan Kirtlan
 * @author Raghubir Chimni
 * @version 1.0
 */
public class Demon extends Entity
{
    /**
     * Constructor for Demon. Sets stats to specified values.
     */
    public Demon(int playerLev)
    {
        super.setLevel(1 + (int)(Math.random()*playerLev));
        super.setHealth(60 + (15 * (super.getLevel()-1)));
        super.setAttackPower(12 + (2 * (super.getLevel()-1)));
        super.setName("Demon");
        super.addEnemy(this);
        super.setGold(35 + (super.getLevel()-1)*5);
        super.setExp((int)((Math.random()+.7)*(super.getLevel() * 7 * super.getAttackPower())));
    }

    /**
     * Returns a string representation of object.
     * @return String representation of the demon
     */
    public String toString()
    {
        return "\n" + super.toString() + "\n";
    }
}
