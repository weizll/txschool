/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.grade.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.grade.entity.TxGrade;

/**
 * 年级管理DAO接口
 * @author ThinkGem
 * @version 2017-07-04
 */
@MyBatisDao
public interface TxGradeDao extends CrudDao<TxGrade> {
	
}