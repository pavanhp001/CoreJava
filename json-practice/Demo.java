import org.jsoup.Jsoup;

/*import org.apache.commons.lang.StringEscapeUtils;

import com.allconnect.xml.dtl.v4.CustomerContextEntityType;
*/
public class Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*String s = "with Vantage TVï¿½s wireless Receiver and";
		String s3 = "with Vantage  wireless Receiver and";
		String s2 = escapeSpecialCharacters(s3);*/
		
		//System.out.println(s2);
		
		//String s ="{\"lineItems\":[{\"noEmail\":\"false\",\"img_id\":\"24699452\",\"productExernalId\":\"RTS:ATTSTI:ATT-21-AI-2TI-450LA-PRO-J\",\"isTPVProduct\":false,\"partnerExternalId\":\"24699452\",\"recuring\":\"$197.00\",\"capabilityMap\":{\"fiberDataUpSpeed\":\"fiberDataUpSpeed\",\"fiberDataDownSpeed\":\"fiberDataDownSpeed\",\"iptv\":\"iptv\"},\"productType\":\"DOUBLE_PLAY\",\"providerName\":\"ATTSTI\",\"hybrisShell\":\"false\",\"non_recuring\":\"$0.00\",\"isWarmTransfer\":false,\"noOrderStatus\":\"false\",\"isPromotion\":false,\"providerSourceBaseType\":\"REALTIME\",\"orderId\":1900081715,\"productname\":\"U450 Latino TV All Included + Internet Basic 3 (3 MB 1 MB)\"} , {\"noEmail\":\"false\",\"img_id\":\"27010360\",\"productExernalId\":\"RTS:DISH:CORE_222291\",\"isTPVProduct\":false,\"partnerExternalId\":\"27010360\",\"recuring\":\"$74.99\",\"capabilityMap\":{\"satellite\":\"satellite\"},\"productType\":\"VIDEO\",\"providerName\":\"DISH Network\",\"hybrisShell\":\"false\",\"non_recuring\":\"$0.00\",\"isWarmTransfer\":false,\"noOrderStatus\":\"false\",\"isPromotion\":false,\"providerSourceBaseType\":\"REALTIME\",\"orderId\":1900081715,\"productname\":\"America's Top 200\"}]}"
		 String jsonStr = "{\"dataArray\": [{\"A\": \"a\",\"B\": \"b\",\"C\": \"c\"}, { \"A\": \"a1\",\"B\": \"b2\", \"C\": \"c3\"}]}";
		System.out.println("subStr "+ subStr);
		subStr = escapeSpecialCharacters(subStr);
		System.out.println("subStr : "+subStr);
				
				
		
	}
	public static String escapeSpecialCharacters(String str){
		if(str!=null){
			//this is for - mark
			str = str.replaceAll("\u2013", "&#8211;");
			//this is for right single quotation mark
			str = str.replaceAll("\u2019", "&#8217;");
			//this is for left single quotation mark
			str = str.replaceAll("\u2018", "&#8216;");
			//this is for left double quotation mark
			str = str.replaceAll("\u201C", "&#8220;");
			//this is for right double quotation mark
			str = str.replaceAll("\u201D", "&#8221;");
			//this is for ellipsis 
			str = str.replaceAll("\u2026","&#8230;");
			//str = str.replaceAll("℠","<sup>SM</sup>");
			str = str.replaceAll("℠","<sup>SM</sup>");
		}
		return str;
	}

}
