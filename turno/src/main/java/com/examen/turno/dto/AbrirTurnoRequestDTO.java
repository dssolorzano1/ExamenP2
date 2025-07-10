package com.examen.turno.dto;

import com.examen.turno.model.DenominacionBillete;
import lombok.Data;

import java.util.List;

@Data
public class AbrirTurnoRequestDTO {
    private String codigoCaja;
    private String codigoCajero;
    private List<DenominacionBillete> denominaciones;
}
