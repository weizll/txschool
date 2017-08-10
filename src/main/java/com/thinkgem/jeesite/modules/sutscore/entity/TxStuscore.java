/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sutscore.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学生成绩管理Entity
 * @author thinkgem
 * @version 2017-07-21
 */
public class TxStuscore extends DataEntity<TxStuscore> {
	
	private static final long serialVersionUID = 1L;
	private String sno;		// 学生编号
	private String subno;		// 科目编号
	private String examscore;		// 考试成绩
	private String examyear;		// 考试年段
	private String examterm;		// 考试学期
	
	public TxStuscore() {
		super();
	}

	public TxStuscore(String id){
		super(id);
	}

	@Length(min=0, max=20, message="学生编号长度必须介于 0 和 20 之间")
	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}
	
	@Length(min=0, max=20, message="科目编号长度必须介于 0 和 20 之间")
	public String getSubno() {
		return subno;
	}

	public void setSubno(String subno) {
		this.subno = subno;
	}
	
	public String getExamscore() {
		return examscore;
	}

	public void setExamscore(String examscore) {
		this.examscore = examscore;
	}
	
	@Length(min=0, max=10, message="考试年段长度必须介于 0 和 10 之间")
	public String getExamyear() {
		return examyear;
	}

	public void setExamyear(String examyear) {
		this.examyear = examyear;
	}
	
	@Length(min=0, max=10, message="考试学期长度必须介于 0 和 10 之间")
	public String getExamterm() {
		return examterm;
	}

	public void setExamterm(String examterm) {
		this.examterm = examterm;
	}
	
}