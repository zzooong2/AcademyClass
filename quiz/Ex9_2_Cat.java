package kr.co.quiz;

public class Ex9_2_Cat extends Ex9_2_Animal {

	public Ex9_2_Cat(String name, int age) {
		super(name, age);
	}
	
	public void meow() {
		System.out.println("야옹");
	}
	
	@Override
	public void sleep() {
		System.out.println("쿨쿨..zzZ (오버라이딩 된 메소드)");
	}
	
	@Override
	public void makeSound(String sound) {
		System.out.println(name + "이(가) " + sound + " 하고 소리를 냅니다.");
		System.out.println("고양이는 츄르를 좋아합니다.");
	}
	
}
