package jp.koshiro.update;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpDateServlet
 */
@WebServlet("/UpDateServlet")
public class UpDateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpDateServlet() {
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

		//update.jspからリクエストパラメータの取得
		String sid = (String) request.getAttribute("sid");
		String sprice = request.getParameter("price");
		String squantity = request.getParameter("quantity");
		String sremarks = request.getParameter("remarks");
		String cancel = request.getParameter("cancel");

		//キャンセル処理
				if ("キャンセル".equals(cancel)) {

					response.sendRedirect("../LIST/List.jsp");

				} else {


				//Updateの呼び出し
				UpDateDAO uDAO = new UpDateDAO(sid, sprice, squantity, sremarks);

				//リダイレクト
				response.sendRedirect("../LIST/List.jsp");

				}

	}

}
