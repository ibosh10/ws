package org.perfume.domain.repo;

import org.perfume.domain.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartItemDao extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByCartIdAndPerfumeId(Long cartId, Long perfumeId);
}