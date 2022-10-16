package com.example.demo.example.controller;

import com.example.demo.example.model.response.AnimalGetAsIDJson;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAnimalController {

  @GetMapping("animal/{id}")
  public AnimalGetAsIDJson idolDetail(
      @PathVariable("id") String id,
      @RequestParam(value = "one-time-token", defaultValue = "?") String oneTimeToken,
      Model model
  ) {

    // json返却例
    return new AnimalGetAsIDJson(
        0,
        "null",
        "null",
        0,
        "null");
  }
}
