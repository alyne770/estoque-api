package com.ilia.digital.estoqueapi.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCodes {
    PRODUCT_NOT_FOUND("Product Not Found");

    private final String message;
}
