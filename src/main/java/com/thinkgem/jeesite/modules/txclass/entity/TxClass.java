/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.txclass.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 班级管理Entity
 * @author ThinkGem
 * @version 2017-07-18
 */
public class TxClass extends DataEntity<TxClass> implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String cno;		// 班级编号
	private String cname;		// 班级名称
	private String gno;		// 所属年级
	private String tno;		// 班主任
	private String csum;		// 班级人数
	private String remark;		// 备注
	
	public TxClass() {
		super();
	}

	public TxClass(String id){
		super(id);
	}

	@Length(min=0, max=50, message="班级编号长度必须介于 0 和 50 之间")
	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}
	
	@Length(min=1, max=50, message="班级名称长度必须介于 1 和 50 之间")
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
	@Length(min=0, max=50, message="所属年级长度必须介于 0 和 50 之间")
	public String getGno() {
		return gno;
	}

	public void setGno(String gno) {
		this.gno = gno;
	}
	
	@Length(min=0, max=50, message="班主任长度必须介于 0 和 50 之间")
	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}
	
	@Length(min=0, max=11, message="班级人数长度必须介于 0 和 11 之间")
	public String getCsum() {
		return csum;
	}

	public void setCsum(String csum) {
		this.csum = csum;
	}
	
	@Length(min=0, max=50, message="备注长度必须介于 0 和 50 之间")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}