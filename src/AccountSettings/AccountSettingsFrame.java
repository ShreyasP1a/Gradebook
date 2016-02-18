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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountSettingsFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AccountSettingsFrame() {
		
		setBounds(100, 100, 365, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account Settings");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(29, 11, 298, 21);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setBounds(212, 105, 101, 16);
		contentPane.add(label);
		
		JButton btnChangeUserName = new JButton("Change User Name");
		btnChangeUserName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChangeUserNameFrame();
			}
		});
		btnChangeUserName.setBounds(106, 121, 155, 23);
		contentPane.add(btnChangeUserName);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChangePasswordFrame();
			}
		});
		btnChangePassword.setBounds(106, 215, 155, 23);
		contentPane.add(btnChangePassword);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	

}
