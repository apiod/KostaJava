package ex0811.board;

public class QaBoardServiceImpl implements BoardService {

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
		return new QaBoard(no,"sleep","OTT", "잠잘자는 법",false);
	}

}
