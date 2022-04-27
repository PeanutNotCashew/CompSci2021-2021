class Rectangle extends Shape{
  double height;
  double width;

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
}
