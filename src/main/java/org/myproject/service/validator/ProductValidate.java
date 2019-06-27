package org.myproject.service.validator;

import org.myproject.service.dto.ProductDto;

import static org.myproject.service.serviceUtil.StringUtil.isEmpty;

public class ProductValidate implements Validator<ProductDto> {

    @Override
    public boolean isValid(ProductDto object) {
        return !isEmpty(object.getPhoneModel())
                && !isEmpty(String.valueOf(object.getDateOfIssue()))
                && !isEmpty(object.getProductCharacteristic())
                && !isEmpty(String.valueOf(Double.parseDouble(String.valueOf(object.getPrice()))));
    }


}
