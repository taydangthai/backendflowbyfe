package com.finalsem.projectsem4.service;

import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.OrdersDTO;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
public interface OrderService {

    ResponseBuilder<List<OrdersDTO>>  getAllOrder();

    ResponseBuilder<OrdersDTO>  addOrder(OrdersDTO ordersDTO);

    ResponseBuilder<OrdersDTO>  updateOrder(Long id,OrdersDTO ordersDTO);

    ResponseBuilder<?>  deleteOrder(Long id);

    ResponseBuilder<OrdersDTO>  getOrderById(Long id);

    ResponseBuilder<List<OrdersDTO>>  getOrderByUserId(Long id);
}
