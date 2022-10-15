package com.example.demo.example.controller;

import com.example.demo.example.model.datadase.Animal;
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
public class BasicTestHistory {

  @GetMapping("/basicTestHistory/1")
  public String basicTestHistory(@RequestParam(value = "name", defaultValue = "?") String name, Model model) {




    return "basicTestHistory-1";
  }


}
