package Characters;

import Interfaces.CanFight;
import Interfaces.CanDance;
import Interfaces.CanTalk;

/**
 * Created by michal.powloka on 17.07.2017.
 */
public class Hero extends Adventurer implements CanDance, CanFight, CanTalk{

    // method fight comes down from Adventurer class, so there is no need to manualy
    // implement method fight from CanFight interface

    @Override
    public void talk() {
        System.out.println("My middle name is Justice. Galio Justice Justice.");
    }

    @Override
    public void scream() {
        System.out.println("COLOSUS!");
    }

    @Override
    public void dance() {
        System.out.println("*Sound of jumping pile of stones*");
    }
}
