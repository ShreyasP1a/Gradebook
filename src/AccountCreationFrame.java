import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountCreationFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField pwdEnterPassword;
	private JPasswordField pwdReenterPassword;
	private JTextField txtUserName;

	/**
	 * Create the frame.
	 */
	public AccountCreationFrame() {
		
		setBounds(100, 100, 410, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		JLabel lblAccountCreation = new JLabel("Account Creation");
		lblAccountCreation.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblAccountCreation.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountCreation.setBounds(10, 11, 374, 33);
		contentPane.add(lblAccountCreation);

		pwdEnterPassword = new JPasswordField();
		pwdEnterPassword.setBounds(155, 184, 194, 20);
		pwdEnterPassword.getDocument().addDocumentListener(null);
		contentPane.add(pwdEnterPassword);

		JLabel lbl_Student_Admin_Teacher = new JLabel("");
		lbl_Student_Admin_Teacher.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_Student_Admin_Teacher.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Student_Admin_Teacher.setBounds(103, 55, 178, 20);
		contentPane.add(lbl_Student_Admin_Teacher);

		pwdReenterPassword = new JPasswordField();
		pwdReenterPassword.setBounds(155, 247, 194, 20);
		contentPane.add(pwdReenterPassword);

		txtUserName = new JTextField();
		txtUserName.setToolTipText("");
		txtUserName.setBounds(155, 121, 194, 20);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);

		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 122, 86, 14);
		contentPane.add(lblNewLabel);

		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEnterPassword.setBounds(10, 187, 107, 14);
		contentPane.add(lblEnterPassword);

		JLabel lblReenterPassword = new JLabel("Reenter Password");
		lblReenterPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblReenterPassword.setBounds(10, 247, 120, 20);
		contentPane.add(lblReenterPassword);

		JButton btnEnter = new JButton("Create");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userName = txtUserName.getText();
				String password = pwdEnterPassword.getText();
				String checkPassword = pwdReenterPassword.getText();
				
				if(!password.equals(checkPassword)) {
					JOptionPane.showMessageDialog(null, "Please make sure that the passwords match");
					pwdEnterPassword.setText("");
					pwdReenterPassword.setText("");
					
				} else {
					//do stuff
					dispose();
				}
				
			
			
			}
		});
		
		btnEnter.setBounds(155, 328, 89, 23);
		contentPane.add(btnEnter);
	}
}
