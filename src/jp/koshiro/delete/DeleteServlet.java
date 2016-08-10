package jp.koshiro.delete;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		//delete.jspからリクエストパラメータの取得
		String id = (String) request.getAttribute("str");
		String back = request.getParameter("delete");

		request.setAttribute("id", id);

		//キャンセル処理
		if ("キャンセル".equals(back)) {

			response.sendRedirect("../LIST/List.jsp");

		} else {

		DeleteDAO ddao = new DeleteDAO();
		ddao.execute(id);

		//リクエストに設定
		request.setAttribute("sdb", ddao);


		//リダイレクト
		response.sendRedirect("../LIST/List.jsp");

		}

	}

}
