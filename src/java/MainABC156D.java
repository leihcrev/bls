/**
 * ABC156D
 * <p>
 * あかりさんは n 種類の花を 1 本ずつ持っています。<br />
 * あかりさんは、これらの花から 1 本以上を選び、花束を作ろうとしています。<br />
 * ただし、あかりさんは a と b の 2 つの数を苦手としていて、いずれかと一致するような本数の花からなる花束は作ることができません。<br />
 * あかりさんが作ることのできる花束は何種類あるでしょうか。<br />
 * (10^9+7) で割った余りを求めてください。<br />
 * ここで 2 つの花束は、一方では使われているが、もう一方では使われていない種類の花があるとき、別の種類の花束であるとみなします。<br />
 * </p>
 * <p>
 * 2 <= n <= 10^9<br />
 * 1 <= a < b <= min(n, 2*10^5)<br />
 * </p>
 */
public final class MainABC156D {
  private static void execute(final IO io) throws Exception {
    final int n = io.nextInt();
    final int a = io.nextInt();
    final int b = io.nextInt();
    MC c = new MC(1000000007);
    long x1 = c.power(2, n) - 1;
    long x2 = c.combination(n, a);
    long x3 = c.combination(n, b);
    io.println(c.add(x1, -(x2 + x3)));
  }

  public static void main(final String[] args) throws Exception {
    try (IO io = new IO(System.in, System.out)) {
      execute(io);
    }
  }

  public static final class MC {
    private final int mod;
    public MC(final int mod) {
      this.mod = mod;
    }

    public long mod(long x) {
      x %= mod;
      if (x < 0) {
        x += mod;
      }
      return x;
    }

    public long add(final long a, final long b) {
      return mod(a + b);
    }

    public long mul(final long a, final long b) {
      return mod(a * b);
    }

    public long div(final long numerator, final long denominator) {
      return mod(numerator * inverse(denominator));
    }

    public long power(long base, long exp) {
      long ret = 1;
      base %= mod;
      while (exp > 0) {
        if ((exp & 1) == 1) {
          ret = mul(ret, base);
        }
        base = mul(base, base);
        exp >>= 1;
      }
      return ret;
    }

    public long inverse(final long x) {
      return power(x, mod - 2);
    }

    public long factorial(final int n) {
      return product(1, n);
    }

    public long product(final int start, final int end) {
      long result = 1;
      for (int i = start; i <= end; i++) {
        result *= i;
        result %= mod;
      }
      return result;
    }

    public long combination(final int n, int r) {
      if (r > n) {
        return 0;
      }
      return div(product(n - r + 1, n), factorial(r));
    }
  }

  public static final class IO implements AutoCloseable {
    private final java.io.InputStream in;
    private final java.io.BufferedOutputStream out;
    private static final int BUFFER_SIZE = 1 << 16;
    private final byte[] buf = new byte[BUFFER_SIZE];
    private int pos = 0;
    private int end = 0;
    public IO(final java.io.InputStream in, final java.io.OutputStream out) throws java.io.IOException {
      this.in = in;
      this.out = new java.io.BufferedOutputStream(out);
    }

    @Override
    public void close() throws java.io.IOException {
      out.close();
    }

    private int fetchByte() throws java.io.IOException {
      if (pos >= end) {
        pos = 0;
        end = in.read(buf);
        if (end <= 0) {
          return -1;
        }
      }
      return buf[pos++];
    }

    public String nextString() throws java.io.IOException {
      int c;
      for (c = fetchByte(); c <= ' '; c = fetchByte()) {
      }
      final StringBuilder sb = new StringBuilder();
      for (; c > ' '; c = fetchByte()) {
        sb.append((char) c);
      }
      return sb.toString();
    }

    public String[] nextString(final int n) throws java.io.IOException {
      final String[] result = new String[n];
      for (int i = 0; i < n; i++) {
        result[i] = nextString();
      }
      return result;
    }

    public int nextInt() throws java.io.IOException {
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

    public int[] nextInt(final int n) throws java.io.IOException {
      final int[] result = new int[n];
      for (int i = 0; i < n; i++) {
        result[i] = nextInt();
      }
      return result;
    }

    public long nextLong() throws java.io.IOException {
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

    public long[] nextLong(final int n) throws java.io.IOException {
      final long[] result = new long[n];
      for (int i = 0; i < n; i++) {
        result[i] = nextLong();
      }
      return result;
    }

    public void print(final Object a) throws java.io.IOException {
      out.write(a.toString().getBytes());
    }

    private static final byte[] SP = new byte[] { 0x20 };
    public void printsp(final Object a) throws java.io.IOException {
      out.write(a.toString().getBytes());
      out.write(SP);
    }

    private static final byte[] CRLF = System.lineSeparator().getBytes();
    public void println() throws java.io.IOException {
      out.write(CRLF);
    }

    public void println(final Object a) throws java.io.IOException {
      out.write(a.toString().getBytes());
      out.write(CRLF);
    }

    public void printaln(final int[] a) throws java.io.IOException {
      for (int i = 0, n = a.length; i < n; i++) {
        out.write(Integer.toString(a[i]).getBytes());
        out.write(CRLF);
      }
    }

    public void printasp(final int[] a) throws java.io.IOException {
      for (int i = 0, n = a.length; i < n; i++) {
        out.write(Integer.toString(a[i]).getBytes());
        out.write(SP);
      }
    }

    public void printaln(final long[] a) throws java.io.IOException {
      for (int i = 0, n = a.length; i < n; i++) {
        out.write(Long.toString(a[i]).getBytes());
        out.write(CRLF);
      }
    }

    public void printasp(final long[] a) throws java.io.IOException {
      for (int i = 0, n = a.length; i < n; i++) {
        out.write(Long.toString(a[i]).getBytes());
        out.write(SP);
      }
    }

    public void printaln(final Object[] a) throws java.io.IOException {
      for (int i = 0, n = a.length; i < n; i++) {
        out.write(a[i].toString().getBytes());
        out.write(CRLF);
      }
    }

    public void printasp(final Object[] a) throws java.io.IOException {
      for (int i = 0, n = a.length; i < n; i++) {
        out.write(a[i].toString().getBytes());
        out.write(SP);
      }
    }

    public void flush() throws java.io.IOException {
      out.flush();
    }
  }
}
