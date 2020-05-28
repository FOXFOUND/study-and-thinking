package com.javainuse.swaggertest.service;

import com.javainuse.swaggertest.dao.DogsRepository;
import com.javainuse.swaggertest.entity.Dog;
import com.javainuse.swaggertest.entity.DogDto;
import com.javainuse.swaggertest.exception.DogNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;


@Component
public class DogsService {

    @Autowired
    DogsRepository repository;

    public void add(DogDto dto) {
        repository.save(toEntity(dto));
    }
    public void delete(long id) {
        repository.deleteById(id);
    }
    public List<Dog> getDogs() {
        return (List<Dog>) repository.findAll();
    }
    public Dog getDogById(long id) {
        Optional<Dog> optionalDog = repository.findById(id);
        try {
            return optionalDog.orElseThrow(() -> new DogNotFoundException("Couldn't find a Dog with id: " + id));
        } catch (DogNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    private Dog toEntity(DogDto dto) {
        Dog entity = new Dog();
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        return entity;
    }
}