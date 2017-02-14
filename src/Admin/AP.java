package Admin;
import java.awt.Color;
import java.awt.Font;
import java.awt.List;
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

import Default.FileManager;
public class AP extends JFrame {
	private DefaultListModel listModel;
	private FileManager file = new FileManager();

	private JPanel contentPane;
	java.util.List selectedValuesList;

	public AP(String name) {

		setBounds(100, 100, 413, 490);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("AP Tests");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 377, 23);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 17));
		contentPane.add(lblNewLabel);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 377, 331);
		contentPane.add(scrollPane);

		listModel = new DefaultListModel();
		
	


		ArrayList<String> apList = new ArrayList();
		
		apList = file.getAllAPClass();
		
		final String[] apLists = apList.toArray(new String[0]);
		
		for(String a : apLists) {
			listModel.addElement(a);
		}
		
		final JList list = new JList(listModel);
		scrollPane.setViewportView(list);
		
		list.addListSelectionListener(new ListSelectionListener() {
	        @Override
	        public void valueChanged(ListSelectionEvent e) {
	            if (!e.getValueIsAdjusting()) {
	                selectedValuesList = list.getSelectedValuesList();
	               
	            }
	        }
	    });
		
		JButton btnPickAp = new JButton("Pick AP");
		btnPickAp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedValuesList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please select at least one ap, Remeber you can hold ctrl to select more than one value!");
				} else{
				
					dispose();
					String userName = file.getUserNameFromName(name, "student");
					file.writeApExamsToPerson(userName, selectedValuesList);
				
					}
				}
		});
		btnPickAp.setBounds(298, 412, 89, 23);
		contentPane.add(btnPickAp);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(10, 412, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel labelName = new JLabel("");
		labelName.setText("Scheduling AP Exams for: " + name);
		labelName.setHorizontalAlignment(SwingConstants.CENTER);
		labelName.setFont(new Font("Arial Black", Font.PLAIN, 17));
		labelName.setBounds(10, 45, 377, 23);
		contentPane.add(labelName);
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
}