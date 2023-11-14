package com.finalsem.projectsem4.service;

import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.OrderDetailsDTO;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
public interface OrderDetailsService {

    ResponseBuilder<List<OrderDetailsDTO>> getAllOrderDetails();
    ResponseBuilder<OrderDetailsDTO> addOrderDetails(OrderDetailsDTO orderDetailsDTO);

    ResponseBuilder<OrderDetailsDTO> updateOrderDetails(Long id, OrderDetailsDTO orderDetailsDTO);

    ResponseBuilder deleteOrderDetails(Long id);

    ResponseBuilder<List<OrderDetailsDTO>> getOrderDetailsByOrderId(Long id);

    ResponseBuilder<List<OrderDetailsDTO>> getOrderDetailsByProductId(Long id);

    ResponseBuilder<OrderDetailsDTO> getOrderDetailsById(Long id);

}
