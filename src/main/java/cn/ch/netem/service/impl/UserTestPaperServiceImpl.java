package cn.ch.netem.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ch.netem.mapper.UserTestPaperMapper;
import cn.ch.netem.pojo.UserTestPaper;
import cn.ch.netem.service.UserTestPaperService;
@Transactional
@Service
public class UserTestPaperServiceImpl implements UserTestPaperService {

	@Autowired
	private UserTestPaperMapper userTestPaperMapper;

	@Override
	public boolean addUserTestPaper(UserTestPaper paper) {
		// TODO Auto-generated method stub
		boolean flag = true;
		if (userTestPaperMapper.insert(paper)==0) {
			flag = false;
		}
		return flag;
	}

	@Override
	public UserTestPaper selectByUserTestPaperId(int userTestPaperId) {
		// TODO Auto-generated method stub
		return userTestPaperMapper.selectByUserTestPaperId(userTestPaperId);
	}

	@Override
	public List<UserTestPaper> selectByUserId(String testPaperTtile,int pageNo,int userId) {
		pageNo=(pageNo-1)*3;
		return userTestPaperMapper.selectByUserId(testPaperTtile,pageNo,userId);
	}

	@Override
	public int getUserTestPaperCount(String testPaperTtile, int userId) {
		// TODO Auto-generated method stub
		return userTestPaperMapper.getTestPaperCount(testPaperTtile, userId);
	}
	
}
