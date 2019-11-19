<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student information</title>
<script type="text/javascript" src="/student/js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="/student/js/demo.js"></script>
<script type="text/javascript">
	$(function(){
		var pageSize = "${pageinfo.pageSize}";
		var pageNumber = "${pageinfo.pageNumber}";
		var tname = "${pageinfo.tname}";
		var sname = "${pageinof.sname}";
		var total = ${pageinfo.total}
		//i表示循环脚标   n表示迭代变量  n=数组[i]  n是dom对象
		//dom对象转换成jquery对象?  $(dom对象)
		//把jquery对象转换成dom对象 ?   jquery对象[0]  jquery对象.get(0)
		$.each($(":radio"),function(i, n){
			if($(n).val()==pageSize){
				$(n).attr("checked","checked");
			}
		});
		//对输入框设置值
		$(":text[name='sname']").val(sname);
		$(":text[name='tname']").val(tname);
		//查询按钮点击事件
		$("button").click(function(){
			location.href="show?pageSize=" + pageSize + "&pageNumebr=1&tname=" + $(":text[name='tname']").val() 
					+ "&sname=" + $(":text[name='sname']").val()
		});
		$(":radio").click(function(){
			pageSize = $(this).val();
			location.href="show?pageSize="+pageSize+"&pageNumber=1&tname="+$(":text[name='tname']").val()+"&sname="+$(":text[name='sname']").val();
		})
		//点击上一页
		$(".page_a:eq(0)").click(function(){
			pageNumber=parseInt(pageNumber)-1;
			if(pageNumber>=1){
				location.href="show?pageSize="+pageSize+"&pageNumber="+pageNumber+"&tname="+$(":text[name='tname']").val()+"&sname="+$(":text[name='sname']").val();
			}else{
				pageNumber = 1;
			}
			return false;
		});
	});
</script>
</head>
<body>
	<input type="radio" value="2" name="pageSize"/>2
	<input type="radio" value="2" name="pageSize"/>3
	<input type="radio" value="2" name="pageSize"/>4<br>
	Student Name:<input type="text" name="sname"/> Teacher Name:<input type="text" name="tname"/> <button>Search</button><br/>
	<table border="1">
		<tr>
			<td>Student ID</td>
			<td>Student Name</td>
			<td>Student Age</td>
			<td>Teacher</td>
		</tr>
		<c:forEach items="${pageinfo.list} " var="stu">
			<tr>
				<td>${stu.id }</td>
				<td>${stu.name }</td>
				<td>${stu.age }</td>
				<td>${stu.teacher.name }</td>
			</tr>
		</c:forEach>
	</table>
	<a href="" class="page_a">Previous Page</a><a href="" class="page_a">Next Page</a>
</body>
</html>