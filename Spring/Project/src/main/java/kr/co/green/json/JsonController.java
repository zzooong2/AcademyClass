package kr.co.green.json;

import com.google.gson.Gson;

public class JsonController {
	public static void main(String[] args) {
		JsonDTO data = new JsonDTO();
		
		data.setName("홍길동");
		data.setAge(22);
		data.setAdmin(false);
		
		System.out.println(data.toString());
		
		// Java 객체 -> JSON 문자열로 변환
		Gson gson = new Gson();
		String dataJson = gson.toJson(data);
		System.out.println(dataJson);
		
		// JSON 문자열 -> Java 객체로 변환 
		JsonDTO dataObject = gson.fromJson(dataJson, JsonDTO.class);
		System.out.println(dataObject);
	}
}
