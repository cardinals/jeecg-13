package com.jeecg.controller.userbalance;
import java.net.URI;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.jeecg.entity.userbalance.UserbalanceEntity;
import com.jeecg.service.userbalance.UserbalanceServiceI;

/**   
 * @Title: Controller
 * @Description: 用户余额
 * @author zhangdaihao
 * @date 2017-08-20 18:21:06
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/userbalanceController")
public class UserbalanceController extends BaseController {
	@Autowired
	private UserbalanceServiceI userbalanceService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	@Autowired
	protected JdbcDao jdbcdao;
	


	/**
	 * 用户余额列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		String sqls = "insert into t_user_balance(id,userid,username,balance) select id,username,realname,0 from t_s_base_user where username not in (select userid from t_user_balance)";
		jdbcdao.executeForObject(sqls,null);
		return new ModelAndView("com/jeecg/pay/userbalance/userbalanceList");
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
	public void datagrid(UserbalanceEntity userbalance,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(UserbalanceEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, userbalance, request.getParameterMap());
		this.userbalanceService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除用户余额
	 * 
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(UserbalanceEntity userbalance, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		userbalance = systemService.getEntity(UserbalanceEntity.class, userbalance.getId());
		message = "用户余额删除成功";
		userbalanceService.delete(userbalance);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加用户余额
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(UserbalanceEntity userbalance, HttpServletRequest request) {
		String message = null;
		AjaxJson j = new AjaxJson();
		if (StringUtil.isNotEmpty(userbalance.getId())) {
			message = "用户充值成功";
			try {
			    float money =Float.parseFloat((String)(request.getParameter("money")==null?"0":request.getParameter("money")));
				String sqlf = "update t_user_balance set balance="+money+"+balance where id='"+userbalance.getId()+"'";
				jdbcdao.executeForObject(sqlf,null);
				TSUser user = ResourceUtil.getSessionUserName();
		 		String account = user.getUserName();
				String sqls = "insert into t_user_balance_log(id,userid,paymoney,paytime,payway,operator)values(UUID(),'"+userbalance.getUserid()+"',"+money+",current_timestamp(),'0','"+account+"')";
				jdbcdao.executeForObject(sqls,null);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch (Exception e) {
				e.printStackTrace();
				message = "用户充值失败";
			}
		} else {
			message = "该用户不存在，请确认！";
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 用户余额列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "addorupdate")
	public ModelAndView addorupdate(UserbalanceEntity userbalance, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(userbalance.getId())) {
			userbalance = userbalanceService.getEntity(UserbalanceEntity.class, userbalance.getId());
			req.setAttribute("userbalancePage", userbalance);
		}
		return new ModelAndView("com/jeecg/pay/userbalance/userbalance");
	}
	/**
	 * 用户余额列表页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "pay")
	public ModelAndView pay(UserbalanceEntity userbalance, HttpServletRequest req) {
		userbalance = userbalanceService.getEntity(UserbalanceEntity.class, userbalance.getId());
		req.setAttribute("userbalancePage", userbalance);
		return new ModelAndView("com/jeecg/pay/userbalance/userbalance");
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<UserbalanceEntity> list() {
		List<UserbalanceEntity> listUserbalances=userbalanceService.getList(UserbalanceEntity.class);
		return listUserbalances;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		UserbalanceEntity task = userbalanceService.get(UserbalanceEntity.class, id);
		if (task == null) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(task, HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody UserbalanceEntity userbalance, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<UserbalanceEntity>> failures = validator.validate(userbalance);
		if (!failures.isEmpty()) {
			return new ResponseEntity<Object>(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		userbalanceService.save(userbalance);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = userbalance.getId();
		URI uri = uriBuilder.path("/rest/userbalanceController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity<Object>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody UserbalanceEntity userbalance) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<UserbalanceEntity>> failures = validator.validate(userbalance);
		if (!failures.isEmpty()) {
			return new ResponseEntity<Object>(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		userbalanceService.saveOrUpdate(userbalance);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		userbalanceService.deleteEntityById(UserbalanceEntity.class, id);
	}
}
