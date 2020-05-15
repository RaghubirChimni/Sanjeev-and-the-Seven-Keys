/**
 * Represents a knight enemy.
 * 
 * @author Brendan Kirtlan
 * @author Raghubir Chimni
 * @version 1.0
 */
public class Knight extends Entity
{
    /**
     * Constructor for Knight. Sets stats to specified values.
     */
    public Knight(int playerLev)
    {
        super.setLevel(1 + (int)(Math.random()*playerLev));
        super.setHealth(50 + (15 * (super.getLevel()-1)));
        super.setAttackPower(10 + (2 * (super.getLevel()-1)));
        super.setName("Knight");
        super.addEnemy(this);
        super.setGold(30 + (super.getLevel()-1)*5);
        super.setExp((int)((Math.random()+.7)*(super.getLevel() * 7 * super.getAttackPower())));
    }
    
    /**
     * Returns a string representation of object.
     * @return String representation of the knight
     */
    public String toString()
    {
        return "\n" + super.toString() + "\n";
    }
}
