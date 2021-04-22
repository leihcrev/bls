package net.cyberer.sample.proxy;

import lombok.Data;

@Data
public class TestBean {

  public static void main(final String[] args) {
    TestBean bean = LoggingPropertyAccessProxyCreator.create(new TestBean());
    bean.setA(100);
    bean.setB(200);
    bean.setC(300);
    System.out.println(bean.getA());
    System.out.println(bean.getB());
    System.out.println(bean.getC());
  }

  private int a;
  private int b;
  private int c;
}
