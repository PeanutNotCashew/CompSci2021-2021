import java.util.ArrayList;
import java.util.Scanner;

class directory{
  //creates student objects and adds to array
  public static void enterName(ArrayList<Student> arrayName) {
    Scanner nameInput = new Scanner(System.in);

    //gets inputs
    System.out.print("Enter last name: ");
    String lname = nameInput.nextLine();
    System.out.print("Enter first name: ");
    String fname = nameInput.nextLine();
    System.out.print("Enter grade (if n/a enter 0): ");
    String gradeNum = nameInput.nextLine();
    int grade = Integer.parseInt(gradeNum);

    //adds name
    int i = arrayName.size();
    arrayName.add(i, new Student());
    arrayName.get(i).Student(fname, lname, grade);
  }

  public static void main(String[] args) {
    //starting students
    String[] initFnames = {"Marcel", "Todd", "Stefan", "Kaia", "Gary", "Bobbi", "Jay-Jay", "Kenny", "Jovan", "Gracie-Mae", "Kealan"};
    String[] initLnames = {"Green", "Muir", "Pratt", "Bull", "Rossi", "Aguilar", "Stephens", "Barton", "Iles", "Roche", "Smyth"};

    //creates arraylist with all student classes
    ArrayList<Student> studentArray = new ArrayList<Student>();
    for (int i = 0; i < initFnames.length; i++) {
      studentArray.add(i, new Student());
      studentArray.get(i).Student(initFnames[i], initLnames[i], 0);
      System.out.println(studentArray.get(i).studentInfo());
      System.out.println(i);
    }
  }
}

//https://coderanch.com/t/628589/java/create-objects-loop
