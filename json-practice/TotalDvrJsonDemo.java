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




public class TotalDvrJsonDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JSONParser parser = new JSONParser();

		try {
			 
            Object obj = parser.parse(new FileReader(
                    "D:/E/SalesCenter_2016_Sprint_8/A/src/totalDvrJson.txt"));
            System.out.println("obj : "+obj.toString());
            double promoPrice = Double.parseDouble("20.00");
            JSONObject jsonObj = new  JSONObject(obj.toString());
            JSONArray arr = new JSONArray();
        	arr.put("NO_DVR");
        	arr.put("TOTAL_DVR");
            
            JSONObject dvrObj = (JSONObject) jsonObj.opt("NO_DVR");
            Map<String, Map<String, String>> pricingGridJsonMap = new LinkedHashMap<String, Map<String, String>>();
           
            for (int j = 1 ; j < dvrObj.length()+1; j++) {
            	 Map<String, String> map = new LinkedHashMap<String, String>();
            	 JSONObject Tvs = (JSONObject) dvrObj.opt("TV"+j);
            	 System.out.println("tvs == "+Tvs);
            	 if(pricingGridJsonMap.get("TV"+j) == null){
                	 pricingGridJsonMap.put("TV"+j, new LinkedHashMap<String, String>());
                 }
                 Map<String, String> priceData = pricingGridJsonMap.get("TV"+j);
                 priceData.put("NoOfTv","TV"+j);
                 String val = (String)Tvs.get("MTH");
                 
                 String baseVal = "";
                 if(Tvs.opt("A24M") != null && Tvs.opt("A24M") != ""){
                     baseVal = (String)Tvs.opt("A24M");
                 } else if(Tvs.opt("A12M") != null && Tvs.opt("A12M") != ""){
                     baseVal = (String)Tvs.opt("A12M");
                   }
                 System.out.println("val : "+val+" - baseVal : "+baseVal);
                 priceData.put("NO_MTH", val);
                 priceData.put("NO_A12M", baseVal);
                 val = val.replace("$", "");
                 baseVal = baseVal.replace("$", "");
                 Double price = Double.parseDouble(val);
                 Double priceAM = Double.parseDouble(baseVal);
                 Double totalprcA2M = priceAM + promoPrice;
                 Double totalprc = price + promoPrice;

                 priceData.put("TOTAL_MTH", "$"+Double.toString(totalprc));
                 priceData.put("TOTAL_A12M", "$"+Double.toString(totalprcA2M));
                 pricingGridJsonMap.put("TV"+j, priceData);
                 
            }
            System.out.println("pricingGridJsonMap :: "+pricingGridJsonMap.toString());
            JSONObject bundlePriceJsonData  = new JSONObject(pricingGridJsonMap);
            JSONObject pricingGridJsonData  = new JSONObject();
            pricingGridJsonData.put("headers",arr);
            pricingGridJsonData.put("PRICE_JSON",bundlePriceJsonData);
            System.out.println("bundlePriceJson :: "+pricingGridJsonData.toString());
      
            
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
