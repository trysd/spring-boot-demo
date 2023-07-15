package com.example.demo.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test1 {

  public Test1() {
    System.out.println("===== test1");
//    lambda1();
//    lambda2();
//    lambda3();
    localClass();
  }

  // https://qiita.com/sano1202/items/64593e8e981e8d6439d3
  private void localClass() {
    class Local implements Runnable {
      @Override
      public void run() {
        System.out.println("Hello Lambda!");
      }
    }

    Runnable runner = new Local();
    runner.run(); // Hello Lambda!
  }


  private void lambda1() {
    List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
    integerList.stream() // streamの取得
        .filter(i -> i % 2 == 0) // 中間操作
        .forEach(System.out::println); // 終端操作
  }

  private void lambda2() {
    List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
    integerList.stream() // streamの取得
        .sorted((a, b) -> Integer.compare(a, b)) // 中間操作
        .forEach(i -> System.out.println(i)); // 終端操作
  }

  private void lambda3() {
    Function<String, String> toHakata = s -> {
      return s + "とよ。";
    };
    List<String> sss =  Arrays.asList("そぎゃんこつなか").stream().map(toHakata).collect(Collectors.toList());
    System.out.println(sss);

  }


}
