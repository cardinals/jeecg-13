package com.jeecg.controller.votetask;

import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.json.JSONObject;
import org.jsoup.Connection.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;
import com.jeecg.service.votetask.VoteTaskServiceI;


/**   
 * @Title: Controller
 * @Description: 投票任务
 * @author cfma
 * @date 2017-07-19 16:18:44
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/voteTaskController")
public class VoteTaskController extends BaseController{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(VoteTaskController.class);

	@Autowired
	private VoteTaskServiceI voteTaskService;
	@Autowired
	private SystemService systemService;

	/**
	 * 投票页面 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "task")
	public ModelAndView task(HttpServletRequest request) {
		return new ModelAndView("com/jeecg/vote/votetask/voteform");
	}

	/**
	 * 开始投票
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "next")
	public ModelAndView nextCheck(HttpServletRequest request) {
		String link = request.getParameter("address");
		boolean linkok = false;
		try {
            URL url=new URL(link);
            URLConnection conn=url.openConnection();
            String str=conn.getHeaderField(0);
            if (str.indexOf("OK")> 0){
                //网址正常
            	linkok = true;
            }else{
                //网址不正常
            	linkok= false;
            	request.setAttribute("address", link);
            }
        } catch (Exception ex) {
            //网址不正常
        	linkok=false;
        	request.setAttribute("address", link);
        }
		request.setAttribute("isNext", linkok);
		return new ModelAndView("com/jeecg/vote/votetask/voteform");
	}

	/**
	 * 开始投票
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "start")
	public ModelAndView startTask(final ModelMap model,HttpServletRequest request) {
		 ModelAndView modelAndView = new ModelAndView();
		 String address = request.getParameter("address");
		 String votecount =  request.getParameter("votecount");
		 modelAndView.setViewName("com/jeecg/vote/votetask/voteform");
         request.setAttribute("startTask", "true");
         request.setAttribute("address",address);
         request.setAttribute("votecount",votecount);
         String jsonstr = null;
         String voteaddress =null;
         String appkey =null;
         String code=null;
         String taskid=null;
         String startNum=null;
		 String endNum=null;
 		 try {
 			 if(voteTaskService.getAddress().size()>0){
 				 voteaddress= voteTaskService.getAddress().get(0).get("address").toString();
 				 appkey =  voteTaskService.getAddress().get(0).get("clientsign").toString(); 
 			 }
 			 
 			String voteurl =voteaddress+"?methods=freshPlaceOrder&appkey="+appkey+"&url="+ java.net.URLEncoder.encode(address,"utf-8")+"&taskNum="+votecount+"&readPerMin=0&remark=1&productType=48";
 		    jsonstr= voteTaskService.getJSON(voteurl);
 		   JSONObject jsStr = new JSONObject(jsonstr);
 		   code = jsStr.getString("code");
 		   if("0".equals(code)){
 			  JSONObject contentJson =   jsStr.getJSONObject("content");
 			  taskid =contentJson.getString("id");
 			  startNum = contentJson.getString("startNum");
 			  endNum = contentJson.getString("currentNum");
 		   }
 		   voteTaskService.recordLog(voteaddress, votecount, taskid, startNum, endNum, jsonstr,"Start",code);
 		 } catch (Exception e) {
 			// TODO Auto-generated catch block
 			 e.printStackTrace();
 		 }
 		request.setAttribute("taskid",taskid);
 		request.setAttribute("jsonstr",jsonstr);
 		request.setAttribute("code",code);
 		systemService.addLog(jsonstr, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
         return modelAndView;
	}


	/**
	 * 添加投票设置
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "end")
	@ResponseBody
	public String endTask(HttpServletRequest request) {
		String jsonstr = null;
        String voteaddress =null;
        String appkey =null;
        String taskId = request.getParameter("taskid");
		 try {
			 if(voteTaskService.getAddress().size()>0){
				 voteaddress= voteTaskService.getAddress().get(0).get("address").toString();
	 			 appkey =  voteTaskService.getAddress().get(0).get("clientsign").toString(); 
			 }
			String voteurl =voteaddress+"?methods=freshCancelOrder&appkey="+appkey+"&status=0&taskId="+taskId;
		    jsonstr= voteTaskService.getJSON(voteurl);
		 } catch (Exception e){
			// TODO Auto-generated catch block
			 e.printStackTrace();
		 }
		systemService.addLog(jsonstr, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		return jsonstr;
	}

	/**
	 * 查询投票
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "query")
	@ResponseBody
	public String queryTask(HttpServletRequest req) {
		 String jsonstr = null;
         String voteaddress =null;
         String appkey =null;
         String code=null;
         String taskId = req.getParameter("taskid");
         String startNum=null;
		 String endNum=null;
		 String status = null;
		 String taskNum=null;
 		 try {
 			 if(voteTaskService.getAddress().size()>0){
 				 voteaddress= voteTaskService.getAddress().get(0).get("address").toString();
 				 appkey =  voteTaskService.getAddress().get(0).get("clientsign").toString(); 
 			 }
 			String voteurl =voteaddress+"?methods=freshTaskInfo&appkey="+appkey+"&taskId="+taskId+"&productType=48";
 		    jsonstr= voteTaskService.getJSON(voteurl);
 		   JSONObject first = JSONObject.fromObject(jsonstr);
		   code = first.getString("code");
		   if("0".equals(code)){
			  JSONObject contentJson =   JSONObject.fromObject( first.getString("content"));;
			  startNum = contentJson.getString("startNum");
			  endNum = contentJson.getString("currentNum");
			  taskNum = contentJson.getString("taskNum");
		   }
		   voteTaskService.recordLog(voteaddress, taskNum, taskId, startNum, endNum, jsonstr,"Query",status);
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
		 }
		systemService.addLog(jsonstr, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		return jsonstr;
	}
	
	/**
	 * 查询投票
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "relog")
	public AjaxJson relog(HttpServletRequest req) {
		String message = null;
		AjaxJson j = new AjaxJson();
		message = "记录日志";
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		j.setMsg(message);
		return j;
	}

}
