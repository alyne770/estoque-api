package com.ilia.digital.estoqueapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum ProductCategory {
    SPORT("Sport", 1),
    DOMESTIC("Domestic" ,2),
    HOBBY("Hobby",3),
    ELECTRONICS("Electronics",4);

    private final String label;
    private final int value;

    public static ProductCategory of(int value){
       return Stream.of(ProductCategory.values())
                .filter(productCategory -> productCategory.getValue() ==value )
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Product Category not found"));
    }


}
