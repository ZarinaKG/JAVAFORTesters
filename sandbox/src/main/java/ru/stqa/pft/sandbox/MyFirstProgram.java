package ru.stqa.pft.sandbox;

public class MyFirstProgram {
	
	public static  void main(String[] args){
		/* Square s = new Square(5);
		 Rectangle r = new Rectangle(10,20); */
		
		 Point p1 = new Point(2,2);
		 Point p2 = new Point(7,6);
		System.out.println("Point1 : x "+p1.a+" y: "+p1.b);
		System.out.println("Point2 : x "+p2.a+" y: "+p2.b);
		System.out.println("Distance between P1 and P2: "+p1.calculateDistance(p2));
	}
}