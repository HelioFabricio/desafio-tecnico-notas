package com.panvel.desafiotecnico.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EstatisticaDTO {
    private Integer count;
    private Double sum;
    private Double avg;
    private Double min;
    private Double max;
}
