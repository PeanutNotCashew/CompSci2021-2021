import java.util.LinkedList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
  JFrame frame;
  JPanel panel;
  JTextField textField;
  JButton[] numberButtons = new JButton[10];
  JButton[] functionButtons = new JButton[18];
  String[] functionLabels = {"SIN", "COS", "TAN", "RAD", "SQRT", "LOG", "LN", "/", "*", "-", "+", ".", "(-)", "=", ")", "2ND", "DEL", "CLR"};
  LinkedList<String> nums = new LinkedList<String>();
  LinkedList<String> operations = new LinkedList<String>();

  public Calculator () {
    // Create frame
    frame = new JFrame("Calculator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("Calculator");
    frame.setSize(420, 550);
    frame.setLayout(null);

    //create textfield
    textField = new JTextField();
    textField.setBounds(50, 25, 300, 50);
    textField.setEditable(false);

    //create numbers
    for (int i = 0; i < 10; i++) {
      numberButtons[i] = new JButton(String.valueOf(i));
      numberButtons[i].addActionListener(this);
      numberButtons[i].setFocusable(false);
    }

    //create functions
    for (int i = 0; i < functionButtons.length; i++) {
      functionButtons[i] = new JButton(functionLabels[i]);
      functionButtons[i].addActionListener(this);
      functionButtons[i].setFocusable(false);
    }

    //create panel for buttons
    panel = new JPanel();
    panel.setBounds(50, 100, 300, 400);
    panel.setLayout(new GridLayout(8, 4, 10, 10));

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

  public void actionPerformed(ActionEvent e){
    // Number buttons
    for (int i = 0; i < 10; i++) {
      if (e.getSource() == numberButtons[i]) {
        if(nums.size() != operations.size()){
          int j = nums.size() - 1;
          String appendText = nums.get(j).concat(String.valueOf(i));
          nums.set(j, appendText);
        } else {
          String appendText = String.valueOf(i);
          nums.add(appendText);
        }
      }
    }

    // Basic functions
    for (int i = 7; i < 12; i++) {
      if (e.getSource() == functionButtons[i]) {
        if (nums.size() != operations.size()) {
          String appendText = functionLabels[i];
          operations.add(appendText);
        }
      }
    }

    System.out.print(nums);
    System.out.println(operations);
  }
}
