class Manager extends Employee {

  public Manager(String newName, int newWage) {
    super(newName,newWage);
  }

  public int getPaycheck() {
    int paycheck = this.wage * 40;
    return paycheck;
  }

  public void print() {
    String strWage = Integer.toString(this.wage);
    String paycheck = Integer.toString(this.getPaycheck());

    System.out.println("Manager- " + this.name + ": \n Hourly: " + strWage + ",\n This week: " + paycheck);
  }
}
