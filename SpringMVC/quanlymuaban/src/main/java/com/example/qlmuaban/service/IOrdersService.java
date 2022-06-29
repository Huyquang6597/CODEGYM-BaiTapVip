package com.example.qlmuaban.service;

import com.example.qlmuaban.model.OrderDetail;
import com.example.qlmuaban.model.Orders;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrdersService extends IGeneralService<Orders>{
    Iterable<OrderDetail> findDetail(Long id);

    List<Orders> findAllByCreateAtBetween(LocalDateTime from , LocalDateTime to);


}
