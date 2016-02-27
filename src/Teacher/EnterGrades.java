package Teacher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Default.FileManager;
import net.miginfocom.swing.MigLayout;

public class EnterGrades extends JFrame {

	

	

	/**
	 * Create the frame.
	 */
	public EnterGrades(String nameOfClass, String name) {
		
		FileManager file = new FileManager();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		DefaultTableModel model = new DefaultTableModel();
	    JTable table = new JTable(model);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    
	  
	    model.addColumn("Students");
	    ArrayList<String> listOfStudent = new ArrayList();
	   
	   listOfStudent = file.getListOfStudentsInClassForTeacher(nameOfClass, name);
	   
	   String[] listOfStudentsUserNames = listOfStudent.toArray(new String[0]);
	   
	  String[] listOfStudents = new String[listOfStudentsUserNames.length];
	  
	 int l = 0;
	  for(String a : listOfStudentsUserNames) {
		  listOfStudents[l] = file.getNameFromUserName(listOfStudentsUserNames[l], "student");
		   l++;
	   }
	  
	   for(String a : listOfStudents) {
		   model.addRow(new Object[] {a});
		   
	   }
	   
	    
	    
	    
//	    Vector data = model.getDataVector();
//	    Vector row = (Vector) data.elementAt(1);

//	    int mColIndex = 0;
//	    List colData = new ArrayList(table.getRowCount());
//	    for (int i = 0; i < table.getRowCount(); i++) {
//	      row = (Vector) data.elementAt(i);
//	      colData.add(row.get(mColIndex));
//	    }

	    // Append a new column with copied data
	   
	   
	    
	   
	    
	   
	    
	    
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