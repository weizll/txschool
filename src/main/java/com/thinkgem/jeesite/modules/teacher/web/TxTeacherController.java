/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.teacher.web;

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
import com.thinkgem.jeesite.modules.teacher.entity.TxTeacher;
import com.thinkgem.jeesite.modules.teacher.service.TxTeacherService;

/**
 * 教师管理Controller
 * @author thinkGem
 * @version 2017-07-19
 */
@Controller
@RequestMapping(value = "${adminPath}/teacher/txTeacher")
public class TxTeacherController extends BaseController {

	@Autowired
	private TxTeacherService txTeacherService;
	
	@ModelAttribute
	public TxTeacher get(@RequestParam(required=false) String id) {
		TxTeacher entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = txTeacherService.get(id);
		}
		if (entity == null){
			entity = new TxTeacher();
		}
		return entity;
	}
	
	@RequiresPermissions("teacher:txTeacher:view")
	@RequestMapping(value = {"list", ""})
	public String list(TxTeacher txTeacher, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TxTeacher> page = txTeacherService.findPage(new Page<TxTeacher>(request, response), txTeacher); 
		model.addAttribute("page", page);
		return "modules/teacher/txTeacherList";
	}

	@RequiresPermissions("teacher:txTeacher:view")
	@RequestMapping(value = "form")
	public String form(TxTeacher txTeacher, Model model) {
		model.addAttribute("txTeacher", txTeacher);
		return "modules/teacher/txTeacherForm";
	}

	@RequiresPermissions("teacher:txTeacher:edit")
	@RequestMapping(value = "save")
	public String save(TxTeacher txTeacher, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, txTeacher)){
			return form(txTeacher, model);
		}
		txTeacherService.save(txTeacher);
		addMessage(redirectAttributes, "保存教师成功");
		return "redirect:"+Global.getAdminPath()+"/teacher/txTeacher/?repage";
	}
	
	@RequiresPermissions("teacher:txTeacher:edit")
	@RequestMapping(value = "delete")
	public String delete(TxTeacher txTeacher, RedirectAttributes redirectAttributes) {
		txTeacherService.delete(txTeacher);
		addMessage(redirectAttributes, "删除教师成功");
		return "redirect:"+Global.getAdminPath()+"/teacher/txTeacher/?repage";
	}

}