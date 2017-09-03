package com.jeecg.service.impl.userbalance;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.service.userbalance.UserbalanceServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("userbalanceService")
@Transactional
public class UserbalanceServiceImpl extends CommonServiceImpl implements UserbalanceServiceI {
	
}