/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.student.web;

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
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.grade.entity.TxGrade;
import com.thinkgem.jeesite.modules.grade.service.TxGradeService;
import com.thinkgem.jeesite.modules.student.entity.TxStudent;
import com.thinkgem.jeesite.modules.student.service.TxStudentService;

/**
 * 学生管理Controller
 * @author thinkgem
 * @version 2017-07-19
 */
@Controller
@RequestMapping(value = "${adminPath}/student/txStudent")
public class TxStudentController extends BaseController {

	@Autowired
	private TxStudentService txStudentService;
	@Autowired
	private TxGradeService txGradeService;
	
	@ModelAttribute
	public TxStudent get(@RequestParam(required=false) String id) {
		TxStudent entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = txStudentService.get(id);
		}
		if (entity == null){
			entity = new TxStudent();
		}
		return entity;
	}
	
	@RequiresPermissions("student:txStudent:view")
	@RequestMapping(value = {"list", ""})
	public String list(TxStudent txStudent, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TxStudent> page = txStudentService.findPage(new Page<TxStudent>(request, response), txStudent); 
		model.addAttribute("page", page);
		model.addAttribute("txgrade",txGradeService.findList(new TxGrade()));
		return "modules/student/txStudentList";
	}

	@RequiresPermissions("student:txStudent:view")
	@RequestMapping(value = "form")
	public String form(TxStudent txStudent, Model model) {
		model.addAttribute("txStudent", txStudent);
		model.addAttribute("txgrade",txGradeService.findList(new TxGrade()));
		return "modules/student/txStudentForm";
	}

	@RequiresPermissions("student:txStudent:edit")
	@RequestMapping(value = "save")
	public String save(TxStudent txStudent, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, txStudent)){
			return form(txStudent, model);
		}
		txStudentService.save(txStudent);
		addMessage(redirectAttributes, "保存学生成功");
		return "redirect:"+Global.getAdminPath()+"/student/txStudent/?repage";
	}
	
	@RequiresPermissions("student:txStudent:edit")
	@RequestMapping(value = "delete")
	public String delete(TxStudent txStudent, RedirectAttributes redirectAttributes) {
		txStudentService.delete(txStudent);
		addMessage(redirectAttributes, "删除学生成功");
		return "redirect:"+Global.getAdminPath()+"/student/txStudent/?repage";
	}

}