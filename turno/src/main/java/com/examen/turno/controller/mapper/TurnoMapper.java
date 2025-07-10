package com.examen.turno.controller.mapper;

import com.examen.turno.dto.AbrirTurnoRequestDTO;
import com.examen.turno.model.TurnoCaja;
import com.examen.turno.model.DenominacionBillete;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class TurnoMapper {

    public static TurnoCaja fromRequest(AbrirTurnoRequestDTO dto) {
        String codigoTurno = generarCodigo(dto.getCodigoCaja(), dto.getCodigoCajero());
        BigDecimal montoInicial = dto.getDenominaciones().stream()
                .map(DenominacionBillete::getMonto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        TurnoCaja turno = new TurnoCaja();
        turno.setCodigoTurno(codigoTurno);
        turno.setCodigoCaja(dto.getCodigoCaja());
        turno.setCodigoCajero(dto.getCodigoCajero());
        turno.setFechaInicio(LocalDateTime.now());
        turno.setEstado(TurnoCaja.EstadoTurno.ABIERTO);
        turno.setDenominacionesIniciales(dto.getDenominaciones());
        turno.setMontoInicial(montoInicial);
        return turno;
    }

    private static String generarCodigo(String codigoCaja, String codigoCajero) {
        return codigoCaja + "-" + codigoCajero + LocalDate.now().toString().replace("-", "");
    }
}
