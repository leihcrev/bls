import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public final class MainABC160C {
  public static void main(final String[] args) throws Exception {
    try (IO io = new IO(System.in, System.out)) {
      execute(io);
    }
  }

  private static void execute(final IO io) throws Exception {
    int k = io.nextInt();
    int n = io.nextInt();
    int[] a = io.nextInt(n);
    int max = k - a[n - 1] + a[0];
    for (int i = 1; i < n; i++) {
      int d = a[i] - a[i - 1];
      if (d > max) {
        max = d;
      }
    }
    io.println(k - max);
  }

  public static final class M {
    public static int gcd(int a, int b) {
      int tmp;
      while (b != 0) {
        tmp = a;
        a = b;
        b = tmp % b;
      }
      return a;
    }

    public static int gcd(final int a, final int b, final int c) {
      return gcd(gcd(a, b), c);
    }

    public static int min(final int a, final int b) {
      return a > b ? b : a;
    }

    public static int min(final int a, final int b, final int c) {
      return min(min(a, b), min(b, c));
    }
  }

  public static final class IO implements AutoCloseable {
    private final InputStream in;
    private final BufferedOutputStream out;
    private static final int BUFSIZE = 1 << 16;
    private final byte[] buf = new byte[BUFSIZE];
    private int index = 0;
    private int total = 0;
    public IO(final InputStream in, final PrintStream out) throws IOException {
      this.in = in;
      this.out = new BufferedOutputStream(out);
    }

    @Override
    public void close() throws IOException {
      in.close();
      out.close();
    }

    private int scan() throws IOException {
      if (index >= total) {
        index = 0;
        total = in.read(buf);
        if (total <= 0)
          return -1;
      }
      return buf[index++];
    }

    public String next() throws IOException {
      int c;
      for (c = scan(); c <= 32; c = scan());
      StringBuilder sb = new StringBuilder();
      for (; c > 32; c = scan())
        sb.append((char) c);
      return sb.toString();
    }

    public int nextInt() throws IOException {
      int c, val = 0;
      for (c = scan(); c <= 32; c = scan());
      boolean neg = c == '-';
      if (c == '-' || c == '+')
        c = scan();
      for (; c >= '0' && c <= '9'; c = scan())
        val = (val << 3) + (val << 1) + (c & 15);
      return neg ? -val : val;
    }

    public int[] nextInt(final int n) throws IOException {
      final int[] result = new int[n];
      for (int i = 0; i < n; i++) {
        result[i] = nextInt();
      }
      return result;
    }

    public long nextLong() throws IOException {
      int c;
      long val = 0;
      for (c = scan(); c <= 32; c = scan());
      boolean neg = c == '-';
      if (c == '-' || c == '+')
        c = scan();
      for (; c >= '0' && c <= '9'; c = scan())
        val = (val << 3) + (val << 1) + (c & 15);
      return neg ? -val : val;
    }

    public long[] nextLong(final int n) throws IOException {
      final long[] result = new long[n];
      for (int i = 0; i < n; i++) {
        result[i] = nextLong();
      }
      return result;
    }

    public void print(final Object a) throws IOException {
      out.write(a.toString().getBytes());
    }

    private static final byte[] SP = new byte[] { 0x20 };
    public void printsp(final Object a) throws IOException {
      out.write(a.toString().getBytes());
      out.write(SP);
    }

    private static final byte[] CRLF = System.lineSeparator().getBytes();
    public void println() throws IOException {
      out.write(CRLF);
    }

    public void println(final Object a) throws IOException {
      out.write(a.toString().getBytes());
      out.write(CRLF);
    }

    public void flush() throws IOException {
      out.flush();
    }
  }
}
