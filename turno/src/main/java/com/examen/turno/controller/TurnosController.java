package com.examen.turno.controller;

import com.examen.turno.dto.AbrirTurnoRequestDTO;
import com.examen.turno.dto.CerrarTurnoRequestDTO;
import com.examen.turno.model.TurnoCaja;
import com.examen.turno.service.TurnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/turnos")
public class TurnosController {

    @Autowired
    private TurnosService turnosService;

    @PostMapping("/abrir")
    public ResponseEntity<TurnoCaja> abrirTurno(@RequestBody AbrirTurnoRequestDTO request) {
        TurnoCaja turno = turnosService.abrirTurno(
                request.getCodigoCaja(),
                request.getCodigoCajero(),
                request.getDenominaciones());
        return ResponseEntity.ok(turno);
    }

    @PostMapping("/cerrar")
    public ResponseEntity<TurnoCaja> cerrarTurno(@RequestBody CerrarTurnoRequestDTO request) {
        TurnoCaja turno = turnosService.cerrarTurno(
                request.getCodigoTurno(),
                request.getDenominaciones(),
                request.getMontoFinal());
        return ResponseEntity.ok(turno);
    }
}

