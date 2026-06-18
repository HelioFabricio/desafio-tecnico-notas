package com.panvel.desafiotecnico.repository;

import com.panvel.desafiotecnico.entity.NotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface NotaRepository extends JpaRepository< NotaEntity, UUID > {
    List< NotaEntity > findByDataHoraGreaterThanEqualAndDataHoraLessThanEqual( OffsetDateTime dataInicio, OffsetDateTime dataLimite );
}
