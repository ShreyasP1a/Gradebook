import java.awt.EventQueue;
import java.awt.Font;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private JPanel contentPane;
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
		setBounds(100, 100, 420, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTheGradeBook = new JLabel("The Grade Book");
		lblTheGradeBook.setFont(new Font("Eras Bold ITC", Font.BOLD | Font.ITALIC, 24));
		lblTheGradeBook.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheGradeBook.setBounds(10, 11, 373, 46);
		contentPane.add(lblTheGradeBook);

		JButton btnNewButton = new JButton("Student");
		btnNewButton.setBounds(95, 83, 201, 23);
		contentPane.add(btnNewButton);

		JButton btnTeacher = new JButton("Teacher");
		btnTeacher.setBounds(95, 135, 201, 23);
		contentPane.add(btnTeacher);

		JButton btnAdminstrator = new JButton("Adminstrator");
		btnAdminstrator.setBounds(95, 186, 201, 23);
		contentPane.add(btnAdminstrator);

	}

	public String getAppDataPath(String OS) {
		String appData = System.getenv("APPDATA");
		String newAppData = appData.replace("\\", "/");

		
						return newAppData;
	}
}
