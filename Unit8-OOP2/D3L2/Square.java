public class Square extends Shape{
  double side;

  public Square(double newSide) {
    this.side = newSide;
    this.area = calcArea();
    this.peri = calcPeri();
  }

  public double calcArea() {
    return this.side*this.side;
  }
  public double calcPeri() {
    return this.side*4;
  }
}
