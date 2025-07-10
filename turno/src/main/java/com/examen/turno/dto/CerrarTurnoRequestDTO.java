package com.examen.turno.dto;

import com.examen.turno.model.DenominacionBillete;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CerrarTurnoRequestDTO {
    private String codigoTurno;
    private List<DenominacionBillete> denominaciones;
    private BigDecimal montoFinal;
}
