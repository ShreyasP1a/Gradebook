import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;

public class FileManager {
	/*
	 * Programmer: Shreyas Patil 
	 * Latest worked on date: 11/26/15 
	 * The Main Purpose of this class is to facilitate the use of files throughout out
	 * the program If another class has to use some type of file it has to come
	 * through here and cannot open the files in their actual classes
	 */

	// This is just setting up all of the Paths and where everything is located

	private static String appData = System.getenv("APPDATA");

	private static final String NEW_APP_DATA = appData.replace("\\", "/"); 
	
	private final static String FOLDER_NAME = "/GradeBook";

	private static String OS = System.getProperty("os.name").toUpperCase(); 

	private static final Path APP_DATA_PATH = Paths.get(NEW_APP_DATA + FOLDER_NAME); 

	private static final String TEACHER_ADDRESS = "/TEACHER"; 

	private static final String STUDENT_ADDRESS = "/STUDENT";

	private static final String ADMINSTRATOR_ADDRESS = "/ADMINSTRATOR"; 
	
	
	
	// Create the paths for all of the folders in the
	// %Appdata%/Gradebook	
	
	private static final Path PATH_STUDENT = Paths.get(APP_DATA_PATH + STUDENT_ADDRESS);

	private static final Path PATH_TEACHER = Paths.get(APP_DATA_PATH + TEACHER_ADDRESS);
	
	private static final Path PATH_ADMINSTRATOR = Paths.get(APP_DATA_PATH + ADMINSTRATOR_ADDRESS);
	
	//Paths for where all of the people passwords are stored.
	//There are stored in a txt file. if a student creates a account then his password and user is stored in the database in the folder that contains the name student
	//This code will contain where all of the Password database files are stored for student, teacher, and adminstrator.
	
	private static final Path PATH_STUDENT_PASSWORD = Paths.get(APP_DATA_PATH + STUDENT_ADDRESS + "/StudentPassword.txt");

	private static final Path PATH_TEACHER_PASSWORD = Paths.get(APP_DATA_PATH + TEACHER_ADDRESS + "/TeacherPassword.txt");
	
	private static final Path PATH_ADMINSTRATOR_PASSWORD = Paths.get(APP_DATA_PATH + ADMINSTRATOR_ADDRESS + "/AdminstratorPassword.txt");
	

	 // this string is to contain which person clicked the
						// button wheather it be student, adminstrator, or
						// teacher
	
	
	private static final String STUDENT = "STUDENT";
	private static final String ADMIN = "ADMINSTRATOR";
	private static final String TEACHER = "TEACHER";
	

	public FileManager() {

		 // intializing the person string

		 // use the method createAppDataFolder to create
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
			return PATH_STUDENT;
		} else if (person.equalsIgnoreCase(TEACHER)){ //if person is teacher return path of teacher
			return PATH_TEACHER;
		} else { //if person is admin return path of admin
			return PATH_ADMINSTRATOR;
		}

	}
	/*
	 * The purpose of this method is the create the gradebook folder along with
	 * the folders: teacher, student, and admin This method will only run if
	 * gradebook is not there.
	 */

	public void preInit() {
		// Checking if the gradebook is there,
		// if it is not there then create it and create all of the necessary
		// folders inside.

		System.out.println("Pre Initiialization Check .....");
		if (!Files.isDirectory(APP_DATA_PATH)) {

			try {

							
				// Create the folders in the %appdata%
				
				System.out.println("Folders not created in the %Appdata% ....");
				
			
				Files.createDirectories((APP_DATA_PATH));
				Files.createDirectories(PATH_STUDENT);
				Files.createDirectories(PATH_TEACHER);
				Files.createDirectories(PATH_ADMINSTRATOR);
				
				System.out.println("Folders Created");
				
				System.out.println();
				System.out.println("Creating pasword databases for student, teacher and admin");
				
				//create the Files for the password/user databases
				PATH_STUDENT_PASSWORD.toFile().createNewFile();
				PATH_TEACHER_PASSWORD.toFile().createNewFile();
				PATH_ADMINSTRATOR_PASSWORD.toFile().createNewFile();
				
				System.out.println("Database created!");
				
			} catch (IOException e1) {
			//if there are any problems, print out an error message!
				e1.printStackTrace();
			}
		}
		
		System.out.println("Pre init check done all up to date!");

	}
	/*
	 * This method will first check to see if an account is already created in a file and if it is not it will add it to the database with the password
	 * encrypted using an md5 hashing method. ----- dont really know how to do this will work on it later lol lol lol hahaha
	 * I dont know why I did the lol part hahaha!
	 * oh my!
	 */
	public void addUserNameAndPasswordToDataBase(String Username, String Password) 
	{
					
		
			
			
	
	}
	private String encryptPassword(String password) {
			
	
		
		return "";
	}
	
	private void writeToFile(String user, String md5) {
		//test what to do ?
		
		

	}
	
}
