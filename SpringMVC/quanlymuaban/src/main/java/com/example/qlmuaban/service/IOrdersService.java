package com.example.qlmuaban.service;

import com.example.qlmuaban.model.OrderDetail;
import com.example.qlmuaban.model.Orders;

public interface IOrdersService extends IGeneralService<Orders>{
    Iterable<OrderDetail> findDetail(Long id);
}
