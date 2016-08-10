<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String price = request.getParameter("price");
	String quantity = request.getParameter("quantity");
	String remarks = request.getParameter("remarks");
%>
<% if (name != null) { %>

<% String back = request.getParameter("back");%>
<% if ("戻る".equals(back)) {%>
<% request.setAttribute("back", back); %>
<% request.getRequestDispatcher("../CreateServlet").forward(request, response); %>
<%  } %>

<% String end = request.getParameter("end");%>
<% if ("終了".equals(end)) {%>
<% request.setAttribute("end", end); %>
<% request.getRequestDispatcher("../CreateServlet").forward(request, response); %>
<%  } %>

<% if (!("".equals(id)) && !("".equals(name)) && !("".equals(price)) && !("".equals(quantity))) {%>
	<% request.setAttribute("id", id);%>
  <% request.setAttribute("name", name);%>
	<% request.setAttribute("price", price);%>
	<% request.setAttribute("quantity", quantity); %>
	<% request.setAttribute("remarks", remarks);%>
	<% request.getRequestDispatcher("../CreateServlet").forward(request, response);%>
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

<form  action="" method="post" id="entry" autocomplete="off">
<input class="top1" type="submit" value="確認" />
<input class="top2" name="back" type="submit" value="戻る"/>
<input class="end" name="end" type="submit" value="終了"/>
</form>

</div>

<div class="right">


	<div class="p">
  <p class="entry1">以下の登録フォームに必要事項を入力してください。</p>
	</div>

	<table class="entry">

		<tr>
		<th class="create">品 番</th>
		<td class="entry"><input pattern="^[0-9]+$" class="form" type="text" style="height:18px" name="id" size="15" maxlength="255" form="entry" /><br/>
		<span class="err"><% if("".equals(id)) {out.println("品番を入力してください。");} %></span>
		</td>

		<tr>
		<th class="create">品 名</th>
		<td class="entry"><input class="form" type="text" style="height:18px" name="name" size="40" maxlength="255" form="entry" /><br/>
		<span class="err"><% if ("".equals(name)) {out.println("品名を入力してください。");} %></span>
		</td>
		</tr>

		<tr>
		<th class="create">単 価</th>
		<td class="entry"><input class="form" type="text" style="height:18px" name="price" size="15" maxlength="255" form="entry" /><br/>
		<span class="err"><% if("".equals(price)) {out.println("単価を入力してください。");} %></span>
		</td>
		</tr>

		<tr>
		<th class="create">数 量</th>
		<td class="entry"><input class="form" type="text" style="height:18px" name="quantity" size="10" maxlength="255" form="entry" /><br/>
		<span class="err"><% if("".equals(quantity)) {out.println("数量を入力してください。");} %></span>
		</td>
		</tr>

		<tr>
		<th class="create">備 考</th>
		<td class="entry"><input class="form" type="text" style="height:18px" name="remarks" size="40" maxlength="255" form="entry" /><br/>
		<span class="err"><% if("".equals(remarks)) {out.println("備考を入力してください。");} %></span>
		</td>
		</tr>





	</table>

</div>

</article>
</div>



</body>
</html>