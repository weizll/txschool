<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>班级管理</title>
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
		<li class="active"><a href="${ctx}/txclass/txClass/">班级列表</a></li>
		<shiro:hasPermission name="txclass:txClass:edit"><li><a href="${ctx}/txclass/txClass/form">班级添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="txClass" action="${ctx}/txclass/txClass/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>班级编号：</label>
				<form:input path="cno" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>班级名称：</label>
				<form:input path="cname" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>所属年级：</label>
				<select name="gno" id="gno" style="width: 185px;">
				    <option></option>
					<c:forEach var="grade" items="${txgrade}"> 
					<option value="${grade.gno}" <c:if test ="${grade.gno eq txClass.gno}">selected</c:if>>${grade.gname}</option> 
					</c:forEach>
				</select>
			</li>
			<li><label>班主任：</label>
				<select name="tno" id="tno" style="width: 185px;">
				    <option></option>
					<c:forEach var="txteacher" items="${txteacher}"> 
					<option value="${txteacher.tno}" <c:if test ="${txteacher.tno eq txClass.tno}">selected</c:if>>${txteacher.tname}</option> 
					</c:forEach>
				</select>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>班级编号</th>
				<th>班级名称</th>
				<th>所属年级</th>
				<th>班主任</th>
				<th>班级人数</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="txclass:txClass:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="txClass">
			<tr>
				<td><a href="${ctx}/txclass/txClass/form?id=${txClass.id}">
					${txClass.cno}
				</a></td>
				<td>
					${txClass.cname}
				</td>
				<td>
					${fns:getNameByNo("tx_grade", "gno", "gname", txClass.gno)}
				</td>
				<td>
					${fns:getNameByNo("tx_teacher", "tno", 'tname',txClass.tno)}
				</td>
				<td>
					${txClass.csum}
				</td>
				<td>
					<fmt:formatDate value="${txClass.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${txClass.remarks}
				</td>
				<shiro:hasPermission name="txclass:txClass:edit"><td>
    				<a href="${ctx}/txclass/txClass/form?id=${txClass.id}">修改</a>
					<a href="${ctx}/txclass/txClass/delete?id=${txClass.id}" onclick="return confirmx('确认要删除该班级吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>