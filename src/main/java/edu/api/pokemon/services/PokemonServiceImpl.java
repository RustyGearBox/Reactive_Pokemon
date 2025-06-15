package edu.api.pokemon.services;

import org.springframework.stereotype.Service;

import edu.api.pokemon.documents.Pokemon;
import edu.api.pokemon.documents.request.PokemonCreateRequest;
import edu.api.pokemon.documents.request.PokemonDeleteRequest;
import edu.api.pokemon.documents.request.PokemonUpdateRequest;
import edu.api.pokemon.repositories.PokemonRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PokemonServiceImpl {
    
    private final PokemonRepository pokemonRepository;

    public Mono<Pokemon> createPokemon(PokemonCreateRequest request) {
        return pokemonRepository.findByName(request.getName())
            .switchIfEmpty(pokemonRepository.save(
                Pokemon.builder()
                    .name(request.getName())
                    .level(request.getLevel())
                    .health(request.getHealth())
                    .attack(request.getAttack())
                    .specialAttack(request.getSpecialAttack())
                    .defense(request.getDefense())
                    .specialDefense(request.getSpecialDefense())
                    .speed(request.getSpeed())
                    .build()
            ));
    }

    public Mono<Pokemon> getPokemonById(String id) {
        return pokemonRepository.findById(id);
    }

    public Mono<Pokemon> updatePokemon(PokemonUpdateRequest request) {
        return pokemonRepository.findById(request.getId())
            .flatMap(pokemon -> {
                pokemon.setName(request.getName());
                pokemon.setLevel(request.getLevel());
                pokemon.setHealth(request.getHealth());
                pokemon.setAttack(request.getAttack());
                pokemon.setSpecialAttack(request.getSpecialAttack());
                pokemon.setDefense(request.getDefense());
                pokemon.setSpecialDefense(request.getSpecialDefense());
                pokemon.setSpeed(request.getSpeed());
                return pokemonRepository.save(pokemon);
            });
    }

    public Mono<Void> deletePokemon(PokemonDeleteRequest request) {
        return pokemonRepository.deleteById(request.getId());
    }

}
