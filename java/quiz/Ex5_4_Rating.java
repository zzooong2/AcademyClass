package kr.co.quiz;

public class Ex5_4_Rating {
	
	// 평점 변수 생성
	double rating;
	
	// 사람들이 남긴 평점 변수 생성
	public final double USER_A_RATING = 3;
	public final double USER_B_RATING = 2;
	public final double USER_C_RATING = 2.5;
	public final double USER_D_RATING = 5;
	public final double USER_E_RATING = 4;
	
	// 평점 평균을 구하는 메서드 작성
	public void getAvgRating(double userRating) {
		rating = ((USER_A_RATING + USER_B_RATING + USER_C_RATING + USER_D_RATING + USER_E_RATING) + userRating) / 6;
		System.out.println("평균 평점: " + rating);
	}
	
}
