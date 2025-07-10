package com.examen.transacciones.dto;

import com.examen.transacciones.model.DenominacionBillete;
import com.examen.transacciones.model.TransaccionTurno.TipoTransaccion;
import lombok.Data;

import java.util.List;

@Data
public class RegistrarTransaccionRequestDTO {
    private String codigoCaja;
    private String codigoCajero;
    private String codigoTurno;
    private TipoTransaccion tipo;
    private List<DenominacionBillete> denominaciones;
}
