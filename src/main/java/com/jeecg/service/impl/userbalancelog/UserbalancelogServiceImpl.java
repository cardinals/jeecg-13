package com.jeecg.service.impl.userbalancelog;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.service.userbalancelog.UserbalancelogServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("userbalancelogService")
@Transactional
public class UserbalancelogServiceImpl extends CommonServiceImpl implements UserbalancelogServiceI {
	
}