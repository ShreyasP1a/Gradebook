package Student;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import AccountSettings.AccountSettingsFrame;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentFrame extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public StudentFrame() {
		setBounds(100, 100, 323, 333);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeBack = new JLabel("Welcome Back");
		lblWelcomeBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeBack.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblWelcomeBack.setBounds(73, 11, 159, 37);
		contentPane.add(lblWelcomeBack);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(73, 65, 159, 24);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Check your Grades");
		btnNewButton.setBounds(49, 131, 210, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCheckYourAp = new JButton("Check your Ap Exam Schedule");
		btnCheckYourAp.setBounds(49, 189, 210, 23);
		contentPane.add(btnCheckYourAp);
		
		JButton btnAccountSettings = new JButton("Account Settings");
		btnAccountSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AccountSettingsFrame();
			}
		});
		btnAccountSettings.setBounds(49, 246, 210, 23);
		contentPane.add(btnAccountSettings);
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
