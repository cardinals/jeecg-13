package com.jeecg.service.impl.votelog;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.service.votelog.VotelogServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("votelogService")
@Transactional
public class VotelogServiceImpl extends CommonServiceImpl implements VotelogServiceI {
	
}