package CorePractise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class FileExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("1");
		// File helps us to create, delete, get details about a file.
		long timedata = System.currentTimeMillis();
		File file = new File("FileName"+timedata+".txt");
		System.out.println("2");
		// Check if the file exists
		System.out.println("File exists : "+file.exists());
		System.out.println("3");

		// If file does not exist creates it and returns true
		// If file exists, returns false
		System.out.println("File create New : "+file.createNewFile());
		
		System.out.println("4");

		// Gets the full path of file
		System.out.println("File getAbsolutePath : "+file.getAbsolutePath());
		System.out.println("File isFile : "+file.isFile());// true
		System.out.println("File isDirectory : "+file.isDirectory());// false
		System.out.println("5");

		// Renaming a file
		File fileWithNewName = new File("NewFileName.txt");
		file.renameTo(fileWithNewName);
		// There is no method file.renameTo("NewFileName.txt");

		// A File class in Java represents a file and directory.
		long d = System.currentTimeMillis();
		File directory = new File("src/com/rithus"+d);
		System.out.println("6");
		// prints full directory path
		System.out.println("directory getAbsolutePath : "+directory.getAbsolutePath());
		System.out.println("directory isDirectory : "+directory.isDirectory());// true
		System.out.println("7");
		//File fileInDir = new File(directory, "NewFileInDirectory.txt");
		// This does not create the actual file.

		// Actual file is created when we invoke createNewFile method
		//System.out.println(fileInDir.createNewFile()); // true - First Time

		// Prints the files and directories present in the folder
		System.out.println("directory List : "+Arrays.toString(directory.list()));

		// Creating a directory
		File newDirectory = new File("newfolder"+timedata);
		System.out.println("newDirectory mkdir : "+newDirectory.mkdir());// true - First Time

		// Creating a file in a new directory
		File notExistingDirectory = new File("notexisting"+timedata);
		File newFile = new File(notExistingDirectory, "newFile");

		// Will throw Exception if uncommented: No such file or directory
		// newFile.createNewFile();

		System.out.println("newDirectory mkdir : "+newDirectory.mkdir());// true - First Time

		// Implementations of Writer and Reader abstract classes help us
		// to write and read (content of) files.

		// Writer methods - flush, close, append (text)
		// Reader methods - read, close (NO FLUSH)

		// Writer implementations - FileWriter,BufferedWriter,PrintWriter
		// Reader implementations - FileReader,BufferedReader

		// Write a string to a file using FileWriter
		// FileWriter helps to write stuff into the file
		FileWriter fileWriter = new FileWriter(file);
		fileWriter.write("How are you doing?");
		// Always flush before close. Writing to file uses Buffering.
		fileWriter.flush();
		fileWriter.close();

		FileReader fileReader = new FileReader(file);
		char[] temp = new char[25];

		// Read from file using FileReader
		// fileReader reads entire file and stores it into temp
		System.out.println("File lenth : "+fileReader.read(temp));// 18 - No of characters Read
													// from file

		System.out.println(Arrays.toString(temp));// output below
		// [H, o, w, , a, r, e, , y, o, u, , d, o, i, n, g, ?, 
	}

}
