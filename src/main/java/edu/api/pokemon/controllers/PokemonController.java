package edu.api.pokemon.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.api.pokemon.documents.Pokemon;
import edu.api.pokemon.documents.request.PokemonCreateRequest;
import edu.api.pokemon.documents.request.PokemonDeleteRequest;
import edu.api.pokemon.documents.request.PokemonUpdateRequest;
import edu.api.pokemon.services.PokemonServiceImpl;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/crud/pokemon")
public class PokemonController {

    private final PokemonServiceImpl pokemonService;

    @PostMapping("/create")
    public ResponseEntity<Mono<Pokemon>> createGame(@RequestBody PokemonCreateRequest pokemonCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pokemonService.createPokemon(pokemonCreateRequest));
    }

    @GetMapping("/get/{pokemonId}")
    public ResponseEntity<Mono<Pokemon>> getPokemonById(@PathVariable("pokemonId") String id) {
        return ResponseEntity.ok(pokemonService.getPokemonById(id));
    }
    
    @PutMapping("/update")
    public ResponseEntity<Mono<Pokemon>> updatePokemon(@RequestBody PokemonUpdateRequest pokemonUpdateRequest) {
        return ResponseEntity.ok(pokemonService.updatePokemon(pokemonUpdateRequest));
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Mono<Void>> deleteGame(@RequestBody PokemonDeleteRequest pokemonDeleteRequest) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(pokemonService.deletePokemon(pokemonDeleteRequest));
    }

}
