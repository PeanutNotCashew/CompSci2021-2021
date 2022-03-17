import java.util.Random;
import java.util.Scanner;

class Student {
  public String fname;
  public String lname;
  public int grade;
  public String present;

  public void Student(String setFname, String setLname) {
    Random rand = new Random();
    int i = rand.nextInt(30);
    int setGrade = rand.nextInt(11) + 1;

    this.fname = setFname;
    this.lname = setLname;
    this.grade = setGrade;
    if (i == 1) {
      this.present = "Absent";
    } else if (1 < i && i < 4) {
      this.present = "Late";
    } else {
      this.present = "Present";
    }
  }

  public void Student(String setFname, String setLname, int setGrade) {
    Random rand = new Random();
    int i = rand.nextInt(30);

    this.fname = setFname;
    this.lname = setLname;
    this.grade = setGrade;
    if (i == 1) {
      this.present = "Absent";
    } else if (1 < i && i < 4) {
      this.present = "Late";
    } else {
      this.present = "Present";
    }
  }

  public void changeAttendance() {
    Scanner input = new Scanner(System.in);

    System.out.println("\n" + this.fname + " " + this.lname);
    System.out.print("Change status (A/L/P): ");
    String i = input.nextLine();

    if (i == "A") {
      this.present = "Absent";
    } else if (i == "L") {
      this.present = "Late";
    } else if (i == "P") {
      this.present = "Present";
    } else {
      System.out.println("Error: Incorrect input");
    }
  }

  public int returnAttendance() {
    int i = 0;
    if (this.present == "Present") {
      i = 0;
    } else if (this.present == "Late") {
      i = 1;
    } else if (this.present == "Absent") {
      i = 2;
    }
    return i;
  }

  public String print() {
    String fullName = this.fname + " " + this.lname;
    String strGrade = Integer.toString(this.grade);
    return fullName + " (" + strGrade + ") : " + this.present;
  }

}
