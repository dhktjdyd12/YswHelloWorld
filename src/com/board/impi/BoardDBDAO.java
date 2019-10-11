package com.board.impi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.board.common.DAO;
import com.board.model.Board;
import com.board.model.BoardDB;

public class BoardDBDAO {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;

	public void updateBoard(BoardDB board) {
		conn = DAO.getConect();
		String sql = "update boards set orig_no = orig_no"; 
		//	String sql = "update boards set creation_date = sysdate "; 
		if(board.getTitle() != null && board.getTitle().equals("")) {
			sql += ",title= ? ";
		}
		if(board.getContent() != null && board.getContent().equals("")) {
			sql += ",content = ? ";
		}
		sql += "where board_no=? and orig_no is null";
		int n = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			if (board.getTitle() != null ) {
				pstmt.setString(++n, board.getTitle());
			}
			if (board.getContent() != null ) {
				pstmt.setString(++n, board.getTitle());
			}
			pstmt.setInt(++n, board.getBoardNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}
	
	public void replayBoard(Board board) {
		conn = DAO.getConect();
		String sql = "insert into boards values"
					+"(board_seq.nextval, ?, ?, ?, sysdata, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContents());
			pstmt.setString(3, board.getWriter());

			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 입력되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<BoardDB> getReplayList(int boardNo) {  
		conn = DAO.getConect();
		String sql = "select * from boards where orig_no = ?";
		
		
		List<BoardDB> list = new ArrayList<>(); 
		// ^ 컬렉션프레임워크 List의 데이터타입이 BoardDB인 변수 list
		// ^ list컬레션에 속한 ArrayList 클래스를 사용해서 리스트 선언 
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next() ) {
				Board board = new BoardDB;
				board .setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContents(rs.getString("Content"));
				board.setWriter(rs.getString("writer"));

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		pstmt.setInt(1, boardNo);
		return null;
	}
	
	public BoardDB getBoard(int boardNo) {
		BoardDB board = null;
		conn = DAO.getConect();
		String sql = "selcet from boards where board_no is null";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				board = new BoardDB();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("Content"));
				board.setWriter(rs.getString("writer"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return board;
	}
	
	public void insertBoard(BoardDB board) {
		conn = DAO.getConect();
		String sql = "insert into boards values((select max(board_no)+1 from boards), ?, ?, ?, sysdate, null)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());

			int r = pstmt.executeUpdate();
			System.out.println(r + "건이 입력되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public String getUserName(String id, String pass) {
		conn = DAO.getConect();
		String sql = "select * from user_login where id =? and passwd = ?";
		String name = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				name = rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
}
