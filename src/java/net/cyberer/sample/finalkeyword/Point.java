package net.cyberer.sample.finalkeyword;

public class Point {
  private final int x;
  private final int y;

  public Point(final int x, final int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + x;
    result = prime * result + y;
    return result;
  }

//  @Override
//  public boolean equals(Object obj) {
//    return obj instanceof Point p && this.x == p.x && this.y == p.y;
//  }

  public static void main(final String[] args) {
    Point p1 = new Point(1, 1);
    Point p2 = null;
    System.out.println(p1.equals(p2));
    p2 = new Point(2, 2);
    System.out.println(p1.equals(p2));
    p2 = new Point(1, 1);
    System.out.println(p1.equals(p2));
  }
}
