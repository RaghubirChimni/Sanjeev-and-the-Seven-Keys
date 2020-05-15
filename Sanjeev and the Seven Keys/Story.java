/**
 * Prints out the story text for the game.
 * 
 * @author Brendan Kirtlan
 * @author Raghubir Chimni
 * @version 1.0
 */
import java.util.*;
public abstract class Story{

    static Scanner scan = new Scanner(System.in);
    private static String input = "";
    private static int intput = 0;
    private static ArrayList <Item> shop = new ArrayList<Item>();
    private static boolean mushroom = true;
    private static boolean firstTown = true;
    private static boolean saloon = true;
    private static boolean geyser = true;
    private static boolean volcanoChest = true;
    private static ArrayList <Boolean> bossesAlive = new ArrayList<Boolean>();

    /**
     * Starts the story and prompts to ask if the player wants to go to the shop.
     * @param Sanjeev player the player
     * @return 1
     */
    public static int part1(Sanjeev player)
    {
        SmallPotion sPotion = new SmallPotion();
        shop.add(sPotion);
        LargePotion lPotion = new LargePotion();
        shop.add(lPotion);
        IronSword ironSword = new IronSword();
        shop.add(ironSword);
        DragonTooth dTooth = new DragonTooth();
        shop.add(dTooth);
        for(int x = 0; x < 6; x++){
            bossesAlive.add(true);
        }
        System.out.print("You slowly open your eyes to find yourself waking up in a pile of grass.\n"
            + "You look down and see a large metal sword protruding from your leg.\n"
            + "You see a beaten up shack with a rusty open sign glowing.\n");
        System.out.print("\nWould you like to go explore?(Y/N): ");
        input = scan.next();
        if(input.equalsIgnoreCase("y")){
            List.setCurrentPlace(0);
            part2(player);
        }
        else{
            System.out.println("\nYou decide to lay back down in the grass and slowly black out.");
            return 1;
        }
        return 1;
    }

    /**
     * Prints out story for the part when the player is in the shop.
     * @param Sanjeev player the player
     * @return 1
     */
    public static int part2(Sanjeev player)
    {
        System.out.print("\nYou slowly stumble torwards the shop where the door suddenly swings open.\n"
            + "You see a bug-eyed old wrinkly shop owner staring at you from inside.\n"
            + "You see a red shimmer from behind the counter.\n");
        sleep(2000);
        System.out.print("\nShop-Owner: \"It\'s been quite a while since we\'ve had a visitor around here.\n"
            + "             Legend has it the last man to step foot in this shop was eaten alive\n"
            + "             by the Kraken.\"\n");
        sleep(1500);
        System.out.print("\nSanjeev:    \"W-w-where am I?\"\n");
        sleep(1500);
        System.out.print("\nShop-Owner: \"You have found yourself in the land of Folumptimus.\"\n");
        sleep(1500);
        while(!input.equals("3")){
            System.out.print("\n1 - Ask how to get out.\n2 - Ask what he has for sale.\n3 - Leave.\nInput: ");
            input = scan.next();
            if (input.equals("1")){
                System.out.print("\nSanjeev:    \"How do I get out of here?\"\n");
                sleep(1000);
                System.out.print("\nShop-Owner: \"Legend has it only one man knows how to get out of here alive.\n"
                    + "             His name is Jeremy.\"\n");
                sleep(1500);
                System.out.print("\nSanjeev:    \"Where is he?\"\n");
                sleep(1000);
                System.out.println("\nShop-Owner: \"He has been kidnapped by Sohan, kingpin of the Russian mafia.\n"
                    + "             He is locked behind a magical padlock, with 7 keys. The only way\n"
                    + "             to obtain these 7 keys is by defeating the mythical beasts inhabiting\n"
                    + "             the cursed lands of Biggoti. It is a very dangerous task that no man\n"
                    + "             has lived to tell the tale.\"");
                sleep(2500);
            }
            else if (input.equals("2")){
                shop(player);
            }
        }
        if(input.equals("3"))
            part3(player);
        return 1;
    }

    /**
     * Prints out story for when the player battles the first boss.
     * @param Sanjeev player the player
     * @return 1
     */
    public static int part3(Sanjeev player)
    {
        System.out.print("\nAs you are walking out the door, the shop owner hurls a stale biscuit at\n"
            + "you from behind the counter. You turn around and see him walking out in a magnificent\n"
            + "purple wizard robe.\n");
        sleep(1500);
        System.out.print("\nShop-Owner: \"You ignorant fool. Did you really think you could get out of here alive?.\n"
            + "             I am Cicero Homo, the first visionary, and holder of the crimson key.\n"
            + "             Face me now and perish.\"\n");
        sleep(2000);
        System.out.print("\nSanjeev:    \"W-what? Why would you throw a biscuit at me?! Die!\"\n"
            + "\nFace Cicero Homo? (Y/N): ");
        input = scan.next();
        if(input.equalsIgnoreCase("Y")){
            Homer h = new Homer();
            h.battle(player);
        }
        else{
            System.out.println("\nCicero jumps on top of you and forces you into a fight.");
            sleep(1000);
            Homer h = new Homer();
            h.battle(player);
        }
        part4(player);
        return 1;
    }

    /**
     * Prints out story for when you exit the shop.
     * @param Sanjeev player the player
     * @return 1
     */
    public static int part4(Sanjeev player)
    {
        System.out.println("You are sweating profusely as you stand up, preparing for your journey.");
        sleep(2000);
        travelFirst(player);
        return 1;
    }

    /**
     * Prints out story for when you come to the first crossroad of the forest, town, geyser, and casltle. Also gives
     * option to access shop and menu.
     * @param Sanjeev player the player
     * @return 1
     */
    public static int travelFirst(Sanjeev player)
    {
        int o = 0;
        List.setCurrentPlace(0);
        System.out.print("\nYou look around and see several areas to go.\n"
            + " 1 - Wooded Burton Forrest.\n"
            + " 2 - Abandoned town.\n"
            + " 3 - Geyser Grounds.\n"
            + " 4 - Folumptimus Castle.\n"
            + " 5 - Return to Shop.\n"
            + " 6 - Access Menu.\n"
            + "Input: ");

        while(o != 1 && o != 2 && o != 3 && o != 4 && o != 5 && o != 8049)
        {
            o = scan.nextInt();
            if(o == 1)
                forrest(player);
            else if(o == 2)
                town(player);
            else if(o == 3)
                geyser(player);
            else if(o == 4)
                castle(player);
            else if(o==5){
                shop(player);
                travelFirst(player);
            }
            else if(o == 6)
                menu(player);
            else if(o == 8049)
                colby(player);
            else {
                System.out.print("Please enter a valid input:");
                o = scan.nextInt();
            }
        }
        return 1;
    }

    /**
     * Prints out questions to get Colby's Greatsword.
     * @param Sanjeev player the player
     */
    public static void colby(Sanjeev player){
        System.out.println("\nHello Colby. To access your weapon, answer the following questions.");
        sleep(3000);
        System.out.print("\nWhat is your mother's name?: ");
        input = scan.next();
        if(input.equalsIgnoreCase("Roxanne")){
            System.out.print("Correct.\nNext Question: Is your brother a bigger stud than you?(Yes/No): ");
            input = scan.next();
            if(input.equalsIgnoreCase("Yes")){
                System.out.print("Correct.\nNext Question: Who has the dreamiest eyes?: ");
                input = scan.next();
                if(input.equalsIgnoreCase("Michaela")){
                    System.out.println("\nYou have passed the security test. Here you go.\n");
                    ColbyGreatsword colby = new ColbyGreatsword();
                    colby.addToInv();
                    travelFirst(player);
                }
            }
        }
        System.out.println("Wrong");
        travelFirst(player);
    }

    /**
     * Prints out story for when the player is in the forest.
     * @param Sanjeev player the player
     * @return 1
     */
    public static int forrest(Sanjeev player)
    {
        System.out.print("\nYou begin your journey over to the Wooded Burton Forrest.\n\n"
            + "As you are walking, you hear a rustle from behind a bush.\n"
            + "Go to check it out? (Y/N):");
        input = scan.next();
        if(input.equalsIgnoreCase("y")){
            System.out.println("\nYou carefully walk over to the bush and get startled when you see\n"
                + "a blur jump out at you.");
            sleep(2400);
            player.battle(player);
        }
        else{
            System.out.println("\nYou ignore the rustle and continue on your journey.\n");
            sleep(2000);   
        }
        System.out.print("The path in front of you splits once again. Where would you like to go?\n"
            + " 1 - Mike's Mountain\n"
            + " 2 - Eerie Lake\n"
            + " 3 - Back\n"
            + "Input:");
        intput = 0;
        while(intput != 1 && intput != 2 && intput != 3){
            intput = scan.nextInt();
            if(intput == 1)
                mikesMountain(player);
            else if(intput == 2)
                eerieLake(player); 
            else if(intput == 3)
                travelFirst(player);
            else
                System.out.print("Please enter a valid input:");
        }
        return 1;
    }

    /**
     * Prints out story for when the player is at Mike's Mountain.
     * @param Sanjeev player the player
     * @return 1
     */
    public static int mikesMountain(Sanjeev player)
    {
        System.out.print("\nYou traverse your way through to the end of the treeline where\n"
            + "jagged rocks start to protrude form the earth.\n\n");
        sleep(2500);
        if(mushroom){
            System.out.print("You see a glowing mushroom growing on top of one of the rocks\n"
                + "Would you like to eat it? (Y/N):");
            input = scan.next();
            int o = (int)(Math.random() * 2);
            if(input.equalsIgnoreCase("Y")){
                mushroom = false;
                if(o == 0)
                {
                    System.out.print("\nYou eat the mushroom. It's quite delicious.\n"
                        + "Restored 20 health!");
                    if(player.getHealth() + 20 <= player.getMaxHealth())
                        player.setHealth(player.getHealth() + 20);
                    else
                        player.setHealth(player.getMaxHealth());
                    System.out.println(" Your health is now " + player.getHealth() + ".\n");
                }
                else
                {
                    System.out.print("\nYou eat the mushroom. You start to feel dizzy.\n");
                    sleep(1000);
                    System.out.println("Lost 20 health!");
                    player.setHealth(player.getHealth() - 20);
                    System.out.println("Your health is now " + player.getHealth() + ".\n");
                    if(player.getHealth() <= 0)
                        die();
                }
                sleep(2000);
            }
            else
                System.out.println("\nYou decide to ignore the mushroom.\n");
        }

        System.out.println("You begin to make your way up the mountain when a gust of wind suddenly knocks\n"
            + "you down. An enemy jumps on top of you!");
        sleep(2500);
        player.battle(player);
        sleep(500);
        if(bossesAlive.get(0))
        {
            System.out.println("You continue to climb up the mountain. You finally reach the top as you hear a\n"
                + "voice calling down to you.");
            sleep(2500);
            System.out.print("\n?????:     \"Sanjeev...");
            sleep(2000);
            System.out.println(" Leave now. Do not disturb me in my peace.\"");
            sleep(2000);
            System.out.print("\nLeave? (Y/N):");
            input = scan.next();
            if(input.equalsIgnoreCase("Y")){
                System.out.println("\nYou decide to obey the voice and leave.");
                sleep(1000);
                travelFirst(player);
            }
            else{
                System.out.println("\nFlavian Blastna: \"How dare you disobey a god. I am Flavian Blastna, lightning deity,\n"
                    + "                  and keeper of the lightning key. Perish.\"");
                sleep(2000);
                Flavian f = new Flavian();
                f.battle(player);
                System.out.println("You make your way over to where Flavian was standing and pick up a moving ball\n"
                    + "of lightning. It's a key.");
                sleep(2000);
                System.out.println("\nYou traverse your way back down the mountain, back to where you came from.");
                bossesAlive.set(0, false);
                travelFirst(player);
            }
        }
        else{
            System.out.println("The top of the mountain has been destroyed. You return back.");
            travelFirst(player);
        }
        return 1;
    }

    /**
     * Prints out story for when the player is at Eerie Lake.
     * @param Sanjeev player the player
     * @return 1
     */
    public static int eerieLake(Sanjeev player)
    {
        List.setCurrentPlace(2);
        System.out.print("\nYou hear the quiet, calming sound of the lake, almost eerie-like.\n"
            + "You start to see the light, shimmering waves gently crash into the muddy shoreline.\n");
        sleep(3000);
        System.out.print("\nAs you continue to walk out to the water, you feel your foot get\n"
            + "snagged against something in the mud. You try to yank your foot free,\n"
            + "but it's no use. You see a giant, muddy shape emerge from the gound.\n");
        sleep(3000);
        player.battle(player);
        sleep(2000);
        if(!bossesAlive.get(1)){
            System.out.println("You notice the lake is nothing but a pit now. You return back.");
            travelFirst(player);
        }
        System.out.println("You finally free your foot from the mud. You slowly make your way over\n"
            + "to the edge of the water. You see a narrow walkway, made of long wooden planks leading\n"
            + "to a white gazebo in the middle of the lake.\n");
        sleep(3000);
        System.out.print("Would you like to go to the gazebo? (Y/N):");
        input = scan.next();
        if(input.equalsIgnoreCase("Y"))
        {
            System.out.println("\nYou decide to walk out to the gazebo. A piercing, high-pitched scream breaks the\n"
                + "sinister silence. Your eyes gravitate down to the water, where you see bubbles\n"
                + "slowy rising to the surface.\n");
            sleep(3300);
            System.out.println("You lean over the edge of the pier. The water is so glassy you see your reflection\n"
                + "staring back at you.\n");
            sleep(3000);
            System.out.println("Suddenly, a hand reaches out and snatches your leg, trying to pull you in. You\n"
                + "fall into the water, rapidly descending down to the depths of the lake.");
            sleep(3300);
            System.out.println("\nYou feel blackness closing in around you as the water begins to crush your chest.");
            sleep(2000);
            System.out.println(".");
            sleep(1500);
            System.out.println(".");
            sleep(1500);
            System.out.println(".");
            sleep(3000);
            System.out.println("In an instant, air rushes back into your lungs. You cannot beleive what you see\n"
                + "before your eyes.");
            sleep(2700);
            System.out.println("A great blue palace, enclosed in a bubble of air, sitting on the bottom of the lake.\n");
            sleep(2000);
            System.out.println("A gigantic shape, covered in shadow, emerges from behind the castle. The figure\n"
                + "steps toward you as the ground rumbles beneath your feet. It lets out a gigantic\n"
                + "shriek as you see a tentacle swing out and seize you.");
            sleep(3500);
            System.out.println("\nIt violenly thrashes you about. The firgure comes into the light.\n");
            sleep(2500);
            System.out.println("It's a kraken.\n");
            sleep(3000);
            System.out.println("You notice a key, made of a moving mass of tentacles, danging from its neck.\n"
                + "You realize what you must do as you unsheathe your weapon.");
            sleep(3300);
            Keelan k = new Keelan();
            k.battle(player);
            sleep(3000);
            System.out.println("You trudge over to the dead kraken and take the key off it's neck.\n"
                + "You push the it to the side and notice a crimson trapdoor. You hop in.");
            sleep(3000);
            bossesAlive.set(1, false);
            trapdoor(player);
        }
        return 1;
    }

    /**
     * Prints out story for when the player goes through a trapdoor and takes them back to travelFirst()
     * @param Sanjeev player the player
     */
    public static void trapdoor(Sanjeev player)
    {
        System.out.println("\nYou are falling down a long chute for what seems like forever. Finally, you find\n"
            + "yourself in a pile of sweet flowers. You notice this area seems very familiar to you.");
        sleep(2000);
        travelFirst(player);
    }

    /**
     * Prints out story for when the player goes into the town.
     * @param Sanjeev player the player
     */
    public static void town(Sanjeev player)
    {
        if(firstTown){
            System.out.println("\nAs you are walking over to the abandoned town, a heavy fog hangs in the air.\n"
                + "The fog inhibits you to see more than 10 feet in front of you. Doors and\n"
                + "shattered windows creak as they sway in the wind.");
            sleep(3300);
            System.out.print("\nAs you delve deeper into the town, you begin to feel a sense of uneasiness,\n"
                + "as if you are not alone.\nYou come to a crossroads.\n");
            firstTown = false;
            sleep(2500);
        }
        System.out.print("\nWhere would you like to go? (left, right, straight, back):");
        input = scan.next();
        if(input.equalsIgnoreCase("back")){
            System.out.println("\nYou decide to go back to where you came from.");
            travelFirst(player);
        }
        else if(input.equalsIgnoreCase("left")){
            if(!saloon){
                System.out.println("\nYou turn left once again but the saloon has caved in. You cannot enter.\n"
                    + "You return to the crossroad.");
                town(player);
            }
            System.out.print("\nYou turn left and start to walk at a brisk pace. You approach an old saloon.\n"
                + "Would you like to go in? (Y/N):");
            input = scan.next();
            if(input.equalsIgnoreCase("N")){
                System.out.println("\nYou return back to the crossroads.");
                town(player);
            }
            else{
                System.out.println("\nYou slowly open the door to the saloon, trying to not make any noise. Despite your best\n"
                    + "efforts, the door, obviously not greased in years, lets out a loud groan.\n");
                sleep(2500);
                System.out.println("You hear a scuffle from behind the counter. You walk over to investigate. A large\n"
                    + "pile of books is sitting on the floor. You feel something hit your shoulder\n"
                    + "and you slowly gaze upward.\n");
                sleep(3000);
                System.out.println("You see a giant spider clinging to the ceiling, staring at you, clutching a giant safe in its web.\n");
                sleep(2500);
                System.out.print("Aragog:     \"Fear not human, I exist not to hurt you, but only to aid you on your journey. I am Aragog.\"\n");
                sleep(2000);
                System.out.println("            \"If you solve my riddle, you will receive what is in this safe.\"\n");
                sleep(2000);
                System.out.println("Sanjeev:    \"What's the riddle?\"\n");
                sleep(2000);
                System.out.println("Aragog:     \"19 - 10 - 7 - 5 - 1.\"\n"
                    + "            \"Now enter the four digit code into the safe.\"\n");
                sleep(2500);
                System.out.println("Aragog drops the safe in front of you.\n");
                input = " ";
                while (!input.equals("9324") && !input.equals("0")){
                    System.out.print("Code (0 to quit):");
                    input = scan.next();
                    if(!input.equals("9324") && !input.equals("0"))
                        System.out.println("Incorrect. Try again");
                }
                if (input.equals("9324"))
                {
                    System.out.println("\nThe safe clicked. You unlocked it!\n");
                    sleep(1500);
                    System.out.println("Aragog:     \"So I see you've solved my riddle. Congratulations. Please take this.\"\n");
                    WebbedBlade w = new WebbedBlade();
                    System.out.println("You have obtained the " + w + "!");
                    w.addToInv();
                    System.out.println("\nThere is nothing left to do here so you return back to the crossroads.");
                    saloon = false;
                    town(player);
                }
                else{
                    System.out.println("\nAragog:     \"I see you couldn't solve my riddle.\"");
                    sleep(2000);
                    System.out.println("            \"Leave now, before I change my mind and eat you.\"\n");
                    saloon = false;
                    town(player);
                }
            }
        }
        else if(input.equalsIgnoreCase("right")){
            System.out.println("\nYou turn right and start to make your way down the street. A tumbleweed rolls by your feet\n"
                + "as the light breeze blows the fog away.\n");
            sleep(1500);
            if(!bossesAlive.get(2)){
                System.out.println("The library is in ruins. You turn back to the crossroads.");
                town(player);
            }
            System.out.print("Concealed behind the fog was a maginificent library, constructed of white marble. You see a\n"
                + "towering iron door, cracked open.\n\nWould you like to go in? (Y/N):");
            input = scan.next();
            if(input.equalsIgnoreCase("N")){
                System.out.println("You decide to turn back to the crossroads.");
                town(player);
            }
            else{
                System.out.println("\nYou carefully walk up to the massive door. You notice a red stain on the marble stairs\n"
                    + "as you are walking up the steps.");
                sleep(2500);
                System.out.println("\nThe sight sitting before your eyes is extrodinary. A massive, candle-lit room, full of\n"
                    + "open books, flipping through pages on their own, seemingly magical. White hieroglyphics \n"
                    + "are hovering above the books and flying throughout the air.\n");
                sleep(3500);
                System.out.println("You see an old man, dressed in an oversized robe, slowly descending down the spiral staircase.\n"
                    + "Once he reaches the bottom, he gingerly walks up to you. You notice a writhing orb of purple energy\n"
                    + "floating above his head. It's a key.");
                sleep(5000);
                System.out.println("\nCyril Demetrius: \"Greetings,  Sanjeev. Welcome to the fabled Latvian Library, where scholars\n"
                    + "                  from all around the world come to study the art of sorcery. I see you seek\n"
                    + "                  not magic, but something I hold very dear to myself.");
                sleep(4500);
                System.out.println("                  AND YOU WILL NOT BE GETTING IT\"");
                sleep(3000);
                Cyril c = new Cyril();
                c.battle(player);
                bossesAlive.set(2, false);
                System.out.println("You pick up the Eldest Key and put it in your bag. You walk back to the crossroads. ");
                town(player);
            }
        }
        else if(input.equalsIgnoreCase("straight")){
            System.out.println("\nYou continue on traveling straight. The town abruptly ends at the edge of a vast cliff.\n");
            sleep(10-0);
            System.out.print("Would you like to jump off the cliff? (Y/N):");
            input = scan.next();
            if(input.equalsIgnoreCase("Y")){
                System.out.print("Are you sure? (Y/N):");
                input = scan.next();
                if(input.equalsIgnoreCase("Y")){
                    System.out.print("Are you really sure? It's a really big cliff. (Y/N):");
                    input = scan.next();
                    if(input.equalsIgnoreCase("Y"))
                    {
                        System.out.println("You jumped off the cliff.");
                        sleep(1500);
                        System.out.println("You fall for what seems like hours. You finally get impaled by a giant rock.\n"
                            + "You shouldn't jump off cliffs.");
                        sleep(2000);
                        System.out.println("You hear a spirit calling out to you. It's Jeremy.\n");
                        sleep(2500);
                        System.out.println("Jeremy:     It's a cliff... Why did you jump?");
                        sleep(2000);
                        die();
                    }
                }
            }
            if(input.equalsIgnoreCase("N"))
            {
                if(!bossesAlive.get(3)){
                    System.out.println("\nYou decide not to jump off the cliff. You turn around and notice nothing is there\n"
                        + "anymore. You go back to the crossroads.");
                    town(player);
                }
                System.out.println("\nYou decide not to jump off the cliff. You turn around and notice the whole town has changed.\n"
                    + "No longer is it a foggy, sprawling ghost town, but rather only one building.\n");
                sleep(3500);
                System.out.println("The building seems somewhat familiar to you..\n");
                sleep(2500);
                System.out.print("It's your");
                sleep(500);
                System.out.print(".");
                sleep(500);
                System.out.print(".");
                sleep(500);
                System.out.print(".");
                sleep(1000);
                System.out.println(" house..\n");
                sleep(2000);
                System.out.println("You know it can't be real.. You know it's just this land trying to mess with your head right?");
                sleep(2000);
                System.out.println("Right?");
                sleep(2500);
                System.out.print("\nStill, you feel a yearning to go into your house. It almost feels as if it is calling\n"
                    + "your name.\n"
                    + "\nOpen the door? (Y/N):");
                input = scan.next();
                if(input.equalsIgnoreCase("N")){
                    System.out.println("\nYou decide not to open the door..\n");
                    sleep(1000);
                    System.out.println("You black out.\n");
                    sleep(3000);
                    System.out.println("You find yourself awaking at the crossroads once again.");
                    town(player);
                }
                System.out.println("\nYou open the door and find nothing but a light blue hue. You walk into the door and find\n"
                    + "yourself falling.");
                sleep(4000);
                System.out.println("\nYou land in a bright green field filled with thriving flowers and plants. You look around\n"
                    + "to discover you are in a floating, circular garden.");
                sleep(3000);
                System.out.println("\nYou get up and walk towards the edge of the garden. Before you get 10 feet, you slip on\n"
                    + "something. It's a banana peel.\n");
                sleep(3000);
                System.out.println("You hear a deep, booming noise come from the other edge of the garden. A huge shadow is\n"
                    + "cast over you.\n");
                sleep(3000);
                System.out.print("You slowly turn around..");
                sleep(2000);
                System.out.println(" A 15 foot tall giant ape is standing before you.\n");
                sleep(2500);
                System.out.println("Gaben:      \"Welcome Sanjeev. I've called you here for a very specific reason.\"\n");
                sleep(2000);
                System.out.println("Shocked, and struck with fear, you don't even know what to say.");
                sleep(2000);
                System.out.println("\nSanjeev:    \"...W-why?\"");
                sleep(2000);
                System.out.println("\nGaben:      \"I've been watching you up here from my sky garden and I have realized how\n"
                    + "             truly powerful you really are. Join me now and help me conquer Bigotti.\"\n");
                sleep(3000);
                System.out.print("Join Gaben? (Y/N):");
                input = scan.next();
                if(input.equalsIgnoreCase("Y")){
                    System.out.println("\nYou decide to join Gaben's force to conquer Bigotti. Gaben walks up to you and gives you\n"
                        + "the banana of trust.");
                    sleep(3000);
                    System.out.println("\nYou eat the banana and you are shocked when you see Gaben swing his giant ape arms at you.\n");
                    sleep(2000);
                    System.out.println("Gaben:      \"How dare you eat the ancient banana of trust?! I trusted you! Fight me now!");
                    sleep(3000);
                    Gaben g = new Gaben();
                    g.battle(player);
                    bossesAlive.set(3, false);
                }
                else{
                    System.out.println("\nGaben:      \"How dare you disobey a bape god? You will pay!\n");
                    sleep(2500);
                    Gaben g = new Gaben();
                    g.battle(player);
                    bossesAlive.set(3, false);
                }
                sleep(2000);
                System.out.print("You pick up the mon-key. Haha. Get it? Mon-");
                sleep(2000);
                System.out.print("key.");
                sleep(1000);
                System.out.print(" Haha. You notice a trapdoor in the middle of the\n"
                    + "garden and decide to jump in it.\n");
                sleep(3000);
                trapdoor(player);
            }
        }
    }

    /**
     * Prints out story for when the player goes to the geysers.
     * @param Sanjeev player the player
     */
    public static void geyser(Sanjeev player)
    {
        List.setCurrentPlace(5);
        System.out.println("\nYou start your journey over to the Geyser Grounds. The air gets noticeably warmer.\n");
        sleep(1500);
        System.out.println("You notice an empty set of armor, semmingly new, sitting on the ground.");
        System.out.print("Put it on? (Y/N):");
        input = scan.next();
        if(input.equalsIgnoreCase("Y")){
            System.out.println("\nYou bend over to the armor to pick it up but freeze. You notice it is breathing.\n");
            sleep(2000);
            System.out.println("Someone is in this armor...");
            sleep(1500);
            player.battle(player);
        }
        else{
            System.out.println("\nYou decide to ignore the armor.");
            sleep(1500);
        }
        if(geyser){
            System.out.println("You continue to walk through the valley of geysers. You begin to notice that\n"
                + "geysers aren't shooting up randomly.. There's a pattern.\n");
            sleep(3000);
            System.out.println("The pattern goes something like this.. (O - not firing, X - firing)\n");
            sleep(2000);
            System.out.println(" 1 - X X X X");
            System.out.println(" 2 - O O O X");
            System.out.println(" 3 - O X X X");
            System.out.println(" 4 - O O O X");
            System.out.println(" 5 - X X X X");
            sleep(4500);
            System.out.println("\nYou see a sign that reads:\n\n"
                + "     --TO ALL WHO FIND THIS SIGN--\n"
                + "  LOOK IN THE RIGHT GEYSER FOR TREASURE\n"
                + "     LOOK IN THE WRONG GEYSER FOR PAIN\n");
            sleep(2500);
            System.out.print("Would you like to look into a geyser? (Y/N):");
            input = scan.next();
            if(input.equalsIgnoreCase("Y")){
                System.out.print("\nWhich geyser would you like to look into? (1,2,3,4,5, 0 to not pick):");
                intput = scan.nextInt();
                if(intput == 3){
                    System.out.println("\nYou slowly peer over the third geyser, hoping not to get blasted.\n"
                        + "\nYou notice a treasure chest. Quickly, you drop down into the hole and unlock\n"
                        + "the chest. You find a giant sword, swirling with black fire.\n");
                    sleep(2500);
                    OnyxBlade onyx = new OnyxBlade();
                    onyx.addToInv();
                    geyser = false;
                }
                else if(intput == 0){
                    System.out.println("\nYou decide against sticking your face into a hot geyser.");
                }
                else{
                    System.out.println("\nYou slowly peer over the edge of the geyser. A huge stream of steam\n"
                        + "shoots up and sears your face.\n");
                    sleep(2000);
                    System.out.println("You lost 30 health!");
                    player.setHealth(player.getHealth() - 30);
                    System.out.println("You now have " + player.getHealth() + " health.");
                    if(player.getHealth() <= 0){
                        die();
                    }
                    geyser = false;
                }
            }
            else
                System.out.println("\nYou decide against sticking your face into a hot geyser.");
        }
        sleep(2500);
        System.out.print("\nYou walk through the field of geysers for a good 20 minutes. ");
        tundraOrVolcano(player, 1);
    }

    /**
     * Prints out story for when the player can choose between a volcano or a tundra.
     * @param Sanjeev player the player
     */
    public static void tundraOrVolcano(Sanjeev player, int x){
        if(x==1){
            System.out.print("You see a tundra\nto your left and a huge volcano to your right.\n"
                + "Where would you like to go? (L/R/back):");
        }
        else{
            System.out.print("You see a tundra to your left and a huge volcano to your right.\n"
                + "Where would you like to go? (L/R/back):");
        }
        input = scan.next();
        if(input.equalsIgnoreCase("R"))
        {
            volcano(player);
        }
        else if (input.equalsIgnoreCase("L")){
            tundra(player);
        }
        else{
            travelFirst(player);
        }
    }

    /**
     * Prints out story for when the player is in the tundra.
     * @param Sanjeev player the player
     */
    public static void tundra(Sanjeev player){
        if(bossesAlive.get(5)){
            System.out.println("\nYou begin to walk over to the frozen tundra. The air around you feels frozen.\n");
            sleep(2000);
            System.out.println("Everything around you is empty. No life. No movement. Only an abyss of nothingness.\n");
            sleep(3000);
            System.out.println("You start to shiver as the air seems to only be getting colder.\n"
                + "You feel a warm tingle on your neck, almost as if someone is breathing down it.\n"
                + "You turn around.");
            List.setCurrentPlace(8);
            sleep(3000);
            player.battle(player);
            sleep(1000);

            System.out.println("You've been walking through the tundra for so long that all you see in any direction\n"
                + "is a frozen wasteland.\n");
            sleep(2500);
            System.out.println("Gradually, the area around you begins to become brighter. You look up and see a hole\n"
                + "opening up in the clouds. A bolt of lighting strikes near your foot as you see a godly\n"
                + "appartion float down. It slowly comes into view. It's a man with wings.\n");
            sleep(4500);
            System.out.println("Anakin:   \"I am Anakin Atmospheretraverser. There is no path.");
            sleep(3000);
            System.out.println("           Beyond the scope of light, beyond the reach of Dark...");
            sleep(3000);
            System.out.println("           ...what could possibly await us? And yet, we seek it, insatiably...");
            sleep(3000);
            System.out.println("           Such is our fate.\"");
            sleep(2500);
            Anakin a = new Anakin();
            a.battle(player);
            bossesAlive.set(5, false);
            sleep(2500);
            System.out.println("The tundra suddenly warms and all the clouds dissapear. You see a key, forged\n"
                + "of storm, and pick it up.\n");
            sleep(2000);
            System.out.println("There is nothing left to do here. You exit the tundra.\n");
            sleep(3000);
            tundraOrVolcano(player, 2);
        }
        else{
            System.out.println("\nThe tundra is no longer frozen. There is nothing to do here.\n");
            sleep(2000);
            tundraOrVolcano(player, 2);
        }
    }

    /**
     * Prints out story for when the player is at the volcano.
     * @param Sanjeev player the player
     */
    public static void volcano(Sanjeev player){
        List.setCurrentPlace(6);
        System.out.println("\nYou prepare your calves for the climb you are about to endure. Basalt rock\n"
            + "after basalt rock, you slowly inch your way up the mountain.");
        sleep(2500);
        System.out.println("\nYou look behind you and notice the true horror of this land.\n");
        sleep(2500);
        System.out.println("Fields, blackened with soot, stretch for miles. Trees, wilted and withered,\n"
            + "tower high above the ground. You need to get home.\n");
        sleep(3500);
        System.out.println("You turn back around and get startled when you see a demon, about an inch\n"
            + "away from your face.");
        sleep(2300);
        player.battle(player);
        sleep(1000);
        System.out.println("You keep climbing and you realized that you have almost reached the top.\n");
        sleep(2000);
        if(bossesAlive.get(4)){
            System.out.println("Finally, gasping for air, you reached the top. You peek over the edge\n"
                + "of the ring and see magma, boiling and smoking, rising to the surface.\n");
            sleep(3000);
            System.out.println("Suddenly, a glowing shape emerges from the magma.\n");
            sleep(3000);
            System.out.println("Jorge:     \"Traveler. I am Jorge Tanaka, the feared Flame Tarragon.\n"
                + "            Every age it seems, is tainted by the greed of men...");
            sleep(3700);
            System.out.println("            I know what you seek. I've seen men, time and time again,\n"
                + "            try to escape these cursed lands, but alas, it consumes them...");
            sleep(3800);
            System.out.println("            If escape is truly what you want.. I will give it to you.\"");
            sleep(3500);
            Jorge j = new Jorge();
            j.battle(player);
            sleep(2000);
            bossesAlive.set(4, false);
            System.out.println("Instantly, the magma starts cooling. The center of the volcano has now become\n"
                + "a circle of rock. You walk out onto the dried magma and pick up a flaming\n"
                + "key.\n");
            sleep(3300);
            System.out.println("There is nothing else to do here so you travel back down the volcano.");
            tundraOrVolcano(player, 2);
        }
        else{
            if(volcanoChest){
                System.out.print("The volcano has hardened. A chest lays unopened upon the dried magma.\n"
                    + "Open it? (Y/N):");
                input = scan.next();
                if(input.equalsIgnoreCase("Y")){
                    System.out.println("\nYou open the chest and become delighted to find a heaping pile of 100 gold.");
                    player.setGold(player.getGold() + 100);
                    System.out.println("You now have " + player.getGold() + " gold!");
                    sleep(2000);
                    volcanoChest = false;
                    System.out.println("\nYou go back down the volcano.\n");
                    tundraOrVolcano(player, 2);
                }
                else{
                    System.out.println("You don't open the chest and go back down the volcano.");
                    tundraOrVolcano(player, 2);
                }
            }
            else{
                System.out.println("The volcano has hardened. A chest lays opened upon the dried magma.\n"
                    + "You travel back down the volcano.");
                tundraOrVolcano(player, 2);
            }
        }
    }

    /**
     * Prints out story for when the player is at the castle. They fight Sohan if they have 7 keys.
     * @param Sanjeev player the player
     * @return 1
     */
    public static int castle(Sanjeev player)
    {
        int amountOfKeys = 0;
        System.out.print("\nYou walk over to the enourmous castle, towering high above you. You see\n"
            + "a giant padlock door with seven keyholes.\nTry to unlock it? (Y/N):");
        input = scan.next();
        if (input.equalsIgnoreCase("y"))
        {
            for(int p = 0; p < player.getKeys().size(); p++)
            {
                if((boolean)(player.getKeys().get(p)))
                    amountOfKeys++;
            }
            if(amountOfKeys == 7){
                System.out.println("\nYou unlocked the door. The door slowly swings open and you hear a sinister laugh.\n");
                sleep(2500);
                System.out.println("?????:      \"So I see you've come to seek the way out. But you won't be speaking to\n"
                    + "             Jeremy anytime soon.\n");
                sleep(3000);
                System.out.println("Sanjeev:    \"I need to! My mom is making custard tonight, and I am not going to\n"
                    + "             miss it. Fight me.\"\n");
                sleep(2500);
                System.out.println("?????:      \"You fool. Do you really think you can defeat me?\"\n");
                sleep(3000);
                System.out.println("Sohan steps out from the shadows, mustache glimmering in the faint candle glow, holding his\n"
                    + "bloodied clipboard.\n");
                sleep(3000);
                System.out.println("Sohan:      \"You've lasted too long here. Now it's your time to die.");
                sleep(2500);
                Sohan s = new Sohan();
                s.battle(player);
                sleep(5000);
                System.out.println("You did it. You beat Sohan.\n");
                sleep(3000);
                ending();
            }
            else{
                System.out.println("\nYou are missing " + (7-amountOfKeys) + " keys.\n");
                sleep(1500);
                System.out.println("You return back to where you came from");
                sleep(1000);
                travelFirst(player);
            }
        }
        else{
            System.out.println("You return back to where you came from\n");
            travelFirst(player);
        }
        return 1;
    }

    /**
     * Prints out the shop and lets the user buy items.
     * @param Sanjeev player the player
     * @return 1
     */
    public static int shop(Sanjeev player){
        if(shop.size() == 0)
        {
            System.out.println("There's nothing else left to buy.");
            return 1;
        }
        System.out.println("\n---Shop Inventory---");
        printShop();
        System.out.print("\nWould you like to purchase anything? (Gold: " + player.getGold() + ") (Y/N): ");
        input = scan.next();
        while(input.equalsIgnoreCase("Y")){
            if(shop.size() == 0){
                System.out.println("There's nothing else left to buy.");
                return 1;
            }
            else{
                System.out.print("What would you like to buy?: ");
                intput = scan.nextInt();
                if(intput == 1){
                    if(player.getGold() >= 30){
                        shop.get(intput-1).addToInv();
                        System.out.println("\nYou have bought " + shop.get(intput-1) + "!\n");
                        player.setGold(player.getGold() - shop.get(intput-1).getPrice());
                        System.out.println("You now have " + player.getGold() + " gold.\n");
                    }
                    else{
                        System.out.println("\nYou don't have enough gold.\n");
                    }
                }
                else if(intput == 2){
                    if(player.getGold() >= 50){
                        shop.get(intput-1).addToInv();
                        System.out.println("\nYou have bought " + shop.get(intput-1) + "!\n");
                        player.setGold(player.getGold() - shop.get(intput-1).getPrice());
                        System.out.println("You now have " + player.getGold() + " gold.\n");
                    }
                    else{
                        System.out.println("\nYou don't have enough gold.\n");
                    }
                }

                else if(shop.get(intput-1).getPrice() <= player.getGold()){
                    shop.get(intput-1).addToInv();
                    System.out.println("\nYou have bought " + shop.get(intput-1) + "!\n");
                    player.setGold(player.getGold() - shop.get(intput-1).getPrice());
                    shop.remove(intput-1);
                    System.out.println("You now have " + player.getGold() + " gold.\n");
                }
                else
                    System.out.println("\nYou don't have enough gold!\n");
            }
            if(shop.size() != 0){
                System.out.print("Would you like to buy anything else?(Y/N): ");
                input = scan.next();
                if (input.equals("Y")){
                    printShop();
                }

            }
        }
        return 1;
    }

    /**
     * Prints out story for the ending.
     */
    public static void ending(){
        System.out.print("You walk over to his body and realize there's a flap of skin protruding from his face.\n"
            + "You pull the skin back and realize...");
        sleep(4000);
        System.out.println(" It was Jeremy this whole time.\n");
        sleep(2000);
        System.out.println("You hear a banging on a closet from across the room.\n");
        sleep(2000);
        System.out.print("Check it out? (Y/N): ");
        input = scan.next();
        if(input.equalsIgnoreCase("N")){
            System.out.println("\nThe sound keeps coming. Curiosity wins and you decide to check it out.");
            sleep(2000);
        }
        System.out.print("\nYou slowly open the door...");
        sleep(2000);
        System.out.print(" It's...");
        sleep(1000);
        System.out.print(" Sohan. He doesn't have a face.\n");
        sleep(2000);
        System.out.println("\nSohan:        \"Sanjeev.. Finally someone has come to help... Jeremy kidnapped me 3 years ago.\n"
            + "               He stole my face and impersonated me, taking over the Russan Mafia with my sick\n"
            + "               basketball skills. I am the only person who knows the way out. You must believe.\"\n");
        sleep(3500);
        System.out.println("Sanjeev:      \"Believe in what..?\"\n");
        sleep(2000);
        System.out.print("Sohan:        \"In... ");
        sleep(2500);
        System.out.println("Santa.\"\n");
        sleep(2000);
        System.out.println("You decide to take his advice. You close your eyes and believe. You believe harder than you've ever\n"
            + "believed before. You hear bells jingle and a hearty laugh approaching. You open your eyes and see a drunken\n"
            + "mall Santa sled to you in his shopping cart.\n");
        sleep(3500);
        System.out.println("Santa:        \"Hey kid. Wanna see some cool iPod cases in my sleigh?\"\n");
        sleep(2000);
        System.out.print("Go with Santa? (Y/N): ");
        input = scan.next();
        if(input.equalsIgnoreCase("N")){
            System.out.println("\nObviously disgruntled, Santa puts you in a chokehold and forces you into his sleigh.\n");
            sleep(2000);
            System.out.println("Santa:        \"Whether you like it or not, we're getting out of here.\"\n");
            sleep(2000);
            System.out.println("You guys sled out of the castle together into the sunset.");
            sleep(4000);
            win();
        }
        else{
            System.out.println("\nYou get in  Santa's sleigh and you ride off into the sunset together.");
            win();
        }
    }

    /**
     * Prints out story for when you win.
     */
    public static void win(){
        System.out.println("\nCongratulations! You beat the game!");
        sleep(2000);
        System.exit(0);
    }

    /**
     * Prints out everything the player can buy in the shop.
     */
    public static void printShop(){
        System.out.println("");
        for(int n = 1; n < shop.size()+1; n++)
        {
            System.out.println(n + " - " + shop.get(n-1) + " | Price: " + shop.get(n-1).getPrice() + " gold");
        }
    }

    /**
     * Prints out the menu and lets user pick an option.
     * @param Sanjeev player the player
     */
    public static void menu(Sanjeev player){
        System.out.println("\nWhat would you like to do?\n"
            + "   1 - View Weapons\n"
            + "   2 - View Usable Items\n"
            + "   3 - View Keys\n"
            + "   4 - See Player Summary\n"
            + "   5 - Exit Menu\n"
            + "   6 - Quit");
        System.out.print("Input:");
        intput = scan.nextInt();
        if (intput == 1)
        {
            System.out.print("");
            for(int n = 0; n < player.getWeapons().size(); n++)
            {
                if(n==0)
                    System.out.println(" " + (n+1) + " - " + player.getWeapons().get(n) + " (equipped)");
                else
                    System.out.println(" " + (n+1) + " - " + player.getWeapons().get(n));
            }
            System.out.print("\nWould you like to switch  weapons? (Y/N):");
            input = scan.next();
            if(input.equalsIgnoreCase("Y")){
                player.switchItems();
            }
        }
        else if (intput == 2)
        {
            System.out.print("");
            if(player.getUsables().size() > 0){
                for(int n = 0; n < player.getUsables().size(); n++)
                {
                    System.out.println(" " + (n+1) + " - " + player.getUsables().get(n));
                }
            }
            else
                System.out.println("\nYou have no usable items!");
        }
        else if (intput == 3)
        {
            System.out.print("");
            int amountOfKeys = 0;
            for(int p = 0; p < player.getKeys().size(); p++)
            {
                if((boolean)(player.getKeys().get(p)))
                    amountOfKeys++;
            }
            System.out.println("\nYou have " + amountOfKeys + " keys.");
        }
        else if (intput == 4)
        {
            System.out.print("\n" + player);
        }
        else if (intput == 5){  
            travelFirst(player);
        }
        else if (intput == 6)
        {
            System.out.println("\nGoodbye!");
            System.exit(0);
        }
        menu(player);
    }

    /**
     * Makes the program wait the number of milliseconds in the parameter.
     * @param int x amount of milliseconds to wait
     */
    public static void sleep(int x)
    {
        try 
        {
            Thread.sleep(x);
        } 
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Ends the program for when the player dies.
     */
    public static void die()
    {
        System.out.print("\nYour vision slowly fades to black.\nYou died.");
        sleep(3000);
        System.exit(0);
    }
}