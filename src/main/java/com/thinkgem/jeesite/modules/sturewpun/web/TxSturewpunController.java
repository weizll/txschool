/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sturewpun.web;

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
import com.thinkgem.jeesite.modules.student.entity.TxStudent;
import com.thinkgem.jeesite.modules.student.service.TxStudentService;
import com.thinkgem.jeesite.modules.sturewpun.entity.TxSturewpun;
import com.thinkgem.jeesite.modules.sturewpun.service.TxSturewpunService;

/**
 * 学生奖惩管理Controller
 * @author thinkgem
 * @version 2017-07-21
 */
@Controller
@RequestMapping(value = "${adminPath}/sturewpun/txSturewpun")
public class TxSturewpunController extends BaseController {

	@Autowired
	private TxSturewpunService txSturewpunService;
	@Autowired
	private TxStudentService txStudentService;
	
	@ModelAttribute
	public TxSturewpun get(@RequestParam(required=false) String id) {
		TxSturewpun entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = txSturewpunService.get(id);
		}
		if (entity == null){
			entity = new TxSturewpun();
		}
		return entity;
	}
	
	@RequiresPermissions("sturewpun:txSturewpun:view")
	@RequestMapping(value = {"list", ""})
	public String list(TxSturewpun txSturewpun, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TxSturewpun> page = txSturewpunService.findPage(new Page<TxSturewpun>(request, response), txSturewpun); 
		model.addAttribute("page", page);
		model.addAttribute("txStudent", txStudentService.findList(new TxStudent()));
		return "modules/sturewpun/txSturewpunList";
	}

	@RequiresPermissions("sturewpun:txSturewpun:view")
	@RequestMapping(value = "form")
	public String form(TxSturewpun txSturewpun, Model model) {
		model.addAttribute("txSturewpun", txSturewpun);
		model.addAttribute("txStudent", txStudentService.findList(new TxStudent()));
		return "modules/sturewpun/txSturewpunForm";
	}

	@RequiresPermissions("sturewpun:txSturewpun:edit")
	@RequestMapping(value = "save")
	public String save(TxSturewpun txSturewpun, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, txSturewpun)){
			return form(txSturewpun, model);
		}
		txSturewpunService.save(txSturewpun);
		addMessage(redirectAttributes, "保存学生奖惩成功");
		return "redirect:"+Global.getAdminPath()+"/sturewpun/txSturewpun/?repage";
	}
	
	@RequiresPermissions("sturewpun:txSturewpun:edit")
	@RequestMapping(value = "delete")
	public String delete(TxSturewpun txSturewpun, RedirectAttributes redirectAttributes) {
		txSturewpunService.delete(txSturewpun);
		addMessage(redirectAttributes, "删除学生奖惩成功");
		return "redirect:"+Global.getAdminPath()+"/sturewpun/txSturewpun/?repage";
	}

}