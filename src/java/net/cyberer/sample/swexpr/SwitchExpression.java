package net.cyberer.sample.swexpr;

public class SwitchExpression {
  public static void main(final String[] args) {
    int num = Integer.parseInt(args[0]);

    switch (num) {
    case 1:
      System.out.println("one");
      break;
    case 2:
      System.out.println("two");
      break;
    default:
      System.out.println("many");
    }

    switch (num) {
    case 1 -> System.out.println("one");
    case 2 -> System.out.println("two");
    default -> System.out.println("many");
    }

    System.out.println(switch (num) {
    case 1:
      yield ("one");
    case 2:
      yield ("two");
    default:
      yield ("many");
    });

    System.out.println(switch (num) {
    case 1 -> "one";
    case 2 -> "two";
    default -> {
      throw new RuntimeException("100");
    }
    });

    String x = switch (num) {
    case 1 -> "one";
    case 2 -> "two";
    default -> {
      throw new RuntimeException("100");
    }
    };
    SwitchExpression.yield("test");
  }
  private static final String yield(final String arg) {
    return arg;
  }
  private static String switchStatement(final int num) {
    String result;
    switch (num) {
    case 1:
      result = "one";
      break;
    case 2:
      result = "two";
      break;
    default:
      result = "many";
    }
    return result;
  }
  private static String switchExpression(final int num) {
    String result = switch (num) {
    case 1:
      yield "one";
    case 2:
      yield "two";
    default:
      yield "many";
    };
    return result;
  }
  private static String switchExpression2(final int num) {
    String result = switch (num) {
    case 1 -> "one";
    case 2 -> "two";
    default -> "many";
    };
    return result;
  }
  private static String switchExpression3(final int num) {
    String result = switch (num) {
    case 1 -> "one";
    case 2 -> "two";
    default -> {
      System.err.println("WARN: too many...");
      yield "many";
    }
    };
    return result;
  }
}
