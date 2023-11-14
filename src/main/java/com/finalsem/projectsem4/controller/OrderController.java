package com.finalsem.projectsem4.controller;

import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.OrdersDTO;
import com.finalsem.projectsem4.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/orders")
public class OrderController{

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/all")
    ResponseEntity<?> getAllOrders() {
        ResponseBuilder<List<OrdersDTO>> resp = orderService.getAllOrder();
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    ResponseEntity<?> getOrderById(@PathVariable Long id) {
        ResponseBuilder<OrdersDTO> resp = orderService.getOrderById(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/get/user/{id}")
    ResponseEntity<?> getOrderByUserId(@PathVariable Long id) {
        ResponseBuilder<List<OrdersDTO>> resp = orderService.getOrderByUserId(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<?> addOrder(@RequestBody OrdersDTO ordersDTO) {
        ResponseBuilder<OrdersDTO> resp = orderService.addOrder(ordersDTO);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> updateOrder(@PathVariable Long id, @RequestBody OrdersDTO ordersDTO) {
        ResponseBuilder<OrdersDTO> resp = orderService.updateOrder(id, ordersDTO);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        ResponseBuilder<?> resp = orderService.deleteOrder(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
