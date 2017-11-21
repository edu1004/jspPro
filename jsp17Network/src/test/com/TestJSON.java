package test.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestJSON {
	
	public String getJSON(String address) {
		
		HttpURLConnection conn = null;
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(address);
			conn = (HttpURLConnection) url.openConnection();
			System.out.println("conn.getResponseCode():"+conn.getResponseCode());
			is = conn.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String str = "";
			while((str = br.readLine()) != null) {
				sb.append(str);
			}
			System.out.println(sb.toString());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(br!=null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(isr!=null){
				try {
					isr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(is!=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null)conn.disconnect();
			
		}
		return sb.toString();
	}

}
