package com.techelevator.service;

import com.techelevator.model.TaxResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
@Component
public class TaxService {

    private final static String API_BASE_URL = "https://teapi.netlify.app/api/statetax?state=";
    private final RestTemplate restTemplate = new RestTemplate();

    public BigDecimal getTaxRate (String stateCode) {
        String api = API_BASE_URL + stateCode.toLowerCase();
        try {
            TaxResponseDto taxResponseDto = restTemplate.getForObject(api, TaxResponseDto.class);
            return taxResponseDto.getSalesTax().divide(new BigDecimal("100"));
        } catch (HttpClientErrorException e){
            if (e.getRawStatusCode() == 404){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tax not found for state '"+ stateCode.toLowerCase() + "'.", e);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There was an error getting the tax rate.", e);
            }
        }
    }
}
