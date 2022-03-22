package com.ilia.digital.estoqueapi.product;

import com.ilia.digital.estoqueapi.domain.Product;
import com.ilia.digital.estoqueapi.domain.ProductCategory;
import com.ilia.digital.estoqueapi.domain.ProductStock;
import com.ilia.digital.estoqueapi.dto.product.CreateProductDto;
import com.ilia.digital.estoqueapi.dto.product.UpdateProductDto;


public final class MockUtil {

    public static Product getProductWithId(){
        Product product = new Product();
        product.setName("Name of Product");
        product.setCode("HB-000000");
        product.setDescription("Description");
        product.setPrice(0.0f);
        product.setId(1L);
        product.setProductCategory(ProductCategory.HOBBY);
        product.setProductStock(new ProductStock(1L, product,null,50));
        return product;
    }



    public static Product getProductWithOutId(){
        Product product = new Product();
        product.setName("Name of Product");
        product.setCode("HB-000000");
        product.setDescription("Description");
        product.setPrice(0.0f);
        product.setProductCategory(ProductCategory.HOBBY);
        product.setProductStock(new ProductStock(1L, product,null,50));

        return product;
    }

    public static CreateProductDto getCreateProductDto(){
        CreateProductDto product = new CreateProductDto();
        product.setName("Name of Product");
        product.setDescription("Description");
        product.setPrice(0.0f);
        product.setProductCategory(ProductCategory.HOBBY);
        product.setProductStockQuantity(50);
        return product;
    }



    public static UpdateProductDto getUpdateProductDto(){
        UpdateProductDto product = new UpdateProductDto();
        product.setName("Name of Product 2");
        product.setDescription("Description 2");
        product.setPrice(22.0f);
        product.setId(2L);
        product.setProductCategory(ProductCategory.DOMESTIC);

        return product;
    }

    public static Product getProductWithIdWithChanges(){
        Product product = new Product();
        product.setName("Name of Product 2");
        product.setDescription("Description 2");
        product.setPrice(22.0f);
        product.setId(2L);
        product.setCode("HB-000000");
        product.setProductCategory(ProductCategory.DOMESTIC);
        product.setProductStock(new ProductStock(1L, product,null,50));
        return product;
    }
}
