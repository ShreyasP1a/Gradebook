import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;

public class AccountCreationFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField pwdEnterPassword;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountCreationFrame frame = new AccountCreationFrame();
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
	public AccountCreationFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccountCreation = new JLabel("Account Creation");
		lblAccountCreation.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblAccountCreation.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountCreation.setBounds(10, 11, 374, 33);
		contentPane.add(lblAccountCreation);
		
		pwdEnterPassword = new JPasswordField();
		pwdEnterPassword.setBounds(61, 209, 194, 20);
		pwdEnterPassword.getDocument().addDocumentListener(null);
		contentPane.add(pwdEnterPassword);
		
		JLabel lbl_Student_Admin_Teacher = new JLabel("");
		lbl_Student_Admin_Teacher.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Student_Admin_Teacher.setBounds(114, 55, 135, 14);
		contentPane.add(lbl_Student_Admin_Teacher);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(61, 259, 194, 20);
		contentPane.add(passwordField);
	}
}
