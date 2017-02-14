package Teacher;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Default.FileManager;

public class ClassListTeacher extends JFrame {

	private DefaultListModel listModel;
	private FileManager file = new FileManager();
	private JPanel contentPane;

	
	public ClassListTeacher(String name) {
		setBounds(100, 100, 401, 487);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("Class List For " + name);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 365, 28);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 365, 351);
		contentPane.add(scrollPane);

		listModel = new DefaultListModel();

		ArrayList<String> namesOfClass = file.getClassListForTeacher(name);
		
		final String[] classList = namesOfClass.toArray(new String[0]);
		
		for(String a : classList) {
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
		btnCancel.setBounds(10, 412, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnCheckGradeFor = new JButton("Enter grades for class");
		btnCheckGradeFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new EnterGrades((String)listModel.getElementAt(list.getSelectedIndex()), name);
				
			}
		});
		btnCheckGradeFor.setBounds(215, 412, 160, 23);
		contentPane.add(btnCheckGradeFor);
		setVisible(true);
		setLocationRelativeTo(null);
		
		
	}
}
