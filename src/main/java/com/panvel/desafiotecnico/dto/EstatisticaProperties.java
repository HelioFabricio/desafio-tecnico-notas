package com.panvel.desafiotecnico.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotNull;

@Validated
@ConfigurationProperties( prefix = "spring.application" )
public record EstatisticaProperties(

        @NotNull
        @Positive
        Integer searchTimeSpanSeconds

) {

}


