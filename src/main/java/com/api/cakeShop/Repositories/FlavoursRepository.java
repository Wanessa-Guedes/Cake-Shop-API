package com.api.cakeShop.Repositories;

import com.api.cakeShop.Models.Flavours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlavoursRepository extends JpaRepository<Flavours, Long> {

    Flavours findByName(String name);

    Flavours findById(long id);
}
