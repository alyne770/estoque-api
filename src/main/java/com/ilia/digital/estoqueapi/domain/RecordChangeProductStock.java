package com.ilia.digital.estoqueapi.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class RecordChangeProductStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;

    @CreationTimestamp
    private LocalDateTime updateDate;

   @ManyToOne
    private ProductStock productStock;

   private TypeChangeProductStock typeChangeProductStock;

}
