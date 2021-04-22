package net.cyberer.sample.order;

class ConditionalOperatorPrecedence {
  public static void main(String[] args) {
    for (int i = 0; i < 8; i++) {
      boolean a = (i & 1) != 0;
      boolean b = (i & 2) != 0;
      boolean c = (i & 4) != 0;
      System.out.println(
          a + " || " + b + " && " + c + " -> " + (expression("a", a) || expression("b", b) && expression("c", c)));
      System.out.println();
    }
  }

  public static boolean expression(String msg, boolean value) {
    System.out.println(msg);
    return value;
  }
}