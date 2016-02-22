package Student;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Default.FileManager;
public class APSchedule extends JFrame {
	private DefaultListModel listModel;
	private FileManager file = new FileManager();

	private JPanel contentPane;

	public APSchedule(String userName) {

		setBounds(100, 100, 401, 487);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Ap Schedule");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 365, 28);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 365, 351);
		contentPane.add(scrollPane);

		listModel = new DefaultListModel();


		
		ArrayList<String> apList = new ArrayList();
		
		apList = file.getApList(userName);
		final String[] apLists = apList.toArray(new String[0]);
		
		for(String a : apLists) {
			listModel.addElement(a);
		}
		

		final JList list = new JList(listModel);
		scrollPane.setViewportView(list);
	
		
		JButton btnCancel = new JButton("Close");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					dispose();
			}
		});
		btnCancel.setBounds(141, 412, 89, 23);
		contentPane.add(btnCancel);
		setVisible(true);
		setLocationRelativeTo(null);
	}
}