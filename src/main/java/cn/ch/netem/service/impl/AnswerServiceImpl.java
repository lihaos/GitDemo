package cn.ch.netem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ch.netem.mapper.AnswerMapper;
import cn.ch.netem.pojo.Answer;
import cn.ch.netem.service.AnswerService;
@Transactional
@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	private AnswerMapper answerMapper;
	
	@Override
	public List<Answer> selectByQuestion(int questionId) {
		// TODO Auto-generated method stub
		return answerMapper.selectByQuestion(questionId);
	}

	@Override
	public int deleteAnswer(int questionId) {
		// TODO Auto-generated method stub
		return answerMapper.deleteAnswer(questionId);
	}

	@Override
	public int updateAnswer(Answer answer) {
		// TODO Auto-generated method stub
		return answerMapper.updateAnswer(answer);
	}

	@Override
	public int insertAnswer(Answer answer) {
		// TODO Auto-generated method stub
		return answerMapper.insert(answer);
	}

}
