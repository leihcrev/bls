package net.cyberer.sample.concatstring;

import java.util.Arrays;

public class ConcatString {
  public static final String concatenate1(final String a, final String b) {
    return "[" + a + b + "]";
  }

  public static final String concatenate2(final String a, final String b) {
    return new StringBuilder("[").append(a).append(b).append("]").toString();
  }

  public static final String bad(final String[] strs) {
    String result = "";
    for (String s : strs) {
      result += s;
    }
    return result;
  }

  public static final String good(final String[] strs) {
    StringBuilder result = new StringBuilder();
    for (String s : strs) {
      result.append(s);
    }
    return result.toString();
  }

  public static final String good2(final String[] strs) {
    StringBuilder result = new StringBuilder();
    Arrays.stream(strs).forEach(result::append);
    return result.toString();
  }
}

/* Legacy
public class ConcatString {
  public static final java.lang.String concatenate1(java.lang.String a, java.lang.String b);
     0  new java.lang.StringBuilder [16]
     3  dup
     4  ldc <String "["> [18]
     6  invokespecial java.lang.StringBuilder(java.lang.String) [20]
     9  aload_0 [a]
    10  invokevirtual java.lang.StringBuilder.append(java.lang.String) : java.lang.StringBuilder [23]
    13  aload_1 [b]
    14  invokevirtual java.lang.StringBuilder.append(java.lang.String) : java.lang.StringBuilder [23]
    17  ldc <String "]"> [27]
    19  invokevirtual java.lang.StringBuilder.append(java.lang.String) : java.lang.StringBuilder [23]
    22  invokevirtual java.lang.StringBuilder.toString() : java.lang.String [29]
    25  areturn

  public static final java.lang.String concatenate2(java.lang.String a, java.lang.String b);
     0  new java.lang.StringBuilder [16]
     3  dup
     4  ldc <String "["> [18]
     6  invokespecial java.lang.StringBuilder(java.lang.String) [20]
     9  aload_0 [a]
    10  invokevirtual java.lang.StringBuilder.append(java.lang.String) : java.lang.StringBuilder [23]
    13  aload_1 [b]
    14  invokevirtual java.lang.StringBuilder.append(java.lang.String) : java.lang.StringBuilder [23]
    17  ldc <String "]"> [27]
    19  invokevirtual java.lang.StringBuilder.append(java.lang.String) : java.lang.StringBuilder [23]
    22  invokevirtual java.lang.StringBuilder.toString() : java.lang.String [29]
    25  areturn
}
*/

/* Indy
public class ConcatString {
  public static final java.lang.String concatenate1(java.lang.String, java.lang.String);
    Code:
       0: ldc           #7                  // String [
       2: aload_0
       3: aload_1
       4: ldc           #9                  // String ]
       6: invokedynamic #11,  0             // InvokeDynamic #0:makeConcat:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
      11: areturn

  public static final java.lang.String concatenate2(java.lang.String, java.lang.String);
    Code:
       0: new           #15                 // class java/lang/StringBuilder
       3: dup
       4: ldc           #7                  // String [
       6: invokespecial #17                 // Method java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
       9: aload_0
      10: invokevirtual #20                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      13: aload_1
      14: invokevirtual #20                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      17: ldc           #9                  // String ]
      19: invokevirtual #20                 // Method java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
      22: invokevirtual #24                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      25: areturn
}
*/