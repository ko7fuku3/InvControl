<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="jp.koshiro.create.Item" %>
<!-- セッションスコープの取得 -->
<% Item CreateServlet = (Item) session.getAttribute("CreateServlet"); %>

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

<form  action="../CreateServlet" method="get" id="entry" autocomplete="off">
<input class="top1" name="action" type="submit" value="登録" />
<input class="top2" name="action" type="submit" value="戻る"/>
<input class="end" name="action" type="submit" value="終了"/>
</form>

</div>

<div class="right">

<div class="p">
  <p class="entry1">登録情報を確認してください。</p>
</div>

<table class="entry">

		<tr>
		<th class="create">品 番</th>
		<td class="entry"><%=CreateServlet.getId() %></td>
		</tr>

		<tr>
		<th class="create">品 名</th>
		<td class="entry"><%=CreateServlet.getName() %></td>
		</tr>

		<tr>
		<th class="create">単 価</th>
		<td class="entry"><%=CreateServlet.getPrice() %></td>
		</tr>

		<tr>
		<th class="create">数 量</th>
		<td class="entry"><%=CreateServlet.getQuantity() %></td>
		</tr>

		<tr>
		<th class="create">備 考</th>
		<td class="entry"><%=CreateServlet.getRemarks() %></td>
		</tr>

	</table>



</div>

</article>
</div>



</body>
</html>