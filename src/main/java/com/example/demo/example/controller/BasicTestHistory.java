package com.example.demo.example.controller;

import com.example.demo.example.model.datadase.Animal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.*;

@Controller
public class BasicTestHistory {

  public static final String DEFAULT_STATUS = "Unknown";

  /**
   * Optionalテスト
   * 参考: https://qiita.com/rubytomato@github/items/92ac7944c830e54aa03d
   *
   * @param name
   * @param model
   * @return
   */
  @GetMapping("/basicTestHistory/1")
  public String basicTestHistory(@RequestParam(value = "name", defaultValue = "?") String name, Model model) {

    String result = null;

    // optional基本. ==========
    Optional<String> opt1 =  randomOptional_1();

    // nullではない時のみ実行
    opt1.ifPresent(res -> System.out.println("nullではない"));

    //
    // orElse と orElseGet の違いは以下
    // https://qiita.com/nobi_tum/items/145966ebe251d0ac5bc3
    //
    result = opt1.orElseGet(() -> {
      System.out.println("nullなのでdefault値を設定");
      return "nullなのでdefault値を設定";
    });


    model.addAttribute("result", result);
    return "basicTestHistory-1";
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



}



