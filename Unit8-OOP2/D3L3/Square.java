public class Square implements ShapeBuilder {
  double side;
  double area;
  double peri;

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
  public void getArea() {
    System.out.println(area);
  }
  public void getPeri() {
    System.out.println(peri);
  }
}
