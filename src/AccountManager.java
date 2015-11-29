
public class AccountManager {

	/*
	 * Programmer: Shreyas Patil 
	 * Latest worked on date: 11/28/15
	 * The Main purpose of this class is to help the other classes use the accounts.
	 */
	
	/*
	 * Students:  
	 * Students will have multiple files one file will contain a list of all of their classes
	 * Then students will have multiple files, Each file will contain a list of their classes and their grades in them.
	 * The files will be seperated from other students in diffrent  folders.
	 */
	
	/*
	 * Teachers:
	 * 	There will also be another file containg the list of all of the teachers 	
	 * 	Teacher will have 1 file containg all of the classes they teach
	 * 	Another file will contain the students for each class and the grades for them
	 * 
	 * 
	 */
	
	/*
	 * Adminstrators:
	 * 	Admin will have one file containg all of the students in the system
	 * 	Admin will also have acces to a list of files in a folder containg all of the teachers and their list of classes and a list of students
	 * 	Admin will also have access to a list containg a list of IB and AP exams and their dates
	 * 
	 */
	

	
	//? what to do if a person misplaces an account or forgets the password? --- dont know
	
	//This method will access the File manager and create then neccessary files for each person 
	
	public void createAccountForPerson(String person, String name, String password) {
	//Console Display message
		System.out.println("----------------------------------------------------");
		
		System.out.println("Getting information from Account Creation Frame! ...");
		System.out.println();
		System.out.println("Name: " + name);
		System.out.println("Account: " + person);
		System.out.println("Password: " + password);
			
			
			
		
	}
	public void returnAccountStatus(){
		
	}
	

}
