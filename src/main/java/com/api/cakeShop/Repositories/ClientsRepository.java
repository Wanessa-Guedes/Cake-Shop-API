package com.api.cakeShop.Repositories;

import com.api.cakeShop.Models.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients, Long> {
}
