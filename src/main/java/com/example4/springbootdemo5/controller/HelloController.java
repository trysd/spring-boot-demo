package com.example4.springbootdemo5.controller;

import com.example4.springbootdemo5.Mapper.city.CityMapper;
import com.example4.springbootdemo5.entity.city.City;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {

  @Autowired
  private CityMapper cityMapper;

  @Autowired
  private SqlSession sqlSession;

  @RequestMapping("/")
  public String home() {
    City city1 = cityMapper.findByState("CA");
    return city1.toString();
  }

  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "XWorld") String name, Model model) {
    City city1 = cityMapper.findByState("CA");
    model.addAttribute("message", "Hello Thymeleaf!!");
    model.addAttribute("name",name + " .. " + city1);
    return "hello";
  }
}

