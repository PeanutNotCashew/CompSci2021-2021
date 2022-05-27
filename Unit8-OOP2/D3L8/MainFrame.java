import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JTextField;

public class MainFrame extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField fNameField;
	private JTextField lNameField;
	private JButton okButton;
	private JButton clrButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("MainFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		okButton = new JButton("OK");
		okButton.setBounds(34, 200, 117, 29);
		okButton.addActionListener(this);
		contentPane.add(okButton);

		clrButton = new JButton("Clear");
		clrButton.setBounds(284, 200, 117, 29);
		clrButton.addActionListener(this);
		contentPane.add(clrButton);

		JLabel fNameLabel = new JLabel("First Name");
		fNameLabel.setBounds(34, 20, 117, 16);
		contentPane.add(fNameLabel);

		fNameField = new JTextField();
		fNameField.setBounds(44, 48, 243, 26);
		contentPane.add(fNameField);
		fNameField.setColumns(10);

		JLabel lNameLabel = new JLabel("Last Name");
		lNameLabel.setBounds(34, 88, 106, 16);
		contentPane.add(lNameLabel);

		lNameField = new JTextField();
		lNameField.setBounds(44, 116, 243, 26);
		contentPane.add(lNameField);
		lNameField.setColumns(10);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == okButton) {

		}

		if (e.getSource() == clrButton) {

		}
	}

}
