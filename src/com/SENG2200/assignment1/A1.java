package com.SENG2200.assignment1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import com.SENG2200.assignment1.mypolygons.MyPolygons;
import com.SENG2200.assignment1.polygon.Polygon;
import com.SENG2200.assignment1.polygon.point.Point;

public class A1 {
    public static void main(String[] args) {
        MyPolygons myPolygons = new MyPolygons();

//        final double[] arr = Polygon.largestToSmallest(200, 100, 5, 203, 500, 1000, 4);
//        for (final double val : arr) {
//            System.out.println(val);
//        }

        try {
            Scanner scanner = new Scanner(new FileReader("input.txt"));
            while (scanner.hasNext()) {
                if (scanner.next().equals("P")) {
                    Point[] points = new Point[scanner.nextInt()];
                    int i = 0;
                    while (scanner.hasNextDouble() && i < points.length) {
                        points[i] = new Point(scanner.nextDouble(), scanner.nextDouble());
                        i++;
                    }
                    myPolygons.prepend(new Polygon(points));
                }
            }
//            System.out.println(myPolygons);
            System.out.println(myPolygons.print());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }






    }
}
