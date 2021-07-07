package com.taranenkoant.msscbreweryclient.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Create by taranenko on 07.07.2021
 * Описание:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {

    private UUID id;
    private String name;
}
