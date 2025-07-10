package com.examen.transacciones.repository;

import com.examen.transacciones.model.TransaccionTurno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransaccionTurnoRepository extends MongoRepository<TransaccionTurno, String> {
    List<TransaccionTurno> findByCodigoTurno(String codigoTurno);
}
