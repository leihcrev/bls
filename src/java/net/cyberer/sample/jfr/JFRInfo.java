package net.cyberer.sample.jfr;

import jdk.jfr.FlightRecorder;

public class JFRInfo {
  public static void main(final String[] args) {
    FlightRecorder jfr = FlightRecorder.getFlightRecorder();
    for (var type : jfr.getEventTypes()) {
      if (args.length >= 1) {
        if (!type.getName().toLowerCase().contains(args[0].toLowerCase())) {
          continue;
        }
      }
      System.out.println(type.getName() + ": " + type.getDescription());
      System.out.println("  Settings:");
      for (var desc : type.getSettingDescriptors()) {
        System.out.println(
            "    " + desc.getName() + ": " + desc.getDescription() + " (default: " + desc.getDefaultValue() + ")");
      }
      System.out.println("  Fields:");
      for (var val : type.getFields()) {
        System.out.println("    " + val.getName() + " (" + val.getContentType() + "/" + val.getTypeName() + "): "
            + val.getDescription());
      }
    }
  }
}
