/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.txclass.dao;

import java.util.List;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.txclass.entity.TxClass;

/**
 * 班级管理DAO接口
 * @author ThinkGem
 * @version 2017-07-18
 */
@MyBatisDao
public interface TxClassDao extends CrudDao<TxClass> {
	
	public List<TxClass> getClassByGno(TxClass txClass);
	
}