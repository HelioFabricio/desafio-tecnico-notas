package com.panvel.desafiotecnico.validators;

import com.panvel.desafiotecnico.dto.NotaDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;

public class DataValidatorTest {
    private DataValidator validator;
    private Clock fixedClock;

    @BeforeEach
    void setUp() {
        fixedClock = Clock.fixed(
                Instant.parse( "2026-01-01T10:00:00Z" ),
                ZoneOffset.UTC
        );

        validator = new DataValidator( fixedClock );
    }

    @Test
    void deveSerInvalidoQuandoDataForNull() {
        NotaDTO dto = new NotaDTO();
        dto.setDataHora( null );

        assertFalse ( validator.isValid( dto ) );
    }

    @Test
    void deveSerInvalidoQuandoDataForNoFuturo() {
        NotaDTO dto = new NotaDTO();
        dto.setDataHora( OffsetDateTime.parse( "2026-01-02T10:00:00Z" ) );

        assertFalse( validator.isValid( dto ) );
    }

    @Test
    void deveSerValidoQuandoDataForIgualAoClock() {
        NotaDTO dto = new NotaDTO();
        dto.setDataHora(OffsetDateTime.parse( "2026-01-01T10:00:00Z" ) );

        assertTrue( validator.isValid( dto ) );
    }

    @Test
    void deveSerValidoQuandoDataForNoPassado() {
        NotaDTO dto = new NotaDTO();
        dto.setDataHora( OffsetDateTime.parse( "2025-12-31T23:59:59Z") );

        assertTrue( validator.isValid( dto ) );
    }
}