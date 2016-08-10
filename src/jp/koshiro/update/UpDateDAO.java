package jp.koshiro.update;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpDateDAO {

	private String id;
	private String price;
	private String quantity;
	private String remarks;

	public UpDateDAO(String id, String price, String quantity, String remarks) {

		this.id = id;
		this.price = price;
		this.quantity = quantity;
		this.remarks = remarks;

		Connection conn = null;

		try {
			//MySQLに接続
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/invcontrol?useUnicode=true&characterEncoding=utf8", "root", "");

			//SQL文を送る準備
			String sql = "UPDATE items SET price='" + price +"', quantity='" + quantity + "', remarks='" + remarks +"' WHERE id='" + id + "'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//UPDATE文の実行
			int it = pStmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			//データベース切断
			if (conn != null) {

				try {

					conn.close();

				} catch (SQLException e) {

					e.printStackTrace();

				}
			}
		}

	}


}
