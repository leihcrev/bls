package net.cyberer.sample.concatstring;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.StringConcatFactory;

public class Benchmark {
  private static final int WARMUP = 100;
  private static final int LOOP = 1000000;

  public static void main(final String[] args) throws Exception {
    final String a = "abcdefg";
    final String b = "hijklmn";
    final String c = "opqrstu";
    final String[] resultHolder = new String[1];
    long nop;

    // nop
    resultHolder[0] = null;
    System.out.println("nop," + (nop = timer(new Concatenator(a, b, c) {
      @Override
      public void run() {
        try {
          resultHolder[0] = "abcdefg-hijklmn-opqrstu";
        } catch (final Throwable t) {
          throw new RuntimeException(t);
        }
      }
    })));

    // StringConcatFactory
    final MethodHandle concatenator = StringConcatFactory.makeConcatWithConstants(MethodHandles.lookup(), "",
        MethodType.methodType(String.class, new Class[] { String.class, String.class, String.class }), "\1\2\1\2\1",
        '-', '-').dynamicInvoker();
    resultHolder[0] = null;
    System.out.println("StringConcatFactory," + (timer(new Concatenator(a, b, c) {
      @Override
      public void run() {
        try {
          resultHolder[0] = (String) concatenator.invoke(a, b, c);
        } catch (final Throwable t) {
          throw new RuntimeException(t);
        }
      }
    }) - nop));

    // StringBuilder
    resultHolder[0] = null;
    System.out.println("StringBuilder," + (timer(new Concatenator(a, b, c) {
      @Override
      public void run() {
        try {
          resultHolder[0] = new StringBuilder(a).append('-').append(b).append('-').append(c).toString();
        } catch (final Throwable t) {
          throw new RuntimeException(t);
        }
      }
    }) - nop));

    // StringBuffer
    resultHolder[0] = null;
    System.out.println("StringBuffer," + (timer(new Concatenator(a, b, c) {
      @Override
      public void run() {
        try {
          resultHolder[0] = new StringBuffer(a).append('-').append(b).append('-').append(c).toString();
        } catch (final Throwable t) {
          throw new RuntimeException(t);
        }
      }
    }) - nop));
  }

  private static final long timer(final Runnable task) {
    long t = 0;
    for (int r = 0; r < WARMUP; r++) {
      t = System.nanoTime();
      for (int i = 0; i < LOOP; i++) {
        task.run();
      }
      t = System.nanoTime() - t;
    }
    return t;
  }

  private static abstract class Concatenator implements Runnable {
    protected final String a;
    protected final String b;
    protected final String c;
    public Concatenator(final String a, final String b, final String c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }
  }
}
