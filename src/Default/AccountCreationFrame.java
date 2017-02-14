package Default;
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

/*
 * Programmer: Shreyas Patil 
 * Latest worked on date: 11/28/15
 * The Main purpose of this class is to display the frame to create a new account
 */

public class AccountCreationFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField pwdEnterPassword;
	private JPasswordField pwdReenterPassword;
	private JTextField txtUserName;
	private JTextField txtName;

	/**
	 * Create the frame.
	 */
	public AccountCreationFrame() {
		
		setBounds(100, 100, 531, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);
		
		
		JLabel lblAccountCreation = new JLabel("Account Creation");
		lblAccountCreation.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblAccountCreation.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountCreation.setBounds(10, 11, 495, 33);
		contentPane.add(lblAccountCreation);

		pwdEnterPassword = new JPasswordField();
		pwdEnterPassword.setBounds(155, 219, 194, 20);
		pwdEnterPassword.getDocument().addDocumentListener(null);
		contentPane.add(pwdEnterPassword);

		JLabel lbl_Student_Admin_Teacher = new JLabel("");
		lbl_Student_Admin_Teacher.setFont(new Font("Tahoma", Font.BOLD, 13));
		lbl_Student_Admin_Teacher.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Student_Admin_Teacher.setBounds(103, 55, 178, 20);
		contentPane.add(lbl_Student_Admin_Teacher);

		pwdReenterPassword = new JPasswordField();
		pwdReenterPassword.setBounds(155, 286, 194, 20);
		contentPane.add(pwdReenterPassword);

		txtUserName = new JTextField();
		txtUserName.setToolTipText("");
		txtUserName.setBounds(155, 161, 194, 20);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);

		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 162, 86, 14);
		contentPane.add(lblNewLabel);

		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEnterPassword.setBounds(10, 222, 107, 14);
		contentPane.add(lblEnterPassword);

		JLabel lblReenterPassword = new JLabel("Reenter Password");
		lblReenterPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblReenterPassword.setBounds(10, 286, 120, 20);
		contentPane.add(lblReenterPassword);
		
		JRadioButton studentRadioButton = new JRadioButton("Student");
		studentRadioButton.setBounds(377, 158, 109, 23);
		contentPane.add(studentRadioButton);
		
		JRadioButton teacherRadioButton = new JRadioButton("Teacher");
		teacherRadioButton.setBounds(377, 216, 109, 23);
		contentPane.add(teacherRadioButton);
		
		JRadioButton adminRadioButton = new JRadioButton("Adminstrator");
		adminRadioButton.setBounds(377, 283, 109, 23);
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
					
					String name = txtName.getText();
					
					String person = "";
					String UserName = txtUserName.getText();
					String Password = pwdEnterPassword.getText();
					
				if(name.equalsIgnoreCase(UserName)) {
					
				JOptionPane.showMessageDialog(null, "Please make sure that your username is not the same thing as your name");	
			
		} else {
			if(studentRadioButton.isSelected()) {
				person = "student";
			} else if(teacherRadioButton.isSelected()){
				person = "teacher";
			} else {
				person = "admin";
			}
			
			manager.createAccountForPerson(person, name, Password, userName);
			
			//kill the account creation frame and go back to the main menu
			dispose();
			
			//display message
			JOptionPane.showMessageDialog(null, "Account Created!");
			dispose();
			
		}
					
					
				}
			} else {
				//Display "select a option teacher, student, or admin
				
				JOptionPane.showMessageDialog(null, "Please select which account you are creating");
				
			}
				
			
			
			}
		});
		
		btnEnter.setBounds(212, 349, 89, 23);
		contentPane.add(btnEnter);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(10, 102, 86, 14);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setToolTipText("");
		txtName.setColumns(10);
		txtName.setBounds(155, 101, 194, 20);
		contentPane.add(txtName);
		
		
	}
}
