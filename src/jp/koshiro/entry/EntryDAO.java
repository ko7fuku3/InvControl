package jp.koshiro.entry;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class EntryDAO {

	public boolean execute(User user) throws UnsupportedEncodingException {

		String mbid = user.getMbid();
		String name = user.getName();
		String phonetic = user.getPhonetic();
		String sex = user.getSex();
		String pass = user.getPassword();

		//パスワードをハッシュ化
		MessageDigest digest = null;

		try {

			digest = MessageDigest.getInstance("SHA1");

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();

		}

		byte[] hash = digest.digest(pass.getBytes("UTF-8"));
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

		//MySQLに接続
		Connection conn = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost/invcontrol?useUnicode=true&characterEncoding=utf8", "root", "");

			//データベースにSQL文を送る準備
			String sql = "INSERT INTO members (mbid, name, phonetic, sex, password) values ('" + mbid +"', '" + name + "', '" + phonetic + "', '" + sex + "', '" + hashStr + "')";
			PreparedStatement pStmt = (PreparedStatement) conn.prepareStatement(sql);

			int rs = pStmt.executeUpdate();

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

		return false;
	}
}
