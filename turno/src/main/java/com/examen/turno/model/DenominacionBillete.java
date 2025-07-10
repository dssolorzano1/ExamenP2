package com.examen.turno.model;

import lombok.Data;
import lombok.ToString;
import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Data
@ToString
public class DenominacionBillete {

    private int valor;
    private int cantidad;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal monto; 
}
