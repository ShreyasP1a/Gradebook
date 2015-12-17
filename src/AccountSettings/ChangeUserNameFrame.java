package AccountSettings;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class ChangeUserNameFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterOldUser;
	private JTextField txtEnterNewUser;
	private JTextField txtRenterNewUser;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public ChangeUserNameFrame() {
		
		setBounds(100, 100, 452, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEnterOldUser = new JTextField();
		txtEnterOldUser.setText("Enter Old User Name");
		txtEnterOldUser.setBounds(150, 56, 136, 32);
		contentPane.add(txtEnterOldUser);
		txtEnterOldUser.setColumns(10);
		
		txtEnterNewUser = new JTextField();
		txtEnterNewUser.setText("Enter New User Name");
		txtEnterNewUser.setColumns(10);
		txtEnterNewUser.setBounds(150, 117, 136, 32);
		contentPane.add(txtEnterNewUser);
		
		txtRenterNewUser = new JTextField();
		txtRenterNewUser.setText("Renter New User Name");
		txtRenterNewUser.setColumns(10);
		txtRenterNewUser.setBounds(150, 183, 136, 32);
		contentPane.add(txtRenterNewUser);
		
		JButton btnChange = new JButton("Change");
		btnChange.setBounds(281, 304, 89, 23);
		contentPane.add(btnChange);
		
		JLabel lblNewLabel = new JLabel("User Name Change");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(22, 11, 402, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(97, 304, 89, 23);
		contentPane.add(btnCancel);
		setVisible(true);
		setLocationRelativeTo(null);
	}

}
