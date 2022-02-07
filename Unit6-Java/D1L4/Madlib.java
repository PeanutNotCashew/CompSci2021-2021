import java.util.Scanner;

class Madlib{
  public static void main(String[] args) {
    //Establishes variables
    String word1 = "_1_";
    String word2 = "_2_";
    String word3 = "_3_";
    String word4 = "_4_";

    //Prints Madlib
    System.out.println("Once there was a " + word1 + ". The " + word1 + " was very " + word2 + ". It jumped on the top of a(n) " + word3 + ". On the top of the " + word3 + ", it " + word4 + ".");

    //User inputs
    Scanner wordInput = new Scanner(System.in);

    System.out.println("Enter word 1:");
    word1 = wordInput.nextLine();

    System.out.println("Enter word 2:");
    word2 = wordInput.nextLine();

    System.out.println("Enter word 3:");
    word3 = wordInput.nextLine();

    System.out.println("Enter word 4:");
    word4 = wordInput.nextLine();

    //Prints complete Madlib
    System.out.println("Once there was a " + word1 + ". The " + word1 + " was very " + word2 + ". It jumped on the top of a(n) " + word3 + ". On the top of the " + word3 + ", it " + word4 + ".");
  }
}
