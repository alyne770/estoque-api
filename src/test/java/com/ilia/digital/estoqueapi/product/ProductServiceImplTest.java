package com.ilia.digital.estoqueapi.product;

import com.ilia.digital.estoqueapi.MockUtil;

import com.ilia.digital.estoqueapi.domain.Product;

import com.ilia.digital.estoqueapi.exception.BadRequestException;
import com.ilia.digital.estoqueapi.repository.ProductRepository;
import com.ilia.digital.estoqueapi.service.product.impl.ProductServiceImpl;

import lombok.extern.slf4j.Slf4j;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;



import java.util.Optional;


@ExtendWith(SpringExtension.class)
@Slf4j
class ProductServiceImplTest {
    @InjectMocks
    ProductServiceImpl productServiceImpl;
    @Mock
    ProductRepository productRepository;

    @Test
    void findById_cannotReturnNullOrDifferentProductIfProductExists() {

        BDDMockito.when(productRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(MockUtil
                .getProductWithId()));

        Optional<Product> product = Optional.ofNullable(productServiceImpl.findById(1L));

        Assertions.assertThat(product).isNotEmpty();
        Assertions.assertThat(product.get()).isEqualTo(MockUtil
                .getProductWithId());
    }

    @Test
    void findById_throwBadRequestExceptionIfProductNotExists() {

        BDDMockito.when(productRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.empty());

        Assertions.assertThatThrownBy(() -> productServiceImpl.findById(1L)).isInstanceOf(BadRequestException.class);
    }


    @Test
    void findAByNameOrCode() {
    }

    @Test
    void create() {
    }

    @Test
    void replace() {
    }


}