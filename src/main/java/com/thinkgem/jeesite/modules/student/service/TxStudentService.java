/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.student.entity.TxStudent;
import com.thinkgem.jeesite.modules.student.dao.TxStudentDao;

/**
 * 学生管理Service
 * @author thinkgem
 * @version 2017-07-19
 */
@Service
@Transactional(readOnly = true)
public class TxStudentService extends CrudService<TxStudentDao, TxStudent> {

	public TxStudent get(String id) {
		return super.get(id);
	}
	
	public List<TxStudent> findList(TxStudent txStudent) {
		return super.findList(txStudent);
	}
	
	public Page<TxStudent> findPage(Page<TxStudent> page, TxStudent txStudent) {
		return super.findPage(page, txStudent);
	}
	
	@Transactional(readOnly = false)
	public void save(TxStudent txStudent) {
		super.save(txStudent);
	}
	
	@Transactional(readOnly = false)
	public void delete(TxStudent txStudent) {
		super.delete(txStudent);
	}
	
}