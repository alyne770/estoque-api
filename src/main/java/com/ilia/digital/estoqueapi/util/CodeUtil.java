package com.ilia.digital.estoqueapi.util;

import com.ilia.digital.estoqueapi.domain.ProductCategory;


import java.text.DecimalFormat;
import java.util.Random;

public  final  class CodeUtil {
    private CodeUtil(){}
    private static final Random GENERATOR = new Random();

    public static String generateCode(ProductCategory productCategory){
        DecimalFormat format = new DecimalFormat(productCategory.getCode()+"-000000");
        return  format.format(GENERATOR.nextInt(1000000));
    }



}
