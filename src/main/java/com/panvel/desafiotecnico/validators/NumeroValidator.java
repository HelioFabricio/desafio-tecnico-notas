package com.panvel.desafiotecnico.validators;

import com.panvel.desafiotecnico.dto.NotaDTO;
import org.springframework.stereotype.Component;

@Component
public class NumeroValidator implements NotaValidator {
    @Override
    public boolean isValid( NotaDTO nota ) {
        return nota.getNumero() != null
                && nota.getNumero() > 0;
    }

    @Override
    public String getMensagem() {
        return "Número vazio ou Inválido";
    }
}
