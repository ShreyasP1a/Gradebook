package Teacher;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class TeacherLogin extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTxt;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public TeacherLogin() {
		
		setBounds(100, 100, 450, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(0, 0, 434, 297);
		contentPane.add(panel);
		
		JLabel lblTeacherLogin = new JLabel("Teacher Login");
		lblTeacherLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblTeacherLogin.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblTeacherLogin.setBounds(44, 11, 341, 33);
		panel.add(lblTeacherLogin);
		
		userNameTxt = new JTextField();
		userNameTxt.setHorizontalAlignment(SwingConstants.LEFT);
		userNameTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userNameTxt.setColumns(10);
		userNameTxt.setBounds(174, 92, 185, 33);
		panel.add(userNameTxt);
		
		JButton button = new JButton("Cancel");
		button.setBounds(0, 253, 89, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("Login");
		button_1.setBounds(345, 253, 89, 23);
		panel.add(button_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(174, 171, 185, 33);
		panel.add(passwordField);
		
		JLabel label_1 = new JLabel("User Name");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		label_1.setBounds(0, 92, 109, 33);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Arial Black", Font.PLAIN, 14));
		label_2.setBounds(0, 169, 109, 33);
		panel.add(label_2);
		setLocationRelativeTo(null);
	}
}
