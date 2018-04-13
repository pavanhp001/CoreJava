
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;


public class HttpCilentExample {

	/**
	 * @param args
	 */
	private static final String USER_AGENT = "Mozilla/5.0";
	public static void main(String[] args) {
		 sendPost();
	}

	private static void sendPost() {
		
		// TODO Auto-generated method stub
		StringBuffer result = null;
		try{

		String url = "https://qa-enroll.dpspartnerportal.com/DPSPartnerPortal/Web/Enrollment";

		HttpClient client = HttpClientBuilder.create().build();

		HttpPost post = new HttpPost(url);

		// add header
		post.setHeader("User-Agent", USER_AGENT);

		List<BasicNameValuePair> urlParameters = new ArrayList<BasicNameValuePair>();
		urlParameters.add(new BasicNameValuePair("UDC_code", "ALLC"));
		urlParameters.add(new BasicNameValuePair("AllConnect", "INUM"));
		urlParameters.add(new BasicNameValuePair("AllConnect Agent ID", "76385"));
		urlParameters.add(new BasicNameValuePair("Customer First Name", "John"));
		urlParameters.add(new BasicNameValuePair("Customer Middle Name", "Deo"));
		urlParameters.add(new BasicNameValuePair("Customer Last Name", "Palapala"));
		urlParameters.add(new BasicNameValuePair("Customer Service Address1", "2007 W Scrull St"));
		urlParameters.add(new BasicNameValuePair("Customer Service Address2", ""));
		urlParameters.add(new BasicNameValuePair("Customer Service City", "Pine Bluff"));
		urlParameters.add(new BasicNameValuePair("Customer Service State", "AR"));
		urlParameters.add(new BasicNameValuePair("Customer Service Zipcode", "71601"));
		urlParameters.add(new BasicNameValuePair("Customer Phone_nbr", "1234567890"));
		urlParameters.add(new BasicNameValuePair("Customer Email_Address", "npalapala@allconnect.com"));
		urlParameters.add(new BasicNameValuePair("Product Offer_id", "8676090816101654"));
		
		/*
		a.	UDC_code Default ‘ALLC’
		b.	AllConnect INUM
		c.	AllConnect Agent ID
		d.	Customer First Name
		e.	Customer Middle Name
		f.	Customer Last Name
		g.	Customer Service Address1
		h.	Customer Service Address2
		i.	Customer Service City
		j.	Customer Service State
		k.	Customer Service Zipcode
		l.	Customer Phone_nbr
		m.	Customer Email_Address
		n.	Product Offer_id
        */

		post.setEntity(new UrlEncodedFormEntity(urlParameters));

		HttpResponse response = client.execute(post);
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + post.getEntity());
		System.out.println("Response Code : " +response.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader( new InputStreamReader(response.getEntity().getContent()));

		result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}

		System.out.println(result.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
