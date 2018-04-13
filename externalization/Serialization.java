package externalization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialization {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {
		Son son = new Son();
		son.parent = 101;
		son.child = 102;
		Son pair = new Son();
		System.out.println("Initially: " + pair.toString());

		// Serialize the pair to a file.
		FileOutputStream outputStream = new FileOutputStream("ext.ser");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		pair.writeExternal(objectOutputStream);

		// Close all resources.
		objectOutputStream.flush();
		outputStream.close();

		System.out.println("==================================");
		// Read the contents from the file and create a new instance.
		Son copyOfPair = new Son();

		FileInputStream inputStream = new FileInputStream("ext.ser");
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		copyOfPair.readExternal(objectInputStream);

		// Close all resources.
		objectInputStream.close();
		inputStream.close();
		
		System.out.println("After de-serialization: " + copyOfPair.toString());

	}

}