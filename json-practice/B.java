import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class B {

	/**
	 * @param args
	 * @throws JSONException 
	 */
	public static void main(String[] args) throws JSONException {

		String jsonInput = "{\"JObjects\":{\"JArray1\":[\"A=a\",\"B=b\",\"C=c\",\"A=a1\",\"B=b2\",\"pavan=c3\",\"D=d4\",\"E=e5\",\"A=aa\",\"B=bb\",\"C=cc\",\"D=dd\"]}}";

		// "I want to iterate though the objects in the array..."
		System.out.println("jsonInput" + jsonInput);
		JSONObject outerObject = new JSONObject(jsonInput);
		JSONObject innerObject = outerObject.getJSONObject("JObjects");
		JSONArray jsonArray = innerObject.getJSONArray("JArray1");
		System.out.println("jsonArray" + jsonArray);
		for (int i = 0, size = jsonArray.length(); i < size; i++) {
			String providerArray[] = jsonArray.getString(i).split("=");
			if (providerArray[0].equalsIgnoreCase("pavan")) {
				System.out.println("pavan kumar");
			}
			System.out.println();
		}
	}

}
