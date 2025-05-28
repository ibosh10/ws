package org.perfume.mapper;

import lombok.RequiredArgsConstructor;
import org.perfume.domain.entity.CartItem;
import org.perfume.model.dto.response.CartItemResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
public class CartItemMapper implements EntityMapper<CartItem, CartItemResponse> {

    private final PerfumeMapper perfumeMapper;

    @Override
    public CartItemResponse toDto(CartItem entity) {
        if (entity == null) {
            return null;
        }

        return new CartItemResponse(
                entity.getId(),
                perfumeMapper.toDto(entity.getPerfume()),
                entity.getQuantity(),
                entity.getPerfume().getDiscountedPrice().multiply(BigDecimal.valueOf(entity.getQuantity()))
        );
    }

    @Override
    public CartItem toEntity(CartItemResponse dto) {
        if (dto == null) {
            return null;
        }

        CartItem cartItem = new CartItem();
        cartItem.setId(dto.getId());
        cartItem.setQuantity(dto.getQuantity());
        return cartItem;
    }
}