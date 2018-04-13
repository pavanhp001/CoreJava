package com.jsoup;

//import org.apache.commons.lang.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;

public class JsoupTest {

	public static void main(String[] args) {
	
		
		String data = "<fieldset id='CloseConvertedCall_2_FS' class='styled custom_padding'> <p class='black'>You’ll receive an order summary and status updates via your email or your best contact number {ContactPhoneNumber}.</p></fieldset>REPLACERTIMDIALOGUES<fieldset id='CloseConvertedCall_6_FS' class='styled custom_padding'> <p class='black'>You’ll receive an order summary and status updates via your email or your best contact number {ContactPhoneNumber}.</p></fieldset><fieldset id='CloseConvertedCall_3_FS' class='styled custom_padding'> <p class='black'>You’ll receive an order summary and status updates via your email or your best contact number {ContactPhoneNumber}.</p></fieldset><fieldset id='CloseConvertedCall_5_FS' class='styled custom_padding'> <p class='black'>You can also check on your order status at any time at www.allconnect.com (link will be in email). Or, feel free to call us back at {referrer.businessParty.callbackNumber} and enter your order number {order.id}. Again, It’s been a pleasure speaking with you today. Is there anything else I can help you with? </p> </fieldset>";
		String data1 = "<fieldset id='CloseConvertedCall_3_FS' class='styled custom_padding'> <p class='black'>777777777777777777 or your best contact number {ContactPhoneNumber}.</p></fieldset><fieldset id='CloseConvertedCall_5_FS' class='styled custom_padding'> <p class='black'>You can also check on your order status at any time at www.allconnect.com (link will be in email). Or, feel free to call us back at {referrer.businessParty.callbackNumber} and enter your order number {order.id}. Again, It’s been a pleasure speaking with you today. Is there anything else I can help you with? </p> </fieldset>";
		
		new JsoupTest().generateDialoguesAll(data, data1);

	}
	
	public String generateDialoguesAll(String response, String dist){
		String res  = null;
		try{
			Document doc = Jsoup.parse(response);
			StringBuilder sb = new StringBuilder();
			for(Element e : doc.getAllElements()){
				//System.out.println(e.text());
				//System.out.println(e.tag());
				if(e.tag().toString() == "fieldset" && (e.getElementById("CloseConvertedCall_3_FS") != null || e.getElementById("CloseConvertedCall_5_FS") != null)){
					e.remove();
				}else{
					if(e.tag().toString() == "fieldset" && e.getElementById("CloseConvertedCall_2_FS") != null ){
						
						sb.append(e).append("REPLACERTIMDIALOGUES");
					}
					else if(e.tag().toString() == "fieldset"){
						sb.append(e);
					}
				}
			}
			System.out.println(sb.toString());
			
		}catch (Exception e) {
			e.printStackTrace();
			//logger.warn("No Dialogues Found in Drupal");
		}
		//System.out.println();
		return res;
	}

}
