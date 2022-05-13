public class Circle extends Shape {
  private double radius;
  final private double PI = 3.1416;

  public Circle(double r) {
    radius = r;
    calcArea();
    calcPeri();
  }

  public void calcArea() {
    area = PI * radius * radius;
  }

  public void calcPeri() {
    peri = 2 * PI * radius;
  }
}