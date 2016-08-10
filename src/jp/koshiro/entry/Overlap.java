package jp.koshiro.entry;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import jdk.nashorn.internal.ir.RuntimeNode.Request;


public class Overlap {

	public Overlap(User user) throws UnsupportedEncodingException {


		String mbid = user.getMbid();
		String name = user.getName();
		String phonetic = user.getPhonetic();
		String sex = user.getSex();
		String pass = user.getPassword();
		System.out.println(mbid);
		System.out.println(name);
		System.out.println(phonetic);
		System.out.println(sex);
		System.out.println(pass);

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

				ResultSet rs = null;
				Connection conn = null;

				String mb = null;
				String nm = null;
				String pn = null;
				String sx = null;
				String ps = null;

				try {
					//MySQLに接続
					Class.forName("com.mysql.jdbc.Driver");
					conn = (Connection) DriverManager.getConnection(
							"jdbc:mysql://localhost/invcontrol?useUnicode=true&characterEncoding=utf8", "root", "");

					//データベースにSQL文を送る準備
					String sql ="SELECT COUNT(*) AS cnt FROM members WHERE name='" + name + "'";
					PreparedStatement pStmt = (PreparedStatement) conn.prepareStatement(sql);


					//SELECT文を実行し、結果を取得
					int i = pStmt.executeUpdate();

					System.out.print(i);



				} catch (Exception e) {

					e.printStackTrace();

				}

	}

}
