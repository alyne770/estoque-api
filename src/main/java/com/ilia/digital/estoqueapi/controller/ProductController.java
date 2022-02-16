package com.ilia.digital.estoqueapi.controller;

import com.ilia.digital.estoqueapi.service.product.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j
@RestController
@RequestMapping(path = "/product")
public class ProductController {
    ProductService productService;

    @GetMapping
    public void findAll(@RequestParam(value ="page") final Integer page,
                        @RequestParam(value ="size") final Integer size,
                        @RequestParam (value ="sort")final  List<String> sort){

        log.info("ProductServiceImpl.create - start - input  [{},{},{}]",page, size,sort);

    }

}
