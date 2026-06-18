package com.panvel.desafiotecnico.mapper;

import com.panvel.desafiotecnico.dto.NotaDTO;
import com.panvel.desafiotecnico.entity.NotaEntity;
import org.springframework.stereotype.Component;

@Component
public class NotaMapper {
    public NotaEntity toEntity( NotaDTO notaDTO ) {
        if ( notaDTO == null ) {
            return null;
        }

        return new NotaEntity(
                null,
                notaDTO.getValor(),
                notaDTO.getNumero(),
                notaDTO.getDataHora()
        );
    }
}
