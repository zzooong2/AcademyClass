package kr.co.quiz;

import java.util.Scanner;

public class Quiz_1 {

	public static void main(String[] args) {
		
			
//		Q1. 아래의 조건에 만족하는 변수를 선언하세요.
		
//		1. 논리형을 넣을 varFalse 변수를 선언하세요.
//		   -> 위에서 선언한 변수를 false로 초기화 하세요.
		boolean varFalse;
		varFalse = false;
		
//		2. 문자형을 넣을 varChar 변수를 선언하세요.
//		   -> 위에서 선언한 변수를 'Q'로 초기화 하세요.
		char varChar;
		varChar = 'Q';
		
//		3. 정수형 숫자를 넣을 varNum 변수를 선언하세요.
//		   -> 위에서 선언한 변수를 10으로 초기화 하세요.
		int varNum;
		varNum = 10;
		
//		4. 문자열을 넣을 varStr 변수를 선언 및 초기화를 동시에 하세요.
//		   -> 값은 "Java"가 들어갑니다.
		String varStr = "Java";
		
		
//		Q2. 두개의 정수 변수 a와 b를 선언하고, 각각 5와 3의 값을 할당하세요
		int a = 5;
		int b = 3;
		
//		1. a와 b의 합을 구하고 결과를 출력
		System.out.println("a + b = " + (a+b));
		
//		2. a와 b의 차이를 구하고 결과를 출력
		System.out.println("a - b = " + (a-b));
		
//		3. a와 b의 곱을 구하고 결과를 출력
		System.out.println("a x b = " + (a*b));
		
//		4. a를 b로 나눈 결과를 출력
		System.out.println("a / b = " + (a/b));
		
//		5. a를 b로 나눈 나머지를 출력
		System.out.println("a % b = " + (a%b));
		
		System.out.println("-----------------");
		
		
//		Q3. 두개의 문자열을 이어 붙이세요.
		
//		1. 변수 strFirst 에 문자열 "Hello, " 를 할당
		String strFirst = "Hello, ";
		
//		2. 변수 strSecond 에 문자열 "World!"를 할당
		String strSecond = "World!";	
				
//		3. 두개의 문자열을 이어 붙여 출력
		System.out.println(strFirst + strSecond);
		
		
		System.out.println("-----------------");

				
//		Q1. 1부터 100까지의 숫자 중에서 3의 배수인 숫자만 출력하는 자바 프로그램을 작성
		
//		1. for 문을 사용하여 1부터 100까지의 숫자를 반복 실행
		for(int i=1; i<101; i++) {
			System.out.print(i + " " + '\t');
		}
		System.out.println();
		System.out.println("-----------------");
		
//		2. if 문을 사용하여 각 숫자가 3의 배수인지를 확인		
//		3. 3의 배수인 경우 해당 숫자를 출력
		for(int j=1; j<101; j++) {
			if(j%3==0) {
			System.out.print(j + " " + '\t');
			}
		}
		
		System.out.println();
		
		
		System.out.println("-----------------");
		
//		Q2. 사용자로부터 국어, 영어, 수학, 과학 성적을 입력받고 평균 점수를 아래 기준에 따라 출력하는 프로그램을 작성
//		1. 90점 이상 : 평균 점수는 A 입니다.
//		2. 80점 이상 : 평균 점수는 B 입니다.
//		3. 70점 이상 : 평균 점수는 C 입니다.
//		4. 60점 이상 : 평균 점수는 D 입니다.
//		5. 50점 이상 : 평균 점수는 E 입니다. 
//		6. 50점 미만 : 평균 점수는 F 입니다.
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어 점수를 입력하시오: ");
		int kor = sc.nextInt();
		System.out.print("영어 점수를 입력하시오: ");
		int eng = sc.nextInt();
		System.out.print("수학 점수를 입력하시오: ");
		int mat = sc.nextInt();
		System.out.print("과학 점수를 입력하시오: ");
		int sci = sc.nextInt();
		System.out.println();
		
		int avg = (kor + eng + mat + sci) / 4;
		System.out.println("평균 점수: " + avg);
		
		if(avg >= 90) {
			System.out.println("등급: A");
		} else if (avg >= 80) {
			System.out.println("등급: B");
		} else if (avg >= 70) {
			System.out.println("등급: C");
		} else if (avg >= 60) {
			System.out.println("등급: D");
		} else if (avg >= 50) {
			System.out.println("등급: E");
		} else if (avg < 50) {
			System.out.println("등급: F");
		}
		
		
		System.out.println("-----------------");
		
		
//		Q3. 사용자로부터 국어, 영어, 수학, 과학 성적을 입력받고 배열에 담은 후 아래 기준에 따라 출력하는 프로그램을 작성
//		1. 90점 이상 : OO의 성적은 A 입니다.
//		2. 80점 이상 : OO의 성적은 B 입니다.
//		3. 70점 이상 : OO의 성적은 C 입니다.
//		4. 60점 이상 : OO의 성적은 D 입니다.
//		5. 50점 이상 : OO의 성적은 E 입니다. 
//		6. 50점 미만 : OO의 성적은 F 입니다.
//		ex) 영어의 성적은 A 입니다.  /  과학의 성적은 E 입니다.
		
		int[] studyScore = new int[4];
		studyScore[0] = kor;
		studyScore[1] = eng;
		studyScore[2] = mat;
		studyScore[3] = sci;
		
		String[] name = {"국", "영", "수", "과"};
		
		for(int i=0; i<studyScore.length; i++) {
			if(studyScore[i] >= 90) {
				System.out.println(name[i] + "의 성적: A");
			} else if (studyScore[i] >= 80) {
				System.out.println(name[i] + "의 성적: B");
			} else if (studyScore[i] >= 70) {
				System.out.println(name[i] + "의 성적: C");
			} else if (studyScore[i] >= 60) {
				System.out.println(name[i] + "의 성적: D");
			} else if (studyScore[i] >= 50) {
				System.out.println(name[i] + "의 성적: E");
			} else if (studyScore[i] < 50) {
				System.out.println(name[i] + "의 성적: F");
			}
		}
		
		
		
		System.out.println("-----------------");
		
		
		
		
//		Q4. 5개의 정수를 가진 변수를 생성하고, 이 중에서 가장 큰 수와 가장 작은 수를 찾아 출력
		
//		1. num1, num2, num3, num4, num5에 각각 임의의 숫자를 할당  --> 배열 (1~100까지 숫자)
		int[] num = {3 ,6 ,9 ,12, 15};
		
//		2. for문을 활용하여 최대값과 최소값을 출력
		int min = num[0];
		int max = num[0];
		
		for(int i=0; i<num.length; i++) {
			if(min > num[i]) {
				min = num[i];
			}
			
			if(max < num[i]) {
				max = num[i];
			}
		}
		System.out.println("최소값: " + min);
		System.out.println("최대값: " + max);
		
		System.out.println("-----------------");
	
		

//		Q5. 주어진 배열에서 모든 요소의 합을 계산하여 출력하는 프로그램을 작성
		int[] score = {37, 84, 12, 56, 91, 24, 63};
		int sum =0;
		
		for(int i=0; i<score.length; i++) {
			sum += score[i];
		}
		System.out.println("합계: " + sum);
		
	
		System.out.println("-----------------");
		
		
//		Q6. 사용자로부터 10개의 정수를 입력 받아, 배열에 저장한 후 배열의 요소 중에서 짝수의 개수와 홀수의 개수를 출력하는 자바 프로그램을 작성
//		1. Scanner 클래스를 사용하여 사용자로부터 정수를 입력 받을 수 있습니다.		
//		2. 크기가 10인 정수 배열을 선언하고 사용자 입력을 배열에 저장		
//		3. for 루프를 사용하여 10번의 입력을 받고 배열에 저장		
//		4. 배열을 반복하여 짝수와 홀수를 세고 개수를 출력
		int[] arr = new int[10];
		
		int cnt = 0; // 짝
		int cnt2 = 0; // 홀
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(i + "번 숫자를 입력하세요: ");
			arr[i] = sc.nextInt();
				
				if(arr[i] % 2 == 0) {
					cnt ++;
				} else if(arr[i] % 2 != 0) {
					cnt2 ++;	
				}
		}
		System.out.println("짝수 수량: " + cnt);
		System.out.println("홀수 수량: " + cnt2);
		
		System.out.println("-----------------");
		
		
//		Q7. 배열을 사용해 학생들의 성적 찾기
//		1. int[] scores = {85, 90, 78, 92, 88} 배열을 활용
//		2. 모든 학생의 성적의 평균을 계산하고 출력
//		3. 가장 높은 성적을 가진 학생의 성적을 출력
//		4. 가장 낮은 성적을 가진 학생의 성적을 출력
//		5. 80점 이상을 받은 학생의 수를 계산하고 출력
		int[] scores = {85, 90, 78, 92, 88};
		
		int sum2 = 0;
		int avgCnt = 0;
		int minScore = scores[0];
		int maxScore = scores[0];
		
		for(int i=0; i<scores.length; i++) {
			sum2 += scores[i];
		}
		
		int avg3 = sum2 / scores.length ;
		
		System.out.println("성적 합계: " + sum);
		System.out.println("성적 평균: " + avg3);
		
		for(int i=0; i<scores.length; i++) {
			if(minScore > scores[i]) {
				minScore = scores[i];
			}
			
			if(maxScore < scores[i]) {
				maxScore = scores[i];
			}
			
			if(scores[i] >= 80) {
				avgCnt ++;
			}
		}
		System.out.println("가장 높은 성적: " + minScore);
		System.out.println("가장 낮은 성적: " + maxScore);
		System.out.println("80점 이상 학생 수: " + avgCnt);
		

	}

}
