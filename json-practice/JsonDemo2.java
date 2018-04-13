import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;




public class JsonDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JSONParser parser = new JSONParser();

		try {
			 
            Object obj = parser.parse(new FileReader("D:/E/SalesCenter_2016_Sprint_8/A/src/jsonText1.txt"));
            System.out.println("obj : "+obj.toString());
            JSONArray arr = new JSONArray();
            String s = null;
            
            Double pairedProductpromoPrice = null;
            
            if(pairedProductpromoPrice == null){
            	
            	System.out.println("pairedProductpromoPrice : "+pairedProductpromoPrice);
            	
            }
            
            JSONObject jsonObj = new  JSONObject(obj.toString());
            JSONObject pricingGridJsonData  = new JSONObject();
            Map<String, Map<String, String>> pricingGridJsonMap = new LinkedHashMap<String, Map<String, String>>();
            
            for (int i = 1 ; i < jsonObj.length()+1; i++) {
            	JSONObject dvrObj = null;
            	String headerValue = "";
            	if(i == 1){
            		dvrObj = (JSONObject) jsonObj.opt("NO_DVR");
            		headerValue = "NO_DVR";
            	}else if(i == 2){
            		dvrObj = (JSONObject) jsonObj.opt("EN_DVR");
            		headerValue = "EN_DVR";
            	}
            	else if(i == 3){
            		dvrObj = (JSONObject) jsonObj.opt("PR_DVR");
            		headerValue = "PR_DVR";
            	}
            	arr.put(headerValue);
            
	            if(dvrObj != null){
	            	Map<String, JSONObject> m2 = new LinkedHashMap<String, JSONObject>();
		            for (int j = 1 ; j < dvrObj.length()+1; j++) {
		            	 Map<String, String> map = new LinkedHashMap<String, String>();
		            	 JSONObject noOfTv = (JSONObject) dvrObj.opt("TV"+j);
		            	 System.out.println("tvs == "+noOfTv);
		                 String val = (String)noOfTv.get("MTH");
		                 
		                 String baseVal = "";
		                 String headerData = "";
		                 if(noOfTv.opt("A24M") != null && noOfTv.opt("A24M") != ""){
		                     baseVal = (String)noOfTv.opt("A24M");
		                     headerData = "After 24 Months";
		                 }else if(noOfTv.opt("A12M") != null && noOfTv.opt("A12M") != ""){
		                     baseVal = (String)noOfTv.opt("A12M");
		                     headerData = "After 12 Months";
		                 }
		                 if(pricingGridJsonMap.get("TV"+j) == null){
		                	 pricingGridJsonMap.put("TV"+j, new LinkedHashMap<String, String>());
		                 }
		                 Map<String, String> priceData = pricingGridJsonMap.get("TV"+j);
		                 
		                 priceData.put("NoOfTv",j+" TV");
		                 priceData.put("header1","Monthly Price");
		                 priceData.put("header2",headerData);
		                 
		                 priceData.put(headerValue+"_MTH", val);
		                 priceData.put(headerValue+"_A12M", baseVal);
		                 pricingGridJsonMap.put("TV"+j, priceData);
		            }
	            }
            }
            System.out.println("pricingGridJsonMap :: "+pricingGridJsonMap.toString());
            JSONObject bundlePriceJsonData  = new JSONObject(pricingGridJsonMap);
            pricingGridJsonData.put("headers",arr);
            pricingGridJsonData.put("PRICE-JSON",bundlePriceJsonData);
            System.out.println("bundlePriceJson :: "+pricingGridJsonData.toString());
            
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
