package com.workintech.plant.services;

import com.workintech.plant.dao.VegetableRepository;
import com.workintech.plant.entity.Vegetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService{
    private VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> findAll() {
        return vegetableRepository.findAll();
    }

    @Override
    public List<Vegetable> findAllByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public List<Vegetable> findAllByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name);
    }

    @Override
    public Vegetable find(int id) {
        Optional<Vegetable> foundedVegetable = vegetableRepository.findById(id);
        if (foundedVegetable.isPresent()){
            return foundedVegetable.get();
        }
        return null;
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public void delete(Vegetable vegetable) {
        vegetableRepository.delete(vegetable);
    }
}
