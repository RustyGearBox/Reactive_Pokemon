package edu.api.pokemon.helpers;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import edu.api.pokemon.documents.Movement;
import edu.api.pokemon.documents.Pokemon;
import edu.api.pokemon.enums.PokemonType;

public class PokemonTypeWeaknessHelper {
    
    private PokemonTypeWeaknessHelper() {}

    private static final EnumMap<PokemonType, Map<PokemonType, Double>> typeEffectiveness = new EnumMap<>(PokemonType.class);

    static {
        for (PokemonType type : PokemonType.values()) {
            EnumMap<PokemonType, Double> effectiveness = new EnumMap<>(PokemonType.class);
            for (PokemonType attackType : PokemonType.values()) {
                effectiveness.put(attackType, 1.0);
            }
            typeEffectiveness.put(type, effectiveness);
        }

        // FIRE
        typeEffectiveness.get(PokemonType.FIRE).put(PokemonType.WATER, 2.0);
        typeEffectiveness.get(PokemonType.FIRE).put(PokemonType.ROCK, 2.0);
        typeEffectiveness.get(PokemonType.FIRE).put(PokemonType.GROUND, 2.0);
        typeEffectiveness.get(PokemonType.FIRE).put(PokemonType.ICE, 0.5);
        typeEffectiveness.get(PokemonType.FIRE).put(PokemonType.BUG, 0.5);
        typeEffectiveness.get(PokemonType.FIRE).put(PokemonType.FAIRY, 0.5);
        typeEffectiveness.get(PokemonType.FIRE).put(PokemonType.GRASS, 0.5);
        typeEffectiveness.get(PokemonType.FIRE).put(PokemonType.STEEL, 0.5);

        // WATER
        typeEffectiveness.get(PokemonType.WATER).put(PokemonType.ELECTRIC, 2.0);
        typeEffectiveness.get(PokemonType.WATER).put(PokemonType.GRASS, 2.0);
        typeEffectiveness.get(PokemonType.WATER).put(PokemonType.FIRE, 0.5);
        typeEffectiveness.get(PokemonType.WATER).put(PokemonType.ICE, 0.5);
        typeEffectiveness.get(PokemonType.WATER).put(PokemonType.STEEL, 0.5);
        typeEffectiveness.get(PokemonType.WATER).put(PokemonType.WATER, 0.5);

        // GRASS
        typeEffectiveness.get(PokemonType.GRASS).put(PokemonType.FIRE, 2.0);
        typeEffectiveness.get(PokemonType.GRASS).put(PokemonType.ICE, 2.0);
        typeEffectiveness.get(PokemonType.GRASS).put(PokemonType.POISON, 2.0);
        typeEffectiveness.get(PokemonType.GRASS).put(PokemonType.FLYING, 2.0);
        typeEffectiveness.get(PokemonType.GRASS).put(PokemonType.BUG, 2.0);
        typeEffectiveness.get(PokemonType.GRASS).put(PokemonType.WATER, 0.5);
        typeEffectiveness.get(PokemonType.GRASS).put(PokemonType.ELECTRIC, 0.5);
        typeEffectiveness.get(PokemonType.GRASS).put(PokemonType.GRASS, 0.5);
        typeEffectiveness.get(PokemonType.GRASS).put(PokemonType.GROUND, 0.5);

        // ELECTRIC
        typeEffectiveness.get(PokemonType.ELECTRIC).put(PokemonType.GROUND, 2.0);
        typeEffectiveness.get(PokemonType.ELECTRIC).put(PokemonType.ELECTRIC, 0.5);
        typeEffectiveness.get(PokemonType.ELECTRIC).put(PokemonType.FLYING, 0.5);

        // ICE
        typeEffectiveness.get(PokemonType.ICE).put(PokemonType.FIRE, 2.0);
        typeEffectiveness.get(PokemonType.ICE).put(PokemonType.FIGHTING, 2.0);
        typeEffectiveness.get(PokemonType.ICE).put(PokemonType.ROCK, 2.0);
        typeEffectiveness.get(PokemonType.ICE).put(PokemonType.STEEL, 2.0);
        typeEffectiveness.get(PokemonType.ICE).put(PokemonType.ICE, 0.5);

        // FIGHTING
        typeEffectiveness.get(PokemonType.FIGHTING).put(PokemonType.FLYING, 2.0);
        typeEffectiveness.get(PokemonType.FIGHTING).put(PokemonType.PSYCHIC, 2.0);
        typeEffectiveness.get(PokemonType.FIGHTING).put(PokemonType.FAIRY, 2.0);
        typeEffectiveness.get(PokemonType.FIGHTING).put(PokemonType.ROCK, 0.5);
        typeEffectiveness.get(PokemonType.FIGHTING).put(PokemonType.BUG, 0.5);
        typeEffectiveness.get(PokemonType.FIGHTING).put(PokemonType.DARK, 0.5);

        // POISON
        typeEffectiveness.get(PokemonType.POISON).put(PokemonType.GROUND, 2.0);
        typeEffectiveness.get(PokemonType.POISON).put(PokemonType.PSYCHIC, 2.0);
        typeEffectiveness.get(PokemonType.POISON).put(PokemonType.GRASS, 0.5);
        typeEffectiveness.get(PokemonType.POISON).put(PokemonType.FAIRY, 0.5);

        // GROUND
        typeEffectiveness.get(PokemonType.GROUND).put(PokemonType.WATER, 2.0);
        typeEffectiveness.get(PokemonType.GROUND).put(PokemonType.GRASS, 2.0);
        typeEffectiveness.get(PokemonType.GROUND).put(PokemonType.ICE, 2.0);
        typeEffectiveness.get(PokemonType.GROUND).put(PokemonType.FLYING, 0.5);
        typeEffectiveness.get(PokemonType.GROUND).put(PokemonType.POISON, 0.5);
        typeEffectiveness.get(PokemonType.GROUND).put(PokemonType.ROCK, 0.5);

        // FLYING
        typeEffectiveness.get(PokemonType.FLYING).put(PokemonType.ELECTRIC, 2.0);
        typeEffectiveness.get(PokemonType.FLYING).put(PokemonType.ICE, 2.0);
        typeEffectiveness.get(PokemonType.FLYING).put(PokemonType.ROCK, 2.0);
        typeEffectiveness.get(PokemonType.FLYING).put(PokemonType.FIGHTING, 0.5);
        typeEffectiveness.get(PokemonType.FLYING).put(PokemonType.GRASS, 0.5);
        typeEffectiveness.get(PokemonType.FLYING).put(PokemonType.BUG, 0.5);

        // PSYCHIC
        typeEffectiveness.get(PokemonType.PSYCHIC).put(PokemonType.BUG, 2.0);
        typeEffectiveness.get(PokemonType.PSYCHIC).put(PokemonType.GHOST, 2.0);
        typeEffectiveness.get(PokemonType.PSYCHIC).put(PokemonType.DARK, 2.0);
        typeEffectiveness.get(PokemonType.PSYCHIC).put(PokemonType.FIGHTING, 0.5);
        typeEffectiveness.get(PokemonType.PSYCHIC).put(PokemonType.POISON, 0.5);

        // BUG
        typeEffectiveness.get(PokemonType.BUG).put(PokemonType.FIRE, 2.0);
        typeEffectiveness.get(PokemonType.BUG).put(PokemonType.FLYING, 2.0);
        typeEffectiveness.get(PokemonType.BUG).put(PokemonType.ROCK, 2.0);
        typeEffectiveness.get(PokemonType.BUG).put(PokemonType.GRASS, 0.5);
        typeEffectiveness.get(PokemonType.BUG).put(PokemonType.FIGHTING, 0.5);
        typeEffectiveness.get(PokemonType.BUG).put(PokemonType.POISON, 0.5);

        // ROCK
        typeEffectiveness.get(PokemonType.ROCK).put(PokemonType.WATER, 2.0);
        typeEffectiveness.get(PokemonType.ROCK).put(PokemonType.GRASS, 2.0);
        typeEffectiveness.get(PokemonType.ROCK).put(PokemonType.FIGHTING, 2.0);
        typeEffectiveness.get(PokemonType.ROCK).put(PokemonType.GROUND, 2.0);
        typeEffectiveness.get(PokemonType.ROCK).put(PokemonType.STEEL, 2.0);
        typeEffectiveness.get(PokemonType.ROCK).put(PokemonType.FLYING, 0.5);
        typeEffectiveness.get(PokemonType.ROCK).put(PokemonType.POISON, 0.5);

        // GHOST
        typeEffectiveness.get(PokemonType.GHOST).put(PokemonType.GHOST, 2.0);
        typeEffectiveness.get(PokemonType.GHOST).put(PokemonType.DARK, 2.0);
        typeEffectiveness.get(PokemonType.GHOST).put(PokemonType.NORMAL, 0.5);
        typeEffectiveness.get(PokemonType.GHOST).put(PokemonType.FIGHTING, 0.5);

        // DRAGON
        typeEffectiveness.get(PokemonType.DRAGON).put(PokemonType.ICE, 2.0);
        typeEffectiveness.get(PokemonType.DRAGON).put(PokemonType.DRAGON, 2.0);
        typeEffectiveness.get(PokemonType.DRAGON).put(PokemonType.FAIRY, 2.0);
        typeEffectiveness.get(PokemonType.DRAGON).put(PokemonType.FLYING, 0.5);
        typeEffectiveness.get(PokemonType.DRAGON).put(PokemonType.GROUND, 0.5);

        // DARK
        typeEffectiveness.get(PokemonType.DARK).put(PokemonType.FIGHTING, 2.0);
        typeEffectiveness.get(PokemonType.DARK).put(PokemonType.BUG, 2.0);
        typeEffectiveness.get(PokemonType.DARK).put(PokemonType.FAIRY, 2.0);
        typeEffectiveness.get(PokemonType.DARK).put(PokemonType.GHOST, 0.5);
        typeEffectiveness.get(PokemonType.DARK).put(PokemonType.DARK, 0.5);

        // STEEL
        typeEffectiveness.get(PokemonType.STEEL).put(PokemonType.FIRE, 2.0);
        typeEffectiveness.get(PokemonType.STEEL).put(PokemonType.FIGHTING, 2.0);
        typeEffectiveness.get(PokemonType.STEEL).put(PokemonType.GROUND, 2.0);
        typeEffectiveness.get(PokemonType.STEEL).put(PokemonType.ICE, 0.5);
        typeEffectiveness.get(PokemonType.STEEL).put(PokemonType.FAIRY, 0.5);
        typeEffectiveness.get(PokemonType.STEEL).put(PokemonType.ROCK, 0.5);

        // FAIRY
        typeEffectiveness.get(PokemonType.FAIRY).put(PokemonType.POISON, 2.0);
        typeEffectiveness.get(PokemonType.FAIRY).put(PokemonType.STEEL, 2.0);
        typeEffectiveness.get(PokemonType.FAIRY).put(PokemonType.DRAGON, 2.0);
        typeEffectiveness.get(PokemonType.FAIRY).put(PokemonType.FIGHTING, 0.5);
        typeEffectiveness.get(PokemonType.FAIRY).put(PokemonType.BUG, 0.5);
        typeEffectiveness.get(PokemonType.FAIRY).put(PokemonType.DARK, 0.5);

        // NORMAL
        typeEffectiveness.get(PokemonType.NORMAL).put(PokemonType.FIGHTING, 2.0);
        typeEffectiveness.get(PokemonType.NORMAL).put(PokemonType.NORMAL, 0.5);
    }

    public static float getWeaknessOrResistance(Pokemon pokemon, Movement movement) {
        if (pokemon == null || movement == null) return 1.0f;
        Map<PokemonType, Double> map1 = typeEffectiveness.getOrDefault(pokemon.getType1(), Collections.emptyMap());
        Map<PokemonType, Double> map2 = pokemon.getType2() != null ? typeEffectiveness.getOrDefault(pokemon.getType2(), Collections.emptyMap()) : null;
        Double mult1 = map1.get(movement.getType());
        Double mult2 = map2 != null ? map2.get(movement.getType()) : null;
        float m1 = mult1 != null ? mult1.floatValue() : 1.0f;
        float m2 = mult2 != null ? mult2.floatValue() : 1.0f;
        return m1 * m2;
    }

}
