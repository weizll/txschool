/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sutscore.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sutscore.entity.TxStuscore;
import com.thinkgem.jeesite.modules.sutscore.dao.TxStuscoreDao;

/**
 * 学生成绩管理Service
 * @author thinkgem
 * @version 2017-07-21
 */
@Service
@Transactional(readOnly = true)
public class TxStuscoreService extends CrudService<TxStuscoreDao, TxStuscore> {

	public TxStuscore get(String id) {
		return super.get(id);
	}
	
	public List<TxStuscore> findList(TxStuscore txStuscore) {
		return super.findList(txStuscore);
	}
	
	public Page<TxStuscore> findPage(Page<TxStuscore> page, TxStuscore txStuscore) {
		return super.findPage(page, txStuscore);
	}
	
	@Transactional(readOnly = false)
	public void save(TxStuscore txStuscore) {
		super.save(txStuscore);
	}
	
	@Transactional(readOnly = false)
	public void delete(TxStuscore txStuscore) {
		super.delete(txStuscore);
	}
	
}