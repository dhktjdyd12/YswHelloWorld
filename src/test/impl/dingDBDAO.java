package test.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.board.common.DAO;
import com.board.model.BoardDB;

import test.model.dingDB;
import test.model.dingDBService;

public class dingDBDAO { // sql문 작성하는 곳

	Connection conn = null;
	ResultSet rs = null; // DB에 받아온 결과값을 저장해놓는 타입 ResultSet
	PreparedStatement pstmt = null; // 캐쉬값을 이용해서 sql쿼리문을 실행시켜주는 타입 PreparedStatement

	public void createPerson(String id) {   // 사원등록
		conn = DAO.getConect();
		String sql = "insert into boards values((select max(board_no)+1 from boards), ?, ?, ?,?,?, sysdate, null)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, );
			pstmt.setString(2, id.get);
			pstmt.setString(3, id.get);
			pstmt.setString(4, id.get);
			pstmt.setString(5, id.get);
			
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

	public void checkPerson(dingDB names) {   // 사원이름조회
		dingDB per = null;
		conn = DAO.getConect();
		String sql = "selcet from Name where PersonNumber is null";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.set(1, names);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				per = new dingDB();
				per.setPersonNumber(rs.getString("personNum"));
				per.setName(rs.getString("name"));
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
		return per;
		
	}

	public void checkDepartment{ 		// 부서입력하면 한개 조회 안적으면 전체 조회
		dingDB dep = null;
		conn = DAO.getConect();
		String sql = "select board_no, title, content, writer, creation_date, orig_no,"
					+" get_reply_cnt(b.board_no) as reply_count"
					+" from ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, names);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dep = new dingDB();
				dep.setPersonNumber(rs.getString("personNum"));
				dep.setName(rs.getString("name"));
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
		return dep;
	}

	public void updateDepartment{ 		// 부서변경
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

	public void deletePerson {  // 퇴사
		conn = DAO.getConect();
		List<BoardDB> list = getReplayList(board.getBoardNo()); // 제너릭타입이 BOardDB인 list 생성
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

}

}
