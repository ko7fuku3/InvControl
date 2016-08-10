package jp.koshiro.create;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.koshiro.create.Item;
import jp.koshiro.create.ItemDAO;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//フォワード先
				String forwardPath = null;

				//creCheck.jspからaction属性の取得
				String action = new String(request.getParameter("action").getBytes("ISO_8859_1"), "UTF-8");

				//戻る処理
				if ("戻る".equals(action)) {

					//不要となったセッションスコープ内のインスタンスを削除
					HttpSession session = request.getSession();
					session.removeAttribute("CreateServlet");

					//リダイレクト
					response.sendRedirect("./CREATE/Create.jsp");
				}  else if (action.equals("登録")) {

					//セッションスコープに保存された商品情報を取得
					HttpSession session = request.getSession();
					Item CreateServlet = (Item) session.getAttribute("CreateServlet");


					//DB登録処理の呼び出し
					ItemDAO itemdao = new ItemDAO();
					itemdao.execute(CreateServlet);

					//不要となったセッションスコープ内のインスタンスを削除
					session.removeAttribute("CreateServlet");

					//リダイレクト
					response.sendRedirect("./LIST/List.jsp");

				} else if("終了".equals(action)) {

					//不要となったセッションスコープ内のインスタンスを削除
					HttpSession session = request.getSession();
					session.removeAttribute("CreateServlet");

					//リダイレクト
					response.sendRedirect("./End.jsp");

				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


				request.setCharacterEncoding("UTF-8");

				//create.jspからリクエストパラメータを取得
				String id = request.getParameter("id");
				String name = request.getParameter("name");
				String price = request.getParameter("price");
				String quantity = request.getParameter("quantity");
				String remarks = request.getParameter("remarks");
				String back = request.getParameter("back");
				String end = request.getParameter("end");

				//戻る処理
				if("戻る".equals(back)) {

					response.sendRedirect("../LIST/List.jsp");

				} else if("終了".equals(end)) {

					response.sendRedirect("../End.jsp");

				} else {

				//Itemモデルに登録する商品情報を設定
				Item CreateServlet = new Item(id, name, price, quantity, remarks);

				//セッションスコープに商品情報を保存
				HttpSession session = request.getSession();
				session.setAttribute("CreateServlet", CreateServlet);

				//フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("./CREATE/CreCheck.jsp");
				dispatcher.forward(request, response);

				}
	}

}
