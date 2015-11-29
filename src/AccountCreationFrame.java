import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class AccountCreationFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField pwdEnterPassword;
	private JPasswordField pwdReenterPassword;
	private JTextField txtUserName;

	/**
	 * Create the frame.
	 */
	public AccountCreationFrame() {
		
		setBounds(100, 100, 531, 427);
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
		
		JRadioButton studentRadioButton = new JRadioButton("Student");
		studentRadioButton.setBounds(377, 118, 109, 23);
		contentPane.add(studentRadioButton);
		
		JRadioButton teacherRadioButton = new JRadioButton("Teacher");
		teacherRadioButton.setBounds(377, 181, 109, 23);
		contentPane.add(teacherRadioButton);
		
		JRadioButton adminRadioButton = new JRadioButton("Adminstrator");
		adminRadioButton.setBounds(377, 244, 109, 23);
		contentPane.add(adminRadioButton);
		
		
		
		ButtonGroup personButtonGroup = new ButtonGroup( );
		
		personButtonGroup.add(studentRadioButton);
		personButtonGroup.add(teacherRadioButton);
		personButtonGroup.add(adminRadioButton);
		
		

		JButton btnEnter = new JButton("Create");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String userName = txtUserName.getText();
				String password = pwdEnterPassword.getText();
				String checkPassword = pwdReenterPassword.getText();
				
		//Check if any of the Radio buttons are selected do the password check and then create the account if 
		//the radio buttons are not selected then display a message to select one
			if(studentRadioButton.isSelected() || teacherRadioButton.isSelected() || adminRadioButton.isSelected() ) {				
				
			//Check if the passwords match if not then display a correction message
			//If the passwords match then send the account info to the account manager and then dispose the frame, and display a message
				if(!password.equals(checkPassword)) {
					JOptionPane.showMessageDialog(null, "Please make sure that the passwords match");
					pwdEnterPassword.setText("");
					pwdReenterPassword.setText("");
					
				} else {
					//send info to Account manager
					System.out.println("Sending info to account manger");
						
					AccountManager manager = new AccountManager();
					
					String person = "";
					String name = txtUserName.getText();
					String Password = pwdEnterPassword.getText();
					
					if(studentRadioButton.isSelected()) {
						person = "student";
					} else if(teacherRadioButton.isSelected()){
						person = "teacher";
					} else {
						person = "admin";
					}
					
					manager.createAccountForPerson(person, name, Password);
					
					//kill the account creation frame and go back to the main menu
					dispose();
					
					//display message
					JOptionPane.showMessageDialog(null, "Account Created!");
				}
			} else {
				//Display "select a option teacher, student, or admin
				
				JOptionPane.showMessageDialog(null, "Please select which account you are creating");
				
			}
				
			
			
			}
		});
		
		btnEnter.setBounds(155, 328, 89, 23);
		contentPane.add(btnEnter);
		
		
	}
}
