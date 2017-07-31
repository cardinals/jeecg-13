package com.jeecg.service.votetask;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.common.service.CommonService;

public  interface VoteTaskServiceI extends CommonService {

	public String getJSON(String url) throws Exception;
	public List<Map<String, Object>>  getAddress() throws Exception;
	public boolean recordLog(String voteaddress,String votecount,String taskid,String startNum,String endNum,String jsonstr,String logtype,String code)  throws Exception;
}
