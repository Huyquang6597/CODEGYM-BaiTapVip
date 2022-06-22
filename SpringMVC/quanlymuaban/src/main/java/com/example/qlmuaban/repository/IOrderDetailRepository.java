package com.example.qlmuaban.repository;

import com.example.qlmuaban.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail , Long> {
}
