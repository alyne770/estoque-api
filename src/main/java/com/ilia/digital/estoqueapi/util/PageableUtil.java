package com.ilia.digital.estoqueapi.util;

import com.ilia.digital.estoqueapi.constants.DefaultValues;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public  interface PageableUtil {


    static Pageable configuringPageable(Integer page, Integer size, String sort, String orderBy ){

        return PageRequest.of(page == null ? DefaultValues.PAGE: page,
                size == null ? DefaultValues.QUANTITY_ELEMENTS: size,
                sort == null || sort.isEmpty()? Sort.Direction.valueOf(DefaultValues.SORT): Sort.Direction.valueOf(sort.toUpperCase()),
                orderBy == null || orderBy.isEmpty()  ? DefaultValues.ORDER_BY: orderBy );
    }

}
