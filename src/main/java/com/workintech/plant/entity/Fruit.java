package com.workintech.plant.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "fruit", schema = "public")

public class Fruit extends Plant{
    @Enumerated(EnumType.STRING)
    @Column(name = "fruit_type")
    private FruitType fruitType;
}
