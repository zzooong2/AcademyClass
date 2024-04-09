package kr.co.quiz;

public class Ex12_1_Pen extends Ex12_1_Item {

	public String blessing;

	public Ex12_1_Pen(String name, double price, String blessing) {
		super.name = name;
		super.price = price;
		this.blessing = blessing;
	}

	@Override
	public void use() {
		System.out.println("사인을 해줍니다.");
		System.out.println("To. " + name);
		System.out.println(blessing);
		System.out.println("팬사인회 가격: " + price);
	}

	public String getBelssing() {
		return blessing;
	}
}
