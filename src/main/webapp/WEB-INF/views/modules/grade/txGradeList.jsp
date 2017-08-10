<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>年级管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/grade/txGrade/">年级列表</a></li>
		<shiro:hasPermission name="grade:txGrade:edit"><li><a href="${ctx}/grade/txGrade/form">年级添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="txGrade" action="${ctx}/grade/txGrade/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>年级编号：</label>
				<form:input path="gno" htmlEscape="false" maxlength="32" class="input-medium"/>
			</li>
			<li><label>年级名称：</label>
				<form:input path="gname" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>年级编号</th>
				<th>年级名称</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="grade:txGrade:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="txGrade">
			<tr>
				<td><a href="${ctx}/grade/txGrade/form?id=${txGrade.id}">
					${txGrade.gno}
				</a></td>
				<td>
					${txGrade.gname}
				</td>
				<td>
					<fmt:formatDate value="${txGrade.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${txGrade.remarks}
				</td>
				<shiro:hasPermission name="grade:txGrade:edit"><td>
    				<a href="${ctx}/grade/txGrade/form?id=${txGrade.id}">修改</a>
					<a href="${ctx}/grade/txGrade/delete?id=${txGrade.id}" onclick="return confirmx('确认要删除该年级吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>