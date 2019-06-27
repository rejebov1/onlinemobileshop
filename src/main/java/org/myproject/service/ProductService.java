package org.myproject.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.myproject.repository.dao.JdbcDao.ProductJdbcDao;
import org.myproject.repository.entity.Product;
import org.myproject.service.dto.ProductDto;
import org.myproject.service.formatter.LocalDateFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductService {
    private static final ProductService INSTANCE = new ProductService();

    public static ProductService getInstance() {
        return INSTANCE;
    }
    public Product add(ProductDto productDto) {
        Product product = Product.builder()
                .phoneModel(productDto.getPhoneModel())
                .dateOfIssue(LocalDateFormatter.format(String.valueOf(productDto.getDateOfIssue())))
                .productCharacteristic(productDto.getProductCharacteristic())
                .price(productDto.getPrice())
                .brand(productDto.getBrandDto().fromDTO())
                .build();
        return ProductJdbcDao.getInstance().add(product);
    }

}

