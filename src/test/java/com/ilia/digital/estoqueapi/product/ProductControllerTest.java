package com.ilia.digital.estoqueapi.product;

import com.ilia.digital.estoqueapi.controller.ProductController;
import com.ilia.digital.estoqueapi.domain.Product;
import com.ilia.digital.estoqueapi.dto.product.CreateProductDto;
import com.ilia.digital.estoqueapi.dto.product.UpdateProductDto;
import com.ilia.digital.estoqueapi.service.product.ProductService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;


@ExtendWith(SpringExtension.class)
class ProductControllerTest {
    @InjectMocks
    ProductController productController;
    @Mock
    ProductService productService;


    @Test
     void search_listCannotBeNUllOrEmpty() {
        BDDMockito.when(productService.findAByNameOrCode(ArgumentMatchers.any(Pageable.class),
                        ArgumentMatchers.any(String.class))).thenReturn(
                                new PageImpl<>(List.of(MockUtil.getProductWithId())));

        Page<Product> page = productController.search(null,null,null,null,"");

        Assertions.assertThat(page).isNotNull();
        Assertions.assertThat(page.toList()).isNotEmpty().hasSize(1);
        Assertions.assertThat(page.toList().get(0)).isEqualTo(MockUtil.getProductWithId());
    }

    @Test
     void create_productCannotBeNullOrGetChanges() {


        BDDMockito.when(productService.create(ArgumentMatchers.any(CreateProductDto.class))).thenReturn(MockUtil.getProductWithId());

        Product product = productController.create(new CreateProductDto()).getBody();

        Assertions.assertThat(product).isNotNull().isEqualTo(MockUtil.getProductWithId());


    }

    @Test
     void replace_productCannotBeNullOrGetChanges() {
        Product substituteProduct = MockUtil.getProductWithId();
        substituteProduct.setName("Name of Product 2");
        substituteProduct.setCode("HB-110000");

        BDDMockito.when(productService.replace(ArgumentMatchers.any(UpdateProductDto.class))).thenReturn(substituteProduct);

        Product product = productController.replace(new UpdateProductDto()).getBody();

        Assertions.assertThat(product).isNotNull().isEqualTo(substituteProduct);
    }
}