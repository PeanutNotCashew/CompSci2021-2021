import java.lang.Math;

public class Triangle extends Shape {
  double side1;
  double side2;
  double side3;

  public Triangle(double s1, double s2, double s3){
    side1 = s1;
    side2 = s2;
    side3 = s3;
    calcPeri();
    calcArea();
  }

  public void calcPeri(){
    peri = side1 + side2 + side3;
  }

  public void calcArea(){ //Heron's formula
    double sp = peri / 2; //semiperimeter
    area = Math.sqrt(sp * (sp - side1) * (sp - side2) * (sp - side3));
  }
}