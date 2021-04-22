package net.cyberer.sample.textblock;

public class TextBlockSample {
  public static void main(final String[] args) {
    String str1 = "public class TextBlockSample {\n"
                + "  public static void main(final String[] args) {\n"
                + "    String str1 = \"public class TextBlockSample {}\";\n"
                + "  }\n"
                + "}";
    String str2 = """
      public class TextBlockSample {
        public static void main(final String[] args) {
          String str1 = "public class TextBlockSample {}";
        }
      }""";
    System.out.println(str1);
    System.out.println(str1.equals(str2));

    System.out.println("""
                       a\
                       b\
                       c""".equals("abc")); // true
    System.out.println("""
                       a\s\s
                       ab\s
                       abc""".equals("a  \nab \nabc")); // true
    System.out.println("""
                   a
                  b
                   c""".equals(" a\nb\n c"));
  }
}
