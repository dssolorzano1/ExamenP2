package com.examen.transacciones.controller;

import com.examen.transacciones.dto.RegistrarTransaccionRequestDTO;
import com.examen.transacciones.model.TransaccionTurno;
import com.examen.transacciones.service.TransaccionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transacciones")
public class TransaccionesController {

    @Autowired
    private TransaccionesService transaccionesService;

    @PostMapping("/registrar")
    public ResponseEntity<TransaccionTurno> registrar(@RequestBody RegistrarTransaccionRequestDTO request) {
        TransaccionTurno transaccion = transaccionesService.registrarTransaccion(request);
        return ResponseEntity.ok(transaccion);
    }
}