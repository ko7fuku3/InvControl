package jp.koshiro.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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

		//文字エンコーディング
		request.setCharacterEncoding("UTF-8");

		//リクエストパラメータの取得
		String mbid = request.getParameter("mbid");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String back = request.getParameter("back");
		String end = request.getParameter("end");


		//back処理
		if ("戻る".equals(back)) {

			response.sendRedirect("../Top.jsp");

		} else if("終了".equals(end)) {

			response.sendRedirect("../End.jsp");

		} else {

		//ログイン処理
	    LoginDAO logindao = new LoginDAO();
		boolean isLogin = logindao.execute(mbid, name, password);

		//ログイン処理
		if (isLogin) {

			//ログイン成功

			//ログイン結果画面にリダイレクト
			response.sendRedirect("../LIST/List.jsp");

		} else {

			//エラー処理
			String err = "入力内容が間違っています！";
			request.setAttribute("err", err);

			//リダイレクト処理
			response.sendRedirect("Login.jsp");

		   }
		}
	}

}
