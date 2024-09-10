package com.antoniosousa.ticket.domain.service;

import com.antoniosousa.ticket.domain.dto.ViaCepResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class CepService {


    private final RestTemplate restTemplate;

    public CepService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ViaCepResponseDto consultarCep(String cep) {
        String url = UriComponentsBuilder.fromHttpUrl("https://viacep.com.br/ws/{cep}/json/")
                .buildAndExpand(cep)
                .toString();
        return restTemplate.getForObject(url, ViaCepResponseDto.class);
    }
}
