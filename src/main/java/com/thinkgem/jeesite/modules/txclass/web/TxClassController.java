/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.txclass.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.grade.entity.TxGrade;
import com.thinkgem.jeesite.modules.grade.service.TxGradeService;
import com.thinkgem.jeesite.modules.teacher.entity.TxTeacher;
import com.thinkgem.jeesite.modules.teacher.service.TxTeacherService;
import com.thinkgem.jeesite.modules.txclass.entity.TxClass;
import com.thinkgem.jeesite.modules.txclass.service.TxClassService;

/**
 * 班级管理Controller
 * @author ThinkGem
 * @version 2017-07-18
 */
@Controller
@RequestMapping(value = "${adminPath}/txclass/txClass")
public class TxClassController extends BaseController {

	@Autowired
	private TxClassService txClassService;
	@Autowired
	private TxGradeService txGradeService;
	@Autowired
	private TxTeacherService txTeacherService;
	
	@ModelAttribute
	public TxClass get(@RequestParam(required=false) String id) {
		TxClass entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = txClassService.get(id);
		}
		if (entity == null){
			entity = new TxClass();
		}
		return entity;
	}
	
	@RequiresPermissions("txclass:txClass:view")
	@RequestMapping(value = {"list", ""})
	public String list(TxClass txClass, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TxClass> page = txClassService.findPage(new Page<TxClass>(request, response), txClass); 
		model.addAttribute("page", page);
		model.addAttribute("txgrade",txGradeService.findList(new TxGrade()));
		model.addAttribute("txteacher", txTeacherService.findList(new TxTeacher()));
		return "modules/txclass/txClassList";
	}

	@RequiresPermissions("txclass:txClass:view")
	@RequestMapping(value = "form")
	public String form(TxClass txClass, Model model) {
		model.addAttribute("txClass", txClass);
		model.addAttribute("txgrade",txGradeService.findList(new TxGrade()));
		model.addAttribute("txteacher", txTeacherService.findList(new TxTeacher()));
		return "modules/txclass/txClassForm";
	}

	@RequiresPermissions("txclass:txClass:edit")
	@RequestMapping(value = "save")
	public String save(TxClass txClass, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, txClass)){
			return form(txClass, model);
		}
		txClassService.save(txClass);
		addMessage(redirectAttributes, "保存班级成功");
		return "redirect:"+Global.getAdminPath()+"/txclass/txClass/?repage";
	}
	
	@RequiresPermissions("txclass:txClass:edit")
	@RequestMapping(value = "delete")
	public String delete(TxClass txClass, RedirectAttributes redirectAttributes) {
		txClassService.delete(txClass);
		addMessage(redirectAttributes, "删除班级成功");
		return "redirect:"+Global.getAdminPath()+"/txclass/txClass/?repage";
	}

	@RequestMapping(value = "getCname")
	@ResponseBody
	public String getClassByGno(TxClass txClass, Model model){
		List<TxClass> txclassList = txClassService.getClassByGno(txClass);  
		String json = JsonMapper.getInstance().toJson(txclassList);
		System.out.println(json);
		return json;
	}
}