/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 学生管理Entity
 * @author thinkgem
 * @version 2017-07-19
 */
public class TxStudent extends DataEntity<TxStudent> {
	
	private static final long serialVersionUID = 1L;
	private String sno;		// 学号
	private String name;		// 姓名
	private String age;		// 年龄
	private String sex;		// 性别
	private String polity;		// 政治面貌
	private String address;		// 住址
	private Date entrancedate;		// 入校日期
	private String duty;		// 职务
	private Date birthday;		// 出生日期
	private String nation;		// 民族
	private String health;		// 健康状况
	private String parent;		// 家长姓名
	private String relation;		// 家长与本人关系
	private String phone;		// 家长电话
	private String gno;		// 年级号
	private String cno;		// 班级号
	
	public TxStudent() {
		super();
	}

	public TxStudent(String id){
		super(id);
	}

	@Length(min=0, max=50, message="学号长度必须介于 0 和 50 之间")
	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}
	
	@Length(min=0, max=15, message="姓名长度必须介于 0 和 15 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=11, message="年龄长度必须介于 0 和 11 之间")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	@Length(min=0, max=2, message="性别长度必须介于 0 和 2 之间")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=10, message="政治面貌长度必须介于 0 和 10 之间")
	public String getPolity() {
		return polity;
	}

	public void setPolity(String polity) {
		this.polity = polity;
	}
	
	@Length(min=0, max=20, message="住址长度必须介于 0 和 20 之间")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEntrancedate() {
		return entrancedate;
	}

	public void setEntrancedate(Date entrancedate) {
		this.entrancedate = entrancedate;
	}
	
	@Length(min=0, max=50, message="职务长度必须介于 0 和 50 之间")
	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Length(min=0, max=10, message="民族长度必须介于 0 和 10 之间")
	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}
	
	@Length(min=0, max=10, message="健康状况长度必须介于 0 和 10 之间")
	public String getHealth() {
		return health;
	}

	public void setHealth(String health) {
		this.health = health;
	}
	
	@Length(min=0, max=10, message="家长姓名长度必须介于 0 和 10 之间")
	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}
	
	@Length(min=0, max=10, message="家长与本人关系长度必须介于 0 和 10 之间")
	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}
	
	@Length(min=0, max=20, message="家长电话长度必须介于 0 和 20 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=1, max=20, message="年级号长度必须介于 1 和 20 之间")
	public String getGno() {
		return gno;
	}

	public void setGno(String gno) {
		this.gno = gno;
	}
	
	@Length(min=1, max=20, message="班级号长度必须介于 1 和 20 之间")
	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}
	
}