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
	public StudentFrame(String Name) {
		setBounds(100, 100, 451, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeBack = new JLabel("Welcome Back");
		lblWelcomeBack.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeBack.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblWelcomeBack.setBounds(10, 11, 415, 37);
		contentPane.add(lblWelcomeBack);
		
		JLabel lblName = new JLabel("");
		lblName.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(20, 59, 405, 31);
		contentPane.add(lblName);
		lblName.setText(Name);
		
		JButton btnNewButton = new JButton("Check your Grades");
		btnNewButton.setBounds(10, 142, 403, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCheckYourAp = new JButton("Check your Ap Exam Schedule");
		btnCheckYourAp.setBounds(10, 216, 403, 23);
		contentPane.add(btnCheckYourAp);
		
		JButton btnAccountSettings = new JButton("Account Settings");
		btnAccountSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AccountSettingsFrame();
			}
		});
		btnAccountSettings.setBounds(10, 292, 403, 23);
		contentPane.add(btnAccountSettings);
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
