package com.jeecg.service.impl.votetask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import org.jeecgframework.core.common.dao.jdbc.JdbcDao;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jeecg.service.votetask.VoteTaskServiceI;

@Service("voteTaskService")
@Transactional
public   class VoteTaskServiceImpl extends CommonServiceImpl implements VoteTaskServiceI {
	@Autowired
	protected JdbcTemplate  jdbcTemplate;
	@Autowired
	protected JdbcDao jdbcdao;

	public String getJSON (String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL voteUrl = new URL(url);
            URLConnection ulc = voteUrl.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(ulc.getInputStream(),"UTF-8"));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
        	
        } catch (IOException e) {
        	
        }
        return json.toString();
    }
	
	public List getAddress(){
		String sqls = "select * from t_vote_set where enable='Y'";
		List<Map<String, Object>> addresslist = this.jdbcTemplate.queryForList(sqls);
		return addresslist;
	}
	
	public boolean recordLog(String voteaddress,String votecount,String taskid,String startNum,String endNum,String jsonstr,String logtype,String code){
		boolean flag = false;
		TSUser user = ResourceUtil.getSessionUserName();
 		String account = user.getUserName();
		String sqls = "insert into t_vote_log(id,account,voteaddress,votecount,taskid,startNum,endNum,votetime,jsonstr,logtype,code)"
				+"values(UUID(),'"+account+"','"+voteaddress+"','"+votecount+"','"+taskid+"','"+startNum+"','"+endNum+"',current_timestamp(),'"+jsonstr+"','"+logtype+"','"+code+"')";
		int i = jdbcdao.executeForObject(sqls,null);
		if(i>0){
			flag = true;
		}
		return flag;
	}
}
