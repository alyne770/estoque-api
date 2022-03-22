package com.ilia.digital.estoqueapi.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
public class ProductStock {
    @Id
    private  long id;
    @EqualsAndHashCode.Exclude
    @OneToOne
    @MapsId
    private  Product product;
    @EqualsAndHashCode.Exclude
    @OneToMany
    private List<RecordChangeProductStock> recordChangeProductStocks;

    private Integer quantity;



    @Override
    public boolean equals(Object obj)
    {

        if(this == obj)
            return true;

        if(obj == null || obj.getClass()!= this.getClass())
            return false;


        ProductStock productStock = (ProductStock) obj;

        return ( productStock.id == this.id && productStock.quantity == this.quantity
                && productStock.product.getId() == this.product.getId() );
    }
}
