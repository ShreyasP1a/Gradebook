package AccountSettings;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

public class ChangePasswordFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterOldUser;
	private JLabel lblNewLabel_1;
	private JLabel lblEnterNewPassword;
	private JLabel lblReenterNewPassword;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public ChangePasswordFrame() {
		
		setBounds(100, 100, 507, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEnterOldUser = new JTextField();
		txtEnterOldUser.setText("Enter User Name");
		txtEnterOldUser.setBounds(248, 60, 136, 32);
		contentPane.add(txtEnterOldUser);
		txtEnterOldUser.setColumns(10);
		
		JButton btnChange = new JButton("Change");
		btnChange.setBounds(392, 329, 89, 23);
		contentPane.add(btnChange);
		
		JLabel lblNewLabel = new JLabel("Password Change");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(22, 11, 402, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(22, 329, 89, 23);
		contentPane.add(btnCancel);
		
		lblNewLabel_1 = new JLabel("Enter Old Password");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(27, 126, 154, 14);
		contentPane.add(lblNewLabel_1);
		
		lblEnterNewPassword = new JLabel("Enter New Password");
		lblEnterNewPassword.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblEnterNewPassword.setBounds(27, 192, 154, 14);
		contentPane.add(lblEnterNewPassword);
		
		lblReenterNewPassword = new JLabel("Reenter new Password");
		lblReenterNewPassword.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblReenterNewPassword.setBounds(27, 251, 181, 14);
		contentPane.add(lblReenterNewPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(248, 125, 136, 20);
		contentPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(248, 191, 136, 20);
		contentPane.add(passwordField_1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(248, 250, 136, 20);
		contentPane.add(passwordField_2);
		
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
