package Teacher;

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

public class TeacherFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public TeacherFrame() {
		
		setBounds(100, 100, 289, 342);
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
		
		JButton btnAllTeachers = new JButton("All Classes");
		btnAllTeachers.setBounds(48, 172, 159, 23);
		contentPane.add(btnAllTeachers);
		
		JButton btnSechduleApExams = new JButton("Account Settings");
		btnSechduleApExams.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AccountSettingsFrame();
			}
		});
		btnSechduleApExams.setBounds(48, 228, 159, 23);
		contentPane.add(btnSechduleApExams);
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
