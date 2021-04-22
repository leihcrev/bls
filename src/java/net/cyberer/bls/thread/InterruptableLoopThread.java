package net.cyberer.bls.thread;

public abstract class InterruptableLoopThread extends Thread {
  @Override
  public void run() {
    try {
      while (true) {
        try {
          if (!execute()) {
            break;
          }
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
        if (Thread.interrupted()) {
          doWhenInterrupted();
          break;
        }
      }
    } finally {
      doWhenFinished();
    }
  }
  public abstract boolean execute() throws InterruptedException;
  public abstract void doWhenInterrupted();
  public abstract void doWhenFinished();
}
