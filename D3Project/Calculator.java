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

    for (int i = 0; i < 10; i++) {
      if (e.getSource() == numberButtons[i]) {
        String appendText = String.valueOf(i);
        textField.setText(textField.getText().concat(appendText));
      }
    }

    for (int i = 0; i < 7; i++) {
      if (e.getSource() == functionButtons[i]) {
        String appendText = functionLabels[i] + "(";
        textField.setText(textField.getText().concat(appendText));
      }
    }

    for (int i = 7; i < 12; i++) {
      if (e.getSource() == functionButtons[i]) {
        String appendText = functionLabels[i];
        textField.setText(textField.getText().concat(appendText));
      }
    }

    if (e.getSource() == functionButtons[12]) {
      textField.setText(textField.getText().concat("-"));
    }

    if (e.getSource() == functionButtons[13]) {
      //equals
    }

    if (e.getSource() == functionButtons[14]) {
      String appendText = functionLabels[14];
      textField.setText(textField.getText().concat(appendText));
    }

    if (e.getSource() == functionButtons[15]) {
      //2nd
    }

    // DEL
    if (e.getSource() == functionButtons[16]) {
      String string = textField.getText();
      textField.setText("");
      for (int i = 0; i < string.length() - 1; i++) {
        textField.setText(textField.getText() + string.charAt(i));
      }
    }

    // CLR
    if (e.getSource() == functionButtons[17]) {
      textField.setText("");
    }

  }
}
