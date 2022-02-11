package com.ilia.digital.estoqueapi.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private  String name;
    private String code;
    private String description;
    private Float price;
    private ProductCategory productCategory;
}
