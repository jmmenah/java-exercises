// Slides: ch08-classes.ppt
// 26 - 41

import java.awt.Graphics;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

// Displays a set of cities and simulates dropping a "bomb" on them.
public class Bomb2 {
    public static void main(String[] args) throws FileNotFoundException {
        DrawingPanel panel = new DrawingPanel(200, 200);
        Graphics g = panel.getGraphics();

        Scanner input = new Scanner(new File("cities.txt"));
        Point[] cities = readCities(input, g);
        
        // drop the "bomb"
        Scanner console = new Scanner(System.in);
        Point bomb = new Point();
        System.out.print("Blast site x? ");
        bomb.x = console.nextInt();
        System.out.print("Blast site y? ");
        bomb.y = console.nextInt();
        System.out.print("Blast radius? ");
        int radius = console.nextInt();
        boom(bomb, radius, cities, g);
    }
// Reads input file of cities and returns them as array of Points.
    public static Point[] readCities(Scanner input, Graphics g) {
        int numCities = input.nextInt();   // first line = # of cities
        Point[] cities = new Point[numCities];
        for (int i = 0; i < cities.length; i++) {
            cities[i] = new Point();
            cities[i].x = input.nextInt();  // read city x/y from file
            cities[i].y = input.nextInt();
            cities[i].draw(g);  // draw citie point
        }
        return cities;
    }
    
    // Simulates dropping a bomb at the given location on the given cities.
    public static void boom(Point bomb, int radius, Point[] cities, Graphics g) {
        g.setColor(Color.RED);
        g.drawOval(bomb.x - radius, bomb.y - radius, 2 * radius, 2 * radius);
        for (int i = 0; i < cities.length; i++) {
              if (cities[i].distance(bomb) <= radius) {
                cities[i].draw(g);  // draw citie point
            }
        }
        System.out.println("Kaboom!");
    }
}
