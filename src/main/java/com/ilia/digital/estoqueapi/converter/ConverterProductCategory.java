package com.ilia.digital.estoqueapi.converter;

import com.ilia.digital.estoqueapi.domain.ProductCategory;

import javax.persistence.AttributeConverter;

//Faz com que o Product Category seja mapeado pelo seu atributo value

@javax.persistence.Converter(autoApply = true)
public class ConverterProductCategory implements AttributeConverter<ProductCategory, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ProductCategory productCategory) {

        return productCategory == null ? null : productCategory.getValue();
    }

    @Override
    public ProductCategory convertToEntityAttribute(Integer integer) {

        return ProductCategory.of(integer);
    }
}
