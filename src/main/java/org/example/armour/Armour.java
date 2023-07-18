package org.example.armour;

public class Armour {
    private int health;
    private boolean destroyed = false;
    public int getHealth() {
        return health;
    }
    public Armour(int health){
        this.health=health;
    }
    public boolean isDestroyed(){
        return destroyed;
    }
    public void damage(int damage){
        this.health-=damage;
        if(health<=0){
            this.destroyed=true;
        }
    }
}
