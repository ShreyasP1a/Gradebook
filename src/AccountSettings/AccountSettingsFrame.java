package AccountSettings;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AccountSettingsFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AccountSettingsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 291, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account Settings");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(-11, 11, 298, 21);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(212, 105, 101, 16);
		contentPane.add(label);
		
		JButton btnChangeUserName = new JButton("Change User Name");
		btnChangeUserName.setBounds(72, 87, 130, 23);
		contentPane.add(btnChangeUserName);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.setBounds(72, 149, 130, 23);
		contentPane.add(btnChangePassword);
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
