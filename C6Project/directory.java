import java.util.ArrayList;
import java.util.Scanner;

class directory{
  //sorts students alphabetically by last name
  public static void bubbleSort(ArrayList<Student> arrayName) {
    ArrayList<Student> array = new ArrayList<Student>();
    Student temp;

    for (int i = 0; i < arrayName.size(); i++) {
      array.add(arrayName.get(i));
    }

    for (int i = 0; i < array.size(); i++){
      for(int j = 1; j < array.size()-i; j++) {
        int k = j-1;
        if(array.get(k).lastName.compareToIgnoreCase(array.get(j).lastName) > 0){
          temp = array.get(k);
          array.set(k, array.get(j));
          array.set(j, temp);
        }
      }
    }

    printStudents(array);
    array = null;
  }

  //prints list of students
  public static void printStudents(ArrayList<Student> arrayName) {
    System.out.println("");
    for (int i = 0; i < arrayName.size(); i++) {
      System.out.println(arrayName.get(i).studentInfo());
    }
  }

  //finds student by last name
  public static int linearSearch(String toFind, ArrayList<Student> arrayName){
    for (int i = 0; i < arrayName.size(); i++) {
      if (toFind.compareToIgnoreCase(arrayName.get(i).lastName) == 0) {
        return i;
      }
    }
    return -1;
  }

  //creates student objects and adds to array
  public static void enterName(ArrayList<Student> arrayName) {
    Scanner nameInput = new Scanner(System.in);

    //gets inputs (name, grade, index)
    System.out.print("Enter last name: ");
    String lname = nameInput.nextLine();
    System.out.print("Enter first name: ");
    String fname = nameInput.nextLine();
    System.out.print("Enter grade (if N/a enter -1): ");
    String gradeNum = nameInput.nextLine();
    int grade = Integer.parseInt(gradeNum);
    System.out.print("Enter position (if N/a enter -1): ");
    String posNum = nameInput.nextLine();
    int position = Integer.parseInt(posNum);

    //adds name
    int i;
    if (position == -1) {
      i = arrayName.size();
    } else {
      i = position;
    }
    arrayName.add(i, new Student());
    arrayName.get(i).Student(fname, lname, grade);
  }

  //for-loop that allows user to add grades
  public static void enterAllGrades(ArrayList<Student> arrayName) {
    for (int i = 0; i < arrayName.size(); i++) {
      arrayName.get(i).changeGrade();
    }
  }


  public static void chooseAction(ArrayList<Student> arrayName) {
    Scanner actionInput = new Scanner(System.in);
    Scanner nameInput = new Scanner(System.in);

    //interface
    System.out.println("\nActions: \n Add student (1) \n Print all students (2) \n Enter grades (3) \n Exit (4) \n");
    System.out.print("Select action: ");
    String selectedAction = actionInput.nextLine();

    //adds student
    if (selectedAction.compareTo("1") == 0) {
      enterName(arrayName);

    //prints students
    } else if (selectedAction.compareTo("2") == 0) {
      System.out.println("\nChoose an action: ");
      System.out.println(" Print list (1) \n Print alphabetized (2)");
      selectedAction = actionInput.nextLine();

      if (selectedAction.compareTo("1") == 0) {
        printStudents(arrayName);
      } else if (selectedAction.compareTo("2") == 0) {
        bubbleSort(arrayName);
      } else {
        System.out.println("Improper input.");
      }

    //enters grades
    } else if (selectedAction.compareTo("3") == 0) {
      System.out.println("\nChoose an action: ");
      System.out.println(" Change student (1) \n Change all (2)");
      selectedAction = actionInput.nextLine();

      //change individual student
      if (selectedAction.compareTo("1") == 0) {
        System.out.print("Last name of student: ");
        String name = nameInput.nextLine();
        int studentPosition = linearSearch(name, arrayName);
        if (studentPosition == -1) {
          System.out.println("Error: This student does not exist.");
        } else {
          arrayName.get(studentPosition).changeGrade();
        }
      //change all grades
      } else if (selectedAction.compareTo("2") == 0) {
        enterAllGrades(arrayName);
      } else {
        System.out.println("Incorrect input.");
      }

    //exits program
    } else if (selectedAction.compareTo("4") == 0) {
      System.exit(0);

    //error message
    } else {
      System.out.println("Please enter a number.");
    }
    chooseAction(arrayName);
  }


  public static void main(String[] args) {
    //starting students
    String[] initFnames = {"Marcel", "Todd", "Stefan", "Kaia", "Gary", "Bobbi", "Jay-Jay", "Kenny", "Jovan", "Gracie-Mae", "Kealan", "Callum", "Maverick", "Anisah", "Ritchie", "Danial", "Malika", "Shelbie", "Henna", "Kajol", "Leigha", "Jordanne", "Karan", "Libbie", "Rita", "Paulina", "Alishba", "Nichole", "Joel", "Myrtle", "Arianne", "Sheikh", "Lillie-May", "Mustafa", "Ryder", "Blade", "Afsana", "Wayne", "Burhan", "Atticus", "Dafydd", "Shani", "Angharad", "Habiba", "Coby", "Travis", "Kristian", "Nakita", "Kirk", "Skyla", "Shauna", "Abdurrahman", "Wasim", "Terry", "Ed", "Cheyenne", "Kimberly", "Melissa", "Ilayda", "Fathima", "Salma", "Hakim", "Safaa", "Regan", "Maizie", "Faiza", "Norah", "Kristopher", "Elisha", "Janice", "Ahmet", "Sofie", "Natalie", "Inara", "Cai", "Anthony", "Daanyaal", "Aryaan", "Harley", "Humza", "Luka", "Ranveer", "Tanya", "Grover", "Becky", "Eamonn", "Walter", "Rosemary", "Yousef", "Vinny", "Trystan", "Rimsha", "Misha", "Alison", "Jamel", "Thalia", "Jacob", "Krista", "Mari", "Vinay"};
    String[] initLnames = {"Green", "Muir", "Pratt", "Bull", "Rossi", "Aguilar", "Stephens", "Barton", "Iles", "Roche", "Smyth", "Mata", "Herman", "Steele", "Sawyer", "Wolf", "Francis", "Mccartney", "Downes", "Decker", "Pruitt", "Soto", "Mueller", "Mcguire", "Stephenson", "Redfern", "Cairns", "Gross", "Sosa", "Chester", "Roberson", "Weeks", "Flowers", "Benitez", "Vu", "Woods", "Merritt", "Manning", "Booker", "Pearson", "Mccallum", "Bowen", "Spears", "Bartlett", "Velez", "Barlow", "Greenaway", "Armstrong", "Freeman", "Rosa", "Sims", "Dunne", "Reyna", "Bowden", "Mac", "Kearns", "Lozano", "Lott", "Bates", "Mcculloch", "Beck", "Newman", "Bernard", "Burris", "Whyte", "Guy", "Choi", "Blair", "Logan", "Lane", "Erickson", "Knott", "Aldred", "Naylor", "Clarke", "Smith", "Moon", "Mcmanus", "Wilde", "Hamer", "Maddox", "Pena", "Rose", "Hutchinson", "Mansell", "Barnard", "Lugo", "Ryan", "Donnelly", "Noble", "Mercer", "Olson", "Villanueva", "Wilson", "Wilkerson", "Head", "Hewitt", "Thomas", "Gilbert", "Hayden"};

    //creates arraylist with all student classes
    ArrayList<Student> studentArray = new ArrayList<Student>();
    for (int i = 0; i < initFnames.length; i++) {
      studentArray.add(i, new Student());
      studentArray.get(i).Student(initFnames[i], initLnames[i], -1);
    }

    chooseAction(studentArray);

  }
}
