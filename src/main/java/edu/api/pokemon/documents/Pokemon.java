package edu.api.pokemon.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.api.pokemon.enums.PokemonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "pokemons")
@Builder
public class Pokemon {
    
    @Id
    private String id;
    private String name;
    private int level;
    private int health;
    private int attack;
    private int specialAttack;
    private int defense;
    private int specialDefense;
    private int speed;
    private PokemonType type1;
    private PokemonType type2;

}
