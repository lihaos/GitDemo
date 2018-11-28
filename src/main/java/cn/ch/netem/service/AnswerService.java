package cn.ch.netem.service;

import java.util.List;


import cn.ch.netem.pojo.Answer;

public interface AnswerService {
	List<Answer> selectByQuestion(int questionId);
	int deleteAnswer(int questionId);
	int updateAnswer(Answer answer);
	int insertAnswer(Answer answer);
}
