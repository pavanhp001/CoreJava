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




public class JsonDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JSONParser parser = new JSONParser();

		try {
			 
            Object obj = parser.parse(new FileReader(
                    "D:/E/SalesCenter_2016_Sprint_8/A/src/jsonText1.txt"));
            System.out.println("obj : "+obj.toString());
            double promoPrice = Double.parseDouble("20.00");
            List<JSONObject> bundlePrice = new LinkedList<JSONObject>();
            
            
            JSONObject jsonObj = new  JSONObject(obj.toString());
            JSONArray jsonArray = new JSONArray(Arrays.asList(obj));
            System.out.println("jsonArray  == "+jsonArray);
            
            JSONObject dvrObj = (JSONObject) jsonObj.opt("NO_DVR");
           
            for (int j = 1 ; j < dvrObj.length()+1; j++) {
            	 StringBuilder newTvs= new StringBuilder();
            	 Map<String, String> map = new LinkedHashMap<String, String>();
            	 JSONObject temp = new JSONObject();
            	 JSONObject Tvs = (JSONObject) dvrObj.opt("TV"+j);
            	 System.out.println("tvs == "+Tvs);
                 String val = (String)Tvs.get("MTH");
                
                 newTvs.append("{'MTH':");
                 newTvs.append("'"+val+"'");
                 newTvs.append(",'A12M':");
                 
                 String baseVal = "";
                 if(Tvs.opt("A24M") != null && Tvs.opt("A24M") != ""){
                     baseVal = (String)Tvs.opt("A24M");
                 } else if(Tvs.opt("A12M") != null && Tvs.opt("A12M") != ""){
                     baseVal = (String)Tvs.opt("A12M");
                   }
                 newTvs.append(baseVal);
                 val = val.replace("$", "");
                 baseVal = baseVal.replace("$", "");
                 Double price = Double.parseDouble(val);
                 Double priceAM = Double.parseDouble(baseVal);
                 //JSONObject newTvs = new JSONObject();
                 Double totalprcA2M = priceAM + promoPrice;
                // temp.put("A12M", totalprcA2M);
                 
                 Double totalprc = price + promoPrice;
                // temp.put("MTH", totalprc);
                 map.put("MTH", "$"+Double.toString(totalprc));
                 map.put("A12M", "$"+Double.toString(totalprcA2M));
                 
                 newTvs.append(totalprcA2M+"},");
                 System.out.println("newTvs : "+newTvs.toString());
                 JSONObject newTvsJson = new JSONObject(map);
                // bundlePrice.add(newTvsJson);
                 bundlePrice.add(newTvsJson);
            }
            System.out.println("bundlePrice : "+bundlePrice);
            JSONObject bundlePriceJson  = new JSONObject();
            Map<String, JSONObject> m = new LinkedHashMap<String, JSONObject>();
            for(int i = 0 ; i < bundlePrice.size(); i++){
            	System.out.println("bundlePrice val : TV"+(i+1)+ " - "+bundlePrice.get(i).toString());
            	m.put("TV"+(i+1), bundlePrice.get(i));
            	bundlePriceJson.put("TV"+(i+1),bundlePrice.get(i));
            }
            JSONObject bundlePriceJson1  = new JSONObject(m);
            JSONObject bundlePriceJsonData  = new JSONObject();
            bundlePriceJsonData.put("TOTAL_PRICE", bundlePriceJson1);
            System.out.println("bundlePriceJson :: "+bundlePriceJsonData.toString());
            
            
            //jsonObj.put("TOTAL_PRICE", bundlePriceJson);
            
            //System.out.println("jsonObj :: "+jsonObj.toString());
            
            
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
