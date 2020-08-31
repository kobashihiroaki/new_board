package new_board;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 小橋弘章
 *
 */
public class BoardDAO {
	private static BoardDAO controller = new BoardDAO();

	public static BoardDAO getInstance() {
		return controller;
	}

	private BoardDAO() {
	}

	/**
	 * @param topic
	 */
	public void postTopic(BoardDTO bdto) {
		String sql = "INSERT INTO board(detail)"
				+ " VALUES(" + "'" + bdto.getDetail() + "'" + ")";

		Connection con = null;
		Statement smt = null;
		try {
			con = ConnectionManager.getConnection();
			smt = con.createStatement();
			smt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (Exception ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception ignore) {
				}
			}
		}
	}




	/**
	 * @return
	 */
	public List<BoardDTO> getTopics() {
		String sql = "SELECT * FROM board";
		List<BoardDTO> topics = new ArrayList<BoardDTO>();

		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(sql);
			while (rs.next()) {
				BoardDTO bdto = new BoardDTO();
				bdto.setId(rs.getInt("id"));
				bdto.setStart_at(rs
						.getTimestamp("start_at"));
				bdto.setDetail(rs.getString("detail"));
				topics.add(bdto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception ignore) {
				}
			}
			if (smt != null) {
				try {
					smt.close();
				} catch (Exception ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception ignore) {
				}
			}
		}
		return topics;
	}

	/**
	 * @param topic
	 */
	public void deleteTopic(BoardDTO bdto) {
		String sql = "DELETE  FROM board WHERE id = " + bdto.getId() ;
		List<BoardDTO> topics = new ArrayList<BoardDTO>();

		Connection con = null;
		Statement smt = null;
		try {
			con = ConnectionManager.getConnection();
			smt = con.createStatement();
			smt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (smt != null) {
				try {
					smt.close();
				} catch (Exception ignore) {
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception ignore) {
				}
			}
		}
	}

	public static void main(String[] args) {
		BoardDAO bdao = BoardDAO.getInstance();
		List <BoardDTO> topics = bdao.getTopics();
		for (int i = 0; i < topics.size(); i++) {
			System.out.println(topics.get(i));
		}
		System.out.println("END");
	}
}
