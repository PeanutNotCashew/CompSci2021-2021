public class Square extends Shape{
  double side;

  public Square(double s) {
    side = s;
    calcArea();
    calcPeri();
  }

  public void calcArea() {
    area = side * side;
  }
  public void calcPeri() {
    peri = side * 4;
  }
}
