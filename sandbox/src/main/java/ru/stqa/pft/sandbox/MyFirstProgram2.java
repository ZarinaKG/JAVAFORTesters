package ru.stqa.pft.sandbox;

public class MyFirstProgram2 {
	
	public static  void main(String[] args){
			double l=5.0;
			double a = 10;
			double b = 25;
			System.out.println("Ploshad kvadrata:"+l+ " Ploshad:" +area(l));
			System.out.println("Ploshad prjamougolnika so storonami "+a+ "i "+b+" Ploshad: " +area(a,b));
	}

	public static double area(double len){
		return len*len;
	}

	public static double area(double a, double b){
		return a*b;
	}

}