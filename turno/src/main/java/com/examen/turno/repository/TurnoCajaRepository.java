package com.examen.turno.repository;

import com.examen.turno.model.TurnoCaja;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoCajaRepository extends MongoRepository<TurnoCaja, String> {
}
