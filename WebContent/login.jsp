<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="jquery-1.11.1.min.js"></script>
</head>
<body>
	<s:property value="tip"/>
	<s:form id="loginForm">
		<s:textfield name="user.name" label="用户名"></s:textfield>
		<s:textfield name="user.pass" label="密码"></s:textfield>
		<tr>
			<td colspan="2">
				<input type="button" id="loginBn" value="提交">

			</td>
		</tr>
	
	</s:form>
	<div id="show" style="display: none;">
	
	</div>
</body>
<script type="text/javascript">



	$("#loginBn").click(function(){
		
// 		alert("你好");
		$.get("loginPro", $("#loginForm").serializeArray(), 
			function(data, statusText){
				$("#show").height(80)
				.width(300)
				.css("border", "1px solid black")
				.css("background-color","#efef99")
				.css("color", "#ff0000")
				.css("padding", "20px")
				.empty();
				$("#show").append("登录的结果：" + data + "<br/>");
				$("#show").show(2000);
			}		
		
		
		);
		
		
	});


</script>
</html>