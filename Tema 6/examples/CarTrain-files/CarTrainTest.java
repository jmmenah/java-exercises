//http://www.javaproblems.com/2013/12/creating-inheritance-and-polymorphism.html

// Compile
// javac -d . *.java

// Create jar file
// https://docs.oracle.com/javase/tutorial/deployment/jar/downman.html

// jar cfm CarTrain.jar META-INF/MANIFEST.MF com

// jar cfm CarTrain.jar META-INF/MANIFEST.MF -C com/javaproblems/inheritance/ . -C com/javaproblems/vehicles .

// Execute 
// java -jar CarTrain.jar

package com.javaproblems.inheritance;

import com.javaproblems.vehicles.*;

public class CarTrainTest {

	public static void main(String args[]) {

		Engine engine1 = new Engine("150511", 2000);
		Engine engine2 = new Engine("151211", 3000);
		Engine engine3 = new Engine("150911", 4000);
		Engine engine4 = new Engine("151515", 5000);

		Body body1 = new Body(2.3, 1.2, 2, 2000);
		Body body2 = new Body(2.6, 1.5, 4, 3000);
		Body body3 = new Body(20.3, 3.2, 50, 4000);
		Body body4 = new Body(30.3, 3.2, 70, 5000);

		Vehicle vehicles[] = new Vehicle[4];

		vehicles[0] = new Car("Company1", "Car1", engine1, body1, 10000, 2, "Manual", 500);
		vehicles[1] = new Car("Company2", "Car2", engine2, body2, 20000, 4, "Automatic", 400);
		vehicles[2] = new Train("Company1", "Train1", engine3, body3, 50000, 10, "Coal", 200);
		vehicles[3] = new Train("Company2", "Train2", engine4, body4, 100000, 20, "Electricity", 300);

		for (int i = 0; i < vehicles.length; i++) {
			if (vehicles[i] instanceof Train) {

				Train currentVehice = (Train) vehicles[i];
				System.out.println(currentVehice.toString());

			} else {

				Car currentVehice = (Car) vehicles[i];
				System.out.println(currentVehice.toString());

			}
		}
	}
}
