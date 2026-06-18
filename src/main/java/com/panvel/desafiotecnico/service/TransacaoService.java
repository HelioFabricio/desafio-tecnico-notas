package com.panvel.desafiotecnico.service;

import com.panvel.desafiotecnico.dto.NotaDTO;
import com.panvel.desafiotecnico.entity.NotaEntity;
import com.panvel.desafiotecnico.mapper.NotaMapper;
import com.panvel.desafiotecnico.repository.NotaRepository;
import com.panvel.desafiotecnico.validators.NotaValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TransacaoService {
    private final List< NotaValidator > validators;
    private final NotaRepository notaRepository;
    private final NotaMapper notaMapper;

    public Optional< NotaDTO > criaNota( NotaDTO nota ) throws IllegalArgumentException, BadRequestException {
        log.info( "Recebida solicitação para criar nota" );
        if ( nota.getNumero() == null
            || nota.getDataHora() == null
            || nota.getValor() == null ) {
            log.warn( "Payload da nota é inválido." );
            throw new BadRequestException( "Erro: Nota precisa conter os campos Numero, DataHora e Valor." );
        }

        for ( NotaValidator validator : validators ) {
            if ( !validator.isValid( nota ) ) {
                log.warn(
                        "Validação falhou. Validator={}, motivo={}",
                        validator.getClass().getSimpleName(),
                        validator.getMensagem()
                );

                throw new IllegalArgumentException(
                        validator.getMensagem() );
            }
        }

        NotaEntity salvo = notaRepository.save( notaMapper.toEntity( nota ) );
        log.info( "Nota salva com sucesso. id={}", salvo.getId() );

        return Optional.of( nota );
    }

    public void deletarDados() {
        log.info( "Deletanto todas as notas do banco de dados..." );
        List<NotaEntity> notas = notaRepository.findAll();

        log.info("Quantidade de notas a serem deletadas: {}", notas.size());
        log.info( "Todas as informações foram apagadas com sucesso!" );
    }
}