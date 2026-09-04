package kosta.db.dto;

public class EmpDTO {
	
	private int empno;
	private String ename;
	private String jobString;
	private int sal;
	private String hiredate;
	
	
	public EmpDTO() {
	
	}

	public EmpDTO(int empno, String ename, String jobString, int sal, String hiredate) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.jobString = jobString;
		this.sal = sal;
		this.hiredate = hiredate;
	}
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJobString() {
		return jobString;
	}
	public void setJobString(String jobString) {
		this.jobString = jobString;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmpDTO [empno=");
		builder.append(empno);
		builder.append(", ename=");
		builder.append(ename);
		builder.append(", jobString=");
		builder.append(jobString);
		builder.append(", sal=");
		builder.append(sal);
		builder.append(", hiredate=");
		builder.append(hiredate);
		builder.append("]");
		return builder.toString();
	}
	
	
}
