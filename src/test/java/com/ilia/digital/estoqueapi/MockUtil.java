package com.ilia.digital.estoqueapi;

import com.ilia.digital.estoqueapi.domain.Product;
import com.ilia.digital.estoqueapi.domain.ProductCategory;


public final class MockUtil {

    public static Product getProductWithId(){
        Product product = new Product();
        product.setName("Name of Product");
        product.setCode("HB-000000");
        product.setDescription("Description");
        product.setPrice(0.0f);
        product.setId(1L);
        product.setProductCategory(ProductCategory.HOBBY);

        return product;
    }



    public static Product getProductWithOutId(){
        Product product = new Product();
        product.setName("Name of Product");
        product.setCode("HB-000000");
        product.setDescription("Description");
        product.setPrice(0.0f);
        product.setProductCategory(ProductCategory.HOBBY);


        return product;
    }




}
