package com.ilia.digital.estoqueapi.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExceptionDetails {
    private String developerMessage;
    private String title;
    private int status;
}
