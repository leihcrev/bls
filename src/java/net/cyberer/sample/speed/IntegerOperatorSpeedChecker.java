package net.cyberer.sample.speed;

public class IntegerOperatorSpeedChecker {

  private static final int WARMUP = 1000;
  private static final long LOOP = 1000000;
  private static final int A = 119;
  private static final long AL = 119L;

  public static void main(String[] args) {
    for (int tries = 0; tries < 10; tries++) {
      Result result = null;

      for (int i = 0; i < WARMUP; i++) {
        result = nop(LOOP);
      }
      System.out.println(result);

      for (int i = 0; i < WARMUP; i++) {
        result = plus(LOOP);
      }
      System.out.println(result);

      for (int i = 0; i < WARMUP; i++) {
        result = minus(LOOP);
      }
      System.out.println(result);

      for (int i = 0; i < WARMUP; i++) {
        result = multiply(LOOP);
      }
      System.out.println(result);

      for (int i = 0; i < WARMUP; i++) {
        result = divide(LOOP);
      }
      System.out.println(result);

      for (int i = 0; i < WARMUP; i++) {
        result = mod(LOOP);
      }
      System.out.println(result);

      for (int i = 0; i < WARMUP; i++) {
        result = nopL(LOOP);
      }
      System.out.println(result);

      for (int i = 0; i < WARMUP; i++) {
        result = plusL(LOOP);
      }
      System.out.println(result);

      for (int i = 0; i < WARMUP; i++) {
        result = minusL(LOOP);
      }
      System.out.println(result);

      for (int i = 0; i < WARMUP; i++) {
        result = multiplyL(LOOP);
      }
      System.out.println(result);

      for (int i = 0; i < WARMUP; i++) {
        result = divideL(LOOP);
      }
      System.out.println(result);

      for (int i = 0; i < WARMUP; i++) {
        result = modL(LOOP);
      }
      System.out.println(result);
    }
  }

  private static int dummy(int v) {
    return v;
  }

  private static int dummy(int v, int w) {
    return v;
  }

  private static long dummy(long v) {
    return v;
  }

  private static long dummy(long v, long w) {
    return v;
  }

  private static Result nop(long loop) {
    int s = A;
    long ns = System.nanoTime();
    for (long i = 0; i < loop; i++) {
      s = dummy(s, 17);
    }
    return new Result("int,nop", System.nanoTime() - ns);
  }

  private static Result plus(long loop) {
    int s = A;
    long ns = System.nanoTime();
    for (long i = 0; i < loop; i++) {
      s = dummy(s + 17);
    }
    return new Result("int,+", System.nanoTime() - ns);
  }

  private static Result minus(long loop) {
    int s = A;
    long ns = System.nanoTime();
    for (long i = 0; i < loop; i++) {
      s = dummy(s - 17);
    }
    return new Result("int,-", System.nanoTime() - ns);
  }

  private static Result multiply(long loop) {
    int s = A;
    long ns = System.nanoTime();
    for (long i = 0; i < loop; i++) {
      s = dummy(s * 17);
    }
    return new Result("int,*", System.nanoTime() - ns);
  }

  private static Result divide(long loop) {
    int s = A;
    long ns = System.nanoTime();
    for (long i = 0; i < loop; i++) {
      s = dummy(s / 17);
    }
    return new Result("int,/", System.nanoTime() - ns);
  }

  private static Result mod(long loop) {
    int s = A;
    long ns = System.nanoTime();
    for (long i = 0; i < loop; i++) {
      s = dummy(s % 17);
    }
    return new Result("int,%", System.nanoTime() - ns);
  }

  private static Result nopL(long loop) {
    long sl = AL;
    long ns = System.nanoTime();
    for (long i = 0; i < loop; i++) {
      sl = dummy(sl, 17L);
    }
    return new Result("long,nop", System.nanoTime() - ns);
  }

  private static Result plusL(long loop) {
    long sl = AL;
    long ns = System.nanoTime();
    for (long i = 0; i < loop; i++) {
      sl = dummy(sl + 17L);
    }
    return new Result("long,+", System.nanoTime() - ns);
  }

  private static Result minusL(long loop) {
    long sl = AL;
    long ns = System.nanoTime();
    for (long i = 0; i < loop; i++) {
      sl = dummy(sl - 17L);
    }
    return new Result("long,-", System.nanoTime() - ns);
  }

  private static Result multiplyL(long loop) {
    long sl = AL;
    long ns = System.nanoTime();
    for (long i = 0; i < loop; i++) {
      sl = dummy(sl * 17L);
    }
    return new Result("long,*", System.nanoTime() - ns);
  }

  private static Result divideL(long loop) {
    long sl = AL;
    long ns = System.nanoTime();
    for (long i = 0; i < loop; i++) {
      sl = dummy(sl / 17L);
    }
    return new Result("long,/", System.nanoTime() - ns);
  }

  private static Result modL(long loop) {
    long sl = AL;
    long ns = System.nanoTime();
    for (long i = 0; i < loop; i++) {
      sl = dummy(sl % 17L);
    }
    return new Result("long,%", System.nanoTime() - ns);
  }
}

class Result {
  String op;
  long ns;

  Result(String op, long ns) {
    this.op = op;
    this.ns = ns;
  }

  @Override
  public String toString() {
    return op + "," + ns;
  }
}