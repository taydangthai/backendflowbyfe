package com.finalsem.projectsem4.service.impl;

import com.finalsem.projectsem4.common.DateTimeUtil;
import com.finalsem.projectsem4.common.ResponseBuilder;
import com.finalsem.projectsem4.dto.OrderDetailsDTO;
import com.finalsem.projectsem4.entity.OrderDetails;
import com.finalsem.projectsem4.repository.OrderDetailsRepository;
import com.finalsem.projectsem4.repository.OrderRepository;
import com.finalsem.projectsem4.repository.ProductRepository;
import com.finalsem.projectsem4.service.OrderDetailsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ly Quoc Trong
 */
@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {

    private final ProductRepository productRepository;

    private final OrderRepository orderRepository;
    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsServiceImpl(OrderDetailsRepository orderDetailsRepository, ProductRepository productRepository, OrderRepository orderRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public ResponseBuilder<List<OrderDetailsDTO>> getAllOrderDetails() {
        List<OrderDetails> orderItems = orderDetailsRepository.findAll();
        List<OrderDetailsDTO> orderDetailsDTOS = orderItems.stream().map(orderItem -> {
            OrderDetailsDTO orderDetailsDTO;
            ModelMapper mapper = new ModelMapper();
            orderDetailsDTO = mapper.map(orderItem, OrderDetailsDTO.class);
            orderDetailsDTO.setCreatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, orderItem.getCreatedAt()));
            orderDetailsDTO.setUpdatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, orderItem.getUpdatedAt()));
            return orderDetailsDTO;
        }).collect(java.util.stream.Collectors.toList());
        return new ResponseBuilder<>("00", "success", orderDetailsDTOS);
    }

    @Override
    public ResponseBuilder<OrderDetailsDTO> addOrderDetails(OrderDetailsDTO orderDetailsDTO) {
        try {
            OrderDetails orderDetails = new OrderDetails();
            ModelMapper mapper = new ModelMapper();
            orderDetails = mapper.map(orderDetailsDTO, OrderDetails.class);
            orderDetails.setProducts(productRepository.getReferenceById(orderDetailsDTO.getProductId()));
            orderDetails.setOrders(orderRepository.getReferenceById(orderDetailsDTO.getOrderId()));
            orderDetailsRepository.save(orderDetails);
            return new ResponseBuilder<>("00", "success");
        } catch (Exception e) {
            return new ResponseBuilder<>("01", e.toString());
        }
    }

    @Override
    public ResponseBuilder<OrderDetailsDTO> updateOrderDetails(Long id, OrderDetailsDTO orderDetailsDTO) {
        try {
            OrderDetails orderDetails = orderDetailsRepository.getReferenceById(id);
            ModelMapper mapper = new ModelMapper();
            orderDetails = mapper.map(orderDetailsDTO, OrderDetails.class);
            orderDetails.setProducts(productRepository.getReferenceById(orderDetailsDTO.getProductId()));
            orderDetails.setOrders(orderRepository.getReferenceById(orderDetailsDTO.getOrderId()));
            orderDetailsRepository.save(orderDetails);
            return new ResponseBuilder<>("00", "success");
        } catch (Exception e) {
            return new ResponseBuilder<>("01", e.toString());
        }
    }

    @Override
    public ResponseBuilder deleteOrderDetails(Long id) {
        OrderDetails orderDetails = orderDetailsRepository.getReferenceById(id);
        orderDetailsRepository.delete(orderDetails);
        return new ResponseBuilder<>("00", "success");
    }

    @Override
    public ResponseBuilder<List<OrderDetailsDTO>> getOrderDetailsByOrderId(Long id) {
        List<OrderDetails> orderItems = orderDetailsRepository.findAllByOrdersId(id);
        List<OrderDetailsDTO> orderDetailsDTOS = orderItems.stream().map(orderItem -> {
            OrderDetailsDTO orderDetailsDTO;
            ModelMapper mapper = new ModelMapper();
            orderDetailsDTO = mapper.map(orderItem, OrderDetailsDTO.class);
            orderDetailsDTO.setCreatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, orderItem.getCreatedAt()));
            orderDetailsDTO.setUpdatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, orderItem.getUpdatedAt()));
            return orderDetailsDTO;
        }).collect(java.util.stream.Collectors.toList());
        return new ResponseBuilder<>("00", "success", orderDetailsDTOS);
    }

    @Override
    public ResponseBuilder<List<OrderDetailsDTO>> getOrderDetailsByProductId(Long id) {
        List<OrderDetails> orderItems = orderDetailsRepository.findAllByProductsId(id);
        List<OrderDetailsDTO> orderDetailsDTOS = orderItems.stream().map(orderItem -> {
            OrderDetailsDTO orderDetailsDTO;
            ModelMapper mapper = new ModelMapper();
            orderDetailsDTO = mapper.map(orderItem, OrderDetailsDTO.class);
            orderDetailsDTO.setCreatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, orderItem.getCreatedAt()));
            orderDetailsDTO.setUpdatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, orderItem.getUpdatedAt()));
            return orderDetailsDTO;
        }).collect(java.util.stream.Collectors.toList());
        return new ResponseBuilder<>("00", "success", orderDetailsDTOS);
    }

    @Override
    public ResponseBuilder<OrderDetailsDTO> getOrderDetailsById(Long id) {
        OrderDetails orderDetails = orderDetailsRepository.getReferenceById(id);
        OrderDetailsDTO orderDetailsDTO;
        ModelMapper mapper = new ModelMapper();
        orderDetailsDTO = mapper.map(orderDetails, OrderDetailsDTO.class);
        orderDetailsDTO.setCreatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, orderDetails.getCreatedAt()));
        orderDetailsDTO.setUpdatedAt(DateTimeUtil.convertDate2String(DateTimeUtil.ddMMyyyy, orderDetails.getUpdatedAt()));
        return new ResponseBuilder<>("00", "success", orderDetailsDTO);
    }
}
