package com.ilia.digital.estoqueapi.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @NotEmpty(message = "The name of product cannot is empty")
    private  String name;
    @Column(unique = true)
    @NotEmpty(message = "The code of product cannot is empty")
    private String code;
    private String description;
    private Float price;
    private ProductCategory productCategory;
}
