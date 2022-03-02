import java.util.Scanner;

public class Student{
  public String firstName;
  public String lastName;
  public String grade;

  public void Student(String fname, String lname, int sgrade) {
    this.firstName = fname;
    this.lastName = lname;
    if (sgrade == -1) {
      this.grade = "N/a";
    } else {
      this.grade = Integer.toString(sgrade);
    }
  }

  public String studentInfo() {
    return this.firstName + " " + this.lastName + ": " + this.grade;
  }

  public void changeGrade() {
    Scanner gradeInput = new Scanner(System.in);

    System.out.println("\n" + this.firstName + " " + this.lastName);
    System.out.println("Current grade: " + this.grade);
    System.out.print("New grade: ");
    String newGrade = gradeInput.nextLine();

    this.grade = newGrade;
  }
}
