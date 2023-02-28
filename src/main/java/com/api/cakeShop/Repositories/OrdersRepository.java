package com.api.cakeShop.Repositories;

import com.api.cakeShop.Models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>, QuerydslPredicateExecutor<Orders> {
    Orders findById(long id);

    List<Orders> findAllByClientsId(long id);
}
