package cn.ch.netem.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.ch.netem.mapper.QuestionMapper;
import cn.ch.netem.pojo.Page;
import cn.ch.netem.pojo.Question;
import cn.ch.netem.pojo.TestPaper;
import cn.ch.netem.service.QuestionService;
@Transactional
@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionMapper questionMapper;
	
	@Override
	public List<Question> getQuestionByTestId(TestPaper testPaper) {
		// TODO Auto-generated method stub
		return questionMapper.getQuestionByTestId(testPaper);
	}

	@Override
	public List<Question> getQuestionByRand(int subjectId, int level, int questionQuantity) {
		// TODO Auto-generated method stub
		return questionMapper.getQuestionByRand(subjectId, level, questionQuantity);
	}

	@Override
	public List<Question> getQuestionList(String title, Page page) {
		// TODO Auto-genrated method stub
		Integer questionCount = questionMapper.getQuestionCount(title);
		page.setPageSize(5);
		page.setItemCount(questionCount);
		return questionMapper.getQuestionList(title, page);
	}

	@Override
	public int getQuestionCount(String title) {
		// TODO Auto-generated method stub
		return questionMapper.getQuestionCount(title);
	}

	@Override
	public int deleteQuestion(int questionId) {
		// TODO Auto-generated method stub
		return questionMapper.deleteQuestion(questionId);
	}

	@Override
	public Question selectByQuestionId(Integer questionId) {
		// TODO Auto-generated method stub
		return questionMapper.selectByPrimaryKey(questionId);
	}

	@Override
	public int updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionMapper.updateQuestion(question);
	}

	@Override
	public int insertQuestion(Question question) {
		// TODO Auto-generated method stub
		return questionMapper.insert(question);
	}

}
