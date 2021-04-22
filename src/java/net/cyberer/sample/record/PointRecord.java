package net.cyberer.sample.record;

record PointRecord(int x, int y) {
  static int z;
  public PointRecord {
    if (x < 0 || y < 0) {
      throw new IllegalArgumentException("x and y cannot be negative.");
    }
  }
  public int total() {
    return x + y;
  }
}