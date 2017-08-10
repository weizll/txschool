/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sutscore.web;

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
import com.thinkgem.jeesite.modules.student.entity.TxStudent;
import com.thinkgem.jeesite.modules.student.service.TxStudentService;
import com.thinkgem.jeesite.modules.subject.entity.TxSubject;
import com.thinkgem.jeesite.modules.subject.service.TxSubjectService;
import com.thinkgem.jeesite.modules.sutscore.entity.TxStuscore;
import com.thinkgem.jeesite.modules.sutscore.service.TxStuscoreService;

/**
 * 学生成绩管理Controller
 * @author thinkgem
 * @version 2017-07-21
 */
@Controller
@RequestMapping(value = "${adminPath}/sutscore/txStuscore")
public class TxStuscoreController extends BaseController {

	@Autowired
	private TxStuscoreService txStuscoreService;
	@Autowired
	private TxStudentService txStudentService;
	@Autowired
	private TxSubjectService txSubjectService;
	
	@ModelAttribute
	public TxStuscore get(@RequestParam(required=false) String id) {
		TxStuscore entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = txStuscoreService.get(id);
		}
		if (entity == null){
			entity = new TxStuscore();
		}
		return entity;
	}
	
	@RequiresPermissions("sutscore:txStuscore:view")
	@RequestMapping(value = {"list", ""})
	public String list(TxStuscore txStuscore, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TxStuscore> page = txStuscoreService.findPage(new Page<TxStuscore>(request, response), txStuscore); 
		model.addAttribute("page", page);
		model.addAttribute("txStudent", txStudentService.findList(new TxStudent()));
		model.addAttribute("txSubject", txSubjectService.findList(new TxSubject()));
		return "modules/sutscore/txStuscoreList";
	}

	@RequiresPermissions("sutscore:txStuscore:view")
	@RequestMapping(value = "form")
	public String form(TxStuscore txStuscore, Model model) {
		model.addAttribute("txStuscore", txStuscore);
		model.addAttribute("txStudent", txStudentService.findList(new TxStudent()));
		model.addAttribute("txSubject", txSubjectService.findList(new TxSubject()));
		return "modules/sutscore/txStuscoreForm";
	}

	@RequiresPermissions("sutscore:txStuscore:edit")
	@RequestMapping(value = "save")
	public String save(TxStuscore txStuscore, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, txStuscore)){
			return form(txStuscore, model);
		}
		txStuscoreService.save(txStuscore);
		addMessage(redirectAttributes, "保存学生成绩成功");
		return "redirect:"+Global.getAdminPath()+"/sutscore/txStuscore/?repage";
	}
	
	@RequiresPermissions("sutscore:txStuscore:edit")
	@RequestMapping(value = "delete")
	public String delete(TxStuscore txStuscore, RedirectAttributes redirectAttributes) {
		txStuscoreService.delete(txStuscore);
		addMessage(redirectAttributes, "删除学生成绩成功");
		return "redirect:"+Global.getAdminPath()+"/sutscore/txStuscore/?repage";
	}

}