package com.example.demo.example.controller;

import com.example.demo.example.model.Animal;
import com.example.demo.example.repository.animal.AnimalRepositoryForRead;
import com.example.demo.example.repository.animal.AnimalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Controller
public class AnimalController {

  @Inject
  AnimalRepository animalRepository;

  @Inject
  AnimalRepositoryForRead animalRepositoryForRead;

  @PersistenceContext
  private EntityManager em;

  @GetMapping("/animal")
  public String hello(@RequestParam(value = "name", defaultValue = "?") String name, Model model) {

    // ex1: findById
    Animal animalData = animalRepositoryForRead.findById(2);

    // ex2 findAll
    List<Animal> animalList = animalRepository.findAll();

    // ex3 findList
    List<Animal> animalFilterList = animalRepositoryForRead.findList();
    animalFilterList.stream().forEach(f -> System.out.println(f.getKind()));

    // html
    model.addAttribute("animalList", animalList);
    model.addAttribute("message", "Hello Animal");
    model.addAttribute("name", name);

    return "animal";
  }
}
