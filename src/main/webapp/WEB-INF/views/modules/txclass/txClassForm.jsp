<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>班级管理</title>
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
		<li><a href="${ctx}/txclass/txClass/">班级列表</a></li>
		<li class="active"><a href="${ctx}/txclass/txClass/form?id=${txClass.id}">班级<shiro:hasPermission name="txclass:txClass:edit">${not empty txClass.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="txclass:txClass:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="txClass" action="${ctx}/txclass/txClass/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">班级编号：</label>
			<div class="controls">
				<form:input path="cno" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">班级名称：</label>
			<div class="controls">
				<form:input path="cname" htmlEscape="false" maxlength="50" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">所属年级：</label>
			<div class="controls">
				<select name="gno" id="gno" style="width: 270px;">
				    <option>请选择</option>
					<c:forEach var="grade" items="${txgrade}"> 
					<option value="${grade.gno}" <c:if test ="${grade.gno eq txClass.gno}">selected</c:if>>${grade.gname}</option> 
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">班主任：</label>
			<div class="controls">
				<select name="tno" id="tno" style="width: 270px;">
				    <option>请选择</option>
					<c:forEach var="txteacher" items="${txteacher}"> 
					<option value="${txteacher.tno}" <c:if test ="${txteacher.tno eq txClass.tno}">selected</c:if>>${txteacher.tname}</option> 
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">班级人数：</label>
			<div class="controls">
				<form:input path="csum" htmlEscape="false" maxlength="11" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:input path="remark" htmlEscape="false" maxlength="50" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="txclass:txClass:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>