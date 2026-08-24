package ex0803.array;

class ArrayExam{
	
	//각int,double,char,boolean ,String type별로 총 5개씩 저장하는  배열을 생성하세요
	int len=5;//배열의 길이
	int[] intArr =new int[len];
	double[] doubleArr = new double[len];
	char[] charArr = new char[len];
	boolean[] booleanArr = new boolean[len];
	String[] stringArr = new String[len];

	//메소드 : printArrayValue01	
	//위의 배열들에 자동으로 초기화 된값을 출력하세요
	public void printArrayValue01() {
		System.out.println("printArrayValue01---");
		System.out.println("- "+intArr[0]+" -");
		System.out.println("- "+doubleArr[0]+" -");
		System.out.println("- "+charArr[0]+" -");
		System.out.println("- "+booleanArr[0]+" -");
		System.out.println("- "+stringArr[0]+" -");
	}

	//메소드 : printArrayValue02	
	//위의 5개의 배열에서 각각 적당한 값으로 data를 할당하세요.
	public void printArrayValue02() {
		System.out.println("printArrayValue02---");

		for(int i=0;i<len;i++) {
			intArr[i]=i+1;
		}
		for(int i=0;i<len;i++) {
			doubleArr[i]=0.7*i;
		}
		for(int i=0;i<len;i++) {
			charArr[i]=(char)('a'+i);
		}
		for(int i=0;i<len;i++) {
			booleanArr[i]=i%2==0?false:true;
		}
		for(int i=0;i<len;i++) {
			stringArr[i]=(char)('a'+i)+stringArr[i]+i;
		}
		
	}
	//메소드 : printArrayValue03	
	//새롭게 할당된값을 출력하세요
		
	public void printArrayValue03() {
		System.out.println("printArrayValue03---");
		for(int i=0;i<intArr.length;i++) {
			System.out.print(intArr[i]+" ");
		}
		System.out.println();
		for(int i=0;i<doubleArr.length;i++) {
			System.out.print(doubleArr[i]+" ");
		}
		System.out.println();
		for(int i=0;i<charArr.length;i++) {
			System.out.print(charArr[i]+" ");
		}
		System.out.println();
		for(int i=0;i<booleanArr.length;i++) {
			System.out.print(booleanArr[i]+" ");
		}
		System.out.println();
		for(int i=0;i<stringArr.length;i++) {
			System.out.print(stringArr[i]+" ");
		}System.out.println();
		
	}
	
	//메인메소드에서
	//ArrayExam의 메소드들을 순서대로 호출하세요.
	public static void main(String[]args) {
		ArrayExam ae = new ArrayExam();
		ae.printArrayValue01();
		ae.printArrayValue02();
		ae.printArrayValue03();
		
	}
}