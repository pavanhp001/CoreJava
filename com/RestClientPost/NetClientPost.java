package com.RestClientPost;

	
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

//import com.allconnect.ui.service.config.ConfigRepo;

public class NetClientPost {

	// http://localhost:8080/RESTfulExample/json/product/post
	public static void main(String[] args) {

	  try {

		  String URL_ENDPOINT = "http://cor01-dvi004.east.aws.allconnect.com:9028/VZSmartCartSave/ws/vzSmartCart/saveSmartCartProduct";
			String returnStr = null;
		
			StringBuffer urlString = new StringBuffer(URL_ENDPOINT);
	
			urlString.append("?orderId=" + "1700122022");
			//if (!Utils.isBlank(firstName)) {
			/*	urlString.append("&lineItemId="
						+ "1700136244");*/
			//}
			//if (!Utils.isBlank(lastName)) {
				urlString.append("&guid="
						+"018e1258-6162-4a9c-a6aa-0d4d0fc901ec");
			//}
			
			System.out.println("urlString-customerLookup="+urlString);
			connectVZMicroService(urlString.toString());
			Boolean b = Boolean.valueOf("true");
			System.out.println("valueOf : "+b);
			System.out.println("returnStr: ");
			//return returnStr;

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public  static void connectVZMicroService(String URL_ENDPOINT) throws Exception {
		StringBuffer responseBody = new StringBuffer();
		String returnStr = null;
			StringBuffer urlString = new StringBuffer(URL_ENDPOINT);
			HttpURLConnection connection =  null;
			InputStream responseBodyStream = null;
			try{
				URL url = new URL(urlString.toString());
				if (urlString != null && urlString.toString().contains("https:")){
					connection = (HttpsURLConnection) url.openConnection();	
				}else{
					connection = (HttpURLConnection) url.openConnection();
				}
				System.out.println("setRequestMethod");
				connection.setRequestMethod("POST");
				byte buffer[] = new byte[8192];
				int read = 0;
				System.out.println("before connect ");
				connection.connect();
				System.out.println("setRequestMethod end--");
				//connection.getResponseMessage();
				System.out.println("getResponseMessage end-----");

				/*if (responseBodyStream != null){
					while ((read = responseBodyStream.read(buffer)) >= 0) {
						responseBody.append(new String(buffer, 0, read,"UTF-8"));
					}			
				}
				returnStr = responseBody.toString();*/
			}catch (IOException e) {
				e.printStackTrace();
			//	logger.error("error_occured_while_get_CustomerLookup_response",e);
			//	logger.warn("No response");
			}finally{
				if(connection!=null){
					connection.disconnect();
				}
				if(responseBodyStream!=null){
					responseBodyStream.close();
				}
			}
		//return returnStr;
	}

}
