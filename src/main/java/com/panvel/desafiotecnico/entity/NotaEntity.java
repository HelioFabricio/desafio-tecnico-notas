package com.panvel.desafiotecnico.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table( name = "NOTAS" )
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotaEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID )
    private UUID id;

    private BigDecimal valor;
    private Integer numero;
    private OffsetDateTime dataHora;
}
