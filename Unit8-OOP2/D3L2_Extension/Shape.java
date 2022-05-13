abstract class Shape {
  protected double area; // stores the shape's area
  protected double peri; // stores the shape's perimeter

  public abstract void calcArea(); // calculates the area
  public abstract void calcPeri(); // calculates the perimeter

  public double getArea(){
    return area;
  }
  public double getPeri(){
    return peri;
  }
}