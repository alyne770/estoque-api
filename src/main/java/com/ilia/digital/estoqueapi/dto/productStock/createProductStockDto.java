package com.ilia.digital.estoqueapi.dto.productStock;

import com.ilia.digital.estoqueapi.domain.Product;
import lombok.Data;


@Data
public class createProductStockDto {

        private  long id;
        private Product product;
        private Integer quantity;
}
