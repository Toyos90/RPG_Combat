package org.example.character;

public class Character {

    private int health =1000;
    private int level = 1;
    private boolean alive = true;


    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
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

    public int damage(int damage) {
        this.health-= damage;
        if(health <=0){
            this.alive=false;
            this.health=0;
        }

    }

    public int heal(int heal){
        if(health > 0 && health <= 1000){
            this.health+=heal;
            if(health >1000){
                setHealth(1000);
            }
        }
        return health;
    }

    public int inflictDamage(Character character, int damage) {
        if(target == this ){
            return;
        }
        target.health -= damage;
        if(target.health <= 0){
            target.die();
        }

    }
}
