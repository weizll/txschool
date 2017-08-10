<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>学生管理</title>
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
		
		 //根据年级级联查询班级
	      function getClassByGno(gno){
	    	    $("#cno").empty();
	    	    $("#cno").append("<option value='0' selected>请选择</option>");
				$.ajax({
					data:"gno="+gno,
					type:"GET",
					dataType:"json",
					url:"${ctx}/txclass/txClass/getCname",
					success:function(data){
						var myobj=eval(data);
						var optionStr="";
						for(var i=0;i<myobj.length;i++){
							optionStr += "<option value="+myobj[i].cno+">"+myobj[i].cname+"</option>"; 
						}
						$("#cno").append(optionStr);
						$("#s2id_cno .select2-chosen").html(""); 
					}
				});		
			}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/student/txStudent/">学生列表</a></li>
		<shiro:hasPermission name="student:txStudent:edit"><li><a href="${ctx}/student/txStudent/form">学生添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="txStudent" action="${ctx}/student/txStudent/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>学号：</label>
				<form:input path="sno" htmlEscape="false" maxlength="50" class="input-medium"/>
			</li>
			<li><label>姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="15" class="input-medium"/>
			</li>
			<li><label>年龄：</label>
				<form:input path="age" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>性别：</label>
				<form:select path="sex" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('sex')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>政治面貌：</label>
				<form:input path="polity" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li><label>住址：</label>
				<form:input path="address" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>入校日期：</label>
				<input name="entrancedate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${txStudent.entrancedate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>出生日期：</label>
				<input name="birthday" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${txStudent.birthday}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>民族：</label>
				<form:input path="nation" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li><label>家长姓名：</label>
				<form:input path="parent" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li><label>与本人关系：</label>
				<form:select path="relation" class="input-medium">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('relation')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>
			<li><label>年级：</label>
				<select name="gno" id="gno" style="width: 175px;" onchange="getClassByGno(this.value)">
				    <option></option>
					<c:forEach var="grade" items="${txgrade}"> 
					<option value="${grade.gno}" <c:if test ="${grade.gno eq txStudent.gno}">selected</c:if>>${grade.gname}</option> 
					</c:forEach>
				</select>
			</li>
			<li><label>班级：</label>
				<select name="cno" id="cno" style="width: 175px;">
				    <option></option>
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
				<th>学号</th>
				<th>姓名</th>
				<th>年龄</th>
				<th>性别</th>
				<th>政治面貌</th>
				<th>住址</th>
				<th>入校日期</th>
				<th>出生日期</th>
				<th>民族</th>
				<th>家长姓名</th>
				<th>家长与本人关系</th>
				<th>年级</th>
				<th>班级</th>
				<th>更新时间</th>
				<th>备注信息</th>
				<shiro:hasPermission name="student:txStudent:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="txStudent">
			<tr>
				<td><a href="${ctx}/student/txStudent/form?id=${txStudent.id}">
					${txStudent.sno}
				</a></td>
				<td>
					${txStudent.name}
				</td>
				<td>
					${txStudent.age}
				</td>
				<td>
					${fns:getDictLabel(txStudent.sex, 'sex', '')}
				</td>
				<td>
					${txStudent.polity}
				</td>
				<td>
					${txStudent.address}
				</td>
				<td>
					<fmt:formatDate value="${txStudent.entrancedate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${txStudent.birthday}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${txStudent.nation}
				</td>
				<td>
					${txStudent.parent}
				</td>
				<td>
					${fns:getDictLabel(txStudent.relation, 'relation', '')}
				</td>
				<td>
					${fns:getNameByNo("tx_grade", "gno", "gname",txStudent.gno)}
				</td>
				<td>
					${fns:getNameByNo("tx_class", "cno", "cname", txStudent.cno)}
				</td>
				<td>
					<fmt:formatDate value="${txStudent.updateDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					${txStudent.remarks}
				</td>
				<shiro:hasPermission name="student:txStudent:edit"><td>
    				<a href="${ctx}/student/txStudent/form?id=${txStudent.id}">修改</a>
					<a href="${ctx}/student/txStudent/delete?id=${txStudent.id}" onclick="return confirmx('确认要删除该学生吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>