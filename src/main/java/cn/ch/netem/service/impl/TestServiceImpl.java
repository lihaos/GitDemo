package cn.ch.netem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ch.netem.mapper.TestPaperMapper;
import cn.ch.netem.pojo.TestPaper;
import cn.ch.netem.service.TestService;
@Transactional
@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private TestPaperMapper testPaperMapper;
	
	@Override
	public List<TestPaper> getTestPaperList(String testPaperTtile,int pageNo) {
		pageNo = (pageNo-1)*3;
		return testPaperMapper.getTestPaperList(testPaperTtile,pageNo);
	}

	@Override
	public int getTestPaperCount(String testPaperTtile) {
		// TODO Auto-generated method stub
		return testPaperMapper.getTestPaperCount(testPaperTtile);
	}

}
