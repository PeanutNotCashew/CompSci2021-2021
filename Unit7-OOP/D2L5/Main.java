import java.util.LinkedList;

class Main {
  public static void main(String[] args) {
    String[] initFnames = {"Arshiah", "Omar", "Otto", "Aunirbhan", "Malak", "Jeremiah", "Matthew", "Camilla", "Drishya", "Kate"};
    String[] initLnames = {"Ahmed", "Badr", "Cline", "Das", "Elkhadragy", "Farnum", "Gomez", "Hajallie", "Karki", "Lee"};
    LinkedList<Student> roster = new LinkedList<Student>();

    for (int i = 0; i < initFnames.length; i++) {
      roster.add(i, new Student());
      roster.get(i).Student(initFnames[i], initLnames[i]);
    }

    for (int i = 0; i < roster.size(); i++) {
      System.out.println(roster.get(i).print());
    }

    takeAttendance(roster);

  }

  public static void takeAttendance(LinkedList<Student> roster) {
    int absent = 0;
    int late = 0;

    for (int i = 0; i < roster.size(); i++) {
      int j = roster.get(i).returnAttendance();
      if (j == 1) {
        late++;
      } else if (j == 2) {
        absent++;
      }
    }
    
    System.out.println();
    System.out.println("Absent: " + Integer.toString(absent));
    System.out.println("Late: " + Integer.toString(late));
  }

}
