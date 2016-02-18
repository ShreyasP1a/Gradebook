package Default;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Admin.AP;
import Admin.AdminLogin;
import Student.StudentLogin;
import Teacher.TeacherLogin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					//create a new instantiation of FileManager
					FileManager file = new FileManager();
					//runing the file manager pre init
					file.preInit();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		new AP();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 411);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblGradebook = new JLabel("Gradebook");
		lblGradebook.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblGradebook.setHorizontalAlignment(SwingConstants.CENTER);
		lblGradebook.setBounds(10, 11, 414, 37);
		contentPane.add(lblGradebook);
		
		JButton btnNewButton = new JButton("Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				new StudentLogin();

			}
		});
		btnNewButton.setBounds(128, 106, 207, 23);
		contentPane.add(btnNewButton);
		
		JButton btnTeacher = new JButton("Teacher");
		btnTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeacherLogin();
			}
		});
		btnTeacher.setBounds(128, 181, 207, 23);
		contentPane.add(btnTeacher);
		
		JButton btnAdminstrator = new JButton("Adminstrator");
		btnAdminstrator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AdminLogin();
			}
		});
		btnAdminstrator.setBounds(128, 257, 207, 23);
		contentPane.add(btnAdminstrator);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				new AccountCreationFrame(); 
			System.out.println(arg0.hashCode());
			
			}
		});
		btnCreateAccount.setBounds(128, 330, 207, 23);
		contentPane.add(btnCreateAccount);
	}
}
