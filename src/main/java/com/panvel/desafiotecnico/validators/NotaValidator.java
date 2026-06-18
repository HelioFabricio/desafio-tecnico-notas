package com.panvel.desafiotecnico.validators;

import com.panvel.desafiotecnico.dto.NotaDTO;

public interface NotaValidator {
    boolean isValid( NotaDTO nota );

    String getMensagem();
}
