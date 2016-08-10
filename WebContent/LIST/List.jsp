<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<jsp:useBean id="lb" class="jp.koshiro.list.ListDAO" scope="request"/>
<%request.setCharacterEncoding("UTF-8"); %>
<%!
	ArrayList colname;
	ArrayList data;
%>
<%
	colname = lb.getColname();
	data = lb.getData();
%>
<% String create = request.getParameter("create"); %>
<% if ("登録".equals(create)) { %>
<% request.setAttribute("create", create); %>
<% request.getRequestDispatcher("/ListServlet").forward(request, response); %>
<%} %>

<% String end = request.getParameter("end"); %>
<% if ("終了".equals(end)) { %>
<% request.setAttribute("end", end); %>
<% request.getRequestDispatcher("/ListServlet").forward(request, response); %>
<%} %>
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

<form action="" method="post">
<input class="top1" name="create" type="submit" value="登録" />
<input class="ListEnd" name="end" type="submit" value="終了"/>
</form>

</div>

<div class="right">

	<h1 class="entry">一覧画面</h1>

		<div class="list">

			<table class="list" border="1">

			<thead class="table_head">
			<tr bgcolor="#E0C76F">
				<th class="list" width="40px">品番</th>
				<th class="list" width="150px">品名</th>
				<th class="list" width="60px">単価</th>
				<th class="list" width="40px">数量</th>
				<th class="list" width="130px">備考</th>
				<th class="list" width="50px">削除</th>
				<th class="list" width="50px">修正</th>
				<th class="list" width="4.5px"></th>
			</tr>
			</thead>

			<tbody class="table_scroll">
				<% for (int row=0; row<data.size(); row++) { %>

				<tr>
				<%
					ArrayList rowdata = (ArrayList) (data.get(row));
					for (int column=0; column<rowdata.size()+2; column++) {
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

				<!-- 削除 -->
				<%} else if (column == 5){%>
				<td class="list" width="50px" align="center"><a class="delete" href="../DELETE/Delete.jsp?id=<%=rowdata.get(0) %>">削除</a></td>

				<!-- 編集 -->
				<%} else {%>
				<td class="list" width="50px" align="center"><a class="modify" href="../UPDATE/UpDate.jsp?id=<%=rowdata.get(0) %>">修正</a></td>
				<%} %>
				<%  } %>
				</tr>
				<%} %>

			</tbody>
			</table>

</div>


</article>
</div>



</body>
</html>