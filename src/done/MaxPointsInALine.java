package undone;

import java.util.HashMap;
import java.util.Map;

class Point {
  int x;
  int y;

  Point() {
    x = 0;
    y = 0;
  }

  Point(int a, int b) {
    x = a;
    y = b;
  }
}

/**
 * ax+by+c=0
 * a/b=(x1-x2)/(y1-y2)
 */
public class MaxPointsInALine {
  public int maxPoints(Point[] points) {
    if (points == null) return 0;
    if (points.length <= 2) return points.length;

    Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
    int result = 0;
    for (int i = 0; i < points.length; i++) {
      map.clear();
      int overlap = 0, max = 0;
      for (int j = i + 1; j < points.length; j++) {
        int x = points[j].x - points[i].x;
        int y = points[j].y - points[i].y;
        if (x == 0 && y == 0) {
          overlap++;
          continue;
        }
        int gcd = generateGCD(x, y);
        if (gcd != 0) {
          x /= gcd;
          y /= gcd;
        }

        if (map.containsKey(x)) {
          if (map.get(x).containsKey(y)) {
            map.get(x).put(y, map.get(x).get(y) + 1);
          } else {
            map.get(x).put(y, 1);
          }
        } else {
          Map<Integer, Integer> m = new HashMap<Integer, Integer>();
          m.put(y, 1);
          map.put(x, m);
        }
        max = Math.max(max, map.get(x).get(y));
      }
      result = Math.max(result, max + overlap + 1);
    }
    return result;
  }

  private int generateGCD(int a, int b) {
    if (b == 0) return a;
    else return generateGCD(b, a % b);
  }
}

//  public int maxPoints(Point[] points) {
//    if(points.length<=1)
//      return points.length;
//    Map<Integer, Map<Integer, Integer>> map=new HashMap<Integer, Map<Integer, Integer>>();
//    for(int i=0;i<points.length;i++) {
//      for(int j=i+1;j<points.length;j++) {
//        int a=points[j].x-points[i].x, b=points[j].y-points[i].y;
//        if(a<0) {
//          a=-a;
//          b=-b;
//        }
//        int gcd=generateGCD(a,b);
//        if (gcd!=0){
//          a/=gcd;
//          b/=gcd;
//        }
//        if(map.get(a)==null)
//          map.put(a, new HashMap<Integer, Integer>());
//        if(map.get(a).get(b)==null)
//          map.get(a).put(b, 0);
//        map.get(a).put(b, map.get(a).get(b)+1);
//      }
//    }
//    int maxPairs=0;
//    for(Map<Integer, Integer> m: map.values())
//      for(Integer num: m.values())
//        maxPairs=num>maxPairs?num:maxPairs;
//    for(int maxPoints=0;;maxPoints++) {
//      if(maxPoints*maxPoints>maxPairs*2)
//        return maxPoints;
//    }
//  }
//
//  private int generateGCD(int a,int b){
//    if (b==0) return a;
//    else return generateGCD(b,a%b);
//  }
//
//  public static void main(String args[]) {
////    Point[] points=new Point[]{new Point(0, 0), new Point(-1, -1), new Point(2, 2)};
//    Point[] points=new Point[]{new Point(0, 0), new Point(0, 0)};
//    System.out.println(new MaxPoinsInALine().maxPoints(points));
//  }
