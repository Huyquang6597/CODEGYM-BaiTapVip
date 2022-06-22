package com.example.qlmuaban.service.impl;

import com.example.qlmuaban.model.OrderDetail;
import com.example.qlmuaban.repository.IOrderDetailRepository;
import com.example.qlmuaban.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    IOrderDetailRepository orderDetailRepository;

    @Override
    public Iterable<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public Optional<OrderDetail> findById(Long id) {
        return orderDetailRepository.findById(id);
    }

    @Override
    public OrderDetail save(OrderDetail orderDetail) {
       return orderDetailRepository.save(orderDetail);
    }

    @Override
    public void remove(Long id) {
        orderDetailRepository.deleteById(id);
    }
}
