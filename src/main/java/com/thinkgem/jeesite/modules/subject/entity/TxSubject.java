/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.subject.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 科目管理Entity
 * @author thinkGem
 * @version 2017-07-17
 */
public class TxSubject extends DataEntity<TxSubject> {
	
	private static final long serialVersionUID = 1L;
	private String subno;		// 科目编号
	private String subname;		// 科目名称
	
	public TxSubject() {
		super();
	}

	public TxSubject(String id){
		super(id);
	}

	@Length(min=0, max=32, message="科目编号长度必须介于 0 和 32 之间")
	public String getSubno() {
		return subno;
	}

	public void setSubno(String subno) {
		this.subno = subno;
	}
	
	@Length(min=1, max=20, message="科目名称长度必须介于 1 和 20 之间")
	public String getSubname() {
		return subname;
	}

	public void setSubname(String subname) {
		this.subname = subname;
	}
	
}