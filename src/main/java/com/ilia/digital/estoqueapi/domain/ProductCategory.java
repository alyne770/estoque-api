package com.ilia.digital.estoqueapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum ProductCategory {
    SPORT("Sport", 0,"SP"),
    DOMESTIC("Domestic" ,1,"DM"),
    HOBBY("Hobby",2,"HB"),
    ELECTRONICS("Electronics",3,"ET");

    private final String label;
    private final int value;
    private final String  code;

    public static ProductCategory of(int value){
       return Stream.of(ProductCategory.values())
                .filter(productCategory -> productCategory.getValue() ==value )
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Product Category not found"));
    }



}
