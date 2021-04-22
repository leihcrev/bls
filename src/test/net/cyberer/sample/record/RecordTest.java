package net.cyberer.sample.record;

public class RecordTest {

  public static void main(final String[] args) {
    Point p1 = new Point(100, 200);
    Point p2 = new Point(100, 200);
    PointRecord pr1 = new PointRecord(100, 200);
    PointRecord pr2 = new PointRecord(100, 200);
    System.out.println(p1);
    System.out.println(pr1);
    System.out.println(p1.hashCode());
    System.out.println(pr1.hashCode());
    pr1.x();
  }
}
