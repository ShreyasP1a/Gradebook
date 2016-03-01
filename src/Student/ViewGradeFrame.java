package Student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
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

public class ViewGradeFrame extends JFrame {

	

	

	/**
	 * Create the frame.
	 */
	public ViewGradeFrame(String nameOfClass, String name) {
		
		FileManager file = new FileManager();
		
		DefaultTableModel model = new DefaultTableModel();
	    JTable table = new JTable(model);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    
	  
	    model.addColumn("Assignments");
	    model.addColumn("Grades");
	    
	    ArrayList<String> listOfAssignments = new ArrayList();
	   
	   try {
		listOfAssignments = file.getAssignmentListForStudent(nameOfClass, name);
		
		for(String a : listOfAssignments) {
			   model.addRow(new Object[] {a});  
		   }
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
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
	   
	   
	
	   
	   ArrayList<String> gradesLists = new ArrayList();
		
		try {
			gradesLists = file.getGradeListForStudent(nameOfClass, name);
			
			String[] gradeList = gradesLists.toArray(new String[0]);
			

	
	if(!gradesLists.isEmpty())		{
			for(int i = 0; i < model.getRowCount(); i++) {
				model.setValueAt(gradeList[i], i, 1);
			}
		
		
	}
			
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		

	    
	    setSize(1421, 618);
	    getContentPane().setLayout(new MigLayout("", "[1352px,grow,left]", "[541.00px,grow,top][]"));
	    JScrollPane scrollPane = new JScrollPane(table);
	    getContentPane().add(scrollPane, "cell 0 0,grow");
	    scrollPane.setAutoscrolls(true);
	    
	    JPanel panel = new JPanel();
	    getContentPane().add(panel, "flowx,cell 0 1,alignx center,growy");
	    panel.setLayout(new MigLayout("", "[][]", "[]"));
	    
	
	    
	   
	    
	    JButton btnViewFinalGrades = new JButton("View Final Grades Of Class");
	    btnViewFinalGrades.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		Vector data = model.getDataVector();
	    		double sum = 0;
	    		
	    		for(int i =0; i < model.getRowCount(); i++) {
	    			sum = sum + Integer.parseInt((String) model.getValueAt(i, 1));
	    		}
	    		String pattern = "###,###.#";
	    		DecimalFormat df = new DecimalFormat(pattern);
	    		
 	    		double rowCount = (double)(model.getRowCount());
 	    		
 	    		double finalGrade = sum/rowCount;
 	    		
 	    		JOptionPane.showMessageDialog(null, "You have a " + df.format(finalGrade) + " in the class");
 	    		
 	    		finalGrade = 0.0;
 	    		sum = 0.0;
	    		
	    	}
	    });
	    getContentPane().add(btnViewFinalGrades, "cell 0 1");
	    setVisible(true);
	    setLocationRelativeTo(null);
	}
}