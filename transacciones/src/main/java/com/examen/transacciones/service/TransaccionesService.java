package com.examen.transacciones.service;

import com.examen.transacciones.dto.RegistrarTransaccionRequestDTO;
import com.examen.transacciones.controller.mapper.TransaccionMapper;
import com.examen.transacciones.model.TransaccionTurno;
import com.examen.transacciones.repository.TransaccionTurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransaccionesService {

    @Autowired
    private TransaccionTurnoRepository transaccionRepository;

    @Autowired
    private RestTemplate restTemplate;

    public TransaccionTurno registrarTransaccion(RegistrarTransaccionRequestDTO request) {
        String url = "http://localhost:8081/api/turnos/estado/" + request.getCodigoTurno();
        Boolean turnoAbierto = restTemplate.getForObject(url, Boolean.class);

        if (turnoAbierto == null || !turnoAbierto) {
            throw new IllegalStateException("No se puede registrar la transacción. El turno está cerrado o no existe.");
        }

        TransaccionTurno transaccion = TransaccionMapper.fromRequest(request);
        return transaccionRepository.save(transaccion);
    }
}