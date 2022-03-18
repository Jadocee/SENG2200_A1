/*
 *  SENG2200 Assignment 1
 *  Jaydon Cameron
 *  C3329145
 *  05/03/2021
 *  This file contains the main java class for commencing the program.
 *  The main method will take the filename as an argument and scan the found file for polygon specs
 *  to create a Polygon object with. The Polygon objects that it creates will be added to a circular
 *  doubly-linked list.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Contains the main method to begin execution
 **/
public class A1 {
    /**
     * main method
     *
     * @param args A <code>String</code> array containing any parsed arguments from the command line.<br/>
     *             This main method will look for a filename in position 0 of the array before continuing
     *             execution.
     **/
    public static void main(String[] args) {
        // Create sorted and unsorted lists
        final MyPolygons myPolygons = new MyPolygons();
        final MyPolygons increasingOrder = new MyPolygons();

        // Try to create scanner to read file with filename found in arguments
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            // Move cursor to whitespace until end of file
            while (scanner.hasNext()) {
                if (scanner.next().equals("P")) {
                    // Create 2D array to store coordinates
                    double[][] points = new double[scanner.nextInt()][2];
                    // Declare for loop with counter to get the specified number of coordinates for a point
                    for (int i = 0; i < points.length; i++) {
                        points[i][0] = scanner.nextDouble();
                        points[i][1] = scanner.nextDouble();
                    }
                    // Create new Polygon object with points and add to the sorted and unsorted lists
                    try {
                        // Create new Polygon object
                        final Polygon polygon = new Polygon(points);
                        // Append to unsorted list
                        myPolygons.append(polygon);
                        // Insert in sorted list
                        increasingOrder.insertInOrder(polygon);
                    } catch (IndexOutOfBoundsException e) {
                        // Catch exception and print stack trace
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            // Scanner could not find source file
            e.printStackTrace();
            System.out.println("Could not find file " + args[0]);
        } catch (NullPointerException e) {
            // File pathname provided is null
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            // Catch exception if no arguments were given
            System.out.println("No arguments provided - provide the filename/pathname");
        } finally {
            // Print unsorted list
            System.out.println("Printing unsorted list...");
            System.out.println(myPolygons);
            // Print sorted list
            System.out.println("Printing sorted list...");
            System.out.println(increasingOrder);
        }
    }
}
