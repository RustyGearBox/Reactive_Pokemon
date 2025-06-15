package edu.api.pokemon.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import edu.api.pokemon.documents.Pokemon;
import reactor.core.publisher.Mono;

@Repository
public interface PokemonRepository extends ReactiveMongoRepository<Pokemon, String> {
 
    public Mono<Pokemon> findByName(String name);

}
