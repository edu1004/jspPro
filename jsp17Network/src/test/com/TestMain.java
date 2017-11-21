package test.com;

import org.json.JSONArray;
import org.json.JSONObject;

public class TestMain {

	public static void main(String[] args) {
		System.out.println("Network...");
		int flag = 0;

		if (flag == 0) {
			String address = "http://192.168.0.118:8090/jsp15JSON/jselectOne.do";
			String responseText = new TestJSON().getJSON(address);
			System.out.println("responseText:" + responseText);
			JSONObject obj = new JSONObject(responseText);
			System.out.println(obj.getString("name"));
			System.out.println(obj.getInt("age"));
		} else {
			String address = "http://192.168.0.118:8090/jsp16MenuJSON/jselectAll.do";
			String responseText = new TestJSON().getJSON(address);
			System.out.println("responseText:" + responseText);
			JSONArray array = new JSONArray(responseText);
			for (int i = 0; i < array.length(); i++) {
				JSONObject obj = array.getJSONObject(i);
				System.out.print(obj.getInt("num")+" ");
				System.out.print(obj.getInt("price")+" ");
				System.out.print(obj.getString("menu")+" ");
				System.out.println(obj.getString("store"));
			}
		}

	}

}
