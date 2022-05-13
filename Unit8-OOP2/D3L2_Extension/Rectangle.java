class Rectangle extends Shape{
  double height;
  double width;

  public Rectangle(double h, double w) {
    height = h;
    width = w;
    calcArea();
    calcPeri();
  }

  public void calcArea() {
    area = height * width;
}

  public void calcPeri() {
    peri = height * 2 + width * 2;
  }
}
