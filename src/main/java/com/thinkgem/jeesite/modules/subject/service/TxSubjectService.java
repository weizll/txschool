/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.subject.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.subject.entity.TxSubject;
import com.thinkgem.jeesite.modules.subject.dao.TxSubjectDao;

/**
 * 科目管理Service
 * @author thinkGem
 * @version 2017-07-17
 */
@Service
@Transactional(readOnly = true)
public class TxSubjectService extends CrudService<TxSubjectDao, TxSubject> {

	public TxSubject get(String id) {
		return super.get(id);
	}
	
	public List<TxSubject> findList(TxSubject txSubject) {
		return super.findList(txSubject);
	}
	
	public Page<TxSubject> findPage(Page<TxSubject> page, TxSubject txSubject) {
		return super.findPage(page, txSubject);
	}
	
	@Transactional(readOnly = false)
	public void save(TxSubject txSubject) {
		super.save(txSubject);
	}
	
	@Transactional(readOnly = false)
	public void delete(TxSubject txSubject) {
		super.delete(txSubject);
	}
	
}