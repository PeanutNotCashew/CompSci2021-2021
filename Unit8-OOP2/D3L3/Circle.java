class Circle implements ShapeBuilder {
  double radius;
  double area;
  double peri;
  final double PI = 3.1416;

  public Circle(double newRadius) {
    this.radius = newRadius;
    this.area = calcArea();
    this.peri = calcPeri();
  }

  public double calcArea() {
    return PI*this.radius*this.radius;
  }
  public double calcPeri() {
    return 2*PI*this.radius;
  }
  public void getArea() {
    System.out.println(area);
  }
  public void getPeri() {
    System.out.println(peri);
  }

}
