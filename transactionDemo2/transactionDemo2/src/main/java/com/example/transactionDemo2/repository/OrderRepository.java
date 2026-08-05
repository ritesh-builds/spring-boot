package com.example.transactionDemo2.repository;

import com.example.transactionDemo2.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
