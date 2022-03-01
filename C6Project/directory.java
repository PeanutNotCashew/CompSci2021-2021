import java.util.ArrayList;

class directory{
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
    }

  }
}

//https://coderanch.com/t/628589/java/create-objects-loop
