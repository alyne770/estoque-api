package com.ilia.digital.estoqueapi.service.product;

import com.ilia.digital.estoqueapi.domain.Product;
import com.ilia.digital.estoqueapi.dto.product.CreateProductDto;
import com.ilia.digital.estoqueapi.dto.product.UpdateProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Product findById(long id);

    Page<Product> findAByNameOrCode(Pageable pageable, String searchTerm);

    Product create(CreateProductDto createProductDto);

    Product replace(UpdateProductDto updateProductDto);

    void setValidCode(Product product);

}
