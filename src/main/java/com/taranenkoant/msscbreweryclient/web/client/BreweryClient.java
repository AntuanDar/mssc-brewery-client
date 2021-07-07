package com.taranenkoant.msscbreweryclient.web.client;

import com.taranenkoant.msscbreweryclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

/**
 * Create by taranenko on 07.07.2021
 * Описание:
 */
@Component
@ConfigurationProperties(prefix = "sfg.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    private String apihost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    public BeerDto getBeerById(UUID id){
        return restTemplate.getForObject(apihost + BEER_PATH_V1 + id.toString(), BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apihost + BEER_PATH_V1, beerDto);
    }

    public void updateBeer(UUID uuid, BeerDto beerDto){
        restTemplate.put(apihost + BEER_PATH_V1 + uuid.toString(), beerDto);
    }

    public void deleteBeer(UUID uuid){
        restTemplate.delete(apihost + BEER_PATH_V1 + uuid.toString());
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
