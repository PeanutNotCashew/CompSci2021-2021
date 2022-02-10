import java.util.Scanner;

class Loop {
  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);

    System.out.println("Enter text:");
    String output = userInput.nextLine();
    System.out.println("Enter repetitions:");
    int repetitions = Integer.parseInt(userInput.nextLine());

    for (int i = 1; i <= repetitions; i++) {
      System.out.println(i + ". " + output);
    }
  }
}
