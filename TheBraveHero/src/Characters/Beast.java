package Characters;

public class Beast extends Character{
    public Beast(String name) {
        setName(name);
        setHealth(diceRoll(55, 80));
        setPower(diceRoll(50, 80));
        setDefence(diceRoll(35, 55));
        setSpeed(diceRoll(40, 60));
        setLuck(diceRoll(25, 40));
    }
}
