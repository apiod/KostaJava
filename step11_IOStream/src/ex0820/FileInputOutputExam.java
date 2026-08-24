package ex0820;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputExam {
	public FileInputOutputExam(){
		FileInputStream fis = null; 
		FileOutputStream fos = null; 
		try {
			fis = new FileInputStream("src/ex0820/a.txt");
//			while(true) {
//				int i = fis.read();//1byte씩 읽기
//				if(i==-1) break;
//				System.out.println (i+" = " + (char)i);	
//			}
			int len = fis.available();//읽을수 있는 byte수 반환
			System.out.println("len: "+ len);
			//byte 배열 크기만큼 한번에 읽기
			byte[]b = new byte[len];
			fis.read(b);
			
			String str = new String(b);
			System.out.println(str);
			System.out.println("end");
			
			///////////////////////////////// 
			fos = new FileOutputStream("src/ex0820/save.txt");
//			fos = new FileOutputStream("src/ex0820/save.txt",true);//존재하는 파일이면 이어쓴다.
			fos.write(65);
			fos.write(66);
			fos.write(67);
			fos.write(68);
			fos.write(69);
			fos.write(13);fos.write(10);//개행
			fos.write(238);fos.write(138);
			
			//위에것이 너무불편하다. String을 byte배열로 변환
			String data = "집에가고싶다.";
			fos.write(data.getBytes());
			
			fos.write(b);//file copy;
		} catch (IOException e) {
			 e.printStackTrace();
		} finally {
			try {
				if(fis!=null) fis.close();	
				if(fos!=null) fos.close();	
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			
		}
	}
	public static void main(String[] args) {
		new FileInputOutputExam();
	}
}
