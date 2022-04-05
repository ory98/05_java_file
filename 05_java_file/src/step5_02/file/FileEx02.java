package step5_02.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//  # 파일 로드 (불러오기) [File Output] 

public class FileEx02 {

	public static void main(String[] args) {
		
		String fileName = "ex01.txt";
		
		File file = new File(fileName); // 파일 객체 생성 
		FileReader fr = null;			// 파일 읽어오는 개체 
		BufferedReader br = null;		// 텍스트를 읽어오는 개체 
		
		if (file.exists()) { // exists() : 파일이 존재한다면 true
			
			try {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				
				System.out.println(br.readLine()); // readline() : 한 줄을 읽어온다.
				System.out.println();
				
				String data = br.readLine();
				System.out.println(data);
				System.out.println();
				
				// 전체 택스트를 읽어오는 예시 
				while (true) {
					
					data = br.readLine();
					if (data == null) { // 읽어 올 라인이 없으면 null을 반환한다. 
						break;
					}
					System.out.println(data);
				}
				System.out.println();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally { 
				// 나중에 open한 객체를 먼저 close한다. ***
				try {br.close();} catch (IOException e) {e.printStackTrace();}
				try {fr.close();} catch (IOException e) {e.printStackTrace();}
			} 
		}
	}
}
