import java.util.LinkedList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;


public class Calculator implements ActionListener {
  // Aesthetic variables
  Color black = new Color(34, 35, 36);
  Color darkgray = new Color(51, 52, 54);
  Color darkblue = new Color(34, 44, 85);
  Color white = new Color(232, 231, 227);
  Color green = new Color(116, 150, 98);
  Font buttonFont = new Font("Arial", Font.PLAIN, 15);
  Font textFieldFont = new Font("Arial", Font.PLAIN, 20);
  Border b = BorderFactory.createLineBorder(black);

  // GUI variables
  JFrame frame;
  JPanel panel;
  JTextField textField;
  JButton[] numberButtons = new JButton[10];
  JButton[] functionButtons = new JButton[18];
  String[] functionLabels = {"SIN", "COS", "TAN", "RAD", "SQRT", "LOG", "LN", "/", "*", "-", "+", ".", "(-)", "=", ")", "2ND", "DEL", "CLR"};

  // Functionality variables
  LinkedList<String> nums = new LinkedList<String>();
  LinkedList<String> operations = new LinkedList<String>();
  boolean second = false;
  boolean radians = false;

  public Calculator () {
    // Create frame
    frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Calculator");
    frame.setSize(470, 550);
    frame.setLayout(null);
    frame.getContentPane().setBackground(black);

    //create textfield
    textField = new JTextField();
    textField.setBounds(50, 25, 350, 50);
    textField.setEditable(false);
    textField.setBackground(green);
    textField.setFont(textFieldFont);
    textField.setBorder(b);

    //create numbers
    for (int i = 0; i < 10; i++) {
      if (i < 9) {
        numberButtons[i] = new JButton(String.valueOf(i + 1));
      } else {
        numberButtons[i] = new JButton("0");
      }
      numberButtons[i].addActionListener(this);
      numberButtons[i].setFocusable(false);
      numberButtons[i].setBackground(white);
      numberButtons[i].setFont(buttonFont);
      numberButtons[i].setBorder(b);
    }

    //create functions
    for (int i = 0; i < functionButtons.length; i++) {
      functionButtons[i] = new JButton(functionLabels[i]);
      functionButtons[i].addActionListener(this);
      functionButtons[i].setFocusable(false);
      functionButtons[i].setFont(buttonFont);
      functionButtons[i].setBorder(b);

      if ((i < 7) | (i > 13)) {
        functionButtons[i].setBackground(darkgray);
        functionButtons[i].setForeground(white);
      } else if ((i < 11) | (i == 13)) {
        functionButtons[i].setBackground(darkblue);
        functionButtons[i].setForeground(white);
      } else if (i < 13) {
        functionButtons[i].setBackground(white);
      }
    }

    //create panel for buttons
    panel = new JPanel();
    panel.setBounds(50, 100, 350, 400);
    panel.setLayout(new GridLayout(8, 4, 10, 10));
    panel.setBackground(black);

    //add buttons
    panel.add(functionButtons[0]);
    panel.add(functionButtons[1]);
    panel.add(functionButtons[2]);
    panel.add(functionButtons[3]);
    panel.add(functionButtons[4]);
    panel.add(functionButtons[5]);
    panel.add(functionButtons[6]);
    panel.add(functionButtons[7]);
    panel.add(numberButtons[0]);
    panel.add(numberButtons[1]);
    panel.add(numberButtons[2]);
    panel.add(functionButtons[8]);
    panel.add(numberButtons[3]);
    panel.add(numberButtons[4]);
    panel.add(numberButtons[5]);
    panel.add(functionButtons[9]);
    panel.add(numberButtons[6]);
    panel.add(numberButtons[7]);
    panel.add(numberButtons[8]);
    panel.add(functionButtons[10]);
    panel.add(numberButtons[9]);
    panel.add(functionButtons[11]);
    panel.add(functionButtons[12]);
    panel.add(functionButtons[13]);
    panel.add(functionButtons[14]);
    panel.add(functionButtons[15]);
    panel.add(functionButtons[16]);
    panel.add(functionButtons[17]);

    frame.add(panel);
    frame.add(textField);

    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    // Number buttons (0-9)
    for (int i = 0; i < 10; i++) {
      if (e.getSource() == numberButtons[i]) {
        if(nums.size() != operations.size()){
          int j = nums.size() - 1;
          String appendText = nums.get(j).concat(numberButtons[i].getText());
          nums.set(j, appendText);
        } else {
          String appendText = numberButtons[i].getText();
          nums.add(appendText);
        }
      }
    }

    // Radian toggle
    if (e.getSource() == functionButtons[3]) {
      if (radians == false) {
        radians = true;
        functionButtons[3].setText("DEG");
      } else {
        radians = false;
        functionButtons[3].setText("RAD");
      }
    }

    // Basic functions (+, -, *, /)
    for (int i = 7; i < 11; i++) {
      if (e.getSource() == functionButtons[i]) {
        if (nums.size() != operations.size()) {
          String appendText = functionLabels[i];
          operations.add(appendText);
        }
      }
    }

    // Advanced functions
    for (int i = 0; i < 3; i++) {
      if (e.getSource() == functionButtons[i]) {
        String appendText = functionButtons[i].getText();
        if (nums.size() != operations.size()) {
          operations.add("*");
          nums.add("n/a");
          operations.add(appendText);
          nums.add("(");
          operations.add("n/a");
        } else {
          nums.add("n/a");
          operations.add(appendText);
          nums.add("(");
          operations.add("n/a");
        }
      }
    }

    for (int i = 4; i < 7; i++) {
      if (e.getSource() == functionButtons[i]) {
        String appendText = functionButtons[i].getText();
        if (nums.size() != operations.size()) {
          if ((second != true) | (i != 4)) {
            operations.add("*");
            nums.add("n/a");
          }
          operations.add(appendText);
          nums.add("(");
          operations.add("n/a");
        } else {
          if ((second != true) | (i != 4)) {
            nums.add("n/a");
            operations.add(appendText);
            nums.add("(");
            operations.add("n/a");
          }
        }
      }
    }

    // Period
    if (e.getSource() == functionButtons[11]) {
      if (nums.size() != operations.size()) {
        int j = nums.size() - 1;
        String appendText = nums.get(j).concat(".");
        nums.set(j, appendText);
      } else {
        nums.add("0.");
      }
    }

    // Negative
    if (e.getSource() == functionButtons[12]) {
      if (nums.size() == operations.size()) {
        nums.add("-");
      }
    }

    // Equals
    if (e.getSource() == functionButtons[13]) {
      boolean evaluateable;
      String output = "0";

      if (nums.size() != operations.size()) {
        try {
          evaluateable = evaluate(0, operations.size());
        } catch(Exception f) {
          evaluateable = false;
        }
      } else {
        evaluateable = false;
      }

      if (evaluateable == true) {
        output = nums.get(0);
      } else {
        output = "ERROR";
      }
      textField.setText(output);

      while (nums.size() > 0) {
        nums.remove();
      }
      while (operations.size() > 0) {
        operations.remove();
      }

    }

    // Parenthesis
    if (e.getSource() == functionButtons[14]) {
      if (second == false) {
        if (nums.size() != operations.size()) {
          operations.add("n/a");
          nums.add(")");
        }
      } else {
        if ((nums.size() != operations.size()) && (nums.size() != 0)) {
          operations.add("*");
        }
        nums.add("(");
        operations.add("n/a");
      }
    }

    // 2ND
    if (e.getSource() == functionButtons[15]) {
      if (second == true) {
        second = false;
        functionButtons[0].setText("SIN");
        functionButtons[1].setText("COS");
        functionButtons[2].setText("TAN");
        functionButtons[4].setText("SQRT");
        functionButtons[5].setText("LOG");
        functionButtons[6].setText("LN");
        functionButtons[14].setText(")");

      } else {
        second = true;
        functionButtons[0].setText("SIN^-1");
        functionButtons[1].setText("COS^-1");
        functionButtons[2].setText("TAN^-1");
        functionButtons[4].setText("^");
        functionButtons[5].setText("10^");
        functionButtons[6].setText("e^");
        functionButtons[14].setText("(");
      }
    }

    // DEL
    if (e.getSource() == functionButtons[16]) {
      int place = nums.size() - 1;

      if (nums.size() == 0) {
        //do nothing
      } else if (nums.size() != operations.size()) {
        String initialStr = nums.get(place);
        String output = initialStr.substring(0, initialStr.length() - 1);
        if (output == "") {
          nums.remove(place);
        } else {
          nums.set(place, output);
        }
      } else {
        operations.remove(place);
      }
    }

    // CLR
    if (e.getSource() == functionButtons[17]) {
      while (nums.size() > 0) {
        nums.remove();
      }
      while (operations.size() > 0) {
        operations.remove();
      }
    }

    if (e.getSource() != functionButtons[13]) {
      print();
    }

    /* For testing bugs:
    System.out.print(nums);
    System.out.println(operations);
    */
  }

  public boolean evaluate(int start, int end) {
    int i;

    //eval paren
    i = 0;
    while (i != -1) {
      i = getEndParen(start, end);
      if (i != -1) {
        int j = getStartParen(i);
        if (j != -1) {
          evaluate(j + 1, i - 1);

          // delete xtra parens
          operations.remove(j);
          operations.remove(j);
          nums.remove(j);
          nums.remove(j + 1);
          end = nums.size() - 1;

          // eval for special functions
          double input;
          String output;
          switch (operations.get(j - 1)) {
            case "SIN":
              if (radians == true) {
                input = Double.valueOf(nums.get(j));
              } else {
                input = Math.toRadians(Double.valueOf(nums.get(j)));
              }
              output = String.valueOf(Math.sin(input));
              nums.set(j - 1, output);
              operations.remove(j - 1);
              nums.remove(j);
              end --;
              break;
            case "COS":
              if (radians == true) {
                input = Double.valueOf(nums.get(j));
              } else {
                input = Math.toRadians(Double.valueOf(nums.get(j)));
              }
              output = String.valueOf(Math.cos(input));
              nums.set(j - 1, output);
              operations.remove(j - 1);
              nums.remove(j);
              end --;
              break;
            case "TAN":
              if (radians == true) {
                input = Double.valueOf(nums.get(j));
              } else {
                input = Math.toRadians(Double.valueOf(nums.get(j)));
              }
              output = String.valueOf(Math.tan(input));
              nums.set(j - 1, output);
              operations.remove(j - 1);
              nums.remove(j);
              end --;
              break;
            case "SQRT":
              input = Double.valueOf(nums.get(j));
              output = String.valueOf(Math.sqrt(input));
              nums.set(j - 1, output);
              operations.remove(j - 1);
              nums.remove(j);
              end --;
              break;
            case "LOG":
              input = Double.valueOf(nums.get(j));
              output = String.valueOf(Math.log10(input));
              nums.set(j - 1, output);
              operations.remove(j - 1);
              nums.remove(j);
              end --;
              break;
            case "LN":
              input = Double.valueOf(nums.get(j));
              output = String.valueOf(Math.log(input));
              nums.set(j - 1, output);
              operations.remove(j - 1);
              nums.remove(j);
              end --;
              break;
            case "SIN^-1":
              if (radians == true) {
                input = Double.valueOf(nums.get(j));
              } else {
                input = Math.toRadians(Double.valueOf(nums.get(j)));
              }
              output = String.valueOf(Math.asin(input));
              nums.set(j - 1, output);
              operations.remove(j - 1);
              nums.remove(j);
              end --;
              break;
            case "COS^-1":
              if (radians == true) {
                input = Double.valueOf(nums.get(j));
              } else {
                input = Math.toRadians(Double.valueOf(nums.get(j)));
              }
              output = String.valueOf(Math.acos(input));
              nums.set(j - 1, output);
              operations.remove(j - 1);
              nums.remove(j);
              end --;
              break;
            case "TAN^-1":
              if (radians == true) {
                input = Double.valueOf(nums.get(j));
              } else {
                input = Math.toRadians(Double.valueOf(nums.get(j)));
              }
              output = String.valueOf(Math.atan(input));
              nums.set(j - 1, output);
              operations.remove(j - 1);
              nums.remove(j);
              end --;
              break;
            case "^":
              input = Double.valueOf(nums.get(j));
              Double inputTwo = Double.valueOf(nums.get(j-1));
              output = String.valueOf(Math.pow(inputTwo, input));
              nums.set(j - 1, output);
              operations.remove(j - 1);
              nums.remove(j);
              end --;
              break;
            case "10^":
              input = Double.valueOf(nums.get(j));
              output = String.valueOf(Math.pow(10, input));
              nums.set(j - 1, output);
              operations.remove(j - 1);
              nums.remove(j);
              end --;
              break;
            case "e^":
              input = Double.valueOf(nums.get(j));
              output = String.valueOf(Math.exp(input));
              nums.set(j - 1, output);
              operations.remove(j - 1);
              nums.remove(j);
              end --;
              break;
          }

        } else {
          return false;
        }
      }

      if ((i == -1) && (getStartParen(end) != -1)) {
        return false;
      }
    }

    //eval multiplication & division
    i = 0;
    while (i != -1) {
      i = linearSearch("*", start, end);
      int placeholder = linearSearch("/", start, end);
      boolean divide = false;
      float output;

      //decides whether multiplication of division occurs 1st
      if (((i > placeholder) && (placeholder != -1)) | (i == -1)) {
        i = placeholder;
        divide = true;
      }

      //carries out operations and deletes xtra array spaces
      if (i != -1) {
        float num1 = Float.valueOf(nums.get(i));
        float num2 = Float.valueOf(nums.get(i + 1));

        if (divide == false) {
          output = num1 * num2;
        } else {
          output = num1 / num2;
        }

        nums.set(i, String.valueOf(output));
        nums.remove(i + 1);
        operations.remove(i);
        end--;
      }
    }

    //eval addition & subtraction
    i = 0;
    while (i != -1) {
      i = linearSearch("+", start, end);
      int placeholder = linearSearch("-", start, end);
      boolean subtract = false;
      float output;

      if (((i > placeholder) && (placeholder != -1)) | (i == -1)) {
        i = placeholder;
        subtract = true;
      }

      if (i != -1) {
        float num1 = Float.valueOf(nums.get(i));
        float num2 = Float.valueOf(nums.get(i + 1));

        if (subtract == false) {
          output = num1 + num2;
        } else {
          output = num1 - num2;
        }

        nums.set(i, String.valueOf(output));
        nums.remove(i + 1);
        operations.remove(i);
        end--;
      }
    }

    return true;
  }

  public void print() {
    String equation = "";
    for (int i = 0; i < nums.size(); i++) {
      String appendText;

      if (nums.get(i) != "n/a") {
        appendText = equation.concat(nums.get(i));
        equation = appendText;
      }

      try {
        if (operations.get(i) != "n/a") {
          appendText = equation.concat(operations.get(i));
          equation = appendText;
        }
      } catch (Exception e) {
        // nothing here
      }
    }
    textField.setText(equation);
  }

  public int linearSearch(String toFind, int start, int end){
    for (int i = start; i < end; i++) {
      if (toFind.compareToIgnoreCase(operations.get(i)) == 0) {
        return i;
      }
    }
    return -1;
  }

  public int getEndParen(int start, int end){
    String paren = ")";
    for (int i = start; i <= end; i++) {
      if (")" == nums.get(i)) {
        return i;
      }
    }
    return -1;
  }

  public int getStartParen(int end){
    int i = end;
    String paren = "(";
    while (i > -1) {
      if (paren.equals(nums.get(i))) {
        return i;
      }
      i--;
    }
    return -1;
  }
}
