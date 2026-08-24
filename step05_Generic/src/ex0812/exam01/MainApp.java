package ex0812.exam01;

public class MainApp {

	public static void main(String[] args) {
		/*//제너릭이 없는경우
		 * Box box = new Box(); box.setContent("상품1");
		 * 
		 * if (box.getContent() instanceof String) { String content =
		 * (String)box.getContent(); System.out.println(content); } box.setContent(new
		 * Board()); if(box.getContent() instanceof Board) { Board content =
		 * (Board)box.getContent(); System.out.println(content.getBno()); }
		 */
		
		System.out.println();
		BoxGeneric<String> box= new BoxGeneric<>();
		String content = box.getContent();
		System.out.println(content);
		
		
		BoxGeneric<Board> box2 = new BoxGeneric<Board>();
		box2.setContent(new Board());
		Board board2=box2.getContent();
		System.out.println(board2.getBno());
		
	}

}
