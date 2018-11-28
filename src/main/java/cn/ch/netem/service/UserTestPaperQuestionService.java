package cn.ch.netem.service;

import java.util.List;

import cn.ch.netem.pojo.UserTestPaperQuestion;

public interface UserTestPaperQuestionService {
	boolean addUserTestPaperQuestion(UserTestPaperQuestion userTestPaperQuestion);
	List<UserTestPaperQuestion> getUserTestPaperQuestionList(Integer userTestPaperId);
}
