package net.cyberer.sample.record;

public final class Point {
  private final int x, y;
  public Point(final int x, final int y) {
    this.x = x;
    this.y = y;
  }
  public int x() {
    return x;
  }
  public int y() {
    return y;
  }
  @Override
  public int hashCode() {
    return java.util.Arrays.hashCode(new Object[] { x, y });
  }
  @Override
  public boolean equals(Object obj) {
    return this == obj || obj != null && obj instanceof Point other && x == other.x && y == other.y;
  }
  @Override
  public String toString() {
    return "Point[x=" + x + ", y=" + y + "]";
  }
}