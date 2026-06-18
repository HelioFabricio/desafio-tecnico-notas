package com.panvel.desafiotecnico.controller;

import com.panvel.desafiotecnico.dto.NotaDTO;
import com.panvel.desafiotecnico.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/nota")
@RequiredArgsConstructor()
public class TransacaoController {

    private final TransacaoService transacaoService;

    @PostMapping()
    public ResponseEntity criaNota( @RequestBody NotaDTO notaDTO ) {
        try{
            transacaoService.criaNota( notaDTO );
            return ResponseEntity.status( HttpStatus.CREATED ).build();
        } catch ( IllegalArgumentException e) {
            return ResponseEntity.status( HttpStatus.UNPROCESSABLE_CONTENT ).build();
        } catch ( BadRequestException e) {
            return ResponseEntity.status( HttpStatus.BAD_REQUEST ).build();
        }
    }

    @DeleteMapping()
    public ResponseEntity deletaNotas() {
        transacaoService.deletarDados();
        return ResponseEntity.status( HttpStatus.OK ).build();
    }
}
