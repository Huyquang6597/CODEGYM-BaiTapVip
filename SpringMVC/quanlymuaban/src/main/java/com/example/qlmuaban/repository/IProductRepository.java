package com.example.qlmuaban.repository;

import com.example.qlmuaban.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {

    //tìm ra các product còn trong kho > 300
    @Query(value = "select * from Product where quantity > 300", nativeQuery = true)
    Page<Product> findAllByQuantityGreaterThan300(Pageable pageable);

    //Tìm product theo tên
    List<Product> findAllByNameContaining(String name);

    //Sắp xếp giá tăng dần , giảm dần
    List<Product> findAllByOrderByPriceDesc();


}
