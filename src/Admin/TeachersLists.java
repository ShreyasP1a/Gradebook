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

import Default.FileManager;

public class TeachersLists extends JFrame {
	private DefaultListModel listModel;
	private FileManager file = new FileManager();

	private JPanel contentPane;

	public TeachersLists() {

		setBounds(100, 100, 368, 487);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("All the Teachers");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 315, 28);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 70, 279, 331);
		contentPane.add(scrollPane);

		listModel = new DefaultListModel();

		ArrayList<String> teacherList = new ArrayList();

		teacherList = file.getNamesList("teacher");
		final String[] teacherLists = teacherList.toArray(new String[0]);

		for (String a : teacherLists) {
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

		JButton btnAddToA = new JButton("Create a Class");
		btnAddToA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Please select a teacher!");
				} else {

					new CreateClass((String) listModel.getElementAt(list.getSelectedIndex()));
				}
			}
		});
		btnAddToA.setBounds(193, 412, 132, 23);
		contentPane.add(btnAddToA);

		setVisible(true);
		setLocationRelativeTo(null);
	}
}