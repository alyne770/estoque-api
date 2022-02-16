package com.ilia.digital.estoqueapi.service.product;

import com.ilia.digital.estoqueapi.domain.Product;
import com.ilia.digital.estoqueapi.dto.CreateProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Product findById(long id);
    Page<Product> findAll(Pageable pageable);
    Product create(CreateProductDto createProductDto);
    Product replace ( Product product);
    String generateCode();

}
