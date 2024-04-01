package kr.co.green;

public class Ex13_Exception {

	public static void main(String[] args) {

		// 예외처리를 할 때 catch 부분에 매개변수로 Exception을 던지는건 지양해야한다.
		
		// Exception은 모든 예외의 부모클래스이기에 
		// 1. 개발자가 어떤 예외가 발생했는지 모른다
		// 2. 어떤 예외가 발생하던지 예외처리가 되버린다
		
		// 따라서 로직을 구성할 때 어떠한 발생 가능성 있는 예외에 대한 처리를 해줘야한다.
		// Exception e -> ArrayIndexOutOfBoundsException e
		
		int[] arr = new int[5]; // index: 0 ~ 4

		try {
			System.out.println("예외 발생 전");
			arr[5] = 10; // ArrayIndexOutOfBoundsException 발생
			System.out.println("예외 발생 후"); // 예외가 발생된 이후에는 코드 진행 X
		} catch (Exception e) {
			System.out.println("예외 발생" + '\n');
			System.out.println(e);
			System.out.println();
			
			// 예외 모든내용 출력
			System.out.println("---printStackTrace---");
			e.printStackTrace();
			System.out.println();
			
			// 예외발생지점 출력
			System.out.println("---getStackTrace----");
			System.out.println(e.getStackTrace()[0]);
			System.out.println();
			
			// 예외이름, 예외내용 출력
			System.out.println("---toString---");
			System.out.println(e.toString());
			System.out.println();
			
			// 예외내용 출력
			System.out.println("---getMessage---");
			System.out.println(e.getMessage());
			
		} finally {
			// 예외 발생 유무와 상관없이 실행되는 부분
			System.out.println();
			System.out.println("예외 처리는 신중하게");
		}

	}

}