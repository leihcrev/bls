import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public final class Main {
  public static void main(final String[] args) throws Exception {
    final StringBuilder result = new StringBuilder();
    try (final BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
      execute(in, result);
    }
    try (final PrintWriter out = new PrintWriter(System.out)) {
      out.println(result);
      out.flush();
    }
  }

  private static void execute(final BufferedReader in, final StringBuilder result) {
  }
}
