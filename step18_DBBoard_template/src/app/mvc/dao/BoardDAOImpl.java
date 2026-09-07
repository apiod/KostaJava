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
			rs = ps.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO(
						rs.getInt(1),
						rs.getString("subject"),
						rs.getString("writer"),
						rs.getString("content"),
						rs.getString("board_date")
				);
				list.add(dto);
			}
		}catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("DB에 문제가 있어 다시 진행해주요^^");
			
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}			
				
		
		return list;
	}
//	select * from board where subject like ?
	@Override
	public List<BoardDTO> boardSelectBySubject(String keyWord) throws SearchWrongException {
		List<BoardDTO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "select * from board where subject like ?";
		ResultSet rs = null;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%"+ keyWord +"%");
			rs =ps.executeQuery();
			while(rs.next()) {
				BoardDTO dto = new BoardDTO(
						rs.getInt(1),
						rs.getString("subject"),
						rs.getString("writer"),
						rs.getString("content"),
						rs.getString("board_date")
				);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("DB문제로 관리자에 연락해주세요");
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		
		
		return list;
	}
	/**
	 * 글번호에 해당하는 레코드 검색 - pk를 대상으로 조건 ( 레코드수가 0 아니면 1)
	 * select * from board where board_no = ? 
	 */
	@Override
	public BoardDTO boardSelectByNo(int boardNo) throws SearchWrongException {
		BoardDTO dto = null;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "select * from board where board_no = ?";
		ResultSet rs = null;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new BoardDTO(
						rs.getInt(1),
						rs.getString("subject"),
						rs.getString("writer"),
						rs.getString("content"),
						rs.getString("board_date")
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("DB문제로 관리자에 연락해주세요");
		}finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		
		
		return dto;
	}
	/**
	 * 게시물 등록하기
	 * insert into board (subject, writer, content, board_date) 
	 * values (?, ?, ?, sysdate)
	 */
	@Override
	public int boardInsert(BoardDTO boardDTO) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into board (subject, writer, content, board_date)"
				+ " values (?, ?, ?, now())";
		int result = 0;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, boardDTO.getSubject());
			ps.setString(2, boardDTO.getWriter());
			ps.setString(3, boardDTO.getContent());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("DB문제로 관리자에 연락해주세요");
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		
		return result;
	}
	/**
	 * 글번호에 해당하는 게시물 내용 수정하기
	 * update board set content = ? where board_no = ?
	 */
	@Override
	public int boardUpdate(BoardDTO boardDTO) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "update board set content = ? where board_no = ?";
		int result = 0;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, boardDTO.getContent());
			ps.setInt(2, boardDTO.getBoardNo());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("DB문제로 관리자에 연락해주세요");
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		
		return result;
	}
	/**
	 * 글번호에 해당하는 레코드 삭제
	 * delete from board where board_no = ?
	 */
	@Override
	public int boardDelete(int boardNo) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "delete from board where board_no = ?";
		int result = 0;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("DB문제로 관리자에 연락해주세요");
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		
		return result;
	}
	/**
	 * 댓글 등록하기
	 *  insert into reply values(reply_no_seq.nextval , ?, ? , sysdate)
	 * */
	@Override
	public int replyInsert(ReplyDTO replyDTO) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into reply(reply_content, board_no ,reply_regdate) values(?, ? , now())";
		int result = 0;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, replyDTO.getReplyContent());
			ps.setInt(2, replyDTO.getBoardNo());
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("DB문제로 관리자에 연락해주세요");
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		
		return result;
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
		BoardDTO dto= null; 
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "select * from board where board_no=?";
		ResultSet rs = null;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			rs = ps.executeQuery();
			if(rs.next()) {
				dto = new BoardDTO(
						rs.getInt(1),
						rs.getString("subject"),
						rs.getString("writer"),
						rs.getString("content"),
						rs.getString("board_date")
				);
			}
			dto.setRepliesList(this.replySelect(con,boardNo));
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("DB문제로 관리자에 연락해주세요");
		} finally {
			DBManager.releaseConnection(con, ps,rs);
		}
		
		return dto;
	}
	
	
	/***
	 * 부모글에 해당하는 댓글정보 가져오기
	 * */
	private List<ReplyDTO> replySelect(Connection con ,int boardNo)throws SQLException{
		List<ReplyDTO> list = new ArrayList<>(); 
		PreparedStatement ps = null;
		String sql = "select * from reply where board_no=?";
		ResultSet rs = null;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardNo);
			rs = ps.executeQuery();
			while(rs.next()) {
				ReplyDTO dto = new ReplyDTO(
						rs.getInt(1),
						rs.getString("reply_content"),
						rs.getInt("board_no"),
						rs.getString("reply_regdate")
				);
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("DB문제로 관리자에 연락해주세요");
		} finally {
			DBManager.releaseConnection(null, ps,rs);
		}
		
		
		return list;
	}

}