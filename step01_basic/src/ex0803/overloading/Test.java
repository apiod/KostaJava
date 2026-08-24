package ex0803.overloading;

class Test{
     public void aa(){System.out.println("aa()");}
     public int aa(int i){
    	 System.out.println("aa(int i)");
    	 return 4;
     }
     protected void aa(String s){System.out.println("aa(String s)");}

     String aa(int i, String s){
    	 System.out.println("aa(int i,String s)");
    	 return "ddd";
    }
     
     public static void main(String[] args) {
//    	 메소드 호출
    	 Test t =new Test();
    	 t.aa();
    	 System.out.println(t.aa(3));
    	 t.aa("하이");
    	 System.out.println(t.aa(3,"하이"));
    	    	 
     }
}
// 
// 
//
//ex)
//System.out.println(4);
//System.out.println("4");
//System.out.println(4.4);
//System.out.println(true);
//
//
//
//class PrintStream {
//
//    제한자 리턴타입 println(){
//
//    }
//}