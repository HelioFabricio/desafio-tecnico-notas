package com.panvel.desafiotecnico.service;

import com.panvel.desafiotecnico.dto.EstatisticaDTO;
import com.panvel.desafiotecnico.dto.EstatisticaProperties;
import com.panvel.desafiotecnico.entity.NotaEntity;
import com.panvel.desafiotecnico.repository.NotaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EstatisticaService {
    private final NotaRepository notaRepository;
    private final EstatisticaProperties searchTimeSpanSeconds;

    public EstatisticaDTO buscaEstatisticas() {
        log.info("Calculando estatisticas de transaçes... ");

        Integer searchTimeSecondsInteger = searchTimeSpanSeconds.searchTimeSpanSeconds();

        if ( searchTimeSecondsInteger == null ) {
            throw new IllegalArgumentException( "Necessário estar configurado o tempo de busca das notas" +
                    " no application properties" );
        }

        OffsetDateTime dataHoraFim = OffsetDateTime.now();
        OffsetDateTime dataHoraInicio = dataHoraFim.minusSeconds( searchTimeSecondsInteger );

        List<NotaEntity> notaList = notaRepository.findByDataHoraGreaterThanEqualAndDataHoraLessThanEqual(
                dataHoraInicio,
                dataHoraFim
        );

        if ( notaList.isEmpty() ) {
            return new EstatisticaDTO(
                    0,
                    0.0,
                    0.0,
                    0.0,
                    0.0
            );
        }

        var summary = notaList.stream()
                .mapToDouble(t -> t.getValor().doubleValue())
                .summaryStatistics();

        return new EstatisticaDTO(
                (int) summary.getCount(),
                summary.getSum(),
                summary.getAverage(),
                summary.getMin(),
                summary.getMax()
        );
    }
}