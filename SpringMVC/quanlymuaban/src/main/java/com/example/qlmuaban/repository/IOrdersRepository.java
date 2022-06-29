package com.example.qlmuaban.repository;

import com.example.qlmuaban.model.OrderDetail;
import com.example.qlmuaban.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrdersRepository extends JpaRepository<Orders , Long> {
    @Query(value = "from OrderDetail where orderId.id = :id")
    Iterable<OrderDetail> findDetailByOrderId(@Param("id") Long id);

    //Tìm các order trong 1 khoảng thời gian
    List<Orders> findAllByCreateAtBetween(LocalDateTime from , LocalDateTime to);

    @Query(value = "select p.id, p.name, sum(od.quantity)\n" +
            "from product p\n" +
            "join order_detail od on p.id = od.product_id\n" +
            "join orders o on o.id = od.order_id\n" +
            "where o.create_at between :dateFrom and :dateTo\n" +
            "group by p.id;", nativeQuery = true)
    Iterable<Object[]> reportByCreateTime(@Param("dateFrom") LocalDate dateFrom, @Param("dateTo") LocalDate dateTo);
}
