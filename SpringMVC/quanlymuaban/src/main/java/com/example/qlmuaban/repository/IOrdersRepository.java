package com.example.qlmuaban.repository;

import com.example.qlmuaban.model.OrderDetail;
import com.example.qlmuaban.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface IOrdersRepository extends JpaRepository<Orders , Long> {
    @Query(value = "from OrderDetail where orderId.id = :id")
    Iterable<OrderDetail> findDetailByOrderId(@Param("id") Long id);
}
