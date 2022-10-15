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
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Arrays;
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
    animalRepositoryForUpdate.Insert(new Animal(
            null,
            "sss",
            "ssp",
            new Random().nextInt(100),
            "kis",
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

//  @GetMapping("/animal/20220802/{id}")
//  public String animal20220802(@PathVariable("id") Integer id, Model model) {
//    Animal animalData = animalRepositoryForRead.findById(id);
////    animalRepositoryForUpdate.Delete(animalData);
//    System.out.println("test20220802..");
//
//    // https://www.baeldung.com/jpa-criteria-api-in-expressions
//    // 色々: https://qiita.com/opengl-8080/items/6e3e03e4c90cd3d5e211
//    CriteriaBuilder builder = em.getCriteriaBuilder();
//    CriteriaQuery<Animal> query = builder.createQuery(Animal.class);
//    Subquery<Integer> subquery = query.subquery(Integer.class);
//    Predicate sq = subquery.in(new ArrayList<Integer>(Arrays.asList(1, 3, 7)));
//
//    return "x20220802";
//  }

  @GetMapping("/animal")
  public String hello(@RequestParam(value = "name", defaultValue = "?") String name, Model model) {

    // ex1: findById
//    Animal animalData = animalRepositoryForRead.findById(2);

    // ex2 findAll
    List<Animal> animalList = animalRepository.findAll();

    // ex3 findList ..
    List<Animal> animalFilterList = animalRepositoryForRead.findList();
    animalFilterList.stream().forEach(f -> System.out.println(f.getKind()));

    // html
    model.addAttribute("animalList", animalList);
    model.addAttribute("message", "Hello Animal!!");
    model.addAttribute("name", name);

    return "animal";
  }


}
