	package Teacher;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Default.FileManager;
import Student.StudentFrame;

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
		FileManager file = new FileManager();
		
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
		lblTeacherLogin.setBounds(0, 11, 434, 33);
		panel.add(lblTeacherLogin);
		
		userNameTxt = new JTextField();
		userNameTxt.setHorizontalAlignment(SwingConstants.LEFT);
		userNameTxt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userNameTxt.setColumns(10);
		userNameTxt.setBounds(174, 92, 185, 33);
		panel.add(userNameTxt);
		
		JButton button = new JButton("Cancel");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		
		button.setBounds(20, 253, 89, 23);
		panel.add(button);
		
		
		
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
		label_2.setBounds(0, 169, 99, 33);
		panel.add(label_2);
		
		JButton button_1 = new JButton("Login");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password = passwordField.getText();
				
				if(file.checkLogin(password, userNameTxt.getText(), "teacher") == true) {
						JOptionPane.showMessageDialog(null, "Logging in! ");
						new TeacherFrame(file.getNameFromUserName(userNameTxt.getText(), "teacher"));
						dispose();
						password = "";
						userNameTxt.setText("");
						passwordField.setText("");
						
				} else {
					JOptionPane.showMessageDialog(null, "Wrong password or UserName ");
					userNameTxt.setText("");
					passwordField.setText("");
					password = "";
					
				}
			}
		});
		button_1.setBounds(321, 253, 89, 23);
		panel.add(button_1);
		setLocationRelativeTo(null);
	}
}
