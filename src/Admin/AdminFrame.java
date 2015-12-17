package Admin;

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

public class AdminFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AdminFrame() {
		
		setBounds(100, 100, 289, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Welcome Back");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial Black", Font.PLAIN, 14));
		label.setBounds(48, 30, 159, 37);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Name");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(48, 87, 159, 24);
		contentPane.add(label_1);
		
		JButton btnAllStudents = new JButton("All Students");
		btnAllStudents.setBounds(48, 157, 159, 23);
		contentPane.add(btnAllStudents);
		
		JButton btnAllTeachers = new JButton("All Teachers");
		btnAllTeachers.setBounds(48, 204, 159, 23);
		contentPane.add(btnAllTeachers);
		
		JButton btnSechduleApExams = new JButton("Sechdule AP Exams");
		btnSechduleApExams.setBounds(48, 258, 159, 23);
		contentPane.add(btnSechduleApExams);
		
		JButton button = new JButton("Account Settings");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AccountSettingsFrame();
			}
		});
		button.setBounds(48, 312, 159, 23);
		contentPane.add(button);
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
