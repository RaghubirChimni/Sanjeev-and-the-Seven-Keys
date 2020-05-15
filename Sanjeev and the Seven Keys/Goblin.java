/**
 * Represents a goblin enemy.
 * 
 * @author Brendan Kirtlan
 * @author Raghubir Chimni
 * @version 1.0
 */
public class Goblin extends Entity
{
    /**
     * Constructor for Goblin. Sets stats to specified values.
     */
    public Goblin(int playerLev)
    {
        super.setLevel(1 + (int)(Math.random()*playerLev));
        super.setHealth(20 + (10 * (super.getLevel()-1)));
        super.setAttackPower(3 + (2 * (super.getLevel()-1)));
        super.setName("Goblin");
        super.addEnemy(this);
        super.setGold(10 + (super.getLevel()-1)*3);
        super.setExp((int)((Math.random()+.7)*(super.getLevel() * 7 * super.getAttackPower())));
    }
    
    /**
     * Returns a string representation of object.
     * @return String representation of the goblin
     */
    public String toString()
    {
        return "\n" + super.toString() + "\n";
    }
}
