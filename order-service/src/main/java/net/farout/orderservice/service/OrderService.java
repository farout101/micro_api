package net.farout.orderservice.service;

import lombok.RequiredArgsConstructor;
import net.farout.orderservice.dto.OrderLineItemDto;
import net.farout.orderservice.dto.OrderRequest;
import net.farout.orderservice.model.Order;
import net.farout.orderservice.model.OrderLineItem;
import net.farout.orderservice.repository.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepo orderRepo;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItem> orderLineItems = orderRequest.getOrderLineItemDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemList(orderLineItems);

        orderRepo.save(order);
    }

    private OrderLineItem mapToDto(OrderLineItemDto dto) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setSkuCode(dto.getSkuCode());
        orderLineItem.setPrice(dto.getPrice());
        orderLineItem.setQuantity(dto.getQuantity());
        return orderLineItem;
    }
}
