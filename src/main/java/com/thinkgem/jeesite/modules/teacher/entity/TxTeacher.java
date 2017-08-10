/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.teacher.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 教师管理Entity
 * @author thinkGem
 * @version 2017-07-19
 */
public class TxTeacher extends DataEntity<TxTeacher> {
	
	private static final long serialVersionUID = 1L;
	private String tno;		// 教师编号
	private String tname;		// 教师姓名
	private String tmobile;		// 手机号
	private String tsex;		// 性别
	private String taddress;		// 地址
	private String education;		// 学历
	private String graduation;		// 毕业院校
	private Date gradudate;		// 毕业时间
	private String officetel;		// 办公室电话
	private String dutyrank;		// 职称
	private Date begdate;		// 参加工作时间
	private String email;		// E_MAIL
	
	public TxTeacher() {
		super();
	}

	public TxTeacher(String id){
		super(id);
	}

	@Length(min=1, max=20, message="教师编号长度必须介于 1 和 20 之间")
	public String getTno() {
		return tno;
	}

	public void setTno(String tno) {
		this.tno = tno;
	}
	
	@Length(min=1, max=20, message="教师姓名长度必须介于 1 和 20 之间")
	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}
	
	@Length(min=0, max=20, message="手机号长度必须介于 0 和 20 之间")
	public String getTmobile() {
		return tmobile;
	}

	public void setTmobile(String tmobile) {
		this.tmobile = tmobile;
	}
	
	@Length(min=0, max=2, message="性别长度必须介于 0 和 2 之间")
	public String getTsex() {
		return tsex;
	}

	public void setTsex(String tsex) {
		this.tsex = tsex;
	}
	
	@Length(min=0, max=50, message="地址长度必须介于 0 和 50 之间")
	public String getTaddress() {
		return taddress;
	}

	public void setTaddress(String taddress) {
		this.taddress = taddress;
	}
	
	@Length(min=0, max=10, message="学历长度必须介于 0 和 10 之间")
	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}
	
	@Length(min=0, max=130, message="毕业院校长度必须介于 0 和 130 之间")
	public String getGraduation() {
		return graduation;
	}

	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getGradudate() {
		return gradudate;
	}

	public void setGradudate(Date gradudate) {
		this.gradudate = gradudate;
	}
	
	@Length(min=0, max=20, message="办公室电话长度必须介于 0 和 20 之间")
	public String getOfficetel() {
		return officetel;
	}

	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}
	
	@Length(min=0, max=20, message="职称长度必须介于 0 和 20 之间")
	public String getDutyrank() {
		return dutyrank;
	}

	public void setDutyrank(String dutyrank) {
		this.dutyrank = dutyrank;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBegdate() {
		return begdate;
	}

	public void setBegdate(Date begdate) {
		this.begdate = begdate;
	}
	
	@Length(min=0, max=30, message="E_MAIL长度必须介于 0 和 30 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}