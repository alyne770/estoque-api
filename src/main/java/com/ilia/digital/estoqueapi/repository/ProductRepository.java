package com.ilia.digital.estoqueapi.repository;

import com.ilia.digital.estoqueapi.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository< Product, Long> {
    @Query(value = " SELECT p FROM Product p " +
            " WHERE LOWER (p.name ) LIKE %:searchTerm% " +
            " OR LOWER (p.code) LIKE %:searchTerm% " )
    Page<Product> findAByNameOrCode(Pageable pageable, String searchTerm);
}
