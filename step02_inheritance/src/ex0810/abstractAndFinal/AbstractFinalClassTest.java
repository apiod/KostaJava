//Error 를 수정하고 이유를 주석으로 처리하세요.
package ex0810.abstractAndFinal;

//final // 상속 가능 생성 불가
//abstract 부모로만 존재, 재정의 필수 
 final class FinalClassExam{
 final int i = -999999; 
}


abstract class AbstractClassExam{
    abstract String abstractMethodExam(int i,String s);    
    int finalMethodExam(int i, int j){ //25줄의 문제를 위해 final 제거
        return i+j;
    }
}


class Sample01 extends AbstractClassExam{
	String abstractMethodExam(int i,String s){
		System.out.println("return "+s+i);
		return s+i;
	}
	
	int finalMethodExam(int i, int j){ //부모의 finalMethodExam에는final이붙어있어 재정의 불가 따라서 13번째줄 final제거
		return i*j;
	}
	
}

//class Sample02 extends FinalClassExam{} //final불가


 
 abstract class Sample03 extends AbstractClassExam{ //39번 줄의 abstract메소드로 인해서 abstract 추가 작성
	 String abstractMethodExam(int i,String s){//39번줄이랑 같은 이름으로 동시 선언 불가 
		return s+i;
	 }
	abstract String abstractMethodExam1(int i,String s);    //36번줄의랑 같은이름으로 동시 선언 불가 따라서 이름변경

	void sampleMethod03(){
		System.out.println("void sampleMethod03() 호출 됨");
	}
}

class AbstractFinalClassTest{
    public static void main(String args[]){
//		AbstractClassExam ace = new AbstractClassExam(); //abstract 클래스는 객체 생성 불가능
		FinalClassExam fce = new FinalClassExam();
//		fce.i=100000; //final 변수는 값을 재설정 불가
		Sample01 s01 = new Sample01();
		AbstractClassExam aceS01 = new Sample01();
		aceS01.abstractMethodExam(700,"_999");
	}
}
