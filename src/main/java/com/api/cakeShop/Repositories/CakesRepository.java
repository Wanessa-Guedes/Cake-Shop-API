package com.api.cakeShop.Repositories;

import com.api.cakeShop.Models.Cakes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CakesRepository extends JpaRepository<Cakes, Long> {

    Cakes findByName(String name);
}
