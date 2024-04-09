package kr.co.quiz;

public class Ex12_Abstract {

	public static void main(String[] args) {
		
		Ex12_1_Book book = new Ex12_1_Book("토비의 스프링", 80000, "토비");
		
		book.use();
		
		System.out.println(book.getAuthor());
		
		
		System.out.println("------------------------------------");
		
		Ex12_1_Pen pen = new Ex12_1_Pen("김현중", 3000, "공부 열심히 하세요~ 화이팅!");
		
		pen.use();
		System.out.println(pen.blessing);
		
		System.out.println("------------------------------------");
		
		Ex12_2_Pen2 pen2 = new Ex12_2_Pen2("김현중", 30000, "화이팅");
		pen2.use();
		
	}

}
