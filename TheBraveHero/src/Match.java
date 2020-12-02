import Characters.Beast;
import Characters.Character;
import Characters.Hero;

import java.util.Random;

public class Match {

    private Character attacker;
    private Character defender;

    private Character getAttacker() {
        return attacker;
    }

    private void setAttacker(Character attacker) {
        this.attacker = attacker;
    }

    private Character getDefender() {
        return defender;
    }

    private void setDefender(Character defender) {
        this.defender = defender;
    }

    private int getDamage() {
        int baseDamage;
        int attackerPower = attacker.getPower();
        int defenderDefence = defender.getDefence();

        if (attacker instanceof Hero) {
            attackerPower += attacker.getPower() * ((Hero) attacker).dragonForce();
        } else if (defender instanceof Hero) {
            attackerPower -= attacker.getPower() * ((Hero) defender).magicShield() / 2;
        }

        baseDamage = attackerPower - defenderDefence;

        baseDamage = baseDamage < 0 ? 0 : baseDamage;
        baseDamage = baseDamage > 100 ? 100 : baseDamage;

        boolean gotLucky = (new Random().nextInt(defender.getLuck()) == 0);
        if (gotLucky) {
            baseDamage = 0;
            System.out.printf("%s got lucky and dodged %s's attack.\n", defender.getName(), attacker.getName());
        }
        return baseDamage;
    }

    private void battle(int damage) {
        defender.receiveDamage(damage);
        System.out.printf("%s attacked %s with %d damage.\n", attacker.getName(), defender.getName(), damage);
        System.out.printf("%s now has %d health.\n", defender.getName(), defender.getHealth());
    }

    private void swapPlaces() {
        Character aux = attacker;
        setAttacker(defender);
        setDefender(aux);
    }

    public static void main(String[] args) {
        Match match = new Match();
        Character carl = new Hero("Carl");
        Character beast = new Beast("The Beast");
        int rounds = 1;

        carl.printStats();
        System.out.println();
        beast.printStats();
        System.out.println();

        match.setAttacker(carl);
        match.setDefender(beast);

        if (carl.getSpeed() < beast.getSpeed() ||
                carl.getSpeed() == beast.getSpeed() && carl.getLuck() < beast.getLuck()) {
            match.swapPlaces();
        }

        int damage;
        while (match.getAttacker().getHealth() > 0 && match.getDefender().getHealth() > 0 && rounds <= 20) {
            System.out.printf("Round %d\n", rounds);

            damage = match.getDamage();
            match.battle(damage);
            match.swapPlaces();

            rounds++;
            System.out.println();
        }

        if (rounds >= 20) {
            System.out.printf("%s and %s got tired and declared a draw.\n", carl.getName(), beast.getName());
        } else if (carl.getHealth() < beast.getHealth()) {
            System.out.println("Oh no! Our hero lost.");

        } else if (carl.getHealth() >= beast.getHealth()) {
            System.out.println("Success! Our hero won.");
        }

        System.out.printf("The match ended with %s having %d health and %s having %d health.\n",
                carl.getName(), carl.getHealth(), beast.getName(), beast.getHealth());
    }
}
