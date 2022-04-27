abstract class Shape {
  double area;
  double peri;

  abstract double calcArea();
  abstract double calcPeri();
  void getArea() {
    System.out.println(area);
  }
  void getPeri() {
    System.out.print(peri);
  }
}
