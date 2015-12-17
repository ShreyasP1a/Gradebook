package Student;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class StudentFrame extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public StudentFrame() {
		setBounds(100, 100, 341, 360);
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
		btnNewButton.setBounds(73, 130, 210, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCheckYourAp = new JButton("Check your Ap Exam Schedule");
		btnCheckYourAp.setBounds(73, 189, 210, 23);
		contentPane.add(btnCheckYourAp);
		
		JButton btnAccountSettings = new JButton("Account Settings");
		btnAccountSettings.setBounds(73, 245, 210, 23);
		contentPane.add(btnAccountSettings);
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
