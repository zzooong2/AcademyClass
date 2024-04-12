package kr.co.java.problem;

// Ex_12_3_StudentInterface 구현
public class Problem_1_Student implements Problem_1_Interface {

	public String name;
	public int kor, eng, mat, sci;
	int sum;
	
	public Problem_1_Student(String inputName, int inputKor, int inputEng, int inputMat, int inputSci) {
		this.name = inputName;
		this.kor = inputKor;
		this.eng = inputEng;
		this.mat = inputMat;
		this.sci = inputSci;
	};
	
	@Override
	public void getSum() {
		int sum = kor + eng + mat + sci;
		System.out.println(name + "님의 합계 점수는 " + sum + "점 입니다.");
	}

	@Override
	public int getAvg() {
		int avg = (kor + eng + mat + sci) / 4;
		System.out.println(name + "님의 평균 점수는 " + avg + "점 입니다.");
		return avg;
	}

	@Override
	public void getRank(int getAvg) {
		double[] array = { STUDENT_A_AVG, STUDENT_B_AVG, STUDENT_C_AVG, STUDENT_D_AVG, STUDENT_E_AVG };

		int myRank = 1;

		for (double item : array) {
			if (getAvg < item) {
				myRank++;
			}
		}
		System.out.println("등수: " + myRank);
	}
}
