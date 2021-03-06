package Admin;

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import Student.ClassListStudent;

import Default.FileManager;

public class StudentLists extends JFrame {
	private DefaultListModel listModel;
	private FileManager file = new FileManager();
	java.util.List selectedValuesList;

	private JPanel contentPane;

	public StudentLists(int apOrClass, Boolean trueOrFalse, String teacherName, String nameOfClass) {

		setBounds(100, 100, 401, 487);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("All the students");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 315, 28);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 365, 351);
		contentPane.add(scrollPane);

		listModel = new DefaultListModel();

		ArrayList<String> studentList = new ArrayList();

		studentList = file.getNamesList("student");
		final String[] studentLists = studentList.toArray(new String[0]);

		for (String a : studentLists) {
			listModel.addElement(a);
		}

		final JList list = new JList(listModel);
		scrollPane.setViewportView(list);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setBounds(10, 412, 89, 23);
		contentPane.add(btnCancel);

		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					selectedValuesList = list.getSelectedValuesList();

				}
			}
		});

		if (apOrClass == 0) {

			if (trueOrFalse == true) {

				JOptionPane.showMessageDialog(null,
						"Remeber you can select more than one student, once you create the class there are no edits to the class");
				JButton btnAddToAClass = new JButton("Add to a Class");
				btnAddToAClass.setBounds(235, 412, 139, 23);

				btnAddToAClass.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						file.createClass(nameOfClass, teacherName, selectedValuesList);
						dispose();
					}
				});
				contentPane.add(btnAddToAClass);
			} else {

				JButton btnCheckGrade = new JButton("Check grade");
				btnCheckGrade.addActionListener(e -> {
					if (list.isSelectionEmpty()) {
						JOptionPane.showMessageDialog(null, "Please select a student!");

					} else {
						new ClassListStudent((String) listModel.getElementAt(list.getSelectedIndex()));
					}
				});
				btnCheckGrade.setBounds(258, 412, 117, 23);
				contentPane.add(btnCheckGrade);
			}
		} else {
			JButton btnAddToA = new JButton("Add an AP");

			btnAddToA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (list.getSelectedIndex() == -1) {
						JOptionPane.showMessageDialog(null, "Please select a Name!");
					} else {
						String name = (String) listModel.getElementAt(list.getSelectedIndex());
						System.out.println(name);
						dispose();
						JOptionPane.showMessageDialog(null, "Hold Ctrl to select multiple AP's");
						new AP(name);

					}

				}
			});
			btnAddToA.setBounds(235, 412, 139, 23);

			contentPane.add(btnAddToA);

		}

		setVisible(true);
		setLocationRelativeTo(null);
	}

}