package com.api.cakeShop.Repositories;

import com.api.cakeShop.Models.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long> {
    Clients findById(long id);
}
