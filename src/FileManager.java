import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
	/*
	 * Programmer: Shreyas Patil
	 * Latest worked on date: 11/04/15
	 * The Main Purpose of this class is to facilitate the use of files throughout out the program
	 * If another class has to use some type of file it has to come through here and cannot open the files in their actual classes
	 */
	
	
//This is just setting up all of the Paths and where everything is located	
	
	private static String appData = System.getenv("APPDATA");		//get the path to where the %Appdata% is stored!

	private static final String NEWAPPDATA = appData.replace("\\", "/"); //replace all of the \ with / because it doesn't work I have no clue why lol

	private final static String FOLDERNAME = "/GradeBook"; //create the folder name where all of the files are going to be located
	
	private static String OS = System.getProperty("os.name").toUpperCase(); //This string contains what operating system you are on, and makes it all Upper Case: WINDOWS 7, WINDOWS 8.1, WINDOWS 10, OR MAC OSX
	
	private static Path APPDATAPATH = Paths.get(NEWAPPDATA + FOLDERNAME);	//This path contains where the the 
	
	private static final String TEACHERADDRESS = "/TEACHER";
	
	private static final String STUDENTADDRESS = "/STUDENT";
	
	private static final String ADMINSTRATORADDRESS = "/ADMINSTRATOR";

	
	String person = "";
	public FileManager(String person) {
		person = person;
		createAppDataFolder();
	}

	public Path getPath(String person) {

		return null;

	}

	private void createAppDataFolder() {

		if (!Files.isDirectory(APPDATAPATH)) {
			try {
				
			//Create the paths for all of the folders in the %Appdata%
				
				Path pathStudent = Paths.get(APPDATAPATH + STUDENTADDRESS);
				Path pathTeacher = Paths.get(APPDATAPATH + TEACHERADDRESS);
				Path pathAdminstrator = Paths.get(APPDATAPATH + ADMINSTRATORADDRESS);
			//Create the folders in the %appdata%						
				Files.createDirectories((APPDATAPATH));
				Files.createDirectories(pathStudent);
				Files.createDirectories(pathTeacher);
				Files.createDirectories(pathAdminstrator);
				

			} catch (IOException e1) {

				e1.printStackTrace();
			}
		}

	}
}
