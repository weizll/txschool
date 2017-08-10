<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>学生奖惩管理</title>
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
		<li class="active"><a href="${ctx}/sturewpun/txSturewpun/">学生奖惩列表</a></li>
		<shiro:hasPermission name="sturewpun:txSturewpun:edit"><li><a href="${ctx}/sturewpun/txSturewpun/form">学生奖惩添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="txSturewpun" action="${ctx}/sturewpun/txSturewpun/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>学生姓名：</label>
				<select name="sno" id="sno" style="width: 175px;">
				    <option></option>
					<c:forEach var="txStudent" items="${txStudent}"> 
					<option value="${txStudent.sno}" <c:if test ="${txStudent.sno eq txSturewpun.sno}">selected</c:if>>${txStudent.name}</option> 
					</c:forEach>
				</select>
			</li>
			<li><label>奖励或处分：</label>
				<form:select path="sort" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('sortflag')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>奖惩类型：</label>
				<form:input path="type" htmlEscape="false" maxlength="30" class="input-medium"/>
			</li>
			<li><label>奖惩原因：</label>
				<form:input path="reason" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>奖惩时间：</label>
				<input name="rptime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${txSturewpun.rptime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
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
				<th>奖励或处分</th>
				<th>奖惩类型</th>
				<th>奖惩原因</th>
				<th>奖惩时间</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="sturewpun:txSturewpun:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="txSturewpun">
			<tr>
				<td><a href="${ctx}/sturewpun/txSturewpun/form?id=${txSturewpun.id}">
					${fns:getNameByNo("tx_student", "sno", "name",txSturewpun.sno)}
				</a></td>
				<td>
					${fns:getDictLabel(txSturewpun.sort, 'sortflag', '')}
				</td>
				<td>
					${txSturewpun.type}
				</td>
				<td>
					${txSturewpun.reason}
				</td>
				<td>
					<fmt:formatDate value="${txSturewpun.rptime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${txSturewpun.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${txSturewpun.remarks}
				</td>
				<shiro:hasPermission name="sturewpun:txSturewpun:edit"><td>
    				<a href="${ctx}/sturewpun/txSturewpun/form?id=${txSturewpun.id}">修改</a>
					<a href="${ctx}/sturewpun/txSturewpun/delete?id=${txSturewpun.id}" onclick="return confirmx('确认要删除该学生奖惩吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>