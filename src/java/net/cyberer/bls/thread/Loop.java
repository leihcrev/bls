package net.cyberer.bls.thread;

public class Loop extends InterruptableLoopThread {

  public static void main(final String[] args) throws InterruptedException {
    Thread t = new Loop();
    t.start();
    Thread.sleep(10000);
    t.interrupt();
    System.err.print("[do interrupt()]");
  }

  private int counter = 0;

  @Override
  public boolean execute() throws InterruptedException {
    System.out.println("#" + (counter + 1) + " processing started.");
    for (int i = 0; i < 80; i++) {
      System.out.print(".");
      for (int j = 0; j < 100000; j++) {
        int x = j;
        int m = (int) Math.sqrt(j);
        for (int k = 2; k < m; k++) {
          if (x % k == 0) {
            x /= k;
          }
        }
      }
      Thread.sleep(0, 0);
    }
    System.out.println("\n#" + (counter + 1) + " processing finished.");
    return ++counter < 5;
  }

  @Override
  public void doWhenInterrupted() {
    System.out.println("Interrupted!");
  }

  @Override
  public void doWhenFinished() {
    System.out.println("All processing finished! " + counter + " times processed.");
  }

}
