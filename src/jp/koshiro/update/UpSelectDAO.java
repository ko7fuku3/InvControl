package jp.koshiro.update;

import java.io.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSetMetaData;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class UpSelectDAO {

	private String id;
	private String name;
	private String price;
	private String quantity;
	private String remarks;

	private ArrayList<String> colname;
	private ArrayList<ArrayList> data;

	public void SelectDAO(String id) {

		this.id = id;

		Connection conn = null;

		try {

			//MySQLに接続
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/invcontrol?useUnicode=true&characterEncoding=utf8", "root", "");

			//SQL文を送る準備
			String sql = "SELECT * FROM items WHERE id='" + id + "'";
			PreparedStatement pStmt = conn.prepareStatement(sql);

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

			//セルに行のデータを格納
			ArrayList rowdata = null;
			for (int row=0; row<data.size(); row++) {
				rowdata = (ArrayList) (data.get(row));
			}

			//セルのデータをフィールド変数に代入
			this.name = (String) rowdata.get(1);
			this.price = (String) rowdata.get(2);
			this.quantity = (String) rowdata.get(3);
			this.remarks = (String) rowdata.get(4);



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

	public ArrayList getData() {

		return data;

	}

	public ArrayList getColname() {

		return colname;

	}

	public String getId() {

		return id;

	}

	public String getName() {

		return name;

	}

	public String getPrice() {

		return price;

	}

	public String getQuantity() {

		return quantity;

	}

	public String getRemarks() {

		return remarks;

	}
}
