/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.teacher.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.teacher.entity.TxTeacher;
import com.thinkgem.jeesite.modules.teacher.dao.TxTeacherDao;

/**
 * 教师管理Service
 * @author thinkGem
 * @version 2017-07-19
 */
@Service
@Transactional(readOnly = true)
public class TxTeacherService extends CrudService<TxTeacherDao, TxTeacher> {

	public TxTeacher get(String id) {
		return super.get(id);
	}
	
	public List<TxTeacher> findList(TxTeacher txTeacher) {
		return super.findList(txTeacher);
	}
	
	public Page<TxTeacher> findPage(Page<TxTeacher> page, TxTeacher txTeacher) {
		return super.findPage(page, txTeacher);
	}
	
	@Transactional(readOnly = false)
	public void save(TxTeacher txTeacher) {
		super.save(txTeacher);
	}
	
	@Transactional(readOnly = false)
	public void delete(TxTeacher txTeacher) {
		super.delete(txTeacher);
	}
	
}