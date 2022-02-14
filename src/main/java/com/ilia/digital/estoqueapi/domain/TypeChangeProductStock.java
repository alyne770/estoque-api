package com.ilia.digital.estoqueapi.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;


@AllArgsConstructor
@Getter
public enum TypeChangeProductStock {

    SALE("Sale", 1),
    DONATION("Donation" ,2),
    EXPIRED_VALIDITY("Expired Validity",3),
    ARRIVAL_OF_MORE_UNITS("Arrival of more units",4);

    private final String label;
    private final int value;

    public static TypeChangeProductStock of(int value){
        return Stream.of(TypeChangeProductStock.values())
                .filter(typeChangeProductStock -> typeChangeProductStock.getValue() == value )
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Type Change Product Stock  not found"));
    }

}
