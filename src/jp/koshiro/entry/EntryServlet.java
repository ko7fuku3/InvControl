package jp.koshiro.entry;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EntryServlet
 */
@WebServlet("/EntryServlet")
public class EntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EntryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		//CheckEntry.jspからaction属性を取得
		String action = new String(request.getParameter("action").getBytes("ISO_8859_1"), "UTF-8");


		//セッションスコープに保存された登録ユーザーを取得
		HttpSession session1 = request.getSession();
		User EntryServlet = (User) session1.getAttribute("EntryServlet");


		//Overlapメソッドの呼び出し
		Overlap ol = new Overlap(EntryServlet);






		//キャンセル処理
		if ("取消".equals(action)) {
			//不要となったセッションスコープ内のインスタンスを削除
			HttpSession session = request.getSession();
			session.removeAttribute("EntryServlet");

			//リダイレクト
			response.sendRedirect("./ENTRY/Entry.jsp");

		} else if("登録".equals(action)) {

			//セッションスコープに保存された登録ユーザーを取得
			HttpSession session = request.getSession();
			User Entryservlet = (User) session.getAttribute("EntryServlet");

			//データベースに登録する処理を実行
			EntryDAO dao = new EntryDAO();
			dao.execute(Entryservlet);

			//不要となったセッションスコープ内のインスタンスを削除
			session.removeAttribute("EntryServelt");

			//リダイレクト
			response.sendRedirect("./ENTRY/EntryComp.jsp");

		} else if ("終了".equals(action)) {

			//セッションスコープに保存された登録ユーザーを取得
			HttpSession session = request.getSession();
			User Entryservlet = (User) session.getAttribute("EntryServlet");

			//不要となったセッションスコープ内のインスタンスを削除
			session.removeAttribute("EntryServelt");

			//リダイレクト
			response.sendRedirect("./End.jsp");

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		//Entry.jspからリクエストパラメータを取得

		String mbid = request.getParameter("mbid");
		String name = request.getParameter("name");
		String phonetic = request.getParameter("phonetic");
		String sex = request.getParameter("sex");
		String password = request.getParameter("password");
		String back = request.getParameter("back");
		String end = request.getParameter("end");

		//back処理
				if ("戻る".equals(back)) {

					response.sendRedirect("../Top.jsp");

				} else if("終了".equals(end)) {

					response.sendRedirect("../End.jsp");

				} else {

				//Userモデルに登録するユーザーの情報を設定
				User EntryServlet = new User(mbid, name, phonetic, sex, password);

				//セッションスコープに登録ユーザーを保存
				HttpSession session = request.getSession();
				session.setAttribute("EntryServlet", EntryServlet);

				//フォワード
				response.sendRedirect("CheckEntry.jsp");
				}
	}

}
