<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>科目管理</title>
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
		<li class="active"><a href="${ctx}/subject/txSubject/">科目列表</a></li>
		<shiro:hasPermission name="subject:txSubject:edit"><li><a href="${ctx}/subject/txSubject/form">科目添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="txSubject" action="${ctx}/subject/txSubject/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>科目名称：</label>
				<form:input path="subname" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>科目编号</th>
				<th>科目名称</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="subject:txSubject:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="txSubject">
			<tr>
				<td><a href="${ctx}/subject/txSubject/form?id=${txSubject.id}">
					${txSubject.subno}
				</a></td>
				<td>
					${txSubject.subname}
				</td>
				<td>
					<fmt:formatDate value="${txSubject.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${txSubject.remarks}
				</td>
				<shiro:hasPermission name="subject:txSubject:edit"><td>
    				<a href="${ctx}/subject/txSubject/form?id=${txSubject.id}">修改</a>
					<a href="${ctx}/subject/txSubject/delete?id=${txSubject.id}" onclick="return confirmx('确认要删除该科目吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>