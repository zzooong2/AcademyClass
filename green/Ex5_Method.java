package kr.co.green;

public class Ex5_Method {
	
	public static void main(String[] args) {
	
		// 객체 생성 (인스턴스화)
		// Ex5_Method 클래스를 메모리에 올리는 과정
		
		// 클래스명 변수명 = new 클래스명();
		Ex5_1_Calculator method = new Ex5_1_Calculator();
		
		// 변수명.메소드명();
		method.add(10, 20);
		method.sub(10, 20);
		method.mul(10, 20);
		method.div(10, 20);
		
	}

}
