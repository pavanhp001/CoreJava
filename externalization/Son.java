package externalization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public class Son extends Father implements Externalizable {

	public Son() {
		System.out.println("Son Constructor...");
	}

	int child = 4;

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		
		System.out.println("writeExternal called: ");
		out.write(child);
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		System.out.println("readExternal called: ");
		System.out.println(in.read());
		
	}
}