class Rectangle implements ShapeBuilder {
  double height;
  double width;
  double area;
  double peri;

  public Rectangle(double newHeight, double newWidth) {
    this.height = newHeight;
    this.width = newWidth;
    this.area = calcArea();
    this.peri = calcPeri();
  }

  public double calcArea() {
    return this.height*this.width;
}

  public double calcPeri() {
    return this.height*2 + this.width*2;
  }
  public void getArea() {
    System.out.println(area);
  }
  public void getPeri() {
    System.out.println(peri);
  }
}
