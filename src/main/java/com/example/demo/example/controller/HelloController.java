package com.example.demo.example.controller;

import com.example.demo.example.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

@Controller
public class HelloController {

  @Inject
  HelloService test001;

//  // validation result
//  private static class Result {
//    Boolean response;
//    String message;
//    Result(Boolean res, String mess) {
//      this.response = res;
//      this.message = mess;
//    }
//  }

  @CrossOrigin
  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "?") String name, Model model) {

    model.addAttribute("message", "Hello Thymeleaf");
    model.addAttribute("name", name);

    test001.countUp();
    model.addAttribute("str1", test001.test());

//    this.complexity(); // for test

    return "hello";
  }
//
//  /**
//   * 複雑度測定検証
//   */
//  private void complexity() {
//    Random rnd = new Random();
//    int num = rnd.nextInt() + 10;
//    System.out.println(num);
//
//    for (Function<Integer, Result> validate : this.validateList) {
//      Result res = validate.apply(num);
//      if (res.response) {
//        System.out.println(res.message);
//        return;
//      }
//    }
//
//    if (num == 1) {
//      System.out.println(num);
//    } else if (num == 2) {
//      System.out.println(num);
//    } else if (num == 3) {
//      System.out.println(num);
//    } else if (num == 4) {
//      System.out.println(num);
////    } else if (num == 5) {
////      System.out.println(num);
////    } else if (num == 6) {
////      System.out.println(num);
////    } else if (num == 7) {
////      System.out.println(num);
////    } else if (num == 8) {
////      System.out.println(num);
////    } else if (num == 9) {
////      System.out.println(num);
////    } else if (num == 10) {
////      System.out.println(num);
////    } else if (num == 11) {
////      System.out.println(num);
////    } else if (num == 12) {
////      System.out.println(num);
//    }
//
//    switch (num) {
//      case (13) :{
//        System.out.println("13");
//        break;
//      }
//      case (14) :{
//        System.out.println("14");
//        break;
//      }
//      case (15) :{
//        System.out.println("15");
//        break;
//      }
//    }
//
//    String one = num == 16 ? "16" : "not 16";
//    System.out.println(one);
//  }
//
//  private final List<Function<Integer, Result>> validateList
//      = new ArrayList<>(Arrays.asList(
//      (n) -> new Result(n == 0, "is Zero"),
//      (n) -> new Result(
//          n == 1
//              || n == 3
//              || n == 4
//              || n == 5
//              || n == 6
//              || n == 7
//              || n == 8
//              || n == 9
//              || n == 10
//              || n == 11
//              || n == 12
//              || n == 13
//              || n == 14
//              || n == 15
//          , "is One||Two||Three .. "),
//      (n) -> new Result(n == 2, "is Two"),
//      (n) -> {
//        Boolean flag = null;
//        String mess = null;
//
//        Random rnd = new Random();
//        int num = rnd.nextInt() + 10;
//        if (num == 0) {
//          mess = "is 0";
//        } else if (num == 1) {
//          mess = "is 1";
//        } else if (num == 2) {
//          mess = "is 1";
//        } else if (num == 3) {
//          mess = "is 1";
//        } else if (num == 4) {
//          mess = "is 1";
//        } else if (num == 5) {
//          mess = "is 1";
//        } else if (num == 6) {
//          mess = "is 1";
//        } else if (num == 7) {
//          mess = "is 1";
//        } else if (num == 8) {
//          mess = "is 1";
//        } else if (num == 9) {
//          mess = "is 1";
//        } else if (num == 10) {
//          mess = "is 1";
//        } else if (num == 11) {
//          mess = "is 1";
//        } else if (num == 12) {
//          mess = "is 1";
//        } else if (num == 13) {
//          mess = "is 1";
//        } else if (num == 14) {
//          mess = "is 1";
//        } else if (num == 15) {
//          mess = "is 1";
//        }
//        return new Result(flag, mess);
//      }
//  ));

}
