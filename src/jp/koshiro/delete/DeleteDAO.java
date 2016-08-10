package jp.koshiro.delete;

import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DeleteDAO {

	public boolean execute(String id) {

		String dId = id;

		Connection conn = null;

		//MySQLに接続
		try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost/invcontrol?useUnicode=true&characterEncoding=utf8", "root", "");


		//データベースにSQL文を送る準備
		String sql = "DELETE FROM items WHERE id='" + dId + "'";
		PreparedStatement pStmt = (PreparedStatement) conn.prepareStatement(sql);

		//DELETE文の実行
		int rs = pStmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			//データベース切断
			if(conn != null) {

				try {

					conn.close();

				} catch (SQLException e) {

					e.printStackTrace();

				}

			}
		}

		return false;

	}


}
