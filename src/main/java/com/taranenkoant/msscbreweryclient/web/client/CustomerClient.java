package com.taranenkoant.msscbreweryclient.web.client;

import com.taranenkoant.msscbreweryclient.web.model.BeerDto;
import com.taranenkoant.msscbreweryclient.web.model.CustomerDto;
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
@ConfigurationProperties(prefix = "sfg.customer", ignoreUnknownFields = false)
public class CustomerClient {

    public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private String apihost;

    private final RestTemplate restTemplate;

    public CustomerClient(RestTemplateBuilder restTemplate) {
        this.restTemplate = restTemplate.build();
    }

    public CustomerDto getCustomerById(UUID id){
        return restTemplate.getForObject(apihost + CUSTOMER_PATH_V1 + id.toString(), CustomerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDto);
    }

    public void updateCustomer(UUID uuid, CustomerDto customerDto){
        restTemplate.put(apihost + CUSTOMER_PATH_V1 + uuid.toString(), customerDto);
    }

    public void deleteCustomer(UUID uuid){
        restTemplate.delete(apihost + CUSTOMER_PATH_V1 + uuid.toString());
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }
}
