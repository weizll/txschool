/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.txclass.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.txclass.entity.TxClass;
import com.thinkgem.jeesite.modules.txclass.dao.TxClassDao;

/**
 * 班级管理Service
 * @author ThinkGem
 * @version 2017-07-18
 */
@Service
@Transactional(readOnly = true)
public class TxClassService extends CrudService<TxClassDao, TxClass> {

	public TxClass get(String id) {
		return super.get(id);
	}
	
	public List<TxClass> findList(TxClass txClass) {
		return super.findList(txClass);
	}
	
	public Page<TxClass> findPage(Page<TxClass> page, TxClass txClass) {
		return super.findPage(page, txClass);
	}
	
	@Transactional(readOnly = false)
	public void save(TxClass txClass) {
		super.save(txClass);
	}
	
	@Transactional(readOnly = false)
	public void delete(TxClass txClass) {
		super.delete(txClass);
	}
	
	public List<TxClass> getClassByGno(TxClass txClass){
		return dao.getClassByGno(txClass);
	}
	
}