package com.examen.turno.model;

import lombok.Data;
import lombok.ToString;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@ToString
@Document(collection = "TURNOS_CAJA")
public class TurnoCaja {

    @MongoId
    private String codigoTurno;

    private String codigoCaja;
    private String codigoCajero;

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaCierre;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal montoInicial;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal montoFinal;

    private EstadoTurno estado; 

    private List<DenominacionBillete> denominacionesIniciales;
    private List<DenominacionBillete> denominacionesFinales;

    public enum EstadoTurno {
        ABIERTO, CERRADO
    }
}
