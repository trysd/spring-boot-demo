package com.example.demo.example.service;

import org.springframework.stereotype.Component;

@Component
public class HelloService {

  private Integer count = 0;

  public void countUp() {
    this.count++;
  }

  public String test() {
    return "count test001:: " + this.count;
  }
}

// 多分 outer, Inner のテスト
class Outer {
  private int outerVal;

  public class Inner {
    public int innerVal;
    private void method() {
      // OK
      this.innerVal = Outer.this.outerVal;
    }
  }

  private void method() {
    // NG
    // this.outerVal = innerVal;
    Outer.Inner inner = (new Outer()).new Inner();
  }
}