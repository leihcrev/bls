import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public final class MainABC159D {
  private static void execute(final IO io) throws Exception {
    final int n = io.nextInt();
    final int[] a = io.nextInt(n);

    final long[] map = new long[n];
    for (int an : a) {
      map[an - 1]++;
    }

    int ans = 0;
    for (long v : map) {
      ans += v * (v - 1) / 2;
    }

    for (int an : a) {
      io.println(ans - (map[an- 1] - 1L));
    }
  }

  public static void main(final String[] args) throws Exception {
    try (IO io = new IO(System.in, System.out)) {
      execute(io);
    }
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
    private static final int BUFFER_SIZE = 1 << 16;
    private final byte[] buf = new byte[BUFFER_SIZE];
    private int pos = 0;
    private int end = 0;
    public IO(final InputStream in, final PrintStream out) throws IOException {
      this.in = in;
      this.out = new BufferedOutputStream(out);
    }

    @Override
    public void close() throws IOException {
      out.close();
    }

    private int fetchByte() throws IOException {
      if (pos >= end) {
        pos = 0;
        end = in.read(buf);
        if (end <= 0) {
          return -1;
        }
      }
      return buf[pos++];
    }

    public String next() throws IOException {
      int c;
      for (c = fetchByte(); c <= ' '; c = fetchByte()) {
      }
      final StringBuilder sb = new StringBuilder();
      for (; c > ' '; c = fetchByte()) {
        sb.append((char) c);
      }
      return sb.toString();
    }

    public int nextInt() throws IOException {
      int val = 0;
      int c;
      for (c = fetchByte(); c <= ' '; c = fetchByte()) {
      }
      boolean neg = c == '-';
      if (c == '-' || c == '+') {
        c = fetchByte();
      }
      for (; c >= '0' && c <= '9'; c = fetchByte()) {
        val = (val << 3) + (val << 1) + (c & 15);
      }
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
      long val = 0;
      int c;
      for (c = fetchByte(); c <= ' '; c = fetchByte()) {
      }
      boolean neg = c == '-';
      if (c == '-' || c == '+') {
        c = fetchByte();
      }
      for (; c >= '0' && c <= '9'; c = fetchByte()) {
        val = (val << 3) + (val << 1) + (c & 15);
      }
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

    public void printaln(final int[] a) throws IOException {
      for (int i = 0, n = a.length; i < n; i++) {
        out.write(Integer.toString(a[i]).getBytes());
        out.write(CRLF);
      }
    }

    public void printasp(final int[] a) throws IOException {
      for (int i = 0, n = a.length; i < n; i++) {
        out.write(Integer.toString(a[i]).getBytes());
        out.write(SP);
      }
    }

    public void printaln(final long[] a) throws IOException {
      for (int i = 0, n = a.length; i < n; i++) {
        out.write(Long.toString(a[i]).getBytes());
        out.write(CRLF);
      }
    }

    public void printasp(final long [] a) throws IOException {
      for (int i = 0, n = a.length; i < n; i++) {
        out.write(Long.toString(a[i]).getBytes());
        out.write(SP);
      }
    }

    public void printaln(final Object[] a) throws IOException {
      for (int i = 0, n = a.length; i < n; i++) {
        out.write(a[i].toString().getBytes());
        out.write(CRLF);
      }
    }

    public void printasp(final Object[] a) throws IOException {
      for (int i = 0, n = a.length; i < n; i++) {
        out.write(a[i].toString().getBytes());
        out.write(SP);
      }
    }

    public void flush() throws IOException {
      out.flush();
    }
  }
}
