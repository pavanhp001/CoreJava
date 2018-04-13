package externalization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerialization {

	public static void main(String[] args) throws IOException,
			ClassNotFoundException {

		FileInputStream fileInputStream = new FileInputStream("son.ser");
		ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
		Son sonDeseralized = (Son) inputStream.readObject();
		System.out.println(sonDeseralized.parent);
		System.out.println(sonDeseralized.child);
		System.out.println(sonDeseralized.parent12);
	}

}

/*without transiant
 * 
 * Initialization Block..
Father Constructor
3
102
pavan

 * */
