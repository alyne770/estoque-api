package com.ilia.digital.estoqueapi.service.product.impl;

import com.ilia.digital.estoqueapi.constants.ErrorCodes;
import com.ilia.digital.estoqueapi.domain.Product;
import com.ilia.digital.estoqueapi.dto.CreateProductDto;
import com.ilia.digital.estoqueapi.dto.UpdateProductDto;
import com.ilia.digital.estoqueapi.exception.BadRequestException;
import com.ilia.digital.estoqueapi.repository.ProductRepository;
import com.ilia.digital.estoqueapi.service.product.ProductService;
import com.ilia.digital.estoqueapi.util.CodeUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

    @Override
    public Product findById(long id) {
        log.info("ProductServiceImpl.findById - start - input [{}]", id);
        Product productFound = productRepository.findById(id)
                .orElseThrow(() -> new BadRequestException(ErrorCodes.PRODUCT_NOT_FOUND));
        log.info("ProductServiceImpl.findById - end - output [{}]", productFound.getId());
        return productFound;

    }

    @Override
    public Page<Product> findAByNameOrCode(Pageable pageable, String searchTerm) {
        log.info("ProductServiceImpl.findAll - start - input [{}]", searchTerm);
        Page<Product> productPage = productRepository.findAByNameOrCode(pageable, searchTerm);
        log.info("ProductServiceImpl.findAll - end - output [{}]", productPage.getTotalElements());
        return productPage;
    }

    @Override
    @Transactional
    public Product create(CreateProductDto createProductDto) {

        log.info("ProductServiceImpl.create - start - input  [{}]", createProductDto);
        Product product = modelMapper.map(createProductDto, Product.class);

        setValidCode(product);

        Product productSaved = productRepository.save(product);
        log.info("ProductServiceImpl.create - end- output [{}]", productSaved.getId());
        return productSaved;
    }

    @Override
    public Product replace(UpdateProductDto updateProductDto) {

        log.info("ProductServiceImpl.replace - start - input  [{}]", updateProductDto.getId());
        Product product = modelMapper.map(updateProductDto, Product.class);

        Product productCurrent = findById(product.getId());
        if( productCurrent.getCode() == null){
            setValidCode(product);
        }else{
            product.setCode(productCurrent.getCode());
        }

        Product productUpdate = productRepository.save(product);

        
        log.info("ProductServiceImpl.replace - end- output [{}]", productUpdate.getId());
        return productUpdate;
    }


    public void setValidCode(Product product) {
        if (product.getProductCategory() == null) {
            throw new IllegalArgumentException(ErrorCodes.PRODUCT_CATEGORY_NOT_FOUND);
        }
        String code;
        do {
            code = CodeUtil.generateCode(product.getProductCategory());
            if (!productRepository.findByCode(code).isPresent()) {
                product.setCode(code);
            }
        } while (product.getCode() == null);
        product.setCode(code);

    }
}
