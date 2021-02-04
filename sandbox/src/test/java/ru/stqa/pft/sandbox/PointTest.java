package ru.stqa.pft.sandbox;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

  @Test
  public void checkCalculateDistancePositiveTest(){

    Point p1 = new Point(5,25);
    Point p2 = new Point(6,36);
    Assert.assertEquals(p1.calculateDistance(p2),11,0.5);
     p1 = new Point(10,10);
     p2 = new Point(10,5);
    Assert.assertEquals(p1.calculateDistance(p2),5.0,0);

  }

  @Test
  public void checkCalculateDistanceNegativeTest(){

    Point p1 = new Point(-1,0);
    Point p2 = new Point(-9,0);
    Assert.assertNotEquals(p1.calculateDistance(p2),18,0);
    p1 = new Point(-1,10);
    p2 = new Point(6,5);
    Assert.assertNotEquals(p1.calculateDistance(p2),28,0.6);

  }
}
