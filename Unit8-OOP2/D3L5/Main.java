import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.*;

public class Main {
  public static JFrame frame;
  public static JPanel panel;
  public static JLabel userLabel;
  public static JTextField userText;
  public static JLabel passwordLabel;
  public static JPasswordField passwordText;
  public static JButton loginButton;
  public static JButton changeUser;
  public static JLabel success;

  private static String user = "Admin";
  private static String password = "password123";
  private static boolean loggedIn = false;

  public static void main(String[] args) {
    // Setting the width and height of frame
    frame = new JFrame("My First Swing Example");
    frame.setSize(350, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Creating panel (same as a div tag in HTML). Can contain text fields, buttons and other components.
    panel = new JPanel();
    // adding panel to frame
    frame.add(panel);
    // adding components to the panel.
    placeComponents(panel);

    // Setting the frame visibility to true
    frame.setVisible(true);
  }

  private static void placeComponents(JPanel panel) {
    panel.setLayout(null);

    // Creating username label and text field
    userLabel = new JLabel("User");
    //setBounds(x, y, width, height)
    userLabel.setBounds(10,20,80,25);
    panel.add(userLabel);

    userText = new JTextField(20);
    userText.setBounds(100,20,165,25);
    panel.add(userText);

    // Password label and text field.
    passwordLabel = new JLabel("Password");
    passwordLabel.setBounds(10,50,80,25);
    panel.add(passwordLabel);

    passwordText = new JPasswordField(20);
    passwordText.setBounds(100,50,165,25);
    panel.add(passwordText);

    // Buttons
    LoginListener login = new LoginListener();
    loginButton = new JButton("Login");
    loginButton.setBounds(10, 80, 80, 25);
    loginButton.addActionListener(login);
    panel.add(loginButton);

    ChangeListener change = new ChangeListener();
    changeUser = new JButton("Change Account");
    changeUser.setBounds(100, 80, 160, 25);
    changeUser.addActionListener(change);
    panel.add(changeUser);

    // Success message
    success = new JLabel("");
    success.setBounds(10, 110, 300, 25);
    panel.add(success);

  }

  private static class LoginListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      String userInput = userText.getText();
      String passwordInput = passwordText.getText();

      //determines if info is correct, if so, user is logged in
      if ((userInput.equals(user)) && (passwordInput.equals(password))) {
        success.setText("Login successful.");
        loggedIn = true;
      } else {
        success.setText("Login unsuccessful.");
        loggedIn = false;
      }
    }
  }

  private static class ChangeListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      // determines if person can change user & password
      if (loggedIn == true) {
        user = userText.getText();
        password = passwordText.getText();
        success.setText("Changed account settings.");
      } else {
        success.setText("You are unauthorized. Sign in first.");
      }
    }
  }
}
