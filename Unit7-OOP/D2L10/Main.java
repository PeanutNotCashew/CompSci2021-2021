class Main {
  public static void main(String[] args) {
    Manager Meirion = new Manager("Meirion", 30);
    Manager Emiliana = new Manager("Emiliana", 25);
    Manager Hamon = new Manager("Hamon", 25);
    Manager Anna = new Manager("Emiliana", 22);
    
    Employee Naama = new Employee("Naama", 20);
    Employee Mukesh = new Employee("Mukesh", 18);
    Employee Vitilsav = new Employee("Vitilsav", 16);
    Employee Padma = new Employee("Padma", 15);
    Employee Anacletus = new Employee("Anacletus", 14);
    Employee Martino = new Employee("Martino", 12);
    Employee Blair = new Employee("Blair", 12);
    Employee Mani = new Employee("Mani", 12);
    Employee Laszlo = new Employee("Laszlo", 12);
    Employee Herminius = new Employee("Herminius", 12);
    Employee Shprintza = new Employee("Shprintza", 12);
    Employee Aten = new Employee("Aten", 12);
    Employee LaShawn = new Employee("LaShawn", 11);
    Employee Ula = new Employee("Ula", 11);
    Employee Ascelin = new Employee("Ascelin", 11);
    Employee Spela = new Employee("Spela", 10);

    Meirion.print();
    Emiliana.print();
    Hamon.print();
    Anna.print();

    Naama.print(35, 5);
    Mukesh.print(28, 10);
    Vitilsav.print(48, 0);
    Padma.print(20, 20);
    Anacletus.print(35, 12);
    Martino.print(10, 0);
    Blair.print(24, 12);
    Mani.print (35, 0);
    Laszlo.print(28, 0);
    Herminius.print(35, 0);
    Shprintza.print(40, 10);
    Aten.print(35, 20);
    LaShawn.print(20, 0);
    Ula.print(16, 0);
    Ascelin.print(13, 0);
    Spela.print(15, 0);
  }
}
