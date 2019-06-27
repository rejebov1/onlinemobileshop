package org.myproject.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class ProductDto {
    private Long id;
    private String phoneModel;
    private LocalDate dateOfIssue;
    private String productCharacteristic;
    private Double price;
    private BrandDto brandDto;


}
