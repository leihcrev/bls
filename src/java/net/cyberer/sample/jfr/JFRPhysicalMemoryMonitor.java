package net.cyberer.sample.jfr;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.logging.Logger;

import jdk.jfr.consumer.RecordingStream;

/**
 * 物理メモリ使用量を非同期で監視する. コンストラクタ呼び出し元スレッドの終了まで監視を行う.
 *
 * @author CYBERer.NET
 */
public class JFRPhysicalMemoryMonitor extends Thread {
  private final Thread monitoringThread;
  private final long intervalMillis;
  private final long waitMillisAfterDied;
  private static final Logger LOGGER = Logger.getLogger(JFRPhysicalMemoryMonitor.class.getName());
  /**
   * コンストラクタ. このコンストラクタを呼び出したスレッドの終了までをモニタする.
   *
   * @param intervalMillis      監視間隔 (ミリ秒)
   * @param waitMillisAfterDied コンストラクタを呼び出したスレッドが終了してから監視を継続する時間 (ミリ秒)
   */
  public JFRPhysicalMemoryMonitor(final long intervalMillis, final long waitMillisAfterDied) {
    this.monitoringThread = Thread.currentThread();
    this.intervalMillis = intervalMillis;
    this.waitMillisAfterDied = waitMillisAfterDied;
  }

  @Override
  public void run() {
    final DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    try (var rs = new RecordingStream()) {
      rs.enable("jdk.PhysicalMemory").withPeriod(Duration.ofMillis(intervalMillis));
      rs.onEvent("jdk.PhysicalMemory", event -> {
        LOGGER.info(toMBString(event.getLong("usedSize")) + "/" + toMBString(event.getLong("totalSize")));
      });
      rs.startAsync();
      try {
        monitoringThread.join();
        Thread.sleep(waitMillisAfterDied);
      } catch (InterruptedException e) {
        System.err.println("monitoringThread is interrupted.");
      }
    }
  }

  /**
   * バイトサイズをメガバイト換算した文字列に変換する.
   *
   * @param size バイトサイズ
   * @return メガバイト換算値 (0x100000 で割った値) + "MB"
   */
  private static String toMBString(final long size) {
    StringBuilder sb = new StringBuilder();
    sb.append(size / 0x100000);
    sb.append("MB");
    return sb.toString();
  }
}
