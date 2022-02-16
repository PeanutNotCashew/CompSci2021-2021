public class sort {

  public static void bubbleSort(String[] array)  {
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

    //sorts
    bubbleSort(classArray);

    //prints with additional formatting
    for (int i=0; i < classArray.length;) {
      System.out.print(classArray[i]);
      if (++i != classArray.length) {
        System.out.print(", ");
      } else {
        System.out.print("\n");
      }
    }
  }
}
