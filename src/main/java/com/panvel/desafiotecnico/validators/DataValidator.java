package com.panvel.desafiotecnico.validators;

import com.panvel.desafiotecnico.dto.NotaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.OffsetDateTime;

@Component
@RequiredArgsConstructor
public class DataValidator implements NotaValidator {
    private final Clock clock;

    @Override
    public boolean isValid( NotaDTO nota ) {
        return nota.getDataHora() != null
                && !nota.getDataHora().isAfter( OffsetDateTime.now( clock ) );
    }

    @Override
    public String getMensagem() {
        return "Data inválida";
    }
}