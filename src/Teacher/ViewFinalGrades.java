package Teacher;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
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
public class ViewFinalGrades extends JFrame {
	private DefaultListModel listModel;
	private FileManager file = new FileManager();

	private JPanel contentPane;
	

	public ViewFinalGrades(String nameOfClass, double[] grades, int columnCount, ArrayList<String> names) {

		setBounds(100, 100, 413, 490);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//		JLabel lblNewLabel = new JLabel("Final Grades");
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel.setBounds(10, 11, 377, 23);
//		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 17));
//		contentPane.add(lblNewLabel);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 377, 331);
		contentPane.add(scrollPane);

		listModel = new DefaultListModel();
		
	


		
		
		final String[] nameList = names.toArray(new String[0]);
		
		double[] finalGrades = new double[grades.length];
		int l = 0;
		String pattern = "###,###.#";
		DecimalFormat df = new DecimalFormat(pattern);
		for(double a : grades){
			finalGrades[l] = grades[l]/columnCount;
			l++;
		}
		int m = 0;
		for(String a: nameList ){
			listModel.addElement(a + " has a final grade right now of: " + df.format(finalGrades[m]));
			m++;
		
		}
		
		
		
		final JList list = new JList(listModel);
		scrollPane.setViewportView(list);
		
		
		
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setBounds(147, 412, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel labelName = new JLabel("");
		labelName.setText("Final Grades for " + nameOfClass);
		labelName.setHorizontalAlignment(SwingConstants.CENTER);
		labelName.setFont(new Font("Arial Black", Font.PLAIN, 17));
		labelName.setBounds(10, 11, 377, 23);
		contentPane.add(labelName);
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
}