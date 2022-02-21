package com.example.demo.example.model.datadase;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="animal")
public class Animal {


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false)
  private Integer id;

  private String grp;
  private String kind;
  private Integer age;
  private String name;

  @Version
  private Integer version;
}
