/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sutscore.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sutscore.entity.TxStuscore;

/**
 * 学生成绩管理DAO接口
 * @author thinkgem
 * @version 2017-07-21
 */
@MyBatisDao
public interface TxStuscoreDao extends CrudDao<TxStuscore> {
	
}