package com.example.demo.example.repository.animal;

import com.example.demo.example.model.datadase.Animal;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

  List<Animal> findByIdIn(Integer[] ids);


}
