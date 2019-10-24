package niukewang.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: algorithms
 * @description: 题目描述
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * @author: wxq
 * @date 2018-10-11 20:30
 **/


/*
* 注意: 做除法时考虑除数是否有可能为0
* 需要再做
* */

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

public class No3_max_points_on_a_line {
    // 以前的代码
//    public static int maxPoints(Point[] points) {
//
//        if(points == null || points.length == 0){
//            return 0;
//        }
//
//        int[] xPoints = new int[points.length];
//        int[] yPoints = new int[points.length];
//        double[] slopePoints = new double[points.length];
////        System.out.println("len " + points.length);
//        for (int i = 0; i < points.length; i++) {
//            xPoints[i] = points[i].x;
//            yPoints[i] = points[i].y;
//            slopePoints[i] = ((double) points[i].y + 1000000 )/ (points[i].x + 1000000);
//
//        }
//
//        int len = xPoints.length, maxX = 1, maxY = 1, maxSlope = 1;
//        for (int i = 0; i < len; i++) {
//            int countX = 0, countY = 0, countSlope = 0;
//            for (int j = 0; j < len; j++) {
//                if (xPoints[i] == xPoints[j]) {
//                    countX++;
//                }
//                if (yPoints[i] == yPoints[j]) {
//                    countY++;
//                }
//                if (slopePoints[i] == slopePoints[j]) {
//                    countSlope++;
//                }
//            }
//            maxX = maxX < countX ? countX : maxX;
//            maxY = maxY < countY ? countY : maxY;
//            maxSlope = maxSlope < countSlope ? countSlope : maxSlope;
//        }
//
//        return maxX > maxY ? (maxX > maxSlope ? maxX : maxSlope) : (maxY > maxSlope ? maxY : maxSlope);
//    }
    public static int maxPoints(Point[] points){
        if(points == null || points.length == 0){
            return 0;
        }
        if(points.length == 1){
            return 1;
        }

        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int dup = 0, currentMax = 0, ver = 0;
            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if(i != j){
                    int x1 = points[i].x - points[j].x;
                    int y1 = points[i].y - points[j].y;

                    if(x1 == 0 && y1 == 0){
                        if(dup == 0){
                            dup = 2;
                        }else {
                            dup++;
                        }
                    }else if(x1 == 0){
                        if(ver == 0){
                            ver = 2;
                        }else {
                            ver++;
                        }
                        currentMax = Math.max(currentMax, ver);
                    }else {
                        double slope = (double) y1/x1;
                        int countSlope = 0;
                        if (map.containsKey(slope)) {
                            countSlope = map.get(slope);
                            countSlope++;
                        }else {
                            countSlope = 2;
                        }
                        map.put(slope, countSlope);
                        currentMax = Math.max(currentMax, countSlope);
                    }
                }
            }// for
            res = Math.max(res, currentMax+dup);
        }
        return  res;
    }

    public static void main(String[] args) {
        Point point = new Point(0,0);
        Point[] points = new Point[1];
        points[0] = point;
        System.out.println(maxPoints(points));
    }
}
