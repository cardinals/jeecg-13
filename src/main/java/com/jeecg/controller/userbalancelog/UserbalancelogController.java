package com.jeecg.controller.userbalancelog;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.jeecg.entity.userbalancelog.UserbalancelogEntity;
import com.jeecg.service.userbalancelog.UserbalancelogServiceI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**   
 * @Title: Controller
 * @Description: 支付日志
 * @author zhangdaihao
 * @date 2017-08-25 11:08:32
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/userbalancelogController")
public class UserbalancelogController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UserbalancelogController.class);

	@Autowired
	private UserbalancelogServiceI userbalancelogService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	


	/**
	 * 支付日志列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/userbalancelog/userbalancelogList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(UserbalancelogEntity userbalancelog,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(UserbalancelogEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, userbalancelog, request.getParameterMap());
		this.userbalancelogService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除支付日志
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(UserbalancelogEntity userbalancelog, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		userbalancelog = systemService.getEntity(UserbalancelogEntity.class, userbalancelog.getId());
		message = "支付日志删除成功";
		userbalancelogService.delete(userbalancelog);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加支付日志
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(UserbalancelogEntity userbalancelog, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(userbalancelog.getId())) {
			message = "支付日志更新成功";
			UserbalancelogEntity t = userbalancelogService.get(UserbalancelogEntity.class, userbalancelog.getId());
			try {
				MyBeanUtils.copyBeanNotNull2Bean(userbalancelog, t);
				userbalancelogService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "支付日志更新失败";
			}
		} else {
			message = "支付日志添加成功";
			userbalancelogService.save(userbalancelog);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 支付日志列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(UserbalancelogEntity userbalancelog, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(userbalancelog.getId())) {
			userbalancelog = userbalancelogService.getEntity(UserbalancelogEntity.class, userbalancelog.getId());
			req.setAttribute("userbalancelogPage", userbalancelog);
		}
		return new ModelAndView("com/jeecg/userbalancelog/userbalancelog");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<UserbalancelogEntity> list() {
		List<UserbalancelogEntity> listUserbalancelogs=userbalancelogService.getList(UserbalancelogEntity.class);
		return listUserbalancelogs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		UserbalancelogEntity task = userbalancelogService.get(UserbalancelogEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody UserbalancelogEntity userbalancelog, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<UserbalancelogEntity>> failures = validator.validate(userbalancelog);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		userbalancelogService.save(userbalancelog);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = userbalancelog.getId();
		URI uri = uriBuilder.path("/rest/userbalancelogController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody UserbalancelogEntity userbalancelog) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<UserbalancelogEntity>> failures = validator.validate(userbalancelog);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		userbalancelogService.saveOrUpdate(userbalancelog);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		userbalancelogService.deleteEntityById(UserbalancelogEntity.class, id);
	}
}
