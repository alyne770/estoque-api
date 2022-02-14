package com.ilia.digital.estoqueapi.converter.jpa;

//Faz com que o TypeChangeProductStock seja mapeado pelo seu atributo value

import com.ilia.digital.estoqueapi.domain.TypeChangeProductStock;

import javax.persistence.AttributeConverter;

@javax.persistence.Converter(autoApply = true)
public class ConverterTypeChangeProductStock implements AttributeConverter<TypeChangeProductStock, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TypeChangeProductStock typeChangeProductStock) {

        return typeChangeProductStock == null ? null : typeChangeProductStock.getValue();
    }

    @Override
    public TypeChangeProductStock convertToEntityAttribute(Integer integer) {

        return TypeChangeProductStock.of(integer);
    }
}
