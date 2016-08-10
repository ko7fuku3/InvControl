package jp.koshiro.create;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import jp.koshiro.create.Item;


public class ItemDAO {

	public boolean execute(Item item) throws UnsupportedEncodingException {

		String id = item.getId();
		String name = item.getName();
		String price = item.getPrice();
		String quantity = item.getQuantity();
		String remarks = item.getRemarks();

		Connection conn = null;

		//MySQLに接続
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost/invcontrol?useUnicode=true&characterEncoding=utf8", "root", "");

			//データベースにSQL文を送る準備
			String sql = "INSERT INTO items (id, name,price, quantity, remarks) values ('" + id + "', '" + name + "', '" + price + "', '" + quantity + "', '" + remarks + "')";
			PreparedStatement pStmt = (PreparedStatement) conn.prepareStatement(sql);

			int rs = pStmt.executeUpdate();



		} catch(Exception e) {

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
		return false;
	}

}
