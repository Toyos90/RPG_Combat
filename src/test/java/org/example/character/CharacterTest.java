package org.example.character;

import org.example.attacker.Attacker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {

    Character character = new Character();
    Character character2 = new Character();
    Attacker attacker = new Attacker();

    @Test
    public void Health_should_starting_at_1000(){
        assertEquals(1000, character.getHealth());
    }

    @Test
    public void level_should_start_at_1(){
        assertTrue(character.getLevel()>=1);
    }

    @Test
    public void character_should_start_alive(){
        assertTrue(character.isAlive());
    }

    @Test
    public void damage_is_subtracted_from_health(){
        character.damage(100);
        assertEquals(900,character.getHealth());
    }

    @Test
    public void when_damage_received_exceeds_current_health_character_dies(){
        character.damage(1000);
        assertEquals(0,character.getHealth());
    }

    @Test
    public void if_damage_is_equal_to_health_character_dies(){
        character.damage(1000);
        assertFalse(character.isAlive());
    }

    @Test
    public void when_character_dies_health_becomes_0(){
        character.damage(1100);
        assertEquals(0,character.getHealth());
    }

    @Test
    public void if_character_is_dead_cannot_be_healed(){
        character.damage(1000);
        character.heal(300);
        assertFalse(character.isAlive());
    }

    @Test
    public void healing_cannot_raise_health_above_1000(){
        character.heal(300);
        assertEquals(1000,character.getHealth());
    }

    @Test
    public void character_cannot_deal_damage_to_itself(){
        character.inflictDamage(character,10);
        assertEquals(1000, character.getHealth());
    }

    @Test
    public void character_can_only_heal_itself(){

    }

    @Test
    public void if_target_is_5_or_more_levels_above_the_attacker_Damage_is_reduced_by_50(){

    }



}

