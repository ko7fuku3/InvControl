package jp.koshiro.top;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TopServlet
 */
@WebServlet("/TopServlet")
public class TopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopServlet() {
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

		//Top.jspからリクエストパラメータを取得
		String login = request.getParameter("login");
		String entry = request.getParameter("entry");
		String end = request.getParameter("end");

		//リダイレクト
		if ("ログイン".equals(login)) {

			response.sendRedirect("./LOGIN/Login.jsp");

		}

		if ("新規登録".equals(entry)) {

			response.sendRedirect("./ENTRY/Entry.jsp");

		}

		if ("終了".equals(end)) {

			response.sendRedirect("End.jsp");

		}

	}

}
