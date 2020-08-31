package new_board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet(name = "board", urlPatterns = "/board")
public class BoardServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getPerform(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		postPerform(request, response);
	}

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void getPerform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bdao = BoardDAO.getInstance();
		BoardDTO bdto = new BoardDTO();

		List<BoardDTO> topics = bdao.getTopics();
		request.setAttribute("topics", topics);
		request.getRequestDispatcher("/board.jsp").forward(request, response);
	}

	protected void postPerform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO bdao = BoardDAO.getInstance();
		BoardDTO bdto = new BoardDTO();
		String action = request.getParameter("action");

		if (action.equals("insert")) {
			String detail = request.getParameter("detail");
			bdto.setDetail(detail);
			bdao.postTopic(bdto);
		} else if (action.equals("delete")) {
			String id = request.getParameter("board_id");
			bdto.setId(Integer.parseInt(id));
			bdao.deleteTopic(bdto);

		}
/*
		List<BoardDTO> topics = bdao.getTopics();
		request.setAttribute("topics", topics);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
*/
		response.sendRedirect("board");
	}

}
