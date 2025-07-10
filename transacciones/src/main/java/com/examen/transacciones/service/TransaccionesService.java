package com.examen.transacciones.service;

import com.examen.transacciones.model.TransaccionTurno;
import com.examen.transacciones.model.TransaccionTurno.TipoTransaccion;
import com.examen.transacciones.model.DenominacionBillete;
import com.examen.transacciones.repository.TransaccionTurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransaccionesService {

    @Autowired
    private TransaccionTurnoRepository transaccionRepository;

    public TransaccionTurno registrarTransaccion(String codigoCaja, String codigoCajero, String codigoTurno,
                                                 TipoTransaccion tipo, List<DenominacionBillete> denominaciones) {


        BigDecimal montoTotal = calcularMontoTotal(denominaciones);

        TransaccionTurno transaccion = new TransaccionTurno();
        transaccion.setCodigoCaja(codigoCaja);
        transaccion.setCodigoCajero(codigoCajero);
        transaccion.setCodigoTurno(codigoTurno);
        transaccion.setTipoTransaccion(tipo);
        transaccion.setDenominaciones(denominaciones);
        transaccion.setMontoTotal(montoTotal);
        transaccion.setFecha(LocalDateTime.now());

        return transaccionRepository.save(transaccion);
    }

    private BigDecimal calcularMontoTotal(List<DenominacionBillete> denominaciones) {
        return denominaciones.stream()
                .map(DenominacionBillete::getMonto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
} 
