package cn.ch.netem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ch.netem.mapper.UserTestPaperQuestionMapper;
import cn.ch.netem.pojo.UserTestPaperQuestion;
import cn.ch.netem.service.UserTestPaperQuestionService;
@Transactional
@Service
public class UserTestPaperQuestionServiceImpl implements UserTestPaperQuestionService {

	@Autowired
	private UserTestPaperQuestionMapper userTestPaperQuestionMapper;

	@Override
	public boolean addUserTestPaperQuestion(UserTestPaperQuestion userTestPaperQuestion) {
		// TODO Auto-generated method stub
		boolean flag = true;
		if (userTestPaperQuestionMapper.insert(userTestPaperQuestion)==0) {
			flag = false;
		}
		return flag;
	}

	@Override
	public List<UserTestPaperQuestion> getUserTestPaperQuestionList(Integer userTestPaperId) {
		// TODO Auto-generated method stub
		return userTestPaperQuestionMapper.getQuestionByTestId(userTestPaperId);
	}
	
}
