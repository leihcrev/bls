import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public final class MainABC155D {
  public static void main(final String[] args) throws Exception {
    int max = 0;
    final Map<String, int[]> map = new TreeMap<>();

    try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
      for (int n = Integer.parseInt(br.readLine()); n > 0; n--) {
        final String s = br.readLine();
        final int[] c = map.get(s);
        if (c == null) {
          map.put(s, new int[] { 1 });
          if (max == 0) {
            max++;
          }
        } else {
          if (++c[0] > max) {
            max = c[0];
          };
        }
      }
    }
    try (final PrintWriter pw = new PrintWriter(System.out)) {
      for (Map.Entry<String, int[]> e : map.entrySet()) {
        if (e.getValue()[0] == max) {
          pw.println(e.getKey());
        }
      }
      pw.flush();
    }
  }
}
