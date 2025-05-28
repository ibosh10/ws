package org.perfume.domain.repo;

import org.perfume.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
    List<Order> findAllByOrderByCreatedAtDesc();
}