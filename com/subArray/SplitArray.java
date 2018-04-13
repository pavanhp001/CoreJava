package com.subArray;

import java.util.Arrays;
import java.util.List;

public class SplitArray {

	
	public static void main(String[] args) {
		
		String str = "27010360=true|26069942=false|24699452=true|103=true|4353598=false";
		//List<String> rt_provider_description_suppress = Arrays.asList(str.split("\\|"));
		List<String> rt_provider_description_suppress = null;
		
		if(rt_provider_description_suppress != null && !rt_provider_description_suppress.isEmpty() ){
			for (String rt_provider : rt_provider_description_suppress){
				System.out.println("rt_provider_description_suppress ="+rt_provider);
				String providerdata[] = rt_provider.split("=");
				if(providerdata[0].trim().equalsIgnoreCase("103")){
					//productVOJSON.setChannelLineupProvider(true);
					if(Boolean.valueOf(providerdata[1])){
						System.out.println("27010360 provider is enabled="+providerdata[1]);
					}
					break;
				}
			}
		}
		

	}

}
