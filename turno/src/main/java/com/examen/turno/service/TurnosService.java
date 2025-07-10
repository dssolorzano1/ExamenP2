package com.examen.turno.service;

import com.examen.turno.model.TurnoCaja;
import com.examen.turno.model.TurnoCaja.EstadoTurno;
import com.examen.turno.model.DenominacionBillete;
import com.examen.turno.repository.TurnoCajaRepository;
import com.examen.turno.dto.AbrirTurnoRequestDTO;
import com.examen.turno.dto.CerrarTurnoRequestDTO;
import com.examen.turno.controller.mapper.TurnoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class TurnosService {

    @Autowired
    private TurnoCajaRepository turnoCajaRepository;

    public TurnoCaja abrirTurno(AbrirTurnoRequestDTO request) {
        String codigoTurno = TurnoMapper.generarCodigo(request.getCodigoCaja(), request.getCodigoCajero());

        Optional<TurnoCaja> existente = turnoCajaRepository.findById(codigoTurno);
        if (existente.isPresent() && existente.get().getEstado() == EstadoTurno.ABIERTO) {
            throw new IllegalStateException("Ya existe un turno abierto para este cajero");
        }

        TurnoCaja turno = TurnoMapper.fromRequest(request);
        return turnoCajaRepository.save(turno);
    }

    public TurnoCaja cerrarTurno(CerrarTurnoRequestDTO request) {
        TurnoCaja turno = turnoCajaRepository.findById(request.getCodigoTurno())
                .orElseThrow(() -> new IllegalArgumentException("Turno no encontrado"));

        if (turno.getEstado() == EstadoTurno.CERRADO) {
            throw new IllegalStateException("El turno ya fue cerrado");
        }

        turno.setDenominacionesFinales(request.getDenominaciones());
        turno.setFechaCierre(java.time.LocalDateTime.now());
        turno.setMontoFinal(request.getMontoFinal());
        turno.setEstado(EstadoTurno.CERRADO);

        return turnoCajaRepository.save(turno);
    }
}
