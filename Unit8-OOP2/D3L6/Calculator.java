import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
  JFrame frame;
  JPanel panel;
  JTextField textField;
  JButton[] numberButtons= new JButton[10];
  JButton[] functionButtons = new JButton[8];
  JButton addButton, subButton, mulButton, divButton;
  JButton decButton, equButton, delButton, clrButton;

  Font f = new Font("Karla", Font.PLAIN, 30);
  double num1 = 0, num2 = 0, result = 0;
  char operator;

  public Calculator() {
    frame = new JFrame("Calculator");
    frame.setSize(420, 550);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(null);

    textField = new JTextField();
    textField.setBounds(50, 25, 300, 50);
    textField.setFont(f);
    textField.setEditable(false);

    addButton = new JButton("+");
    subButton = new JButton("-");
    mulButton = new JButton("*");
    divButton = new JButton("/");
    decButton = new JButton(".");
    equButton = new JButton("=");
    delButton = new JButton("DEL");
    clrButton = new JButton("CLR");

    functionButtons[0] = addButton;
    functionButtons[1] = subButton;
    functionButtons[2] = mulButton;
    functionButtons[3] = divButton;
    functionButtons[4] = decButton;
    functionButtons[5] = equButton;
    functionButtons[6] = delButton;
    functionButtons[7] = clrButton;


    frame.setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {}


}
