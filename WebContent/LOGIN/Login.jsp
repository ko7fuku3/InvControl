<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String mbid = request.getParameter("mbid");
	String name = request.getParameter("name");
	String password = request.getParameter("password");
%>
<% if (name != null) {%>

	<% String back = request.getParameter("back"); %>
  <% if ("戻る".equals(back)) { %>
  <% request.setAttribute("back", back); %>
  <% request.getRequestDispatcher("/LoginServlet").forward(request, response); %>
  <%} %>

  <% String end = request.getParameter("end"); %>
  <% if ("終了".equals(end)) { %>
  <% request.setAttribute("end", end); %>
  <% request.getRequestDispatcher("/LoginServlet").forward(request, response); %>
  <%} %>

  <% if (!("".equals(mbid)) && !("".equals(name)) && !("".equals(password))) {%>
	<% request.setAttribute("mbid", mbid);%>
  <% request.setAttribute("name", name);%>
	<% request.setAttribute("password", password);%>
	<% request.getRequestDispatcher("/LoginServlet").forward(request, response);%>
	<%}%>
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

<form action="" method="post" id="login" autocomplete="off">
<input class="top1" type="submit" value="ログイン" />
<input class="top2" type="submit" name="back" value="戻る"/>
<input class="end" name="end" type="submit" value="終了"/>
</form>

</div>

<div class="right">


	<div class="loginp">
  <p class="login">以下のフォームにログインに必要な情報を入力してください。</p>
	</div>

	<table class="login">

		<tr>
		<th class="login">職員ID</th>
		<td class="entry"><input class="form" type="text" style="height:18px" name="mbid" size="40" maxlength="255" form="login" /><br/>
		<span class="err"><% if("".equals(mbid)) {out.println("職員IDを入力してください。");} %></span>
		</td>

		</tr>

		<tr>
		<th class="login">氏名</th>
		<td class="entry"><input class="form" type="text" style="height:18px" name="name" size="40" maxlength="255" form="login"/><br/>
		<span class="err"><% if ("".equals(name)) {out.println("氏名を入力してください。");} %></span>
		</td>
		</tr>


		<tr>
		<th class="login">パスワード</th>
		<td class="entry"><input class="form" type="password" style="height:18px" name="password" size="40" maxlength="255" form="login"/><br/>
		<span class="err"><% if ("".equals(password)) {out.println("パスワードを入力してください。");} %></span>
		</td>
		</tr>

	</table>

</div>


</article>
</div>



</body>
</html>