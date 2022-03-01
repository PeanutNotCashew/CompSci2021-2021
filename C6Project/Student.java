public class Student{
  public String firstName;
  public String lastName;
  public int grade;

  public void Student(String fname, String lname, int sgrade) {
    this.firstName = fname;
    this.lastName = lname;
    this.grade = sgrade;
  }

  public String studentInfo() {
    String sgrade;
    if (this.grade == 0) {
      sgrade = "N/a";
    } else {
      sgrade = Integer.toString(this.grade);
    }

    return this.lastName + ", " + this.firstName + ": " + sgrade;
  }
}
