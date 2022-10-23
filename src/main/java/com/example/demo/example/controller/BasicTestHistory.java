package com.example.demo.example.controller;

import com.example.demo.example.model.datadase.Animal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.*;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.*;

// 公式: https://docs.oracle.com/javase/jp/8/docs/api/java/util/Objects.html

@Controller
public class BasicTestHistory {

  public static final String DEFAULT_STATUS = "Unknown";

  /**
   * GET
   * @param name
   * @param model
   * @return
   */
  @GetMapping("/basicTestHistory/1")
  public String basicTestHistory(@RequestParam(value = "name", defaultValue = "?") String name, Model model) {

    // ===== Optional
    this.test_1_1();

    // ===== Object.compare
    this.test_1_2();

    // -----
    model.addAttribute("result", "..");
    return "basicTestHistory-1";
  }

  /**
   * Objects.compare
   *
   * サンプルの他に、
   *  nullを最小値、最大値にする、Comparator#nullsFirst、Comparator#nullsLast
   *
   */
  private void test_1_2() {
    Employee emp1 = new Employee(100L, "rubytomato");
    Employee emp2 = new Employee(200L, "garnetpepper");
    System.out.println("comparing1: " + Objects.compare(emp1, emp2, Comparator.comparing(Employee::getId)));
    System.out.println("comparing2: " + Objects.compare(emp1, emp1, Comparator.comparing(Employee::getId)));
    System.out.println("comparing3: " + Objects.compare(emp2, emp1, Comparator.comparing(Employee::getId)));
  }

  /**
   * Optionalテスト
   * 参考: https://qiita.com/rubytomato@github/items/92ac7944c830e54aa03d
   *       https://www.fenet.jp/java/column/java_tips/6162/
   * nullチェック_1: optional基本
   */
  private void test_1_1() {
    String result = null;

    // optional作成
    Optional<String> opt1 =  randomOptional_1();

    // nullではない時のみ実行
    opt1.ifPresent(res -> System.out.println("nullではない"));

    // orElse と orElseGet の違い => https://qiita.com/nobi_tum/items/145966ebe251d0ac5bc3
    result = opt1.orElseGet(() -> {
      System.out.println("nullなのでdefault値を設定");
      return "nullなのでdefault値を設定";
    });

    System.out.println(result);
  }

  /**
   * optionalテスト ここはgetのようなイメージ
   * @return
   */
  private Optional<String> randomOptional_1() {
    Optional<String> optional = Optional.empty();
    String res = null;
    if (new Random().nextBoolean()) {
      res = "xxx";
    }
    // ここで、nullの場合のデフォルト値を入れてもいい
    // return optional.orElse(DEFAULT_STATUS);
    return Optional.ofNullable(res);
  }

  @Getter
  @Setter
  @AllArgsConstructor
  class Employee {

    private Long id;
    private String name;

//    public Employee(Long id, String name) {
//      this.id = id;
//      this.name = name;
//    }

    @Override
    public String toString() {
      return "Employee{" +
          "id=" + id +
          ", name='" + name + '\'' +
          '}';
    }

    // getter/setterは省略
  }

}
