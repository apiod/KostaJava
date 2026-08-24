package ex0820;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class BufferedFileCopyExam {
	BufferedInputStream bis=null;
	BufferedOutputStream bos=null;
	public BufferedFileCopyExam() {}
	public BufferedFileCopyExam(String readFileName, String writeFileName) {
		try {
			FileInputStream fileInputStream = new FileInputStream("src/ex0820/" + writeFileName);
			bis = new BufferedInputStream(fileInputStream);
			bos =new BufferedOutputStream(new FileOutputStream("src/ex0820/" + writeFileName));
			
			while(true) {
				int i = bis.read();
				if(i==-1)break;
				bos.write(i);
			}
			System.out.println("while종료");
			
		} catch (IOException e) {
			e.getStackTrace();
		}finally {
			try {
				if(bis !=null)bis.close();
				if(bos !=null)bos.close();
			} catch (IOException e) {
				e.getStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		String readFileName = JOptionPane.showInputDialog("읽을 파일명은?");
		String writeFileName = JOptionPane.showInputDialog("저장할 파일명은?");
		new BufferedFileCopyExam(readFileName, writeFileName);
	}
}
