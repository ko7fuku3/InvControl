<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jp.koshiro.entry.User"%>

<!-- セッションスコープの取得 -->
<% User EntryServlet = (User) session.getAttribute("EntryServlet"); %>
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

<form  action="../EntryServlet" method="get">
<input class="top1" name="action" type="submit" value="登録" />
<input class="check1" name="action" type="submit" value="取消"/>
<input class="end" name="action" type="submit" value="終了"/>
</form>

</div>

<div class="right">


	<div class="p">
	<p class="entry1">※入力内容を確認し、登録を行ってください。</p>
	<p class="entryCheck2">入力して頂いた個人情報は、在庫管理システム以外の目的には使用致しません。</p>
  </div>


<table class="entry">

		<tr>
		<th class="entry">職員ID</th>
		<td class="entry"><%=EntryServlet.getMbid() %></td>
		</tr>

		<tr>
		<th class="entry">お名前</th>
		<td class="entry"><%=EntryServlet.getName() %></td>
		</tr>

		<tr>
		<th class="entry">フリガナ</th>
		<td class="entry"><%=EntryServlet.getPhonetic() %></td>
		</tr>

		<tr>
		<th class="entry">性別</th>
		<td class="entry"><%=EntryServlet.getSex() %></td>
		</tr>


		<tr>
		<th class="entry">パスワード</th>
		<td class="entry">******** 【セキュリティ上表示しません】</td>
		</tr>

	</table>

</div>

</article>
</div>



</body>
</html>