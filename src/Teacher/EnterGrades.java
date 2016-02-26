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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import net.miginfocom.swing.MigLayout;

public class EnterGrades extends JFrame {

	

	

	/**
	 * Create the frame.
	 */
	public EnterGrades() {
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		DefaultTableModel model = new DefaultTableModel();
	    JTable table = new JTable(model);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    
	    
//	    Vector data = model.getDataVector();
//	    Vector row = (Vector) data.elementAt(1);

//	    int mColIndex = 0;
//	    List colData = new ArrayList(table.getRowCount());
//	    for (int i = 0; i < table.getRowCount(); i++) {
//	      row = (Vector) data.elementAt(i);
//	      colData.add(row.get(mColIndex));
//	    }

	    // Append a new column with copied data
	    model.addColumn("Students");
	   
	    
	   
	    
	    model.addRow(new Object[] { "Shreyas" });
	    model.addRow(new Object[] { "Kunal" });
	    model.addRow(new Object[] { "Frank" });
	    model.addRow(new Object[] { "Shravan" });
	    model.addRow(new Object[] { "Julian" });
	    
	    
	    setSize(1421, 618);
	    getContentPane().setLayout(new MigLayout("", "[1352px,grow,left]", "[541.00px,grow,top][]"));
	    JScrollPane scrollPane = new JScrollPane(table);
	    getContentPane().add(scrollPane, "cell 0 0,grow");
	    scrollPane.setAutoscrolls(true);
	    
	    JPanel panel = new JPanel();
	    getContentPane().add(panel, "cell 0 1,alignx center,growy");
	    panel.setLayout(new MigLayout("", "[][]", "[]"));
	    
	    JButton btnNewButton = new JButton("Add Grade");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		
	    		String name = JOptionPane.showInputDialog("What is the name of the assignments?");
	    		model.addColumn(name);
	    		
	    		
	    	}
	    });
	    panel.add(btnNewButton, "cell 0 0");
	    
	    JButton btnNewButton_1 = new JButton("save");
	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {

	    		 Vector data = model.getDataVector();			
					
//				 for(int i = 0; i < model.getRowCount(); i++) {
//					 for(int j =0; j< model.getColumnCount(); j++){
//						System.out.print(((Vector) model.getDataVector().elementAt(i)).elementAt(j) + " ");
//					 }	
//					 System.out.println();
//					 
//				 } 	
	    		 
	    		 
	    	}		
	    });
	    panel.add(btnNewButton_1, "cell 1 0");
	    setVisible(true);
	    setLocationRelativeTo(null);
	}
}