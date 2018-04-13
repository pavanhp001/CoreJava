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

public class RestClientForFuse {

	private static final String URL_ENDPOINT = "https://server.fuse.analytics-engine.com/internal/lookup";//https://staging-server.fuse.analytics-engine.com/internal/lookup
	
	public static void main(String[] args) {
		try {
			String postData = "{ \"dnis\": \"8442134224\", \"ani\": \"19849369111\", \"ucid\": \"00001056401351610564\", \"callSourceId\": \"ALLCONNECT\" }";

			System.out.println("postData: " + postData);
			postFuseData(postData);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public  static void postFuseData(String postData) throws Exception {
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
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/json");
			OutputStream os = connection.getOutputStream();
			os.write(postData.getBytes());
			os.flush();
			/*if (connection.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ connection.getResponseCode());
			}*/

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(connection.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			connection.disconnect();
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
	}

}
