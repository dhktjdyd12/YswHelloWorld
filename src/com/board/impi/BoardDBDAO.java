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

public class BoardDBDAO { // 실제적으로 sql문 작성하는 클래스
	Connection conn = null;
	ResultSet rs = null;                   // DB에 받아온 결과값을 저장해놓는 타입 ResultSet
	PreparedStatement pstmt = null;        // 캐쉬값을 이용해서 sql쿼리문을 실행시켜주는 타입 PreparedStatement

	public void deleteBoard(BoardDB board) { // 게시글 삭제하는 메소드
		conn = DAO.getConect();
		List<BoardDB> list = getReplayList(board.getBoardNo());   // 제너릭타입이 BOardDB인 list 생성
		if (list.size() > 0) {
			System.out.println("댓글이 존재합니다.");
		} else {
			String sql = "delete from boards where board_no = ?";

			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, board.getBoardNo());

				int r = pstmt.executeUpdate();
				System.out.println(r + "건이 삭제되었습니다.");
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
	}

	public void deleteBoard2(BoardDB board) {            // 
		conn = DAO.getConect();
		String sql = "delete from boards where board_no = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBoardNo());
			rs = pstmt.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public boolean checkForReply(int boardNO) {       // 댓글 유무 체크하는 곳
		conn = DAO.getConect();
		String sql = "selecet count(*) as cnt from boards" + "where orig_no is null and board_no = ?";
		int rnt = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNO);            // sql문에 첫번째 와일드카드에 매개변수를 넣는 구문
			rs = pstmt.executeQuery();           // pstmt에 쿼리를 실행하는 executeQuery를 변수 rs에 담는다.
			if(rs.next()) {                      // 다음 값을 받는 next() 
				rnt = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} if(rnt > 0) {                       // 댓글 객수가 0개 초과면 true 리턴
			return true;
		} else {                              // 댓글이 0개
			return false;
		}
	}

	public boolean checkResponsibility(BoardDB board) {       // 
		conn = DAO.getConect();                               // DB 연결
		String sql = "selecet count(*) as cnt from boards\r\n"             //sql문을 작성
					+ "where orig_no is null and board_no = ? and writer = ?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBoardNo());
			pstmt.setString(2, board.getWriter());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} if (result > 0) {
			return true;
		} else {
			return false;
		}
		
	}

	public void updateBoard(BoardDB board) { // 게시글
		System.out.println("content" + board.getContent());
		conn = DAO.getConect();
		String sql = "update boards set orig_no = orig_no";

		if (board.getTitle() != null && board.getTitle().equals("")) {
			sql += ",title= ? ";
		}
		if (board.getContent() != null && board.getContent().equals("")) {
			sql += ",content = ? ";
		}
		sql += "where board_no=? and orig_no is null";
		int n = 0;

		try {
			pstmt = conn.prepareStatement(sql);
			if (board.getTitle() != null && board.getTitle().equals("")) {
				pstmt.setString(++n, board.getTitle());
			}
			if (board.getContent() != null && board.getContent().equals("")) {
				pstmt.setString(++n, board.getContent());
			}

			pstmt.setInt(++n, board.getBoardNo());
			pstmt.executeUpdate();
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

	public void replayBoard(BoardDB board) {       // 댓글 작성
		conn = DAO.getConect();
		String sql = "insert into boards values" + "(board_seq.nextval, ?, ?, ?, sysdata, ?)";
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

	public List<BoardDB> getReplayList(int board2) {
		conn = DAO.getConect();
		String sql = "select * from boards where orig_no = ?";

		// 컬렉션프레임워크 List의 데이터타입이 BoardDB인 변수 list
		// list컬레션에 속한 ArrayList 클래스를 사용해서 리스트 선언
		List<BoardDB> list = new ArrayList<>();

		try {
			//
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board2);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				BoardDB board = new BoardDB();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("Content"));
				board.setWriter(rs.getString("writer"));

				list.add(board);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	public BoardDB getBoard(int boardNo) {       // 게시글 1개 조회하는 메소드
		BoardDB board = null;
		conn = DAO.getConect();
		String sql = "selcet from boards where board_no is null";
//		String sql = "select board_no, title, content, writer, creation_date, orig_no,"
//					+"get_reply_cnt(b.board_no) as reply_count"
//					+"from boards b";
//		"(" + rs.getString("reply_cnt")+")"
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
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return board;
	}

	public void insertBoard(BoardDB board) {         // 글 작성하는 기능
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

	public String getUserName(String id, String pass) {     // 
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

	public List<BoardDB> getBoardList() {                   // 게시글 리스트 전체 조회하는 메소드 
		BoardDB board = null;
		conn = DAO.getConect();
//		String sql = "select * from boards where orig_no is null";
		String sql = "select board_no, title, content, writer, creation_date, orig_no,"
					+" get_reply_cnt(b.board_no) as reply_count"
					+" from boards b ";
					
		
		// 리스트 생성
		List<BoardDB> list = new ArrayList<>();

		try {
			pstmt = conn.prepareStatement(sql);  			// sql문을 연결해 pstmt에 담는다.
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				board = new BoardDB();
				board.setBoardNo(rs.getInt("board_no"));
				board.setTitle(rs.getString("title") + "(" + rs.getString("reply_count")+")" );
				board.setContent(rs.getString("Content"));
				board.setWriter(rs.getString("writer"));
				board.setCreationDate(rs.getString("creation_date"));
				list.add(board);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}
