package com.workintech.plant.dao;

import com.workintech.plant.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {

    @Query("SELECT f FROM Fruit f ORDER BY f.price DESC")
    List<Fruit> getByPriceDesc();

    @Query("SELECT f FROM Fruit f ORDER BY f.price ASC")
    List<Fruit> getByPriceAsc();

    @Query(value = "SELECT f FROM Fruit f WHERE f.name ILIKE %:name%")
    List<Fruit> searchByName(String name);
}
