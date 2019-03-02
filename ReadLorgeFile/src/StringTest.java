
public class StringTest {
	public static void main(String[] args) {
		String s = "234|sfdf";
		
		String arr[] = s.split("\\|");
		
		for (String string : arr) {
			System.out.println(string);
			
		}
		
		if(arr[0].equals("2")){
			System.out.println("lsdflas   "+arr[0]);
			
		}
	}

}
