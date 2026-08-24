package ex0811.board;

public class FreeBoardServiceImpl implements BoardService {

	@Override
	public int insert(Board board) {
		System.out.println(super.getClass().getSimpleName()+"의 insert call..");
		System.out.println("전달된 board = "+board);
		return 1;
	}

	@Override
	public boolean update(Board board) {
		System.out.println(super.getClass().getSimpleName()+"의 update call..");
		System.out.println("전달된 board = "+board);		
		return true;
	}

	@Override
	public Board selectByNo(int no) {
		System.out.println(super.getClass().getSimpleName()+"의 selectByNo call..");
		System.out.println("전달된 no = "+no);
		return new FreeBoard(no,"interface","OTH", "interface규격서");
	}
	@Override
	public int delete(int no) {
		System.out.println("freeBoard... delete call");
		return 5;	
	}

}
