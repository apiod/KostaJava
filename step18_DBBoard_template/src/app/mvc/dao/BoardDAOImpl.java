package app.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.mvc.common.DBManager;
import app.mvc.dto.BoardDTO;
import app.mvc.dto.ReplyDTO;
import app.mvc.exception.DMLException;
import app.mvc.exception.SearchWrongException;

public class BoardDAOImpl implements BoardDAO {
	
	private static BoardDAO instance = new BoardDAOImpl();
	
	private BoardDAOImpl() {}
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
//	select * from board order by board_no desc
	@Override
	public List<BoardDTO> boardSelectAll() throws SearchWrongException {
		Connection con=null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		List<BoardDTO> list = new ArrayList<>();
		String sql="select * from board order by board_no desc";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			
			//여기부터 작성하세요.
			
			
			
		}catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("DB에 문제가 있어 다시 진행해주요^^");
			
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}			
				
		
		return null;
	}
//	select * from board where subject like ?
	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SearchWrongException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 글번호에 해당하는 레코드 검색 - pk를 대상으로 조건 ( 레코드수가 0 아니면 1)
	 * select * from board where board_no = ? 
	 */
	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SearchWrongException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 게시물 등록하기
	 * insert into board (board_no, subject, writer, content, board_date) 
	 * values (board_seq.nextval, ?, ?, ?, sysdate)
	 */
	@Override
	public int boardInsert(BoardDTO boardDTO) throws DMLException {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * 글번호에 해당하는 게시물 내용 수정하기
	 * update board set content = ? where board_no = ?
	 */
	@Override
	public int boardUpdate(BoardDTO boardDTO) throws DMLException {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * 글번호에 해당하는 레코드 삭제
	 * delete from board where board_no = ?
	 */
	@Override
	public int boardDelete(int boardNo) throws DMLException {
		return 0;
	}
	/**
	 * 댓글 등록하기
	 *  insert into reply values(reply_no_seq.nextval , ?, ? , sysdate)
	 * */
	@Override
	public int replyInsert(ReplyDTO replyDTO) throws DMLException {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * 부모글에 해당하는 댓글정보 검색하기
	 *   select * from board where board_no=?  -> 1
	 *   select * from reply where board_no=? -> n
	 *   
	 *   
	 *   조인경우 : select * from board join reply using(board_no)  where board_no=?
	 * */
	@Override
	public BoardDTO replySelectByParentNo(int boardNo) throws SearchWrongException {
		return null;
	}
	
	
	/***
	 * 부모글에 해당하는 댓글정보 가져오기
	 * */
	private List<ReplyDTO> replySelect(Connection con ,int boardNo)throws SQLException{
		
		return null;
	}

}













