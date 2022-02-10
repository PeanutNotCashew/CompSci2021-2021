import java.util.Scanner;

class Loop {
  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);

    System.out.println("Enter text:");
    String output = userInput.nextLine();

    for (int i = 1; i <= 5000; i++) {
      System.out.println(i + ". " + output);
    }
  }
}
