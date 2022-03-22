package com.ilia.digital.estoqueapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ilia.digital.estoqueapi.constants.ErrorCodes;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@EqualsAndHashCode
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @JsonIgnore
    @OneToOne(mappedBy = "product", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private ProductStock productStock;

    @NotEmpty(message = ErrorCodes.NAME_NOT_EMPTY)
    private  String name;

    @Column(unique = true)
    @NotEmpty(message =ErrorCodes.CODE_NOT_EMPTY)
    private String code;

    private String description;

    private Float price;

    @NotNull(message = ErrorCodes.PRODUCT_CATEGORY_NOT_FOUND)
    private ProductCategory productCategory;

    @Override
    public boolean equals(Object obj)
    {

        if(this == obj)
            return true;

        if(obj == null || obj.getClass()!= this.getClass())
            return false;


        Product product = (Product) obj;

        return ( product.id == this.id && product.name.equals(this.name)   && product.code.equals(this.code)
                && product.description.equals(this.description) && product.price.equals(this.price)
                && product.productCategory == this.productCategory
                && product.productStock.equals(this.productStock))
                ;
    }
}
