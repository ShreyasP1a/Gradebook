package Admin;

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

public class AdminFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public AdminFrame(String name) {
		
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
		
		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setText(name);
		label_1.setBounds(48, 87, 159, 24);
		contentPane.add(label_1);
		
		JButton btnAllStudents = new JButton("All Students");
		btnAllStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudentLists(0, false, "", "");
					
			}
		});
		btnAllStudents.setBounds(48, 157, 159, 23);
		contentPane.add(btnAllStudents);
		
		JButton btnAllTeachers = new JButton("All Teachers");
		btnAllTeachers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeachersLists();
			}
		});
		btnAllTeachers.setBounds(48, 204, 159, 23);
		contentPane.add(btnAllTeachers);
		
		JButton btnSechduleApExams = new JButton("Schedule AP Exams");
		btnSechduleApExams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new StudentLists(1, false, "", "");
			}
		});
		btnSechduleApExams.setBounds(48, 258, 159, 23);
		contentPane.add(btnSechduleApExams);
		
		JButton button = new JButton("Account Settings");
		button.setVisible(false);
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
