package ex0820;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileCopyExam {
	FileInputStream fis=null;
	FileOutputStream fos=null;
	public FileCopyExam() {}
	public FileCopyExam(String readFileName, String writeFileName) {
		try {
			fis = new FileInputStream("src/ex0820/" + readFileName);
			fos =new FileOutputStream("src/ex0820/" + writeFileName);
			while(true) {
				int i = fis.read();
				if(i==-1)break;
				fos.write(i);
			}
			System.out.println("while종료");
			
		} catch (IOException e) {
			e.getStackTrace();
		}finally {
			try {
				if(fis !=null)fis.close();
				if(fos !=null)fos.close();
			} catch (IOException e) {
				e.getStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		String readFileName = JOptionPane.showInputDialog("읽을 파일명은?");
		String writeFileName = JOptionPane.showInputDialog("저장할 파일명은?");
		new FileCopyExam(readFileName, writeFileName);
	}
}
