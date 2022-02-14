import java.util.ArrayList;

class names{
  public static void main(String[] args) {

    //creates array with class names
    String[] classArray = {"Arshiah", "Ahad", "Omar", "Jesse", "Anamaria", "Steve", "Otto", "Aunirbhan", "Prisha", "Bhavi", "Malak", "Eleanor", "Jeremiah", "Ace", "Petra", "Matthew", "Camilla", "Drishya", "Kate", "Leo", "Sophia", "Stephen", "Ioannis", "Angelina", "Mennaallah", "Fatima", "Tenzin", "Nabeel", "Valentina", "Martyna", "Abhijit", "Patrick", "Haocheng"};

    //creates array list
    ArrayList<String> classList = new ArrayList<String>();

    //for-each loop that adds names to array list
    for (String i : classArray) {
      classList.add(i);
    }

    //prints contents of arrays
    //find 3rd parameter on line 22
    for (int i=0; i < classArray.length;) {
      System.out.print(classArray[i]);
      //additional formatting
      if (++i != classArray.length) {
        System.out.print(", ");
      } else {
        System.out.print("\n");
      }
    }

    System.out.println(classList);
  }
}
