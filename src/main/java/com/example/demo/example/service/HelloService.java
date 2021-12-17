package com.example.demo.example.service;

import org.springframework.stereotype.Component;

@Component
public class HelloService {

  private Integer count = 0;

  public void countUp() {
    this.count++;
  }

  public String test() {
    return "count test001: " + this.count;
  }
}
