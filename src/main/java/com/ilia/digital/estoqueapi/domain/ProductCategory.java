package com.ilia.digital.estoqueapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum ProductCategory {
    SPORT("Sport", 0),
    DOMESTIC("Domestic" ,1),
    HOBBY("Hobby",2),
    ELECTRONICS("Electronics",3);

    private final String label;
    private final int value;

    public static ProductCategory of(int value){
       return Stream.of(ProductCategory.values())
                .filter(productCategory -> productCategory.getValue() ==value )
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Product Category not found"));
    }


}
