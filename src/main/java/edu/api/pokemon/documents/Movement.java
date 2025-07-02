package edu.api.pokemon.documents;

import org.springframework.data.mongodb.core.mapping.Document;

import edu.api.pokemon.enums.PokemonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "movements")
@Builder
public class Movement {
 
    private String id;
    private String name;
    private PokemonType type;
    private String category;
    private int power;
    private int accuracy;
    private int pp;
    
}
