package com.panvel.desafiotecnico.validators;

import com.panvel.desafiotecnico.dto.NotaDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumeroValidatorTest {
    private final NumeroValidator validator = new NumeroValidator();

    @Test
    void deveSerValidoQuandoNumeroMaiorQueZero() {
        NotaDTO dto = new NotaDTO();
        dto.setNumero( 10 );

        assertTrue( validator.isValid( dto ) );
    }

    @Test
    void deveSerInvalidoQuandoNumeroForNull() {
        NotaDTO dto = new NotaDTO();
        dto.setNumero( null );

        assertFalse( validator.isValid( dto ) );
    }

    @Test
    void deveSerInvalidoQuandoNumeroNegativo() {
        NotaDTO dto = new NotaDTO();
        dto.setNumero( -5 );

        assertFalse( validator.isValid( dto ) );
    }

    @Test
    void deveSerInvalidoQuandoNumeroForZero() {
        NotaDTO dto = new NotaDTO();
        dto.setNumero( 0 );

        assertFalse( validator.isValid( dto ) );
    }
}
