import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class main {
  public static void main(String[] args) {
    String[] studentInit = {"Patrick", "Camilla", "Jeremiah", "Petra", "Niki", "Tenzin", "Valentina", "Jules", "Nicholas", "Aly"};
    ArrayList<String> studentAL = new ArrayList<String>();
    LinkedList<String> studentLL = new LinkedList<String>();

    for (int i = 0; i < studentInit.length; i++) {
      studentAL.add(studentInit[i]);
      studentLL.add(studentInit[i]);
    }

    long start = System.currentTimeMillis();
    methodsAL(studentAL);
    long end = System.currentTimeMillis();
    long totalTime = end - start;
    System.out.print("Milliseconds elapsed: ");
    System.out.println(totalTime);

    start = System.currentTimeMillis();
    methodsLL(studentLL);
    end = System.currentTimeMillis();
    totalTime = end - start;
    System.out.print("Milliseconds elapsed: ");
    System.out.println(totalTime);
  }

  public static void methodsAL(ArrayList<String> array) {
    Scanner scan = new Scanner(System.in);

    System.out.println("\n AL:");

    System.out.println("Adding name");
    array.add("placeholder");
    System.out.println(array);

    System.out.println("Removing object");
    array.remove(5);
    System.out.println(array);

    System.out.println("Sorting array");
    sortAL(array);
    System.out.println(array);
  }

  public static void methodsLL(LinkedList<String> array) {
    Scanner scan = new Scanner(System.in);

    System.out.println("\n LL:");

    System.out.println("Adding name");
    array.add("placeholder");
    System.out.println(array);

    System.out.println("Removing object");
    array.remove(5);
    System.out.println(array);

    System.out.println("Sorting array");
    sortLL(array);
    System.out.println(array);
  }

  public static void sortAL(ArrayList<String> array) {
    for (int i=0; i<array.size(); i++){
      for(int j=1; j<array.size()-i; j++) {
        int k = j-1;
        if(array.get(j-1).compareToIgnoreCase(array.get(j)) > 0){
          array.add(j-1, array.get(j));
          array.remove(j+1);
        }
      }
    }
  }

  public static void sortLL(LinkedList<String> array) {
    for (int i=0; i<array.size(); i++){
      for(int j=1; j<array.size()-i; j++) {
        int k = j-1;
        if(array.get(j-1).compareToIgnoreCase(array.get(j)) > 0){
          array.add(j-1, array.get(j));
          array.remove(j+1);
        }
      }
    }
  }

}
