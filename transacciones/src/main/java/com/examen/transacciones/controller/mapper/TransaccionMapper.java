package com.examen.transacciones.controller.mapper;

import com.examen.transacciones.dto.RegistrarTransaccionRequestDTO;
import com.examen.transacciones.model.DenominacionBillete;
import com.examen.transacciones.model.TransaccionTurno;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class TransaccionMapper {

    public static TransaccionTurno fromRequest(RegistrarTransaccionRequestDTO dto) {
        List<DenominacionBillete> billetes = dto.getDenominaciones();
        BigDecimal montoTotal = billetes.stream()
                .map(DenominacionBillete::getMonto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        TransaccionTurno transaccion = new TransaccionTurno();
        transaccion.setCodigoCaja(dto.getCodigoCaja());
        transaccion.setCodigoCajero(dto.getCodigoCajero());
        transaccion.setCodigoTurno(dto.getCodigoTurno());
        transaccion.setTipoTransaccion(dto.getTipo());
        transaccion.setDenominaciones(billetes);
        transaccion.setMontoTotal(montoTotal);
        transaccion.setFecha(LocalDateTime.now());

        return transaccion;
    }
}
