package org.perfume.mapper;

import org.perfume.domain.entity.OrderItem;
import org.perfume.model.dto.response.OrderItemResponse;
import org.springframework.stereotype.Component;

@Component
public class OrderItemMapper implements EntityMapper<OrderItem, OrderItemResponse> {

    @Override
    public OrderItemResponse toDto(OrderItem entity) {
        if (entity == null) {
            return null;
        }

        return new OrderItemResponse(
                entity.getId(),
                entity.getProductName(),
                entity.getBrandName(),
                entity.getQuantity(),
                entity.getUnitPrice(),
                entity.getSubtotal()
        );
    }

    @Override
    public OrderItem toEntity(OrderItemResponse dto) {
        if (dto == null) {
            return null;
        }

        OrderItem orderItem = new OrderItem();
        orderItem.setId(dto.getId());
        orderItem.setProductName(dto.getProductName());
        orderItem.setBrandName(dto.getBrandName());
        orderItem.setQuantity(dto.getQuantity());
        orderItem.setUnitPrice(dto.getUnitPrice());
        return orderItem;
    }
}