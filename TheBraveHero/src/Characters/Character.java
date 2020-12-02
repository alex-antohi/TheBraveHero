package Characters;

import java.util.Random;

public abstract class Character {
    private String name;

    private int health;
    private int power;
    private int defence;
    private int speed;
    private int luck;

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getPower() {
        return power;
    }

    public int getDefence() {
        return defence;
    }

    public int getSpeed() {
        return speed;
    }

    public int getLuck() {
        return luck;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public void printStats() {
        System.out.printf("Name = %s\n", getName());
        System.out.printf("Health = %d\n", getHealth());
        System.out.printf("Power = %d\n", getPower());
        System.out.printf("Defence = %d\n", getDefence());
        System.out.printf("Speed = %d\n", getSpeed());
        System.out.printf("Luck = %d\n", getLuck());
    }

    public int diceRoll(int min, int max) {
        return (int)(new Random().nextInt(max - min) + min);
    }

    public void receiveDamage(int damage) {
        setHealth(getHealth() - damage);
    }
}
