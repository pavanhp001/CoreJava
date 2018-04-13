import java.io.FileReader;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;



public class JsonDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JSONParser parser = new JSONParser();

		try {
			 
            Object obj = parser.parse(new FileReader(
                    "D:/E/SalesCenter_2016_Sprint_8/A/src/jsonText.txt"));
            
            System.out.println("obj : "+obj.toString());
 
            JSONObject jsonObject = new  JSONObject(obj.toString());
            
            JSONArray testArray = new JSONArray();
            for (int j = 0; j < 3; j++) {
				
            	testArray.put("test"+j);
			}
            jsonObject.put("test", testArray);
            System.out.println(jsonObject.toString());
            String name = (String) jsonObject.get("Name");
            String author = (String) jsonObject.get("Author");
            JSONArray companyList = (JSONArray) jsonObject.get("Company List");
            
            JSONArray testList = (JSONArray)jsonObject.get("test");
            
            for (int i = 0; i < testList.length(); i++) {
            	System.out.print(" "+testList.get(i));
			}
            
            System.out.println(companyList.toString());
            System.out.println("Name: " + name);
            System.out.println("Author: " + author);
            System.out.println("\nCompany List:");
          /*  Iterator<String> iterator = companyList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }*/
		Object obj1 = parser.parse(new FileReader(
                "D:/E/SalesCenter_2016_Sprint_8/A/src/jsonText.txt"));
		String result = obj1.toString();
		String firstChar = String.valueOf(result.charAt(0));
		if (firstChar.equalsIgnoreCase("[")) {
		   System.out.println("array");
		}else{
			 System.out.println("Object");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
