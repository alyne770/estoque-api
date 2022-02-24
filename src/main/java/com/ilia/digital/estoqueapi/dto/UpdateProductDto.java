package com.ilia.digital.estoqueapi.dto;

import com.ilia.digital.estoqueapi.domain.ProductCategory;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
public class UpdateProductDto {

    @NotNull(message = "The product id cannot be null")
    private  long id;
    @NotEmpty(message = "The product name cannot be empty")
    private  String name;
    private String description;
    @NotNull(message = "The product price cannot be null")
    private Float price;
    @NotNull(message = "The product category cannot be null")
    private ProductCategory productCategory;
}
