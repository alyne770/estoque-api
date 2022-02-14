package com.ilia.digital.estoqueapi.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class ProductStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @OneToOne
    private  Product product;

    @OneToMany
    private List<RecordChangeProductStock> recordChangeProductStocks;
}
