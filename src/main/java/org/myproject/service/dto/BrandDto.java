package org.myproject.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.myproject.repository.entity.Brand;

@Getter
@Setter
@Builder
public class BrandDto {
    private Long id;
    private String name;
    private String country;

    public Brand fromDTO() {
        return Brand.builder()
                .id(getId())
                .name(getName())
                .country(getCountry())
                .build();
    }
}
