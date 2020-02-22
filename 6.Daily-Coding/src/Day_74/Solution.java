package Day_74;

public class Solution {
  public static void main(String[] args) {

  }

  public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
    Point r11 = new Point(rec1[0], rec1[1]);
    Point r12 = new Point(rec1[2], rec1[3]);

    Point r21 = new Point(rec2[0], rec2[1]);
    Point r22 = new Point(rec2[2], rec2[3]);


    return check(r11, r12, r21, r22);
  }

  public static boolean check(Point p1, Point p2, Point p3, Point p4) {
    if (p1.y >= p4.y || p3.y >= p2.y) {
      return false;
    }

    if (p1.x >= p4.x || p3.x >= p2.x) {
      return false;
    }

    return true;
  }

}

class Point {
  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}