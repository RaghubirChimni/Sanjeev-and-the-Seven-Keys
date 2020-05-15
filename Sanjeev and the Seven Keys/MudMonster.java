/**
 * Represents a mud monster enemy.
 * 
 * @author Brendan Kirtlan
 * @author Raghubir Chimni
 * @version 1.0
 */
public class MudMonster extends Entity
{
    /**
     * Constructor for MudMonster. Sets stats to specified values.
     */
    public MudMonster(int playerLev)
    {
        super.setLevel(1 + (int)(Math.random()*playerLev));
        super.setHealth(40 + (5 * (super.getLevel()-1)));
        super.setAttackPower(5 + (1 * (super.getLevel()-1)));
        super.setName("Mud Monster");
        super.addEnemy(this);
        super.setGold(30 + (super.getLevel()-1)*5);
        super.setExp((int)((Math.random()+.7)*(super.getLevel() * 10 * super.getAttackPower())));
    }
    
    /**
     * Returns a string representation of object.
     * @return String representation of the mud monster
     */
    public String toString()
    {
        return "\n" + super.toString() + "\n";
    }
}
