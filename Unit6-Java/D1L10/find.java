import java.util.Scanner;

public class find {
  public static int linearSearch(String toFind, String[] array){
    for (int i = 0; i < array.length; i++) {
      if (toFind.compareToIgnoreCase(array[i]) == 0) {
        return i;
      }
    }
    return -1;
  }

  public static void bubbleSort(String[] array) {
    String temp;
    for (int i=0; i<array.length; i++){
      for(int j=1; j<array.length-i; j++) {
        //if out of order, switches #s
        if(array[j-1].compareToIgnoreCase(array[j]) > 0){
          temp = array[j-1];
          array[j-1] = array[j];
          array[j] = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    //declare array
    String[] classArray = {"Arshiah", "Ahad", "Omar", "Jesse", "Anamaria", "Steve", "Otto", "Aunirbhan", "Prisha", "Bhavi", "Malak", "Eleanor", "Jeremiah", "Ace", "Petra", "Matthew", "Camilla", "Drishya", "Kate", "Leo", "Sophia", "Stephen", "Ioannis", "Angelina", "Mennaallah", "Fatima", "Tenzin", "Nabeel", "Valentina", "Martyna", "Abhijit", "Patrick", "Haocheng"};
    Scanner userInput = new Scanner(System.in);

    System.out.print("Look up a name: ");
    String name = userInput.nextLine();
    int initialPosition = linearSearch(name, classArray);
    bubbleSort(classArray);
    int sortedPosition = linearSearch(name, classArray);

    if (initialPosition == -1) {
      System.out.print("Name not found");
    } else {
      System.out.println("Found at " + initialPosition + " in given array.");
      System.out.println("Found at " + sortedPosition + " in alphabetical order.");
    }
  }

}
