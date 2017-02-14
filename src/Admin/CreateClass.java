package Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CreateClass extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public CreateClass(String teacherName) {
		String nameOfClass = "";
		
		nameOfClass = JOptionPane.showInputDialog(null, "Please enter the name of the class");
		
		new StudentLists(0, true, teacherName, nameOfClass);
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(false);
		setLocationRelativeTo(null);
	}

}
