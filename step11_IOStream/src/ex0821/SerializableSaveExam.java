package ex0821;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializableSaveExam {
	public SerializableSaveExam() {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/ex0821/save.txt"))) {
			
			Member m1 = new Member("qwe", 78, "서울");
			Member m2 = new Member("asd", 45, "대전");
			Member m3 = new Member("zxc", 12, "대구");

//			oos.writeObject(m1);
//			oos.writeObject(m2);
//			oos.writeObject(m3);
			
			List<Member> list = new ArrayList<>(); 
			list.add(m1);
			list.add(m2);
			list.add(m3);
			oos.writeObject(list);
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	public static void main(String[] args) {
		new SerializableSaveExam();
	}
}
