package net.cyberer.sample.generics;

import java.util.List;

public class Generics {
  public void addHeadElementToTail(List<?> list) {
    addHeadElementToTailHelper(list);
  }
  private <T> void addHeadElementToTailHelper(List<T> list) {
    list.add(list.get(0));
  }

  public static <T> void copy(List<T> dst, List<T> src) {
    dst.addAll(src);
  }

  private static void test() {
    List<Number> dst;
    List<Integer> src;
//    copy(dst, src);
  }
}