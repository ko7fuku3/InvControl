<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="jp.koshiro.delete.SelectDAO" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% String id = request.getParameter("id"); %>
<% SelectDAO sdao = new SelectDAO(); %>
<% sdao.DB(id); %>
<%!
	ArrayList colname;
	ArrayList data;
%>
<%
	colname = sdao.getColname();
	data = sdao.getData();
%>
<% String cancel = request.getParameter("cancel"); %>
<% if ("キャンセル".equals(cancel)) { %>
<% request.setAttribute("cancel", cancel); %>
<% request.getRequestDispatcher("/DeleteServlet").forward(request, response); %>
<%  } %>

<% String delete = request.getParameter("delete"); %>
<% if("削除".equals(delete)) { %>
<% request.setAttribute("delete", delete); %>
<!-- SelectDAOのgetIdメソッドを呼び出し -->
<% String str = sdao.getId(); %>
<% request.setAttribute("str", str); %>
<% request.getRequestDispatcher("/DeleteServlet").forward(request, response); %>
<%  } %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在庫管理</title>
<link rel="stylesheet" type="text/css" href="../style.css" />
</head>
<body>

<div class="out">

<article>

<div class="top">

<h1 class="top">在庫管理システム</h1>

</div>

<div class="left">

<form  action="" method="post" id="entry" autocomplete="off">
<input class="top1" name="delete" type="submit" value="削除" />
<input class="delete" name="cancel" type="submit" value="キャンセル"/>
<input class="end" name="end" type="submit" value="終了"/>
</form>

</div>

<div class="right">

	<div class="delete">
  <p class="entry1">※以下のデータを削除しますが、よろしいですか？。</p>
	</div>

	<div class="delete2">

		<table class="list" border="1">

			<tr bgcolor="#E0C76F">
				<th class="delete" width="40px">品番</th>
				<th class="delete" width="150px">品名</th>
				<th class="delete" width="60px">単価</th>
				<th class="delete" width="40px">数量</th>
				<th class="delete" width="130px">備考</th>

			</tr>

		<!-- 行の挿入 -->
	<% for (int row=0; row<data.size(); row++) {%>
	<tr>
	<%
		ArrayList rowdata = (ArrayList) (data.get(row));
		for (int column=0; column<rowdata.size()-1; column++) {
	%>
	<!-- 品番 -->
				<%if (column == 0) { %>
				<td class="list" width="40px" align="center">
				<%=rowdata.get(column) %>
				</td>

				<!-- 品名 -->
				<%} else if (column == 1) { %>
				<td class="list" width="150px">
				<%=rowdata.get(column) %>
				</td>

				<!-- 単価 -->
				<%} else if (column == 2) { %>
				<td class="list" width="60px" align="right" margin="0,0,">
				<%=rowdata.get(column) %>
				</td>

				<!-- 数量 -->
				<%} else if (column == 3) { %>
				<td class="list" width="40px" align="center">
				<%=rowdata.get(column) %>
				</td>

				<!-- 備考 -->
				<%} else if (column == 4) { %>
				<td class="list" width="130px">
				<%=rowdata.get(column) %>
				</td>
	<%} %>
	<%} %>
	</tr>
	<%} %>


		</table>

	</div>

</div>

</article>

</div>

</body>
</html>