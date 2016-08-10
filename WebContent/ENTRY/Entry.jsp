<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String mbid = request.getParameter("mbid");
	String name = request.getParameter("name");
	String phonetic = request.getParameter("phonetic");
	String sex = request.getParameter("sex");
	String password = request.getParameter("password");
%>
<% if (name != null) {%>

  <% String back = request.getParameter("back"); %>
  <% if ("戻る".equals(back)) { %>
  <% request.setAttribute("back", back); %>
  <% request.getRequestDispatcher("/EntryServlet").forward(request, response); %>
  <%} %>

  <% String end = request.getParameter("end"); %>
  <% if ("終了".equals(end)) { %>
  <% request.setAttribute("end", end); %>
  <% request.getRequestDispatcher("/EntryServlet").forward(request, response); %>
  <%} %>

  <% if (!("".equals(mbid)) && !("".equals(name)) && !("".equals(phonetic)) && !("".equals(password))) {%>
	<% request.setAttribute("mbid", mbid);%>
  <% request.setAttribute("name", name);%>
	<% request.setAttribute("phonetic", phonetic);%>
	<% request.setAttribute("sex", sex); %>
	<% request.setAttribute("password", password);%>
	<% request.getRequestDispatcher("/EntryServlet").forward(request, response);%>
	<%}%>
	<%}%>
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
<input class="top1" type="submit" value="確認" />
<input class="top2" name="back" type="submit" value="戻る"/>
<input class="end" name="end" type="submit" value="終了"/>
</form>

</div>

<div class="right">


	<div class="p">
  <p class="entry1">以下の登録フォームに必要事項を入力してください。</p>
	<p class="entry2">※入力して頂いた個人情報は、在庫管理システム以外の目的には使用致しません。</p>
	<p class="entry3">【必須】は入力必須項目です。</p>
	</div>

	<table class="entry">

		<tr>
		<th class="entry">職員ID<span class="required">【必須】</span></th>
		<td class="entry"><input pattern="^[0-9]+$" class="form" type="text" style="height:18px" name="mbid" size="40" maxlength="255" form="entry" /><br/>
		<span class="err"><% if("".equals(mbid)) {out.println("職員IDを入力してください。");} %></span>
		</td>

		<tr>
		<th class="entry">氏名<span class="required">【必須】</span></th>
		<td class="entry"><input class="form" type="text" style="height:18px" name="name" size="40" maxlength="255" form="entry" /><br/>
		<span class="err"><% if ("".equals(name)) {out.println("氏名を入力してください。");} %></span>
		</td>
		</tr>

		<tr>
		<th class="entry">フリガナ</th>
		<td class="entry"><input class="form" type="text" style="height:18px" name="phonetic" size="40" maxlength="255" form="entry" /><br/>
		<span class="err"><% if("".equals(phonetic)) {out.println("フリガナを入力してください。");} %></span>
		</td>
		</tr>

		<tr>
		<th class="entry">性別<span class="required">【必須】</span></th>
		<td class="entry"><input type="radio" name="sex" value="男性" form="entry" checked/>男性<input type="radio" name="sex" value="女性" form="entry"/>女性</td>
		</tr>

		<tr>
	  <th class="entry">パスワード<span class="required">【必須】</span><br /><div id="pa"></div></th>
		<td class="entry"><input class="form" type="password" style="height:18px" name="password" size="40" maxlength="255" form="entry" /><br/>
		<span class="err"><% if ("".equals(password)) {out.println("パスワードを入力してください。");} %></span>
		</td>
		</tr>


	</table>

</div>

</article>
</div>



</body>
</html>