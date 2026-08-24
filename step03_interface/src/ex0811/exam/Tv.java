package ex0811.exam;

public class Tv extends Elec implements ElecFunction{

	private int chnnel;
	public Tv() {}
	public Tv(int chnnel) {
		this.chnnel = chnnel;
	}
	public Tv(String code, int  cost, int chnnel) {
		super(code,cost);
		this.chnnel=chnnel;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(chnnel);
		builder.append("을 본다.");
		return builder.toString();
	}
	@Override
	public void start() {
		System.out.println(this);
		
	}
	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
