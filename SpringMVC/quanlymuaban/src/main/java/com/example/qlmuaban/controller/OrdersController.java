package com.example.qlmuaban.controller;

import com.example.qlmuaban.model.OrderDetail;
import com.example.qlmuaban.model.Orders;
import com.example.qlmuaban.model.Product;
import com.example.qlmuaban.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;

    @GetMapping
    public ResponseEntity<Iterable<Orders>> findAllOrders(){
        List<Orders> orders = (List<Orders>) ordersService.findAll();
        if(orders.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(orders,HttpStatus.OK);

    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Orders> findOrdersById(@PathVariable Long id) {
//        Optional<Orders> ordersOptional = ordersService.findById(id);
//        if (!ordersOptional.isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(ordersOptional.get(), HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<Orders> saveOrders(@RequestBody Orders orders) {
        return new ResponseEntity<>(ordersService.save(orders), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Orders> updateOrders(@PathVariable Long id, @RequestBody Orders orders) {
        Optional<Orders> ordersOptional = ordersService.findById(id);
        if (!ordersOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orders.setId(ordersOptional.get().getId());
        return new ResponseEntity<>(ordersService.save(orders), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Orders> deleteOrders(@PathVariable Long id) {
        Optional<Orders> ordersOptional = ordersService.findById(id);
        if (!ordersOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ordersService.remove(id);
        return new ResponseEntity<>(ordersOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Iterable<OrderDetail>> findDetail(@PathVariable Long id) {
        return new ResponseEntity<>(ordersService.findDetail(id), HttpStatus.OK);
    }

    @GetMapping("/find-all-creat-at-between")
    public ResponseEntity findAllByCreatAtBetween(@RequestParam String from ,@RequestParam String to){
     return new ResponseEntity(ordersService.findAllByCreateAtBetween(LocalDateTime.parse(from),LocalDateTime.parse(to)), HttpStatus.OK);
    }
}
