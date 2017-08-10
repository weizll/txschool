/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.grade.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.grade.entity.TxGrade;
import com.thinkgem.jeesite.modules.grade.dao.TxGradeDao;

/**
 * 年级管理Service
 * @author ThinkGem
 * @version 2017-07-04
 */
@Service
@Transactional(readOnly = true)
public class TxGradeService extends CrudService<TxGradeDao, TxGrade> {

	public TxGrade get(String id) {
		return super.get(id);
	}
	
	public List<TxGrade> findList(TxGrade txGrade) {
		return super.findList(txGrade);
	}
	
	public Page<TxGrade> findPage(Page<TxGrade> page, TxGrade txGrade) {
		return super.findPage(page, txGrade);
	}
	
	@Transactional(readOnly = false)
	public void save(TxGrade txGrade) {
		super.save(txGrade);
	}
	
	@Transactional(readOnly = false)
	public void delete(TxGrade txGrade) {
		super.delete(txGrade);
	}
	
}