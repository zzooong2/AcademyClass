package kr.co.green.common.validation;

import org.springframework.stereotype.Component;

@Component
public class DataValidation {

	public boolean lengthCheck(String data, int dataLength) {
//		int byteLength = 0;
//		
//		// toCharArray: 문자열을 문자 하나씩 떼어내서 배열로 만들어줌 -> 안녕 = ['안', '녕']
//		for(char c : data.toCharArray()) {
//			if(Character.toString(c).matches("a-zA-Z0-9")) {
//				byteLength += 1;
//			} else if (Character.toString(c).matches("ㄱ-ㅎㅏ-ㅣ가-힣")) {
//				byteLength += 3;
//			}
//		}
		
		int byteLength = data.getBytes().length;
		
		if(byteLength > dataLength) {
			return false;
		} else {
			return true;
		}
		
	}
}
