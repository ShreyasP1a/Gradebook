package Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class EnterGrades extends JFrame {
	private final JButton btnNewButton = new JButton("New button");

	

	

	/**
	 * Create the frame.
	 */
	public EnterGrades() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		DefaultTableModel model = new DefaultTableModel();
	    JTable table = new JTable(model);
	    model.addColumn("Grades");
	    model.addColumn("HomeWork 1");
	   
	    model.addRow(new Object[] { "r1" });
	    model.addRow(new Object[] { "r2" });
	    model.addRow(new Object[] { "r3" });
	    
	    Vector data = model.getDataVector();
	    Vector row = (Vector) data.elementAt(1);

	    int mColIndex = 0;
	    List colData = new ArrayList(table.getRowCount());
	    for (int i = 0; i < table.getRowCount(); i++) {
	      row = (Vector) data.elementAt(i);
	      colData.add(row.get(mColIndex));
	    }

	    // Append a new column with copied data
	    model.addColumn("Col3", colData.toArray());
	    
	    
	    setSize(606, 384);
	    getContentPane().setLayout(null);
	    JScrollPane scrollPane = new JScrollPane(table);
	    scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	    
	    scrollPane.setBounds(0, 0, 1352, 705);
	    getContentPane().add(scrollPane);
	    
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		int i = 3;	
	    	model.addRow(new Object[] {"Row" + i} );	
	    		i++;
	    	}
	    });
	    scrollPane.setRowHeaderView(btnNewButton);
	    scrollPane.setAutoscrolls(true);
	    setVisible(true);
	    setLocationRelativeTo(null);
	}
}