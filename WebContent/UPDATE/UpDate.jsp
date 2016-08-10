<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="jp.koshiro.update.UpSelectDAO" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% String id = request.getParameter("id"); %>
<% UpSelectDAO sdao = new UpSelectDAO(); %>
<% sdao.SelectDAO(id); %>
<%
	 //getメソッドの呼び出し
	 String sid = sdao.getId();
	 String sname = sdao.getName();
	 String sprice = sdao.getPrice();
	 String squantity = sdao.getQuantity();
	 String sremarks = sdao.getRemarks();
%>
<% String cancel = request.getParameter("cancel"); %>
<%
   if ("キャンセル".equals(cancel)) {
	   request.setAttribute("cancel", cancel);
	   request.getRequestDispatcher("/UpDateServlet").forward(request, response);
}%>


<% String update = request.getParameter("update"); %>
<% if("修正".equals(update)) {
   request.setAttribute("update", update);
   request.setAttribute("sid", sid);
   request.setAttribute("sname", sname);
   request.getRequestDispatcher("/UpDateServlet").forward(request, response);
}%>
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

<form  action="" method="post" id="update" autocomplete="off">
<input class="top1" name="update" type="submit" value="修正" />
<input class="delete" name="cancel" type="submit" value="キャンセル"/>
<input class="end" name="end" type="submit" value="終了"/>
</form>

</div>

<div class="right">


	<div class="p">
  <p class="entry1">以下の修正フォームに修正事項を入力してください。</p>
	</div>

	<table class="entry">

		<tr>
		<th class="create">品 番</th>
		<td class="entry"><%=sid %></td>
		</tr>

		<tr>
		<th class="create">品 名</th>
		<td class="entry"><%=sname %></td>
		</tr>

		<tr>
		<th class="create">単 価</th>
		<td class="entry"><input class="form" type="text" style="height:18px" name="price" size="40" maxlength="255" form="update" value="<%=sprice %>" /><br/>
		</td>
		</tr>

		<tr>
		<th class="create">数 量</th>
		<td class="entry"><input class="form" type="text" style="height:18px" name="quantity" size="40" maxlength="255" form="update" value="<%=squantity %>" /></td>
		</tr>

		<tr>
		<th class="create">備 考</th>
		<td class="entry"><input class="form" type="text" style="height:18px" name="remarks" size="40" maxlength="255" form="update" value="<%=sremarks %>" /></td>
		</tr>

	</table>

</div>

</article>
</div>



</body>
</html>