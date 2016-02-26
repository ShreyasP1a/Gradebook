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
	    		Vector data = model.getDataVector();
				 Vector row = (Vector) data.elementAt(0);
				 System.out.println(row.elementAt(0));
	    		String name = JOptionPane.showInputDialog("What is the name of the assignment?");
	    		model.addColumn(name);
	    		
	    	}
	    });
	    panel.add(btnNewButton, "cell 0 0");
	    
	    JButton btnNewButton_1 = new JButton("save");
	    btnNewButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		PrintWriter writer;
				try {
					File f = new File("/test.txt");

					if (!f.exists()) {
						// Create the file
						f.createNewFile();

					}
					writer = new PrintWriter(f, "UTF-8");

					

					System.out.println("*** iterating over the array ***");
					
					 Vector data = model.getDataVector();
					 Vector row = (Vector) data.elementAt(1);
					 for(int i =0; i < table.getColumnCount(); i++) {
						 System.out.println(row.elementAt(i));
					 }

//					    int mColIndex = 0;
//					    List colData = new ArrayList(table.getRowCount());
//					    for (int i = 0; i < table.getRowCount(); i++) {
//					      row = (Vector) data.elementAt(i);
//					      colData.add(row.get(mColIndex));
//					    }
					 
						
						writer.println();

					
					writer.close();
	    	}
	    	 catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
				
	    	}		
	    });
	    panel.add(btnNewButton_1, "cell 1 0");
	    setVisible(true);
	    setLocationRelativeTo(null);
	}
}