package org.example.character;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {

    Character character = new Character();

    @Test
    public void Health_should_starting_at_1000() {
        assertEquals(1000, character.getHealth());
    }

    @Test
    public void level_should_start_at_1() {
        assertTrue(character.getLevel() >= 1);
    }

    @Test
    public void character_should_start_alive() {
        assertTrue(character.isAlive());
    }

    @Test
    public void damage_is_subtracted_from_health() {
        character.damage(100);
        assertEquals(900, character.getHealth());
    }

    @Test
    public void when_damage_received_exceeds_current_health_character_dies() {
        character.damage(1000);
        assertEquals(0, character.getHealth());
    }

    @Test
    public void if_damage_is_equal_to_health_character_dies() {
        character.damage(1000);
        assertFalse(character.isAlive());
    }

    @Test
    public void when_character_dies_health_becomes_0() {
        character.damage(1100);
        assertEquals(0, character.getHealth());
    }

    @Test
    public void if_character_is_dead_cannot_be_healed() {
        character.damage(1000);
        character.heal(300);
        assertFalse(character.isAlive());
    }

    @Test
    public void healing_cannot_raise_health_above_1000() {
        character.heal(300);
        assertEquals(1000, character.getHealth());
    }

    @Test
    public void character_cannot_deal_damage_to_itself() {
        character.inflictDamage(character, 10);
        assertEquals(1000, character.getHealth());
    }

    @Test
    public void character_can_only_heal_itself() {
        character.autoHeal(character, 100);
        assertEquals(1000, character.getHealth());
    }

    @Test
    public void target_is_5_or_more_Levels_above_the_attacker_Damage_is_reduced_by_50_percent() {
        Character attacker = new Character();
        character.setLevel(6);
        attacker.setLevel(1);
        attacker.calculateDamage(character, attacker, 400);
        assertEquals(800, character.getHealth());
    }

    @Test
    public void target_is_5_or_more_Levels_above_the_attacker_Damage_is_increased_by_50_percent() {
        Character attacker = new Character();
        character.setLevel(1);
        attacker.setLevel(7);
        attacker.calculateDamage(character, attacker, 200);
        assertEquals(700, character.getHealth());
    }
    @Test
    public void Melee_fighters_have_an_range_of_2_meters(){
        Character melee = new Character();
        melee.attackMelee(melee, 3.5, 100);
        assertEquals(1000, melee.getHealth());
    }
    @Test
    public void Ranged_fighters_have_a_range_of_meters(){
        Character ranged = new Character();
        ranged.attackRanged(ranged, 20.5, 100);
        assertEquals(1000, ranged.getHealth());
    }
    @Test
    public void charactersCanJoinAndLeaveFactions() {
        character.joinFaction("Faction1");
        character.joinFaction("Faction2");
        assertTrue(character.isAlly(new Character() {{
            joinFaction("Faction1");
        }}));
        assertTrue(character.isAlly(new Character() {{
            joinFaction("Faction2");
        }}));
        character.leaveFaction("Faction1");
        assertFalse(character.isAlly(new Character() {{
            joinFaction("Faction1");
        }}));
        assertTrue(character.isAlly(new Character() {{
            joinFaction("Faction2");
        }}));
    }
    @Test
    public void alliesCannotInflictDamageOnEachOther() {
        Character attacker = new Character();
        attacker.joinFaction("Faction1");
        character.joinFaction("Faction1");
        attacker.attackMelee(character, 1, 100);
        assertEquals(1000, character.getHealth());
    }
    @Test
    public void alliesCanHealEachOther() {
        Character healer = new Character();
        healer.joinFaction("Faction1");
        healer.damage(100);
        character.joinFaction("Faction1");
        character.damage(100);
        healer.autoHeal(character, 50);
        assertEquals(950, character.getHealth());
    }
}