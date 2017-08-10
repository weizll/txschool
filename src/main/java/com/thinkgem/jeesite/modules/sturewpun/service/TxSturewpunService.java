/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sturewpun.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.sturewpun.entity.TxSturewpun;
import com.thinkgem.jeesite.modules.sturewpun.dao.TxSturewpunDao;

/**
 * 学生奖惩管理Service
 * @author thinkgem
 * @version 2017-07-21
 */
@Service
@Transactional(readOnly = true)
public class TxSturewpunService extends CrudService<TxSturewpunDao, TxSturewpun> {

	public TxSturewpun get(String id) {
		return super.get(id);
	}
	
	public List<TxSturewpun> findList(TxSturewpun txSturewpun) {
		return super.findList(txSturewpun);
	}
	
	public Page<TxSturewpun> findPage(Page<TxSturewpun> page, TxSturewpun txSturewpun) {
		return super.findPage(page, txSturewpun);
	}
	
	@Transactional(readOnly = false)
	public void save(TxSturewpun txSturewpun) {
		super.save(txSturewpun);
	}
	
	@Transactional(readOnly = false)
	public void delete(TxSturewpun txSturewpun) {
		super.delete(txSturewpun);
	}
	
}