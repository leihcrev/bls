package net.cyberer.sample.npe;

import java.util.Arrays;

public class NPESample {
  public static void main(final String[] args) {
    Data[] data = {
        new Data("a", "b", "c", "d", "e"),
        new Data("a", "n", "c", null, null),
        new Data("b", "x", "i"),
        new Data("b", "t"),
        new Data("c", "z", "c", null, null),
        new Data("c", "s", "c", null, "m"),
        new Data("d", "a", "r", null, null),
        new Data("d", "v", "c", null, "m"),
        new Data("d"),
        new Data("o", "w", "c", null, "u"),
    };
    Arrays.parallelSort(data);
  }

  static final class Data implements Comparable<Data> {
    private String[] key;
    private String[] tail;

    public Data(final String... strs) {
      key = Arrays.copyOf(strs, 3);
      if (strs.length > 3) {
        tail = Arrays.copyOfRange(strs, 3, strs.length);
      }
    }

    public String[] getKey() {
      return key;
    }

    public String[] getTail() {
      return tail;
    }

    @Override
    public int compareTo(final Data o) {
      return key[0].compareTo(o.key[0]) == 0 ? 0 : key[1].compareTo(o.key[1]) == 0 ? 0 : key[1].compareTo(o.key[1]);
    }
  }
}
