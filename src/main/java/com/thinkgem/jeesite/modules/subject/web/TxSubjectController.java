/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.subject.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.subject.entity.TxSubject;
import com.thinkgem.jeesite.modules.subject.service.TxSubjectService;

/**
 * 科目管理Controller
 * @author thinkGem
 * @version 2017-07-17
 */
@Controller
@RequestMapping(value = "${adminPath}/subject/txSubject")
public class TxSubjectController extends BaseController {

	@Autowired
	private TxSubjectService txSubjectService;
	
	@ModelAttribute
	public TxSubject get(@RequestParam(required=false) String id) {
		TxSubject entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = txSubjectService.get(id);
		}
		if (entity == null){
			entity = new TxSubject();
		}
		return entity;
	}
	
	@RequiresPermissions("subject:txSubject:view")
	@RequestMapping(value = {"list", ""})
	public String list(TxSubject txSubject, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TxSubject> page = txSubjectService.findPage(new Page<TxSubject>(request, response), txSubject); 
		model.addAttribute("page", page);
		return "modules/subject/txSubjectList";
	}

	@RequiresPermissions("subject:txSubject:view")
	@RequestMapping(value = "form")
	public String form(TxSubject txSubject, Model model) {
		model.addAttribute("txSubject", txSubject);
		return "modules/subject/txSubjectForm";
	}

	@RequiresPermissions("subject:txSubject:edit")
	@RequestMapping(value = "save")
	public String save(TxSubject txSubject, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, txSubject)){
			return form(txSubject, model);
		}
		txSubjectService.save(txSubject);
		addMessage(redirectAttributes, "保存科目成功");
		return "redirect:"+Global.getAdminPath()+"/subject/txSubject/?repage";
	}
	
	@RequiresPermissions("subject:txSubject:edit")
	@RequestMapping(value = "delete")
	public String delete(TxSubject txSubject, RedirectAttributes redirectAttributes) {
		txSubjectService.delete(txSubject);
		addMessage(redirectAttributes, "删除科目成功");
		return "redirect:"+Global.getAdminPath()+"/subject/txSubject/?repage";
	}

}