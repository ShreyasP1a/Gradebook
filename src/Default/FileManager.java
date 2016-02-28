 package Default;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import Admin.StudentLists;

public class FileManager {
	/*
	 * Programmer: Shreyas Patil Latest worked on date: 11/26/15 The Main
	 * Purpose of this class is to facilitate the use of files throughout out
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

	// Paths for where all of the people passwords are stored.
	// There are stored in a txt file. if a student creates a account then his
	// password and user is stored in the database in the folder that contains
	// the name student
	// This code will contain where all of the Password database files are
	// stored for student, teacher, and adminstrator.

	private static final Path PATH_STUDENT_PASSWORD_TXT = Paths
			.get(APP_DATA_PATH + STUDENT_ADDRESS + "/StudentPassword.txt");

	private static final Path PATH_TEACHER_PASSWORD_TXT = Paths
			.get(APP_DATA_PATH + TEACHER_ADDRESS + "/TeacherPassword.txt");

	private static final Path PATH_ADMINSTRATOR_PASSWORD_TXT = Paths
			.get(APP_DATA_PATH + ADMINSTRATOR_ADDRESS + "/AdminstratorPassword.txt");

	// this string is to contain which person clicked the
	// button wheather it be student, adminstrator, or
	// teacher

	private static final String STUDENT = "STUDENT";
	private static final String ADMIN = "ADMINSTRATOR";
	private static final String TEACHER = "TEACHER";

	// Path to the AP List
	private static final Path PATH_AP_LIST = Paths.get("/Gradebook intensity/src/APLIST/APLIST.txt");

	// this returns the scanner object of the password txt
	public static Scanner getPasswordFile(String person) {
		try {
			Scanner scannerStudentPassword = new Scanner(PATH_STUDENT_PASSWORD_TXT);
			Scanner scannerTeacherPassword = new Scanner(PATH_TEACHER_PASSWORD_TXT);
			Scanner scannerAdminPassword = new Scanner(PATH_ADMINSTRATOR_PASSWORD_TXT);

			if (person.equalsIgnoreCase(STUDENT)) {
				return scannerStudentPassword;
			} else if (person.equalsIgnoreCase(ADMIN)) {
				return scannerAdminPassword;
			} else {
				return scannerTeacherPassword;
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Password File not found!");
		}

		return null;
		// end getPasswordFile
	}

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

		if (person.equalsIgnoreCase(STUDENT)) { // if person is student return
												// path of student
			return PATH_STUDENT;
		} else if (person.equalsIgnoreCase(TEACHER)) { // if person is teacher
														// return path of
														// teacher
			return PATH_TEACHER;
		} else { // if person is admin return path of admin
			return PATH_ADMINSTRATOR;
		}

	}
	/*
	 * PRE-INITIAZATION The purpose of this method is the create the gradebook
	 * folder along with the folders: teacher, student, and admin This method
	 * will only run if gradebook is not there.
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

				// create the Files for the password/user databases
				PATH_STUDENT_PASSWORD_TXT.toFile().createNewFile();
				PATH_TEACHER_PASSWORD_TXT.toFile().createNewFile();
				PATH_ADMINSTRATOR_PASSWORD_TXT.toFile().createNewFile();

				System.out.println("Database created!");

			} catch (IOException e1) {
				// if there are any problems, print out an error message!
				e1.printStackTrace();
			}
		}

		System.out.println("Pre init check done all up to date!");

		// test for check login

		checkLogin("stanton", "test", "CleverFlames");

		// end PreInit
	}

	// This will create the folders for each account
	// this will be run everytime some one creates an account
	// the password will also be added to the database
	// Student will get a folder with their classes, another folder for their
	// grades

	public void createAccountFileFolder(String account, String name, String password, String userName) {

		// student
		if (account.equalsIgnoreCase("student")) {

			// write password to database
			writePasswordToDataBase(account, userName, password, name);
			// create the neccessary files and folders
			Path folder = Paths.get(PATH_STUDENT + "/" + userName);
			try {
				Files.createDirectories(folder);
				Path classes = Paths.get(PATH_STUDENT + "/" + userName + "/classes");
				Path apExams = Paths.get(PATH_STUDENT + "/" + userName + "/ap exams");

				Files.createDirectories(classes);
				Files.createDirectories(apExams);
			} catch (IOException e) {

				e.printStackTrace();
			}

			// end student
		}
		// teacher
		else if (account.equalsIgnoreCase("teacher")) {

			// write password to database
			writePasswordToDataBase(account, userName, password, name);
			// create the neccessary files and folders
			Path folder = Paths.get(PATH_TEACHER + "/" + userName);
			try {
				Files.createDirectories(folder);
				Path classes = Paths.get(PATH_TEACHER + "/" + userName + "/classes");

				Files.createDirectories(classes);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// end teacher
		}
		// Admin
		else {
			// write password to database
			writePasswordToDataBase(account, userName, password, name);
			// create the neccessary files and folders
			Path folder = Paths.get(PATH_ADMINSTRATOR + "/" + userName);
			try {
				Files.createDirectories(folder);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// end Admin
		}

		// end createAccountFolders
	}

	// This will write to password database
	public void writePasswordToDataBase(String account, String userName, String password, String name) {
		// student
		// open the student password database file
		if (account.equalsIgnoreCase("student")) {
			// write to file
			try {
				PrintWriter print = new PrintWriter(
						new BufferedWriter(new FileWriter(PATH_STUDENT_PASSWORD_TXT.toFile(), true)));
				print.println(userName + " " + password + " " + name);
				print.close();
			} catch (IOException e) {
				// where is the file
				System.out.println("File not found!!!!");
			}
			// end student
		}
		// Teacher
		// open the teacher password database file
		if (account.equalsIgnoreCase("teacher")) {
			// write to file
			try {
				PrintWriter print = new PrintWriter(
						new BufferedWriter(new FileWriter(PATH_TEACHER_PASSWORD_TXT.toFile(), true)));
				print.println(userName + " " + password + " " + name);
				print.close();
			} catch (IOException e) {
				// where is the file
				System.out.println("File not found!!!!");
			}
			// end teacher
		}

		// Admin
		// open the student password database file
		if (account.equalsIgnoreCase("admin")) {
			// write to file
			try {
				PrintWriter print = new PrintWriter(
						new BufferedWriter(new FileWriter(PATH_ADMINSTRATOR_PASSWORD_TXT.toFile(), true)));
				print.println(userName + " " + password + " " + name);
				print.close();
			} catch (IOException e) {
				// where is the file
				System.out.println("File not found!!!!");
			}
			// end admin
		}
		// end passwordToDatabase
	}

	// whenever some one login this check if their passwords match
	// This method is all done
	public static boolean checkLogin(String password, String userName, String person) {
		// Input the files into scanner in order to read the passwords
		// try and catch also there to catch an error in order to make sure that
		// there is an acutual file

		try {
			// Check if person is student
			if (person.equalsIgnoreCase("student")) {
				ArrayList<String> studentPassword = new ArrayList();
				Scanner inputStudentPasswordFile = new Scanner(PATH_STUDENT_PASSWORD_TXT);
				String[] wordSplit;

				while (inputStudentPasswordFile.hasNext()) {
					studentPassword.add(inputStudentPasswordFile.nextLine());
				}

				for (String a : studentPassword) {
					wordSplit = a.split("\\s+");

					if (userName.equalsIgnoreCase(wordSplit[0])) {

						if (password.equals(wordSplit[1])) {

							return true;

						} else {
							return false;
						}
					}
				}

				inputStudentPasswordFile.close();
				// end student password check
			} else if (person.equalsIgnoreCase("teacher")) {
				Scanner inputTeacherPasswordFile = new Scanner(PATH_TEACHER_PASSWORD_TXT);
				ArrayList<String> teacherPassword = new ArrayList();
				String[] wordSplit;

				while (inputTeacherPasswordFile.hasNext()) {
					teacherPassword.add(inputTeacherPasswordFile.nextLine());
				}

				for (String a : teacherPassword) {
					wordSplit = a.split("\\s+");

					if (userName.equalsIgnoreCase(wordSplit[0])) {

						if (password.equals(wordSplit[1])) {

							return true;

						} else {
							return false;
						}
					}
				}

				inputTeacherPasswordFile.close();
				// end teacher password check
			} else {
				Scanner inputAdminstratorPasswordFile = new Scanner(PATH_ADMINSTRATOR_PASSWORD_TXT);
				ArrayList<String> adminPassword = new ArrayList();
				String[] wordSplit;

				while (inputAdminstratorPasswordFile.hasNext()) {
					adminPassword.add(inputAdminstratorPasswordFile.nextLine());
				}

				for (String a : adminPassword) {
					wordSplit = a.split("\\s+");

					if (userName.equalsIgnoreCase(wordSplit[0])) {

						if (password.equals(wordSplit[1])) {

							return true;

						} else {
							return false;
						}
					}
				}
				inputAdminstratorPasswordFile.close();
				// end admin password check

			}
		} catch (IOException e) {
			System.out.println("Files not Found");
			e.printStackTrace();
		}

		return false;
	}

	// this method is to get the name of the person logging into the system can
	// also be used in other parts of the program
	public String getNameFromUserName(String userName, String person) {
		if (person.equalsIgnoreCase("student")) {
			ArrayList<String> studentName = new ArrayList();
			Scanner inputStudentPasswordFile;
			String[] wordSplit;
			try {
				inputStudentPasswordFile = new Scanner(PATH_STUDENT_PASSWORD_TXT);
				while (inputStudentPasswordFile.hasNext()) {
					studentName.add(inputStudentPasswordFile.nextLine());
				}
				for (String a : studentName) {
					wordSplit = a.split("\\s+");
					if (userName.equalsIgnoreCase(wordSplit[0])) {

						return wordSplit[2];
					}

				}
				inputStudentPasswordFile.close();
				// end student
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (person.equalsIgnoreCase("teacher")) {
			ArrayList<String> teacherName = new ArrayList();
			Scanner inputTeacherPasswordFile;
			String[] wordSplit;
			try {
				inputTeacherPasswordFile = new Scanner(PATH_TEACHER_PASSWORD_TXT);
				while (inputTeacherPasswordFile.hasNext()) {
					teacherName.add(inputTeacherPasswordFile.nextLine());
				}
				for (String a : teacherName) {
					wordSplit = a.split("\\s+");
					if (userName.equalsIgnoreCase(wordSplit[0])) {

						return wordSplit[2];
					}

				}
				inputTeacherPasswordFile.close();
				// end teacher
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			// Admin
			ArrayList<String> adminName = new ArrayList();
			Scanner inputAdminPasswordFile;
			String[] wordSplit;
			try {
				inputAdminPasswordFile = new Scanner(PATH_ADMINSTRATOR_PASSWORD_TXT);
				while (inputAdminPasswordFile.hasNext()) {
					adminName.add(inputAdminPasswordFile.nextLine());
				}
				for (String a : adminName) {
					wordSplit = a.split("\\s+");
					if (userName.equalsIgnoreCase(wordSplit[0])) {

						return wordSplit[2];
					}

				}
				inputAdminPasswordFile.close();
				// end admin
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return "";
	}

	// returns an array list containg the all of the names for the each class;
	// teacher and student
	public ArrayList<String> getNamesList(String name) {
		ArrayList<String> names = new ArrayList<String>();
		try {
			// Check if person is student
			if (name.equalsIgnoreCase("student")) {
				ArrayList<String> studentInformationList = new ArrayList();
				Scanner inputStudentPasswordFile = new Scanner(PATH_STUDENT_PASSWORD_TXT);
				String[] wordSplit;

				while (inputStudentPasswordFile.hasNext()) {
					studentInformationList.add(inputStudentPasswordFile.nextLine());
				}

				for (String a : studentInformationList) {
					wordSplit = a.split("\\s+");
					names.add(wordSplit[2]);
				}
				inputStudentPasswordFile.close();
				return names;
				// end student
			} else if (name.equalsIgnoreCase("teacher")) {
				Scanner inputTeacherPasswordFile = new Scanner(PATH_TEACHER_PASSWORD_TXT);

				ArrayList<String> teacherInformationList = new ArrayList();
				Scanner inputTeacherPasswordFile1 = new Scanner(PATH_TEACHER_PASSWORD_TXT);
				String[] wordSplit;

				while (inputTeacherPasswordFile1.hasNext()) {
					teacherInformationList.add(inputTeacherPasswordFile1.nextLine());
				}

				for (String a : teacherInformationList) {
					wordSplit = a.split("\\s+");
					names.add(wordSplit[2]);
				}
				inputTeacherPasswordFile1.close();
				return names;

			}
		} catch (IOException e) {
			System.out.println("Files not Found");
			e.printStackTrace();
		}
		return names;
	}

	// returns the arraylist of all of the ap classes from the aplist.txt
	public ArrayList<String> getAllAPClass() {

		ArrayList<String> apList = new ArrayList<String>();

		try {
			Scanner input = new Scanner(PATH_AP_LIST.toFile());
			while (input.hasNext()) {
				apList.add(input.nextLine());
			}
			return apList;

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		return apList;
	}

	// this method writes all of the ap exams to apExams.txt in their respective
	// student folder
	// this gets parameters from the ap class

	public void writeApExamsToPerson(String userName, java.util.List selectedValuesList) {
		System.out.println(userName);
		int a;
		a = JOptionPane.showConfirmDialog(null,
				"Are you sure this is all of the APs that this student is going to take? side note adding more Ap's to the same student will start over");
		if (a == 0) {

			PrintWriter writer;
			try {
				File f = new File(PATH_STUDENT + "/" + userName + "/ap exams/apExams.txt");

				if (!f.exists()) {
					// Create the file
					f.createNewFile();

				}
				writer = new PrintWriter(f, "UTF-8");

				Object[] array = ((java.util.List<String>) selectedValuesList).toArray();

				System.out.println("*** iterating over the array ***");
				for (Object str : array) {

					writer.print(str);
					writer.println();

				}

				writer.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {

		}
	}

	// This method gets the userName from the Name
	public String getUserNameFromName(String name, String person) {
		if (person.equalsIgnoreCase("student")) {
			ArrayList<String> studentName = new ArrayList();
			Scanner inputStudentPasswordFile;
			String[] wordSplit;
			try {
				inputStudentPasswordFile = new Scanner(PATH_STUDENT_PASSWORD_TXT);
				while (inputStudentPasswordFile.hasNext()) {
					studentName.add(inputStudentPasswordFile.nextLine());
				}
				for (String a : studentName) {
					wordSplit = a.split("\\s+");
					if (name.equalsIgnoreCase(wordSplit[2])) {

						return wordSplit[0];
					}

				}
				inputStudentPasswordFile.close();
				// end student
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (person.equalsIgnoreCase("teacher")) {
			ArrayList<String> teacherName = new ArrayList();
			Scanner inputTeacherPasswordFile;
			String[] wordSplit;
			try {
				inputTeacherPasswordFile = new Scanner(PATH_TEACHER_PASSWORD_TXT);
				while (inputTeacherPasswordFile.hasNext()) {
					teacherName.add(inputTeacherPasswordFile.nextLine());
				}
				for (String a : teacherName) {
					wordSplit = a.split("\\s+");
					if (name.equalsIgnoreCase(wordSplit[2])) {

						return wordSplit[0];
					}

				}
				inputTeacherPasswordFile.close();
				// end teacher
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			// Admin
			ArrayList<String> adminName = new ArrayList();
			Scanner inputAdminPasswordFile;
			String[] wordSplit;
			try {
				inputAdminPasswordFile = new Scanner(PATH_ADMINSTRATOR_PASSWORD_TXT);
				while (inputAdminPasswordFile.hasNext()) {
					adminName.add(inputAdminPasswordFile.nextLine());
				}
				for (String a : adminName) {
					wordSplit = a.split("\\s+");
					if (name.equalsIgnoreCase(wordSplit[2])) {

						return wordSplit[0];
					}

				}
				inputAdminPasswordFile.close();
				// end admin
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return "";

	}

	// This method will return the list of all of the ap classes that a student
	// is taking
	// The method takes in the userName parameter
	public ArrayList<String> getApList(String userName) {
		ArrayList<String> apList = new ArrayList<String>();
		Path apPath = Paths.get(PATH_STUDENT + "/" + userName + "/ap exams/apExams.txt");

		try {
			Scanner input = new Scanner(apPath.toFile());

			while (input.hasNextLine()) {
				apList.add(input.nextLine());
			}
			input.close();
			return apList;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return apList;
	}

	// This method will create the class and add it to the teacher folder and
	// also add students to it and also in the student file
	
	public void createClass(String nameOfClass, String nameOfTeacher, List students){
		int i =0;
		String userNameOfTeacher = getUserNameFromName(nameOfTeacher, "teacher");
		
		
		String[] studentsName = new String[students.size()];
		students.toArray(studentsName);	
		String[] studentUserNames = new String[studentsName.length];
		
		//converts all of the students names in the list to the userNames for each one so that I can add them to the class.
		
		for(String a : studentsName) {
		studentUserNames[i] = getUserNameFromName(studentsName[i], "student");
		i++;
		}
		
		for(int j = 0; j < studentUserNames.length;j++) {
			String userName = studentUserNames[j];
			
			Path pathStudentClass = Paths.get(PATH_STUDENT + "/" + userName + "/classes/" + nameOfClass);
			Path pathStudentClassGrades = Paths.get(PATH_STUDENT + "/" + userName + "/classes/" + nameOfClass+"/grades.txt");
			
			
			
			try {
				Files.deleteIfExists(pathStudentClass);
				Files.createDirectories(pathStudentClass);
				Files.createFile(pathStudentClassGrades);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		
		Path pathTeacherClass = Paths.get(PATH_TEACHER + "/" + userNameOfTeacher + "/classes/" + nameOfClass);
		Path pathTeacherClassStudents = Paths.get(PATH_TEACHER + "/" + userNameOfTeacher + "/classes/" + nameOfClass+"/students.txt");
		Path pathTeacherClassGrades = Paths.get(PATH_TEACHER + "/" + userNameOfTeacher + "/classes/" + nameOfClass+"/Grades.txt");
		Path pathTeacherClassAssignmentList = Paths.get(PATH_TEACHER + "/" + userNameOfTeacher + "/classes/" + nameOfClass+"/Assignments.txt");
		
		try {
			Files.deleteIfExists(pathTeacherClass);
			
			Files.createDirectories(pathTeacherClass);
			Files.createFile(pathTeacherClassGrades);
			Files.createFile(pathTeacherClassStudents);
			Files.createFile(pathTeacherClassAssignmentList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter writer;
		try {
			File f = new File(PATH_TEACHER + "/" + userNameOfTeacher + "/classes/" + nameOfClass+"/students.txt");

			
			writer = new PrintWriter(f, "UTF-8");

			for(String a : studentUserNames){
				writer.print(a);
				writer.println();
				
			}
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
		JOptionPane.showMessageDialog(null, "Class created!");
	}
	
	public ArrayList<String> getClassListForStudent(String name)	{
			ArrayList<String> nameOfClasses = new ArrayList<String>();
			String userName = getUserNameFromName(name, "student");
			
			File f = new File(PATH_STUDENT + "/" + userName + "/classes/");
			
			 nameOfClasses = new ArrayList<String>(Arrays.asList(f.list()));
			return nameOfClasses;
	
	}

	public ArrayList<String> getClassListForTeacher(String name) {
		ArrayList<String> nameOfClasses = new ArrayList<String>();
		
		String userName = getUserNameFromName(name, "teacher");
		
		File f = new File(PATH_TEACHER + "/" + userName + "/classes/");
		
		 nameOfClasses = new ArrayList<String>(Arrays.asList(f.list()));
		
		
		
		return nameOfClasses;
		
	}
	
	public ArrayList<String> getListOfStudentsInClassForTeacher(String nameOfClass, String name) {
		ArrayList<String> listOfStudentsInClass = new ArrayList();
		
		String userName = getUserNameFromName(name, "teacher");
		
		Path pathOfClassList = Paths.get(PATH_TEACHER + "/" + userName + "/classes/" + nameOfClass + "/students.txt");
		
		try {
			Scanner input = new Scanner(pathOfClassList.toFile());
			
			while(input.hasNextLine()) {
				listOfStudentsInClass.add(input.nextLine());
			}
		input.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listOfStudentsInClass;
	}

	public void writeAssignmentsToClass(ArrayList<String> nameOfAssignments, String name , String nameOfClass) throws IOException {
		
		String userName = getUserNameFromName(name, "teacher");
		Path pathsForAssignments = Paths.get(PATH_TEACHER + "/" + userName + "/classes/" + nameOfClass + "/Assignments.txt");
		
		File f = pathsForAssignments.toFile();
		
		if(f.exists()) {
			f.delete();
		}
		final String[] assignmentLists = nameOfAssignments.toArray(new String[0]);
		f.createNewFile();
		
		PrintWriter writer;
		
		writer = new PrintWriter(f, "UTF-8");
		
		for(String a : assignmentLists) {
			writer.print(a);
			writer.println();
		}
		writer.close();		
	}
// Add students too!
	public void writeGradesToFile(String[] grades, String nameOfClass, String name) throws IOException{
		String userName = getUserNameFromName(name, "teacher");
		Path pathsForGrades = Paths.get(PATH_TEACHER + "/" + userName + "/classes/" + nameOfClass + "/Grades.txt");
		
		File f = pathsForGrades.toFile();
		
		f.createNewFile();
		
		PrintWriter writer;
		
		writer = new PrintWriter(f, "UTF-8");
		
		for(String a : grades) {
			writer.print(a);
			writer.println();
		}
		writer.close();		
		
		
		
		
		
	}
	
	public ArrayList<String> getAssignmentList(String nameOfClass, String name) throws FileNotFoundException {
		String userName = getUserNameFromName(name, "teacher");
		ArrayList<String> nameList = new ArrayList();
		
		File f = new File(PATH_TEACHER + "/" + userName + "/classes/" + nameOfClass + "/Assignments.txt");
		
		Scanner input = new Scanner(f);
		
		while(input.hasNextLine()) {
			nameList.add(input.nextLine());
		}
		return nameList;
	}

	
	public ArrayList<String> getGradeList(String nameOfClass, String name) throws FileNotFoundException {
		String userName = getUserNameFromName(name, "teacher");
		
		ArrayList<String> gradeList = new ArrayList();
		
		File f = new File(PATH_TEACHER + "/" + userName + "/classes/" + nameOfClass + "/Grades.txt");
		
		Scanner input = new Scanner(f);
		
		while(input.hasNextLine()) {
			gradeList.add(input.nextLine());
		}
		return gradeList;
	}
}
