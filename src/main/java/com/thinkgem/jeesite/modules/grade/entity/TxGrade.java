/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.grade.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 年级管理Entity
 * @author ThinkGem
 * @version 2017-07-04
 */
public class TxGrade extends DataEntity<TxGrade> {
	
	private static final long serialVersionUID = 1L;
	private String gno;		// 年级编号
	private String gname;		// 年级名称
	
	public TxGrade() {
		super();
	}

	public TxGrade(String id){
		super(id);
	}

	@Length(min=1, max=32, message="年级编号长度必须介于 1 和 32 之间")
	public String getGno() {
		return gno;
	}

	public void setGno(String gno) {
		this.gno = gno;
	}
	
	@Length(min=1, max=20, message="年级名称长度必须介于 1 和 20 之间")
	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}
	
}