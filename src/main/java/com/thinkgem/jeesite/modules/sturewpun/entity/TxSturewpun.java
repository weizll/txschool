/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sturewpun.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学生奖惩管理Entity
 * @author thinkgem
 * @version 2017-07-21
 */
public class TxSturewpun extends DataEntity<TxSturewpun> {
	
	private static final long serialVersionUID = 1L;
	private String sno;		// 学生编号
	private String sort;		// 奖励或处分
	private String type;		// 奖惩类型
	private String reason;		// 奖惩原因
	private Date rptime;		// 奖惩时间
	private String remark;		// 备注
	
	public TxSturewpun() {
		super();
	}

	public TxSturewpun(String id){
		super(id);
	}

	@Length(min=0, max=20, message="学生编号长度必须介于 0 和 20 之间")
	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}
	
	@Length(min=0, max=2, message="奖励或处分长度必须介于 0 和 2 之间")
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
	@Length(min=0, max=30, message="奖惩类型长度必须介于 0 和 30 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=100, message="奖惩原因长度必须介于 0 和 100 之间")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getRptime() {
		return rptime;
	}

	public void setRptime(Date rptime) {
		this.rptime = rptime;
	}
	
	@Length(min=0, max=100, message="备注长度必须介于 0 和 100 之间")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}