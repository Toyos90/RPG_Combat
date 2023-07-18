package org.example.character;
import java.util.HashSet;
import java.util.Set;

public class Character {
    private int health = 1000;
    private int level = 1;
    private boolean alive = true;
    private final Set<String>factions = new HashSet<>();

    public boolean isAlive() {
        return alive;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void damage(int damage) {
        this.health -= damage;
        if (health <= 0) {
            this.alive = false;
            this.health = 0;
        }
    }

    public void heal(int heal) {
        if (health > 0 && health < 1000) {
            this.health += heal;
            if (health >= 1000) {
                setHealth(1000);
            }
        }
    }

    public void inflictDamage(Character target, int damage) {
        if (target == this || isAlly(target)) {
            return;
        }

        target.health -= damage;
        if (target.health <= 0) {
            target.alive = false;
        }

    }

    public void autoHeal(Character target, int heal) {
        if (target == this || isAlly(target)) {
            target.heal(heal);
        }
    }

    public void calculateDamage(Character target, Character attacker, int damage) {
        if (isAlly(target)) {
            return;
        }
        int damageModifier = (damage * 50) / 100;
        if (target.getLevel() >= attacker.getLevel() * 5) {
            damage -= damageModifier;
            target.damage(damage);
        } else if (target.getLevel() <= attacker.getLevel() * 5) {
            damage += damageModifier;
            target.damage(damage);
        }
    }

    public void attackMelee(Character melee, double range, int damage) {
        if (range > 2 || isAlly(melee)) {
            return;
        }
        melee.damage(damage);
    }

    public void attackRanged(Character ranged, double range, int damage) {
        if (range > 20 || isAlly(ranged)) {

            return;
        }
        ranged.damage(damage);
    }

    public void joinFaction(String faction) {
        factions.add(faction);
    }

    public void leaveFaction(String faction) {
        factions.remove(faction);
    }

    public boolean isAlly(Character other) {
        for (String faction : factions) {
            if (other.factions.contains(faction)) {
                return true;
            }
        }
        return false;
    }
}

