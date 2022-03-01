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
    //note to self: add info
    return this.firstName + " " + this.lastName;
  }
}
