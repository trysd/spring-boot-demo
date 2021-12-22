package com.example.demo.example.model.datadase;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="animal")
public class Animal {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  String grp;
  String kind;
  Integer age;
  String name;

  @Version
  Integer version;
}
