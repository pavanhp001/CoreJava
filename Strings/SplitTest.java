package Strings;

public class SplitTest {

	public static void main(String[] args) {
		String data = "Multiple Address_15500201#ATTV6";
		if(data.contains("Multiple Address")){
			String statusMessage = data.split("_")[1].split("#")[0];
			System.out.println("statusMessage= "+statusMessage);
		}
	}
}
