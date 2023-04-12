package com.example.Assignment8_Fetching_Data_Using._Java3;

import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootApplication
public class Assignment8FetchingDataUsingJava3Application {

	public static void main(String[] args) throws Exception {
		URL getURL = new URL("https://api.nationalize.io/?name=nathaniel");
		HttpURLConnection connection = (HttpURLConnection) getURL.openConnection();
		connection.setRequestMethod("GET");
		int responseCode = connection.getResponseCode();

		if(responseCode == 200){
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			StringBuffer jsonResponseData = new StringBuffer();
			String readLine = null;

			while((readLine = in.readLine())!=null){
				jsonResponseData.append(readLine);
			}
			in.close();
			JSONObject obj = new JSONObject(jsonResponseData.toString());
//			System.out.println("Output -");
			System.out.println(obj);
			//To make json beautify and readable
//			System.out.println("\n Beautified JSON  -");
//			System.out.println(obj.toString(3));
		}else{
			System.out.println("Code Error - " + responseCode);
		}
	}

}
