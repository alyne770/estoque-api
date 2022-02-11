package com.ilia.digital.estoqueapi.service.product.impl;

import com.ilia.digital.estoqueapi.domain.Product;
import com.ilia.digital.estoqueapi.repository.ProductRepository;
import com.ilia.digital.estoqueapi.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product findById(long id) {
        log.info("ProductServiceImpl.findById - start - [{}]", id);
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException("rte"));

    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Product create(Product product) {
        return null;
    }

    @Override
    public Product replace(Product product) {
        return null;
    }

    @Override
    public String generateCode() {
        return null;
    }
}
