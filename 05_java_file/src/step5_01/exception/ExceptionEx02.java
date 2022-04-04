package step5_01.exception;

/*
 * 
 * # finally
 * 
 *  예외발생과 상관없이 무조건 실행할 명령어를 작성한다.
 *  주로 외부 모듈과의 컨넥션을 종료할때 사용한다. ******
 *  > 외부 연결을 종료를 무조건 해야 불안정 
 * 
 * */

public class ExceptionEx02 {

	public static void main(String[] args) {
		
		try { // 실행이 안될 경우  
			
			int[] testArr = new int[5];
			// System.out.println(testArr[0]);
			// System.out.println(testArr[999]); // > 배열 초과 에러
			System.out.println(testArr[0] / 0); // > 연산 에러 (0으로 나누면 무조건 에러)	
	
		} catch (Exception e) { // 모든 에러 대응 (= else문)
			System.out.println("모든 에러 catch");
			e.printStackTrace();
		} finally { // > 에러 상관없이 무조건 실행  > 외부 연결을 무조건 종료할 때 사용 
			System.out.println("예외발생과 상관없이 무조건 실행할 명령어를 작성한다.");
			System.out.println("주로 외부 모듈과의 컨넥션을 종료할때 사용한다.");
		}
		
		

	}

}
