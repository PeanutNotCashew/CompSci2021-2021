import java.util.Scanner;

class Employee {
  protected int wage;
  protected String name;

  public Employee(String newName, int newWage) {
    this.name = newName;
    this.wage = newWage;
  }

  public void setWage() {
    Scanner input = new Scanner(System.in);
    System.out.print("Set wage for " + this.name + ": ");
    int newWage = Integer.parseInt(input.nextLine());

    this.wage = newWage;
  }

  public int getWage() {
    return this.wage;
  }

  public int getPaycheck(int hours, int overtime) {
    int normalWage = hours * this.wage;
    int overtimeWage = overtime * this.wage * (int)1.5;
    int paycheck = normalWage + overtimeWage;
    return paycheck;
  }

  public void print(int hours, int overtime) {
    String strWage = Integer.toString(this.wage);
    String paycheck = Integer.toString(this.getPaycheck(hours, overtime));

    System.out.println("Employee- " + this.name + ": \n Hourly: " + strWage + ",\n This week: " + paycheck);
  }

}
