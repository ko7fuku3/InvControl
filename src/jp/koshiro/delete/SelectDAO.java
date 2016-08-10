package jp.koshiro.delete;

import java.util.*;

import javax.servlet.http.HttpSession;

import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

public class SelectDAO implements Serializable {

	private String id;

	private ArrayList<String> colname;
	private ArrayList<ArrayList> data;

	public void DB(String id) {

		this.id = id;

		Connection conn = null;

		//MySQLに接続
		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost/invcontrol?useUnicode=true&characterEncoding=utf8", "root", "");

			//データベースにSQL文を送る準備
			String sql = "SELECT * FROM items WHERE id='" + id +"'";
			PreparedStatement pStmt = (PreparedStatement) conn.prepareStatement(sql);

			//SELECT文の実行
			ResultSet rs = pStmt.executeQuery();

			//列数の取得
			ResultSetMetaData rm = (ResultSetMetaData) rs.getMetaData();
			int cnum = rm.getColumnCount();
			colname = new ArrayList<String>(cnum);

			//列の取得
			for (int i=1; i<=cnum; i++) {
				colname.add(rm.getCatalogName(i).toString());
			}

			//行の取得
			data = new ArrayList<ArrayList>();

			while (rs.next()) {

				ArrayList<String> rowdata = new ArrayList<String>();

				for (int i=1; i<=cnum; i++) {

					rowdata.add(rs.getObject(i).toString());

				}

				data.add(rowdata);

			}


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

	}

	public ArrayList getData() {

		return data;

	}

	public ArrayList getColname() {

		return colname;

	}

	public String getId() {

		return id;

	}

}
