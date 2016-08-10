package jp.koshiro.list;

import java.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class ListDAO implements Serializable {

	private ArrayList<String> colname;
	private ArrayList<ArrayList> data;

	public ListDAO() {

		Connection conn = null;

		try {
			//MySQLに接続
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(
					"jdbc:mysql://localhost/invcontrol?useUnicode=true&characterEncoding=utf8", "root", "");

			//データベースにSQL文を送る
			String sql = "SELECT * FROM items ORDER BY id ASC";
			PreparedStatement pStmt = (PreparedStatement) conn.prepareStatement(sql);

			//SELECT文の実行
			ResultSet rs = pStmt.executeQuery();

			//列数（縦）の取得
			ResultSetMetaData rm = rs.getMetaData();
			int cnum = rm.getColumnCount();
			colname = new ArrayList<String>(cnum);

			//列名の取得
			for (int i=1; i<=cnum; i++) {
				colname.add(rm.getColumnName(i).toString());
			}

			//行(横）の取得
			data = new ArrayList<ArrayList>();
			while(rs.next()) {
				ArrayList<String> rowdata = new ArrayList<String>();
				for(int i=1; i<=5; i++) {
					rowdata.add(rs.getObject(i).toString());
				}
				data.add(rowdata);
			}


		} catch(Exception ex) {

			ex.printStackTrace();

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

	public ArrayList getData() {

		return data;

	}

	public ArrayList getColname() {

		return colname;

	}

}
