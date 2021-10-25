package activities;

class Car {

	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	//Constructor
	 Car() {
		tyres = 4;
		doors = 4;
	}
	public void displayCharacteristics() {
		System.out.println("Color of the Car: "+ color);
		System.out.println("transmission of the Car: "+ transmission);
		System.out.println("make of Car: "+ make);
		System.out.println("Number of tyres: "+ tyres);
		System.out.println("Number of doors: "+ doors);
	}
	public void accelatate() {
		System.out.println("Car is moving forward.");
	}
	public void brake () {
		System.out.println("Car has stopped.");
	}
}
