package jp.koshiro.login;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class LoginDAO {

	public boolean execute(String mbid, String name, String password) throws UnsupportedEncodingException  {

		//リクエストパラメータの取得
		String Lmbid = mbid;
		String Lname = name;
		String Lpassword = password;

		//パスワードをハッシュ化
		MessageDigest digest = null;

		try {

			digest = MessageDigest.getInstance("SHA1");

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();

		}

		byte[] hash = digest.digest(Lpassword.getBytes("UTF-8"));
		StringBuilder hashStr = new StringBuilder();

		for (int i=0, l=hash.length; i<l; i++) {

			int h = hash[i];

			if (h < 0) {

				hashStr.append(Integer.toHexString(h + 256));

			} else {

				if (h < 16) {

					hashStr.append("0");

				}
				hashStr.append(Integer.toHexString(h));
			}
		}

		ResultSet rs = null;
		Connection conn = null;

		String mb = null;
		String nm = null;
		String ps = null;

		try {
			//MySQLに接続
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost/invcontrol?useUnicode=true&characterEncoding=utf8", "root", "");

			//データベースにSQL文を送る準備
			String sql = "SELECT * FROM members WHERE mbid = ? AND name = ? AND password='"+ hashStr + "'";
			PreparedStatement pStmt = (PreparedStatement) conn.prepareStatement(sql);
			pStmt.setString(1, Lmbid);
			pStmt.setString(2, Lname);

			//SELECT文を実行し、結果表を取得
			rs = pStmt.executeQuery();

			//結果の表示
			while (rs.next()) {

				mb = rs.getString("mbid");
				nm = rs.getString("name");
				ps = rs.getString("password");
			}


		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			//データベース切断
			if (conn != null) {

				try {

					conn.close();

				} catch (SQLException e){

				e.printStackTrace();

				}
			}
		}

		//照合判定
		if (rs != null) {
			if (Lmbid.equals(mb) && Lname.equals(nm) && ps.toString().equals(hashStr.toString())) {

				return true;

			}
		}



		return false;

	}

}
