package com.thinkgem.jeesite.modules.sys.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

public class Common extends DataEntity<Common>{

	private static final long serialVersionUID = 1L;
	private String tableName;
	private String fieldName;
	private String colname;
	private String paramno;
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getColname() {
		return colname;
	}
	public void setColname(String colname) {
		this.colname = colname;
	}
	public String getParamno() {
		return paramno;
	}
	public void setParamno(String paramno) {
		this.paramno = paramno;
	}
	

	
}
