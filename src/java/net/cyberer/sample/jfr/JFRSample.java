package net.cyberer.sample.jfr;

import java.time.Duration;
import java.util.Arrays;
import java.util.Random;

import jdk.jfr.consumer.RecordingStream;

public class JFRSample {
  public static void main(final String[] args) throws InterruptedException {
    try (var rs = new RecordingStream()) {
      rs.enable("jdk.CPULoad").withPeriod(Duration.ofSeconds(1));
      rs.onEvent("jdk.CPULoad", event -> {
        System.out.println("CPULoad - machineTotal: " + event.getFloat("machineTotal"));
      });

      rs.enable("jdk.JavaMonitorEnter").withThreshold(Duration.ofMillis(10));
      rs.onEvent("jdk.JavaMonitorEnter", event -> {
        System.out.println("monitorClass: " + event.getClass("monitorClass"));
      });

      rs.enable("jdk.GCPhasePause").withPeriod(Duration.ofSeconds(1));
      rs.onEvent("jdk.GCPhasePause", event -> {
        System.out.println("GCPhasePause: " + event);
      });

      rs.enable("jdk.ThreadStart");
      rs.onEvent("jdk.ThreadStart", event -> {
        System.out.println("ThreadStart: " + event);
      });

      rs.enable("jdk.ThreadEnd");
      rs.onEvent("jdk.ThreadEnd", event -> {
        System.out.println("ThreadEnd: " + event);
      });
      rs.startAsync();

      var r = new Random();
      System.out.println("Generate started.");
      var data = r.ints(0x10000000).toArray();
      System.out.println("Generate finidhed.");
      System.out.println("Sort started.");
      var result = Arrays.copyOf(data, data.length);
      Arrays.parallelSort(result);
      System.out.println("Sort finished.");
      Thread.sleep(5000);
    }
  }
}
