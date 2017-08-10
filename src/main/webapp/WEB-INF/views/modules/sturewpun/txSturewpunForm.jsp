<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>学生奖惩管理</title>
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
		<li><a href="${ctx}/sturewpun/txSturewpun/">学生奖惩列表</a></li>
		<li class="active"><a href="${ctx}/sturewpun/txSturewpun/form?id=${txSturewpun.id}">学生奖惩<shiro:hasPermission name="sturewpun:txSturewpun:edit">${not empty txSturewpun.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sturewpun:txSturewpun:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="txSturewpun" action="${ctx}/sturewpun/txSturewpun/save" method="post" class="form-horizontal">
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
			<label class="control-label">奖励或处分：</label>
			<div class="controls">
				<form:select path="sort" class="input-xlarge ">
					<form:option value="" label=""/>
					<form:options items="${fns:getDictList('sortflag')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">奖惩类型：</label>
			<div class="controls">
				<form:input path="type" htmlEscape="false" maxlength="30" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">奖惩原因：</label>
			<div class="controls">
				<form:input path="reason" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">奖惩时间：</label>
			<div class="controls">
				<input name="rptime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${txSturewpun.rptime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group" style="display:none">
			<label class="control-label">备注：</label>
			<div class="controls">
				<form:input path="remark" htmlEscape="false" maxlength="100" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注信息：</label>
			<div class="controls">
				<form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/>
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="sturewpun:txSturewpun:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>