package com.ilia.digital.estoqueapi.dto;

import com.ilia.digital.estoqueapi.domain.ProductCategory;
import lombok.Data;



@Data
public class CreateProductDto {
    private  String name;
    private String code;
    private String description;
    private Float price;
    private ProductCategory productCategory;
}
