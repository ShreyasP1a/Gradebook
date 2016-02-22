package Admin;
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

public class AdminLogin extends JFrame {
	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPasswordField;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AdminLogin() {
		FileManager file = new FileManager();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setBounds(100, 100, 450, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Adminstrator Login");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 414, 33);
		contentPane.add(lblNewLabel);
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUserName.setHorizontalAlignment(SwingConstants.LEFT);
		txtUserName.setBounds(174, 128, 185, 33);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(10, 292, 89, 23);
		contentPane.add(btnCancel);
		
		
		
		txtPasswordField = new JPasswordField();
		txtPasswordField.setBounds(174, 210, 185, 33);
		contentPane.add(txtPasswordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String password = txtPasswordField.getText();
				
				if(file.checkLogin(password, txtUserName.getText(), "admin") == true) {
						JOptionPane.showMessageDialog(null, "Logging in! ");
						new AdminFrame(file.getNameForPasswordLogin(txtUserName.getText(), "admin"));
						dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Wrong password or UserName ");
					txtUserName.setText("");
					txtPasswordField.setText("");
					
				}
			}
		});
		btnLogin.setBounds(335, 292, 89, 23);
		contentPane.add(btnLogin);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("User Name");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 128, 109, 33);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(10, 210, 109, 33);
		contentPane.add(lblPassword);
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
