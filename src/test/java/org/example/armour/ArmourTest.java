package org.example.armour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArmourTest {
@Test
    public void armourCanBeDamageAndDestroyed(){
    Armour armour = new Armour(2000);
    assertEquals(2000, armour.getHealth());
    assertFalse(armour.isDestroyed());
    armour.damage(1000);
    assertEquals(1000,armour.getHealth());
    assertFalse(armour.isDestroyed());
    armour.damage(1000);
    assertEquals(0, armour.getHealth());
    assertTrue(armour.isDestroyed());
}
}