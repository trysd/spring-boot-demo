package com.example.demo.example.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

// json返却用

@Data
@AllArgsConstructor
public class AnimalGetAsIDJson {
  Integer id;
  String grp;
  String kind;
  Integer age;
  String name;
}
