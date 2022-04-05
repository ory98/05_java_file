package step5_02.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

//# 파일 로드하기 : 연습문제


public class FileEx05_정답예시 {

	public static void main(String[] args) {
		
		// 4번 연습문제에서 작성된 테스트파일을 읽어들여와 아래 배열에 저장하시오.
		
		String[] names = new String[3];			// momk , megait , github
		String[] pws   = new String[3];			// 1111 , 2222   , 3333
		int[] moneys   = new int[3];			// 20000, 30000 , 40000
		
		String fileName = "fileTest02.txt";
		File file = new File(fileName); // 파일을 생성하는 기능의 객체 생성 

		if (file.exists()) {
			
			FileReader fr = null; // 비어있다. 
			BufferedReader br = null; // 비어있다. 
			
			try {
				
				fr = new FileReader(file); // file을 넣는다. 
				br = new BufferedReader(fr); // fr을 넣는다. 
				int i = 0;
				
				while (true) {
					
					String line = br.readLine(); // 한줄 읽어온다. 
					
					if (line == null) { // 없으면 그만 읽는다. 
						break;
					}
					
					String[] info = line.split("/"); // info는 "/"를 기준으로 나누어 배열을 가진다.
					names[i] = info[0]; // 0번째 배열 자리에 이름 배열을 넣는다. 
					pws[i] = info[1]; // 1번째 배열 자리에 psw 배열을 넣는다. 
					moneys[i] = Integer.parseInt(info[2]); // 2번째 배열 자리에 숫자로 바꿔서 money배열을 넣는다. 
					
					i++;
					
				}
				
				for (int j = 0; j < names.length; j++) {
					System.out.println(names[j] + ":" + pws[j] + ":" + moneys[j]);
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {br.close();} catch (IOException e) {e.printStackTrace();}
				try {fr.close();} catch (IOException e) {e.printStackTrace();}
			}
			
		}


	}

}
