package edu.api.pokemon.documents.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
@AllArgsConstructor
public class PokemonUpdateRequest {
    
    private String id;
    private String name;
    private int level;
    private int health;
    private int attack;
    private int specialAttack;
    private int defense;
    private int specialDefense;
    private int speed;

}
