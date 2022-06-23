package com.example.qlmuaban.controller;


import com.example.qlmuaban.model.OrderDetail;
import com.example.qlmuaban.model.Orders;
import com.example.qlmuaban.model.Product;
import com.example.qlmuaban.service.impl.OrderDetailService;
import com.example.qlmuaban.service.impl.OrdersService;
import com.example.qlmuaban.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/orders/{id}")
public class OrderDetailController {

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    OrdersService ordersService;

    @Autowired
    ProductService productService;

//    @GetMapping
//    public ResponseEntity findAll(){
//        return new ResponseEntity<>(orderDetailService.findAll(), HttpStatus.OK);
//    }


    @PostMapping
    public ResponseEntity<OrderDetail> create(@PathVariable Long id, @RequestBody OrderDetail orderDetail) {

        orderDetail.setOrderId(ordersService.findById(id).get());//lấy id của bảng order rồi xét sang orderdetail
        orderDetailService.save(orderDetail); //lưu lại id order detail
        Product product = orderDetail.getProductId(); //lấy sản phẩm từ order detail
        product.setQuantity(product.getQuantity() - orderDetail.getQuantity()); //set lại số lượng cho product từ bảng order detail
        productService.save(product); //lưu số lượng còn lại trong product
        Orders orders = orderDetail.getOrderId(); // set
        double total = orders.getTotalPrice() + product.getPrice() * orderDetail.getQuantity();
        orders.setTotalPrice(total);
        ordersService.save(orders);
        return new ResponseEntity<>(orderDetail, HttpStatus.CREATED);
    }

    @DeleteMapping("/details/{idd}")
    public ResponseEntity<OrderDetail> delete(@PathVariable Long idd) {
        OrderDetail orderDetail = orderDetailService.findById(idd).get();
        orderDetailService.remove(idd);
        Product product = orderDetail.getProductId();
        product.setQuantity(product.getQuantity() + orderDetail.getQuantity());
        productService.save(product);
        Orders orders = orderDetail.getOrderId();
        double total = orders.getTotalPrice() - product.getPrice() * orderDetail.getQuantity();
        orders.setTotalPrice(total);
        ordersService.save(orders);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/details/{idd}")
    public ResponseEntity<OrderDetail> update(@PathVariable Long id, @PathVariable Long idd, @RequestBody OrderDetail orderDetail) {
        Optional<OrderDetail> oldOrderDetail = orderDetailService.findById(idd);
        if (!oldOrderDetail.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orderDetail.setId(oldOrderDetail.get().getId());
        orderDetail.setOrderId(oldOrderDetail.get().getOrderId());

        Product oldProduct = oldOrderDetail.get().getProductId();
        oldProduct.setQuantity(oldProduct.getQuantity() + oldOrderDetail.get().getQuantity());
        double oldMoney = oldProduct.getPrice() * oldOrderDetail.get().getQuantity();
        productService.save(oldProduct);
        orderDetailService.save(orderDetail);
        OrderDetail newOrderDetail = orderDetailService.findById(orderDetail.getId()).get();
        Product newProduct = newOrderDetail.getProductId();
        newProduct.setQuantity(newProduct.getQuantity() - newOrderDetail.getQuantity());
        productService.save(newProduct);

        Orders newOrder = newOrderDetail.getOrderId();
        newOrder.setTotalPrice(newOrder.getTotalPrice() - oldMoney + newOrderDetail.getQuantity() * newProduct.getPrice());
        ordersService.save(newOrder);
        return new ResponseEntity<>(orderDetailService.findById(orderDetail.getId()).get(), HttpStatus.OK);
    }
}
