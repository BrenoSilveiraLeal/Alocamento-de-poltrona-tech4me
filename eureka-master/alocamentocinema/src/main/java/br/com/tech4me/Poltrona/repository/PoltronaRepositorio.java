package br.com.tech4me.Poltrona.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.Poltrona.model.Poltrona;

public interface PoltronaRepositorio extends MongoRepository<Poltrona, String> {

    List<Poltrona> findByDono(String dono);
    
    
}
