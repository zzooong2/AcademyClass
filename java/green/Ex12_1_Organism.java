package kr.co.java.green;

// 추상메서드가 하나라도 선언되어있으면 추상클래스
public abstract class Ex12_1_Organism {
	
	
	// 일반 클래스와 동일한 기능
	public void organism() {
		System.out.println("생물체");
	}
	
	// 추상메서드 : 구현부{} 가 없음
	public abstract void eat();
	
	public abstract void breath();
}
