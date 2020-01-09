// Slides: ch08-classes.ppt
// 26 - 41

import java.awt.*;
import java.io.*;
import java.util.*;

// Displays a set of cities and simulates dropping a "bomb" on them.
public class Bomb {
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
            // g.fillOval(cities[i].x, cities[i].y, 3, 3);
            // g.drawString("(" + cities[i].x + ", " + cities[i].y + ")", cities[i].x, cities[i].y);
            // draw(cities[i], g);   // static (bad)
            cities[i].draw(g);       // inside object (better)
        }
        return cities;
    }
    
    // Simulates dropping a bomb at the given location on the given cities.
    public static void boom(Point bomb, int radius, Point[] cities, Graphics g) {
        g.setColor(Color.RED);
        g.drawOval(bomb.x - radius, bomb.y - radius, 2 * radius, 2 * radius);
        for (int i = 0; i < cities.length; i++) {
            // int dx = cities[i].x - bomb.x;
            // int dy = cities[i].y - bomb.y;
            // double distance = Math.sqrt(dx * dx + dy * dy);
            // if (distance <= radius) {
            if (cities[i].distance(bomb) <= radius) {
                // g.fillOval(cities[i].x, cities[i].y, 3, 3);
                // g.drawString("(" + cities[i].x + ", " + cities[i].y + ")", cities[i].x, cities[i].y);
                // draw(cities[i], g);   // static (bad)
                cities[i].draw(g);       // inside object (better)
            }
        }
        System.out.println("Kaboom!");
    }

    // Draws the given point on the DrawingPanel
    // static (bad) 
    // 
    public static void draw(Point p, Graphics g) {
        g.fillOval(p.x, p.y, 3, 3);
        // g.drawString("(" + p.x + ", " + p.y + ")", p.x, p.y);
        g.drawString(p.toString(), p.x, p.y);
    }


}
