class Main {
  public static void main(String[] args) {
    Circle c1 = new Circle(10);
    Circle c2 = new Circle(7.2);
    Square s1 = new Square(4);
    Square s2 = new Square (2.4);
    Rectangle r1 = new Rectangle(8, 4);
    Rectangle r2 = new Rectangle(4.2, 0.5);

    System.out.println("\nCircles:");
    c1.getArea();
    c1.getPeri();
    c2.getArea();
    c2.getPeri();
    System.out.println("\nSquares:");
    s1.getArea();
    s1.getPeri();
    s2.getArea();
    s2.getPeri();
    System.out.println("\nRectangles:");
    r1.getArea();
    r1.getPeri();
    r2.getArea();
    r2.getPeri();
  }
}
