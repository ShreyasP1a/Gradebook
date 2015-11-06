import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
	/*
	 * Programmer: Shreyas Patil 
	 * Latest worked on date: 11/04/15 
	 * The Main Purpose of this class is to facilitate the use of files throughout out
	 * the program If another class has to use some type of file it has to come
	 * through here and cannot open the files in their actual classes
	 */

	// This is just setting up all of the Paths and where everything is located

	private static String appData = System.getenv("APPDATA");

	private static final String NEWAPPDATA = appData.replace("\\", "/"); 
	
	private final static String FOLDERNAME = "/GradeBook";

	private static String OS = System.getProperty("os.name").toUpperCase(); 

	private static Path APPDATAPATH = Paths.get(NEWAPPDATA + FOLDERNAME); 

	private static final String TEACHERADDRESS = "/TEACHER"; 

	private static final String STUDENTADDRESS = "/STUDENT";

	private static final String ADMINSTRATORADDRESS = "/ADMINSTRATOR"; 
	
	// Create the paths for all of the folders in the
	// %Appdata%/Gradebook	
	
	private static final Path PATHSTUDENT = Paths.get(APPDATAPATH + STUDENTADDRESS);

	private static final Path PATHTEACHER = Paths.get(APPDATAPATH + TEACHERADDRESS);
	
	private static final Path PATHADMINSTRATOR = Paths.get(APPDATAPATH + ADMINSTRATORADDRESS);

	 // this string is to contain which person clicked the
						// button wheather it be student, adminstrator, or
						// teacher
	
	
	private static final String STUDENT = "STUDENT";
	private static final String ADMIN = "ADMINSTRATOR";
	private static final String TEACHER = "TEACHER";
	

	public FileManager() {

		 // intializing the person string

		createAppDataFolder(); // use the method createAppDataFolder to create
								// the Folders in %appdata%
	}

	/*
	 * This method is used to get the path of the folder for either student,
	 * teacher, admin. The Parameters are a person, so the method can
	 * differentiate between all three and give the correct path in gradebook
	 * --------------------------------------------
	 */
	public Path getPath(String person) {
		
		
		if(person.equalsIgnoreCase(STUDENT)) { //if person is student return path of student
			return PATHSTUDENT;
		} else if (person.equalsIgnoreCase(TEACHER)){ //if person is teacher return path of teacher
			return PATHTEACHER;
		} else { //if person is admin return path of admin
			return PATHADMINSTRATOR;
		}

	}
	/*
	 * The purpose of this method is the create the gradebook folder along with
	 * the folders: teacher, student, and admin This method will only run if
	 * gradebook is not there.
	 */

	private void createAppDataFolder() {
		// Checking if the gradebook is there,
		// if it is not there then create it and create all of the necessary
		// folders inside.
		if (!Files.isDirectory(APPDATAPATH)) {

			try {

							
				// Create the folders in the %appdata%
			
				Files.createDirectories((APPDATAPATH));
				Files.createDirectories(PATHSTUDENT);
				Files.createDirectories(PATHTEACHER);
				Files.createDirectories(PATHADMINSTRATOR);

			} catch (IOException e1) {
			//if there are any problems, print out an error message!
				e1.printStackTrace();
			}
		}

	}
	/*
	 * This method will first check to see if an account is already created in a file and if it is not it will add it to the database with the password
	 * encrypted using an md5 hashing method. 
	 */
	public void addUserNameAndPasswordToDataBase(String Username, String Password) {
					
		
		
			
	
	}
		
	
	public void createAccountForPerson(String person) {
	
		
		
		
	}
	private String encryptPassword(String password) {
			
		
		
		return "";
	}
	
	private void writeToFile(String user, String md5) {
		System.out.println("Here");
		
	}
	
}
