/**
 * Holds the array for the places.
 * 
 * @author Brendan Kirtlan
 * @author Raghubir Chimni
 * @version 1.0
 */
public class List extends Places
{
    public Places[] places;
    private static int currentPlace = 0;
    
    /**
     * Constructor for List. Adds all places to places array.
     */
    public List()
    {
        places = new Places[8];
        places[0] = new Places("Shop", 0);
        places[1] = new Places("Mike's Mountain", 1);
        places[2] = new Places("Eerie Lake", 2);
        places[3] = new Places("Latvian Library", 3);
        places[4] = new Places("Sky Garden", 4);
        places[5] = new Places("Tenarius Tundra", 5);
        places[6] = new Places("Mount Mahiti", 6);
        places[7] = new Places("Castle of Folumtimus", 7);
    }

    /**
     * Prints out all the places.
     */
    public void placesPrint()
    {
        for(int i = 0; i < places.length; i++)
        {
            System.out.println(places[i].getPlaceName());
        }
    }

    /**
     * Returns the place name of the specified place.
     * @param int num the place you want to return
     * @return String the name of the place 
     */
    public String getName(int num)
    {
        return places[num].getPlaceName();
    }
    
    /**
     * Returns the current place.
     * @returh int value of current place
     */
    public static int getCurrentPlace()
    {
        return currentPlace;
    }
    
    /**
     * Sets the current place of the player to the specified place.
     * @param int x the place you want to set.
     */
    public static void setCurrentPlace(int x)
    {
        currentPlace = x;
    }
}
