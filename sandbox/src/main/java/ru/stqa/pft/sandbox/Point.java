package ru.stqa.pft.sandbox;

public class Point {

  double a;
  double b;

  public Point(double a, double b){
    this.a = a;
    this.b = b;
  }

  public double calculateDistance(Point p2){

    return Math.sqrt(((p2.a-this.a)*(p2.a-this.a))+((p2.b-this.b)*(p2.b-this.b)));
  }
}
