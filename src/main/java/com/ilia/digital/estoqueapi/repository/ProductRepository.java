package com.ilia.digital.estoqueapi.repository;

import com.ilia.digital.estoqueapi.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository< Product, Long> {
}
