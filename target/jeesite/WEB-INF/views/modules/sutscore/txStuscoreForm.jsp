<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>学生成绩管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sutscore/txStuscore/">学生成绩列表</a></li>
		<li class="active"><a href="${ctx}/sutscore/txStuscore/form?id=${txStuscore.id}">学生成绩<shiro:hasPermission name="sutscore:txStuscore:edit">${not empty txStuscore.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sutscore:txStuscore:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="txStuscore" action="${ctx}/sutscore/txStuscore/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">学生姓名：</label>
			<div class="controls">
				<select name="sno" id="sno" style="width: 270px;">
				    <option></option>
					<c:forEach var="txStudent" items="${txStudent}"> 
					<option value="${txStudent.sno}" <c:if test ="${txStudent.sno eq txStuscore.sno}">selected</c:if>>${txStudent.name}</option> 
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">科目名称：</label>
			<div class="controls">
				<select name="subno" id="subno" style="width: 270px;">
				    <option></option>
					<c:forEach var="txSubject" items="${txSubject}"> 
					<option value="${txSubject.subno}" <c:if test ="${txSubject.subno eq txStuscore.subno}">selected</c:if>>${txSubject.subname}</option> 
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">考试成绩：</label>
			<div class="controls">
				<form:input path="examscore" htmlEscape="false" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">考试年段：</label>
			<div class="controls">
				<form:input path="examyear" htmlEscape="false" maxlength="10" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">考试学期：</label>
			<div class="controls">
				<form:input path="examterm" htmlEscape="false" maxlength="10" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="sutscore:txStuscore:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>