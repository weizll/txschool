package com.thinkgem.jeesite.modules.sys.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sys.entity.Common;

@MyBatisDao
public interface CommonDao extends CrudDao<Common>{
	
	public String getNameByNo(Common common);

}
