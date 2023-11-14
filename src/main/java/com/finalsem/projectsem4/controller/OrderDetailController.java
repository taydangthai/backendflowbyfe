package com.finalsem.projectsem4.controller;

import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.OrderDetailsDTO;
import com.finalsem.projectsem4.dto.OrdersDTO;
import com.finalsem.projectsem4.service.OrderDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/order-details")
public class OrderDetailController {
    private final OrderDetailsService orderDetailsService;

    public OrderDetailController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
    }

    @GetMapping("/all")
    ResponseEntity<?> getAllOrders() {
        ResponseBuilder<List<OrderDetailsDTO>> resp = orderDetailsService.getAllOrderDetails();
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/get/order/{id}")
    ResponseEntity<?> getOrderDetailsByOrderId(@PathVariable Long id) {
        ResponseBuilder<List<OrderDetailsDTO>> resp = orderDetailsService.getOrderDetailsByOrderId(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/get/product/{id}")
    ResponseEntity<?> getOrderDetailsByProductId(@PathVariable Long id) {
        ResponseBuilder<List<OrderDetailsDTO>> resp = orderDetailsService.getOrderDetailsByProductId(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("/add")
    ResponseEntity<?> addOrder(@RequestBody OrderDetailsDTO orderDetailsDTO) {
        ResponseBuilder<OrderDetailsDTO> resp = orderDetailsService.addOrderDetails(orderDetailsDTO);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    ResponseEntity<?> updateOrder(@PathVariable Long id, @RequestBody OrderDetailsDTO orderDetailsDTO) {
        ResponseBuilder<OrderDetailsDTO> resp = orderDetailsService.updateOrderDetails(id,orderDetailsDTO);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<?> deleteOrder(@PathVariable Long id) {
        ResponseBuilder resp = orderDetailsService.deleteOrderDetails(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    ResponseEntity<?> getOrderDetailsById(@PathVariable Long id) {
        ResponseBuilder<OrderDetailsDTO> resp = orderDetailsService.getOrderDetailsById(id);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
