/**
 * Represents a boss.
 * 
 * @author Brendan Kirtlan
 * @author Raghubir Chimni
 * @version 1.0
 */
import java.util.*;
public abstract class Boss extends Entity
{
    public static ArrayList<Boss> bosses = new ArrayList<Boss>();
    public Scanner scan = new Scanner(System.in);
    public Boss(String name, int health, int power, int level)
    {
        super.setLevel(level);
        super.setHealth(health);
        super.setName(name);
        super.setAttackPower(power);
    }

    public abstract int giveExp();
    
    public void attack()
    {
        if(this == bosses.get(0)){
            bosses.get(1).setHealth((bosses.get(1).getHealth() - (int)(super.getAttackPower()*((Item)(getWeapons().get(0))).getPower())));
            System.out.println("\n" + this.getName() + " attacked for " 
                + (int)(super.getAttackPower()*((Item)(getWeapons().get(0))).getPower()) + " damage!"); //player's attack
        }
        else{
            bosses.get(0).setHealth(bosses.get(0).getHealth() - bosses.get(1).getAttackPower());
            System.out.println("\nThe " + this.getName() + " attacked for " + super.getAttackPower() + " damage!"); //enemy attack
        }
    }
    
    public void runBoss()
    {
        System.out.println("You can't run from a boss!");
    }
    
    public void addBoss(int x, Boss e){
        bosses.add(x,e);
    }
    
    public String toString()
    {
        return super.toString();
    }
    
    public void die(){
        super.setHealth(0);
        Sanjeev.getKey();
    }//health == 0
                                //gained this key
}

