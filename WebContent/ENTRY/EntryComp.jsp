<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8");
   String login = request.getParameter("login");
   String end = request.getParameter("end");
   System.out.print(end);
%>
<% if("ログイン".equals(login)) { %>
<% response.sendRedirect("../LOGIN/Login.jsp"); %>
<%} %>
<% if("終了".equals(end)) { %>
<% response.sendRedirect("../End.jsp"); %>
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

<form  action="" method="post" id="entry" autocomplete="off">
<input class="top1" name="login" type="submit" value="ログイン" />
<input class="endcomp" name="end" type="submit" value="終了"/>
</form>

</div>

<div class="right">

	<h1 class="entrycomp">登録完了</h1>

  <div class="entrycomp">
	<p class="entrycomp">登録が完了しました。ログインへとお進みください。</p>
  </div>
	</div>

</article>
</div>



</body>
</html>