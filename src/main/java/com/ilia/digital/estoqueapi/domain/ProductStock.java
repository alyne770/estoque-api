package com.ilia.digital.estoqueapi.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class ProductStock {
    @Id
    private  long id;

    @OneToOne
    @MapsId
    private  Product product;

    @OneToMany
    private List<RecordChangeProductStock> recordChangeProductStocks;

    private Integer quantity;
}
