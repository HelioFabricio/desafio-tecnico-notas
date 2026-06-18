package com.panvel.desafiotecnico.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotaDTO {
    private BigDecimal valor;
    private Integer numero;
    private OffsetDateTime dataHora;
}
