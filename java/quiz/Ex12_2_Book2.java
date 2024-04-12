package kr.co.java.quiz;

public class Ex12_2_Book2 extends Ex12_1_Item {

	public String author;

	public Ex12_2_Book2(String name, double price, String author) {
		super.name = name;
		super.price = price;
		this.author = author;
	}

	@Override
	public void use() {
		System.out.println("책을 읽습니다.");
		System.out.println("도서명: " + name);
		System.out.println("글쓴이: " + author);
		System.out.println("도서가격: " + price + "원");

	}

	public String getAuthor() {
		return author;
	}
}
