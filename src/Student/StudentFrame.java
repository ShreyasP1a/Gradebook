package Student;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import AccountSettings.AccountSettingsFrame;
import Admin.AP;
import Default.FileManager;

public class StudentFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public StudentFrame(String Name) {
		FileManager file = new FileManager();
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ClassListStudent(Name);
			}
		});
		btnNewButton.setBounds(10, 142, 403, 23);
		contentPane.add(btnNewButton);

		JButton btnCheckYourAp = new JButton("Check your Ap Exam Schedule");
		btnCheckYourAp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userName = file.getUserNameFromName(Name, "student");

				new APSchedule(userName);
			}
		});
		btnCheckYourAp.setBounds(10, 216, 403, 23);
		contentPane.add(btnCheckYourAp);

		JButton btnAccountSettings = new JButton("Account Settings");
		btnAccountSettings.setVisible(false);
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
