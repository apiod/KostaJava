package ex0814.map;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapExam {
	Map<String, Integer> map = new HashMap<>();//정렬이 안된다.
//	Map<String, Integer> map = new TreeMap<>();//정렬이 된다.
	
	public MapExam() {
		//추가
		map.put("희정", 10);
		map.put("미미", 20);
		map.put("동혁", 10);
		map.put("가현", 30);
		map.put("미미", 40);//키값이 중복이 되면 수정이 된다.
		System.out.println("크기: "+ map.size());
		System.out.println("내용: "+ map);
		
		System.out.println("--key와 value 분리");
		//key의 정보만 추출
		Set<String> keys=map.keySet();
		for (Iterator iterator = keys.iterator(); iterator.hasNext();) {
			String key = (String) iterator.next();
			Integer value = map.get(key);
			System.out.println(key + " = "+value);
		}
		System.out.println("---개선된 for문---");
		for (String key : map.keySet()) {
			System.out.println(key+ " = "+ map.get(key));
		}
		System.out.println("--- entry 형태로 조회---");
		Set<Map.Entry<String, Integer>> set= map.entrySet();
		for(Map.Entry<String, Integer> entry : set) {
			String key = entry.getKey();
			Integer it = entry.getValue();
			System.out.printf("key: %s\t value: %d\n", key, it);
		}
		System.out.println("-----삭제-----");
		//기본형을 넣으면 null값을 넣을 수 없다
		//객체 타입을 해야 null값을 넣을 수 있다.
		Integer re = map.remove("미미");
		System.out.println("re: "+ re);
		System.out.println(map);
		
		
	}
	public static void main(String[] args) {
		new MapExam();
	}
}
