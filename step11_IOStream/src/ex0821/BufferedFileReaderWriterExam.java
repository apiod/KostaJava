package ex0821;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedFileReaderWriterExam {
	public BufferedFileReaderWriterExam() throws IOException{
		BufferedReader br = null;
		BufferedWriter bw = null;
		br = new BufferedReader(new FileReader("src/ex0820/a.txt"));
//		br.read();//한문자씩읽기
		
		//한 문자씩 읽기
//		int i=0;
//		while((i=br.read())!=-1) {//마지막이면 -1
//			System.out.println(i+" = "+(char)i);
//		}
		
		String str = null;
		while((str = br.readLine())!=null){//마지막이면 null
			System.out.println(str);
		}
		br.readLine();//한줄씩 읽기
		
		bw = new BufferedWriter(new FileWriter("src/ex0821/info.txt"));
		bw.write("안녕하세요. ");
		bw.write("오늘은 비가 오는 습한 날이에요");
		
		bw.newLine();//개행
		
		bw.write("다행이도 오늘은금요일이에요");
		bw.write("주말은 쉴 수 있어요. 하지만 비가와요.");
		
		bw.flush();//버퍼에 있는 내용을 파일에 넣는 작업
		
		if (br != null) br.close();
		if (bw != null) bw.close();
	}
	
	public static void main(String[] args) {
		try {
			new BufferedFileReaderWriterExam();
		} catch (Exception e) {
			e.getStackTrace();
		}
		
	}
}
