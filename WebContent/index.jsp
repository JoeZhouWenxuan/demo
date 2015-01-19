<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="jquery-1.11.1.min.js"></script>

<title>Insert title here</title>

</head>
<body>
	设置每页显示条数：
	<select onchange="setPageSize(this.value)" id="_pz">
			<s:iterator begin="10" end="50" var="size" step="10" >
			
				<option value="${size}">${size}</option>
			
			</s:iterator>
	</select>
	<script type="text/javascript">
				$("#_pz").val("${pageSize}");
	</script>
	<br />
	<s:iterator value="recordList" >
		${id } --- ${name }<br />
	
	</s:iterator>
	<br />
	
	<%--公共代码抽取 begin --%>
	<div>
		页次：${ currentPage } / ${pageCount } &nbsp;&nbsp;&nbsp;
		每页显示：${pageSize } 条
		总记录数：${recordCount }
		
		
		
	</div>
	<div>
		<s:iterator begin="%{beginPageIndex}" end="%{endPageIndex}" var="num">
			<s:if test="#num == currentPage">
				${num }
			</s:if>
			<s:else>
				<a href="#" onclick="gotoPage(${num})">${num }</a>
			</s:else>
		
		</s:iterator>
		<select onchange="gotoPage(this.value)" id="_pn">
				<s:iterator begin="1" end="%{pageCount}" var="num" >
				
					<option value="${num}">${num}</option>
				
				</s:iterator>
				
			
		</select>
		<script type="text/javascript">
			$("#_pn").val("${currentPage}");
		</script>
	
	</div>
	 <!-- 除去此行 -->
	<s:form action="userAction_list" name="form1"></s:form>
	<script type="text/javascript">
	function gotoPage(pageNum){
		
// 		window.location.href="userAction_list.action?pageNum=" + pageNum;
// 		alert("<input type='hidden' name='pageNum' value='" + pageNum + "' />"	);
		$(document.forms["form1"]).append("<input type='hidden' name='pageNum' value='" + pageNum + "' />");
		document.forms["form1"].submit();
	}
	function setPageSize(pageSize){
		$(document.forms["form1"]).append("<input type='hidden' name='pageSize' value='" + pageSize + "' />");
		document.forms["form1"].submit();
	}

</script>
	<%--公共代码抽取 end --%>	
		

</body>
</html>