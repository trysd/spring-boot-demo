package com.example.demo.example.controller;

import com.example.demo.example.model.datadase.Animal;
import com.example.demo.example.model.response.AnimalGetAsIDJson;
import com.example.demo.example.repository.animal.AnimalRepositoryForRead;
import com.example.demo.example.repository.animal.AnimalRepository;
import com.example.demo.example.repository.animal.AnimalRepositoryForUpdate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Random;

@Controller
public class AnimalController {

  @Inject
  AnimalRepository animalRepository;

  @Inject
  AnimalRepositoryForRead animalRepositoryForRead;

  @Inject
  AnimalRepositoryForUpdate animalRepositoryForUpdate;

  @PersistenceContext
  private EntityManager em;

  @GetMapping("/animal/insert")
  public String animalInsert(@RequestParam(value = "name", defaultValue = "?") String name, Model model) {

    // http://localhost/animal?name=newAnimal

    animalRepositoryForUpdate.Insert(new Animal(
            null,
            "default-grp",
            "default-kind",
            new Random().nextInt(100),
            name,
            0));

    return "redirect:/animal";
  }

  @GetMapping("/animal/delete")
  public String animalDeleteReady(Model model) {
    // html
    model.addAttribute("message", "Hello Delete Ready");
    model.addAttribute("name", "try /delete/{id}");

    return "animal";
  }

  @GetMapping("/animal/delete/{id}")
  public String animalDeleteById(@PathVariable("id") Integer id, Model model) {
    Animal animalData = animalRepositoryForRead.findById(id);
    animalRepositoryForUpdate.Delete(animalData);
    return "redirect:/animal";
  }

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
    model.addAttribute("message", "Hello Animal!");
    model.addAttribute("name", name);

    return "animal";
  }


}
