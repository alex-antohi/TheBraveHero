package Characters;
import java.util.Random;

public class Hero extends Character{
    public Hero(String name) {
        setName(name);
        setHealth(diceRoll(65, 95));
        setPower(diceRoll(60, 70));
        setDefence(diceRoll(40, 50));
        setSpeed(diceRoll(40, 50));
        setLuck(diceRoll(10, 30));
    }

    public int dragonForce() {
        boolean usedAbility = (new Random().nextInt(10) == 0);
        if (usedAbility) {
            System.out.printf("%s used Dragon Force.\n", getName());
        }
        return usedAbility ? 1 : 0;
    }

    public int magicShield() {
        boolean usedAbility = (new Random().nextInt(5) == 0);
        if (usedAbility) {
            System.out.printf("%s used Magic Shield.\n", getName());
        }
        return usedAbility ? 1 : 0;
    }
}
