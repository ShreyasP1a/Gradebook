package Teacher;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class EnterGrades extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static DefaultTableModel tableModel;

	

	/**
	 * Create the frame.
	 */
	public EnterGrades() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tableModel = new DefaultTableModel(new Object[] { "Initial Column" }, 5);
		table = new JTable(tableModel);
		
		
		table.setBounds(22, 30, 516, 361);
		
		
		contentPane.add(table);
		setVisible(true);
	
	}
}