package ex0811.board;

public class MainApp {
	Board board;
	BoardService boardService;
	
	public MainApp() {
		board = new FreeBoard(1, "제목1", "작성자1", "내용1");
		boardService = new FreeBoardServiceImpl();
		test(boardService,board);
	
		board = new FreeBoard(2, "제목2", "작성자2", "내용2");
		boardService = new FreeBoardServiceImpl();
		test(boardService,board);
	
		board = new FreeBoard(3, "제목3", "작성자3", "내용3");
		boardService = new FreeBoardServiceImpl();
		test(boardService,board);
	}
	public void test(BoardService service,Board board) {
		service.insert(board);
		service.update(board);
		service.selectByNo(5);
		service.delete(100);
		BoardService.selectAll();
		System.out.println("----------------");
	}
	
	public static void main(String[] args) {
		new MainApp();
	}
}
