package com.javainuse.swaggertest.dao;


import com.javainuse.swaggertest.entity.Dog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DogsRepository extends CrudRepository<Dog, Long> {

    void deleteById(long id);

    Optional<Dog> findById(long id);
}