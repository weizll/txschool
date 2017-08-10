<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>学生成绩管理</title>
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
		<li class="active"><a href="${ctx}/sutscore/txStuscore/">学生成绩列表</a></li>
		<shiro:hasPermission name="sutscore:txStuscore:edit"><li><a href="${ctx}/sutscore/txStuscore/form">学生成绩添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="txStuscore" action="${ctx}/sutscore/txStuscore/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>学生姓名：</label>
				<select name="sno" id="sno" style="width: 185px;">
				    <option></option>
					<c:forEach var="txStudent" items="${txStudent}"> 
					<option value="${txStudent.sno}" <c:if test ="${txStudent.sno eq txStuscore.sno}">selected</c:if>>${txStudent.name}</option> 
					</c:forEach>
				</select>
			</li>
			<li><label>科目名称：</label>
				<select name="subno" id="subno" style="width: 185px;">
				    <option></option>
					<c:forEach var="txSubject" items="${txSubject}"> 
					<option value="${txSubject.subno}" <c:if test ="${txSubject.subno eq txStuscore.subno}">selected</c:if>>${txSubject.subname}</option> 
					</c:forEach>
				</select>
			</li>
			<li><label>考试年段：</label>
				<form:input path="examyear" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li><label>考试学期：</label>
				<form:input path="examterm" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>学生编号</th>
				<th>科目编号</th>
				<th>考试成绩</th>
				<th>考试年段</th>
				<th>考试学期</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="sutscore:txStuscore:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="txStuscore">
			<tr>
				<td><a href="${ctx}/sutscore/txStuscore/form?id=${txStuscore.id}">
					${fns:getNameByNo("tx_student", "sno", "name",txStuscore.sno)}
				</a></td>
				<td>
				    ${fns:getNameByNo("tx_subject", "subno", "subname",txStuscore.subno)}
				</td>
				<td>
					${txStuscore.examscore}
				</td>
				<td>
					${txStuscore.examyear}
				</td>
				<td>
					${txStuscore.examterm}
				</td>
				<td>
					<fmt:formatDate value="${txStuscore.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${txStuscore.remarks}
				</td>
				<shiro:hasPermission name="sutscore:txStuscore:edit"><td>
    				<a href="${ctx}/sutscore/txStuscore/form?id=${txStuscore.id}">修改</a>
					<a href="${ctx}/sutscore/txStuscore/delete?id=${txStuscore.id}" onclick="return confirmx('确认要删除该学生成绩吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>