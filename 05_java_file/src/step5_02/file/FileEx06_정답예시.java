package step5_02.file;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//# 파일 컨트롤러[1단계] : 벡터

public class FileEx06_정답예시 {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int[] vector = null; // 비어있다. 
		int elementCnt = 0;
		
		String fileName = "vector.txt"; // 이 파일을 만든다. 
		
		while (true) {
			
			for (int i = 0; i < elementCnt; i++) {
				System.out.print(vector[i] + " "); // 
			}
			System.out.println();
			
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가하기");
			System.out.println("[2]삭제하기");
			System.out.println("[3]저장하기");
			System.out.println("[4]로드하기");
			System.out.println("[5]종료하기");
			
			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();
			
			if (sel == 1) {
				if (elementCnt == 0) { // 요소가 0개일때 새로운 배열을 만든다.
					vector = new int[elementCnt + 1];
				}
				else if (elementCnt > 0) { // 0개 이상일때
					int[] temp = vector;  // 백터를 일시적 배열 temp에 담는다.
					vector = new int[elementCnt + 1]; // 한개 더 늘어난 배열을 백터에 담는다. 
					
					for (int i=0; i< elementCnt; i++) { // 반복 
						vector[i] = temp[i]; // 일시적 배열 temp를 백터에 담는다.
					}
					temp = null; // 일시적 배열 temp 삭제 
				}
				System.out.print("[추가]데이터 입력 : ");
				int data = scan.nextInt();
				
				vector[elementCnt] = data; // 추가한 데이터를 백터 배열에 넣는다. 
				elementCnt++; 
			}
			else if (sel == 2) { // 2번을 선택했을 때 
				System.out.print("[삭제]인덱스 입력 : ");
				int delIdx = scan.nextInt(); 
				
				if (elementCnt - 1 < delIdx || delIdx < 0) { // 삭제인덱스가 요소갯수-1 보다 크거나 0보다 작을 때 다음 문구를 내보낸다. 
					System.out.println("[메세지]해당 위치는 삭제할 수 없습니다.");
					continue; // 무한 반복 
				}
				
				if(elementCnt == 1) { // 요소갯수가 1개일 때, 
					vector = null; // 백터는 비어있다. 
				}
				else if(elementCnt > 1) { // 요소갯수가 1보다 많을 때 
					int[] temp = vector; // 백터를 일시적 배열에 넣는다. 
					vector = new int[elementCnt - 1]; // 하나 뺀 배열을 백터에 넣는다. 
					
					int j = 0;
					for (int i = 0; i < elementCnt; i++) { 
						if (i != delIdx) { // 삭제인덱스가 i의 갯수와 같지 않을 경우 
							vector[j] = temp[i]; // 일시적 i 문자를 백터 j에 넣는다. ******* 질문 
							j++; // j는 증가한다. 
						}
					}
					temp = null; // 일시적 배열은 삭제한다.
				}
				elementCnt--; // 요소 갯수를 하나씩 줄인다. 
			}
			else if(sel == 3) {				
				String data = ""; // 스트링은 숫자를 인식하지못하기 때문에 넣어준다. 
				if (elementCnt > 0) { 
					for (int i = 0; i < elementCnt; i++) { 
						data += vector[i]; // 데이터에 i를 넣어준다. 
						data += "\n"; // 한줄 밑으로 저장한다. 
					}
					data = data.substring(0, data.length() - 1); // 배열 0에서부터 data길이-1 까지 추출 > 마지막 글자 삭제 
					
					FileWriter fw = null; // 파일 비어있음. 
					try {
						fw = new FileWriter(fileName); // fileName에 fw배열 넣기를 넣는다. 
						fw.write(data); // 파일에 data입력 > write메서드를 이용해서만 입력가능 , 문자열만 입력가능
					} catch (Exception e) { // 에러가 있을 경우 
						e.printStackTrace(); // 에러 난 이유 보여주기 
					} finally { // 객체 종료 
						try {fw.close();} catch (IOException e) {e.printStackTrace();} 
					}
				} 
				else { // 0보다 작으면 
					System.out.println("[메세지]저장할 데이터가 없습니다.");
				}
				
			}
			else if (sel == 4) {
				String data = ""; // 숫자 인식 불가능 > ""데이터로 입력 
				File file = new File(fileName); // 파일 생성 기능의 객체 생성 
				
				if (file.exists()) { // 파일이 존재하면 true 
					
					FileReader fr = null; 
					BufferedReader br = null; 
					
					try {
						
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						
						while (true) {
							String line = br.readLine();
							if (line == null) {
								break;
							}
							data += line;
							data += "\n";
						}
						data = data.substring(0, data.length() - 1);
						
						String[] temp = data.split("\n");
						elementCnt = temp.length;
						
						vector = new int[elementCnt];
						
						for (int i = 0; i < elementCnt; i++) {
							vector[i] = Integer.parseInt(temp[i]);
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {br.close();} catch (IOException e) {e.printStackTrace();}
						try {fr.close();} catch (IOException e) {e.printStackTrace();}
					}
				}
			}
			else if (sel == 5) {
				System.out.println("프로그램 종료");
				break;
			}
			
		}
		
	}
}
