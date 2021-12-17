package com.example.demo.example.controller;

import com.example.demo.example.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

@Controller
public class HelloController {

  @Inject
  HelloService test001;

  @CrossOrigin
  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "?") String name, Model model) {

    model.addAttribute("message", "Hello Thymeleaf");
    model.addAttribute("name", name);

    test001.countUp();
    model.addAttribute("str1", test001.test());

    return "hello";
  }

}
