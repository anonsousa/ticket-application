package com.antoniosousa.ticket.controller;


import com.antoniosousa.ticket.domain.dto.cep.ViaCepResponseDto;
import com.antoniosousa.ticket.domain.service.CepService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/cep")
public class CepController {

    private final CepService cepService;


    public CepController(CepService cepService) {
        this.cepService = cepService;
    }


    @GetMapping("/{cep}")
    public ResponseEntity<ViaCepResponseDto> findCep(@PathVariable String cep) {
        ViaCepResponseDto response = cepService.consultarCep(cep);
        return ResponseEntity.ok(response);
    }
}
