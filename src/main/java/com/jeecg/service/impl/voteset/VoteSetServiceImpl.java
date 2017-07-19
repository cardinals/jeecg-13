package com.jeecg.service.impl.voteset;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeecg.service.voteset.VoteSetServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;

@Service("voteSetService")
@Transactional
public class VoteSetServiceImpl extends CommonServiceImpl implements VoteSetServiceI {
	
}