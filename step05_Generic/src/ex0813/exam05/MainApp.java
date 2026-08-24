package ex0813.exam05;

public class MainApp {
	public static void main(String[] args) {
		Coures coures = new Coures();
		
		System.out.println("--1. <?> 모든 타입 허용 --");
		coures.register01(new Applicant<Person>(new Person()));
		coures.register01(new Applicant<Worker>(new Worker()));
		coures.register01(new Applicant<Student>(new Student()));
		coures.register01(new Applicant<HighStudent>(new HighStudent()));
		coures.register01(new Applicant<MiddleStudent>(new MiddleStudent()));
		System.out.println("--1. <? super Worker> Worker 이상 허용 --");
		coures.register02(new Applicant<Person>(new Person()));
		coures.register02(new Applicant<Worker>(new Worker()));
//		coures.register02(new Applicant<Student>(new Student()));
//		coures.register02(new Applicant<HighStudent>(new HighStudent()));
//		coures.register02(new Applicant<MiddleStudent>(new MiddleStudent()));
		System.out.println("--1. <? extends Student> student 이하 허용 --");
//		coures.register03(new Applicant<Person>(new Person()));
//		coures.register03(new Applicant<Worker>(new Worker()));
		coures.register03(new Applicant<Student>(new Student()));
		coures.register03(new Applicant<HighStudent>(new HighStudent()));
		coures.register03(new Applicant<MiddleStudent>(new MiddleStudent()));
	}
}
