package kr.co.quiz;

public class Ex12_2_Pen2 implements Ex12_2_Item2 {

	public String blessing;

	public Ex12_2_Pen2(String name, double price, String blessing) {
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
