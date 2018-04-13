package CorePractise;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

public class SplitByNewLine {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("D:/E/SalesCenter_2016_Sprint_8/A/src/cox_txt.txt"));
			StringBuilder strb = new StringBuilder();
			String sCurrentLine;
			String str = "";
			while ((sCurrentLine = br.readLine()) != null) {
				strb.append(sCurrentLine);
				strb.append("\n");
				
				//System.out.println(strb);
			}
			//System.out.println(strb.toString());
			str = strb.toString();
			//System.out.println(str);
			insertUpdate(str);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	private static void insertUpdate(String string) {
	   // System.out.println("string : "+string);
	    String splitTpvSript[] = string.split("\\r?\\n");
	    StringBuilder tpvScriptHtml =  new StringBuilder();
		for(String str:splitTpvSript){
			if(!str.contains("TPV Phone Number")){
				if(str.contains("This order requires E911 TPV")){
					tpvScriptHtml.append(str);
					tpvScriptHtml.append("</br>");
				}else if(str.contains("TPV ID")){
					tpvScriptHtml.append(str);
					tpvScriptHtml.append("</br>");
				}else{
					tpvScriptHtml.append(str);
					tpvScriptHtml.append(" ");
				}
			}
		}
		System.out.println(tpvScriptHtml.toString());
	}

}
