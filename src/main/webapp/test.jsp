<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.UUID" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>支付测试接口</title>
</head>
<%
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
String datetime=df.format(new Date());// new Date()为获取当前系统时间
UUID uuid = UUID.randomUUID();
%>
<body>
<form action="/jeecg/GetMsgServlet" method="post">
<tr>
<td>支付订单号：</td>
<td><input type="text" name="ddh" id="ddh"/></td>
<td>支付金额：</td>
<td><input type="text" name="money" id="money"/></td>
</tr>
<tr>
<td>类别：</td>
<td>
<select id="lb" name="lb">
<option value="1">支付宝</option>
<option value="2">QQ钱包</option>
<option value="3">微信</option>
</select>
</td>
<td>备注：</td>
<td><input type="text" id="name" name="name"/></td>
</tr>
<tr>
<td>秘钥：</td>
<td><input type="text" id="key" name ="key" value="<%=uuid.toString()%>" disabled="disabled"/></td>
<td>支付时间：</td>
<td><input type="text" id="paytime" name="paytime" value="<%=datetime%>" disabled="disabled"/></td>
</tr>
<input type="submit" value="提交"/>
</form>
</body>
</html>