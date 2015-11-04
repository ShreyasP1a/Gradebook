import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 415);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGradebook = new JLabel("Gradebook");
		lblGradebook.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblGradebook.setHorizontalAlignment(SwingConstants.CENTER);
		lblGradebook.setBounds(10, 11, 414, 37);
		contentPane.add(lblGradebook);
		
		JButton btnNewButton = new JButton("Student");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				new FileManager("Student");
			
			}
		});
		btnNewButton.setBounds(128, 106, 207, 23);
		contentPane.add(btnNewButton);
		
		JButton btnTeacher = new JButton("Teacher");
		btnTeacher.setBounds(128, 181, 207, 23);
		contentPane.add(btnTeacher);
		
		JButton btnAdminstrator = new JButton("Adminstrator");
		btnAdminstrator.setBounds(128, 257, 207, 23);
		contentPane.add(btnAdminstrator);
		
		JButton btnCreateAccount = new JButton("Create Account");
		btnCreateAccount.setBounds(128, 330, 207, 23);
		contentPane.add(btnCreateAccount);
	}
}
