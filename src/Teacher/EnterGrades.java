package Teacher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Default.FileManager;
import net.miginfocom.swing.MigLayout;

public class EnterGrades extends JFrame {

	

	

	/**
	 * Create the frame.
	 */
	public EnterGrades(String nameOfClass, String name) {
		JOptionPane.showMessageDialog(null, "Remember to click save when you are done otherwise it will not save! Thank you");
		FileManager file = new FileManager();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		DefaultTableModel model = new DefaultTableModel();
	    JTable table = new JTable(model);
	    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    
	    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	    table.setDefaultRenderer(String.class, centerRenderer);
	    
	  
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
	   
	   
	   ArrayList<String> nameList = new ArrayList();
	   
	   try {
		nameList = file.getAssignmentList(nameOfClass, name);
		
		final String[] nameLists = nameList.toArray(new String[0]);
		
		for(String a : nameLists) {
			model.addColumn(a);
		}
		
		
	} catch (FileNotFoundException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	   
	   ArrayList<String> gradesLists = new ArrayList();
		
		try {
			gradesLists = file.getGradeList(nameOfClass, name);
			String[] gradeList = gradesLists.toArray(new String[0]);
			

	String[] wordSplit = new String[model.getColumnCount()-1];	
	if(!gradesLists.isEmpty())		{
		for(int i = 0; i < model.getRowCount(); i++) {
			
				wordSplit = gradeList[i].split("\\s+");
				
				int k = 0;
					for(int j =1; j<model.getColumnCount(); j++) {
						if(wordSplit[k] == null) {
							model.setValueAt(0, i, j);
						}else {
					model.setValueAt(wordSplit[k], i, j);
					k++;
						}
				}
				k = 0;
				
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
				String save = "";
				ArrayList<String> grades = new ArrayList();
				 for(int i = 0; i < model.getRowCount(); i++) {
					 for(int j = 1; j< model.getColumnCount(); j++){
						 save = save + ((Vector) model.getDataVector().elementAt(i)).elementAt(j) + " ";
					//	System.out.print(((Vector) model.getDataVector().elementAt(i)).elementAt(j) + " ");
					 }
					 grades.add(save);
					 save = "";
					 	 
			 } 	
		String[] gradesList = grades.toArray(new String[0]);
		
		try {
			file.writeGradesToFile(gradesList, nameOfClass, name);
			file.writeGradesToFileStudent(gradesList, nameOfClass, name);
			
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		for(String a : gradesList ) {
			System.out.println(a);
		}
				 
	    //write assignmentnames to file		 
	    		ArrayList<String> assignmentNames = new ArrayList(); 
	    		for(int i = 1; i < model.getColumnCount(); i ++) {
	    			
	    			assignmentNames.add(model.getColumnName(i));
	    		}
	    		try {
					file.writeAssignmentsToClassTeacher(assignmentNames, name, nameOfClass);
					file.writeAssignmentsToStudent(assignmentNames, name, nameOfClass);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    		
	    		
	    		 
	    	}		
	    });
	    panel.add(btnNewButton_1, "cell 1 0");
	    
	    JButton btnViewFinalGrades = new JButton("View Final Grades of Students");
	    btnViewFinalGrades.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent arg0) {
	    		Vector data = model.getDataVector();
	    		int sum = 0;
	    		double[] sums = new double[model.getRowCount()];
	    		for(int i = 0; i < model.getRowCount();i++){
	    			for(int j = 1; j< model.getColumnCount(); j++) {
	    				sum = sum + Integer.parseInt((String)model.getValueAt(i, j));
	    			}
	    			
	    			sums[i] = sum;
	    			sum =0;
	    		}
	    		System.out.println();
	    		
	    		ArrayList<String> names = new ArrayList();
	    		
	    		for(int i = 0;i < model.getRowCount(); i++) {
	    			names.add((String)model.getValueAt(i, 0));
	    		}
 	    		int columnCount = (model.getColumnCount()-1);
	    		new ViewFinalGrades(nameOfClass, sums, columnCount, names);
	    	}
	    });
	    
	    
	    getContentPane().add(btnViewFinalGrades, "cell 0 1");
	    setVisible(true);
	    setLocationRelativeTo(null);
	}
}