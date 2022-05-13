import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Menu");
    System.out.println("===================================");
    System.out.println("1: Circle");
    System.out.println("2: Square");
    System.out.println("3: Rectangle");
    System.out.println("4: Triangle");
    System.out.println("===================================");
    System.out.print("Enter a number for your choice: ");
    int choice = input.nextInt();

    switch (choice){  
      case 1: //Circle
        System.out.print("Enter radius: ");
        double newRadius = input.nextDouble();
        Circle c = new Circle(newRadius);
        System.out.println("The area of your circle is "+ c.getArea());
        System.out.println("The perimeter of your circle is "+ c.getPeri());
        break;
      case 2: //Square
        System.out.print("Enter sidelength: ");
        double newSide = input.nextDouble();
        Square s = new Square(newSide);
        System.out.println("The area of your square is "+ s.getArea());
        System.out.println("The perimeter of your square is "+ s.getPeri());
        break;
      case 3: //Rectangle
        System.out.print("Enter width: ");
        double newWidth = input.nextDouble();
        System.out.print("Enter height: ");
        double newHeight = input.nextDouble();
        Rectangle r = new Rectangle(newHeight, newWidth);
        System.out.println("The area of your rectangle is "+ r.getArea());
        System.out.println("The perimeter of your rectangle is "+ r.getPeri());
        break;
      case 4: //Triangle
        System.out.print("Enter side one: ");
        double newSide1 = input.nextDouble();
        System.out.print("Enter side two: ");
        double newSide2 = input.nextDouble();
        System.out.print("Enter side three: ");
        double newSide3 = input.nextDouble();
        Triangle t = new Triangle(newSide1, newSide2, newSide3);
        System.out.println("The area of your rectangle is "+ t.getArea());
        System.out.println("The perimeter of your rectangle is "+ t.getPeri());
        break;
      default:
        System.out.println("You did not choose a valid option!");
        
    }

    input = null; //close resource leak
    
  }

  
}