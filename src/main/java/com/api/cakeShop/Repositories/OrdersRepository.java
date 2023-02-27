package com.api.cakeShop.Repositories;

import com.api.cakeShop.Models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
