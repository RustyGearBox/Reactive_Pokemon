package edu.api.pokemon.documents.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
@AllArgsConstructor
public class PokemonDeleteRequest {
    
    private String id;

}
