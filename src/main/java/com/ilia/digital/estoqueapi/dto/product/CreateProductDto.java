package com.ilia.digital.estoqueapi.dto.product;

import com.ilia.digital.estoqueapi.domain.ProductCategory;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
public class CreateProductDto {
    @NotEmpty(message = "The product name cannot be empty")
    private  String name;
    private String description;
    @NotNull(message = "The product price cannot be null")
    private Float price;
    @NotNull(message = "The product category cannot be null")
    private ProductCategory productCategory;
    private Integer productStockQuantity;
}
