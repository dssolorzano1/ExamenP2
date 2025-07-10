package com.examen.transacciones.model;

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
@Document(collection = "TRANSACCIONES_TURNO")
public class TransaccionTurno {

    @MongoId
    private String id;

    private String codigoTurno;
    private String codigoCaja;
    private String codigoCajero;

    private TipoTransaccion tipoTransaccion; 
    private LocalDateTime fecha;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal montoTotal;

    private List<DenominacionBillete> denominaciones;

    public enum TipoTransaccion {
        INICIO, AHORRO_DEPOSITO, CIERRE
    }
}
