/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.teacher.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.teacher.entity.TxTeacher;

/**
 * 教师管理DAO接口
 * @author thinkGem
 * @version 2017-07-19
 */
@MyBatisDao
public interface TxTeacherDao extends CrudDao<TxTeacher> {
	
}