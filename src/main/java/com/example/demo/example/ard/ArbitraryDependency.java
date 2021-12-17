package com.example.demo.example.ard;

import org.springframework.stereotype.Component;

@Component
public class ArbitraryDependency {

  private Integer count = 0;

  private final String label = "Arbitrary Dependency !";

//  @Bean
  public String toString() {
    return label;
  }

  public String test() {
    this.count++;
    return "is test.." + this.count; }
}
