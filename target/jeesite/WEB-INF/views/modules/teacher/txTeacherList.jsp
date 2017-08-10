<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>教师管理</title>
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
		<li class="active"><a href="${ctx}/teacher/txTeacher/">教师列表</a></li>
		<shiro:hasPermission name="teacher:txTeacher:edit"><li><a href="${ctx}/teacher/txTeacher/form">教师添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="txTeacher" action="${ctx}/teacher/txTeacher/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>教师编号：</label>
				<form:input path="tno" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>教师姓名：</label>
				<form:input path="tname" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>手机号：</label>
				<form:input path="tmobile" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>性别：</label>
				<form:select path="tsex" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('sex')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>学历：</label>
				<form:input path="education" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li><label>毕业院校：</label>
				<form:input path="graduation" htmlEscape="false" maxlength="130" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>教师编号</th>
				<th>教师姓名</th>
				<th>手机号</th>
				<th>性别</th>
				<th>地址</th>
				<th>学历</th>
				<th>毕业院校</th>
				<th>办公室电话</th>
				<th>职称</th>
				<th>参加工作时间</th>
				<th>E_MAIL</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="teacher:txTeacher:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="txTeacher">
			<tr>
				<td><a href="${ctx}/teacher/txTeacher/form?id=${txTeacher.id}">
					${txTeacher.tno}
				</a></td>
				<td>
					${txTeacher.tname}
				</td>
				<td>
					${txTeacher.tmobile}
				</td>
				<td>
					${fns:getDictLabel(txTeacher.tsex, 'sex', '')}
				</td>
				<td>
					${txTeacher.taddress}
				</td>
				<td>
					${txTeacher.education}
				</td>
				<td>
					${txTeacher.graduation}
				</td>
				<td>
					${txTeacher.officetel}
				</td>
				<td>
					${txTeacher.dutyrank}
				</td>
				<td>
					<fmt:formatDate value="${txTeacher.begdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${txTeacher.email}
				</td>
				<td>
					<fmt:formatDate value="${txTeacher.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${txTeacher.remarks}
				</td>
				<shiro:hasPermission name="teacher:txTeacher:edit"><td>
    				<a href="${ctx}/teacher/txTeacher/form?id=${txTeacher.id}">修改</a>
					<a href="${ctx}/teacher/txTeacher/delete?id=${txTeacher.id}" onclick="return confirmx('确认要删除该教师吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>