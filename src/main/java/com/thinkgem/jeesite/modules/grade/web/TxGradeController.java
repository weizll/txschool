/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.grade.web;

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
import com.thinkgem.jeesite.modules.grade.entity.TxGrade;
import com.thinkgem.jeesite.modules.grade.service.TxGradeService;

/**
 * 年级管理Controller
 * @author ThinkGem
 * @version 2017-07-04
 */
@Controller
@RequestMapping(value = "${adminPath}/grade/txGrade")
public class TxGradeController extends BaseController {

	@Autowired
	private TxGradeService txGradeService;
	
	@ModelAttribute
	public TxGrade get(@RequestParam(required=false) String id) {
		TxGrade entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = txGradeService.get(id);
		}
		if (entity == null){
			entity = new TxGrade();
		}
		return entity;
	}
	
	@RequiresPermissions("grade:txGrade:view")
	@RequestMapping(value = {"list", ""})
	public String list(TxGrade txGrade, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TxGrade> page = txGradeService.findPage(new Page<TxGrade>(request, response), txGrade); 
		model.addAttribute("page", page);
		return "modules/grade/txGradeList";
	}

	@RequiresPermissions("grade:txGrade:view")
	@RequestMapping(value = "form")
	public String form(TxGrade txGrade, Model model) {
		model.addAttribute("txGrade", txGrade);
		return "modules/grade/txGradeForm";
	}

	@RequiresPermissions("grade:txGrade:edit")
	@RequestMapping(value = "save")
	public String save(TxGrade txGrade, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, txGrade)){
			return form(txGrade, model);
		}
		txGradeService.save(txGrade);
		addMessage(redirectAttributes, "保存年级成功");
		return "redirect:"+Global.getAdminPath()+"/grade/txGrade/?repage";
	}
	
	@RequiresPermissions("grade:txGrade:edit")
	@RequestMapping(value = "delete")
	public String delete(TxGrade txGrade, RedirectAttributes redirectAttributes) {
		txGradeService.delete(txGrade);
		addMessage(redirectAttributes, "删除年级成功");
		return "redirect:"+Global.getAdminPath()+"/grade/txGrade/?repage";
	}

}