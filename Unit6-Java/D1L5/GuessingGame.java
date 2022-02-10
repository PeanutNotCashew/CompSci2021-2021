import java.util.Scanner;

class GuessingGame{
  public static void takeAGuess(String ans, int tries) {
    if (tries < 3) {
      Scanner userInput = new Scanner(System.in);
      System.out.println("Guess #" + ++tries + "/3:");
      String guess = userInput.nextLine();

      if (guess.equals(ans)) {
        System.out.println("Your guess was correct!");
      } else {
        System.out.println("Your guess was incorrect.");
        takeAGuess(ans, tries);
      }
    } else {
      System.out.print("The answer was " + ans + ".");
    }
  }


  public static void main(String[] args) {
    int randNum = (int) (Math.random() * 10 + 1); //generates rand # from 1-10
    String answer = Integer.toString(randNum);

    takeAGuess(answer, 0);

  }
}
