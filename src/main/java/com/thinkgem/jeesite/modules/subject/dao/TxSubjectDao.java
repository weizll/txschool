/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.subject.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.subject.entity.TxSubject;

/**
 * 科目管理DAO接口
 * @author thinkGem
 * @version 2017-07-17
 */
@MyBatisDao
public interface TxSubjectDao extends CrudDao<TxSubject> {
	
}