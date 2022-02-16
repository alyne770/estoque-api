package com.ilia.digital.estoqueapi.service.product.impl;

import com.ilia.digital.estoqueapi.constants.ErrorCodes;
import com.ilia.digital.estoqueapi.domain.Product;
import com.ilia.digital.estoqueapi.dto.CreateProductDto;
import com.ilia.digital.estoqueapi.exception.BadRequestException;
import com.ilia.digital.estoqueapi.repository.ProductRepository;
import com.ilia.digital.estoqueapi.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Properties;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    @Override
    public Product findById(long id) {
        log.info("ProductServiceImpl.findById - start - input [{}]", id);
        return productRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorCodes.PRODUCT_NOT_FOUND.getMessage()));

    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Product create(CreateProductDto createProductDto) {

        log.info("ProductServiceImpl.create - start - input  [{}]", createProductDto);
        Product product = modelMapper.map(createProductDto, Product.class);

        Product productSaved =productRepository.save(product);
        log.info("ProductServiceImpl.create - end- output [{}]", productSaved);
        return productSaved;
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
