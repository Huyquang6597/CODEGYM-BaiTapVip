package com.example.qlmuaban.repository;

import com.example.qlmuaban.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "from Product where quantity > 300")
    Iterable<Product> findProductByQuantity(@Param("quantity") int quantity);

}
