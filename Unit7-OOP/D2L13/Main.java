import java.util.Scanner;

class Main{
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    double fahrenheit;
    double celcius;

    System.out.print("Enter a temperature in fahrenheit (num): ");

    try {
      fahrenheit = Double.parseDouble(input.nextLine());
      celcius = (fahrenheit-32)*5/9;
      System.out.println("The temperature in celcius is: " + String.valueOf(celcius));

    } catch(Exception e) {
      System.out.println("Your input is not an number.");

    }

  }
}
