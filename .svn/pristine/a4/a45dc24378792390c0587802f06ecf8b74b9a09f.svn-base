package cn.ch.netem.service;

import java.util.List;

import cn.ch.netem.pojo.Page;
import cn.ch.netem.pojo.Question;
import cn.ch.netem.pojo.TestPaper;

public interface QuestionService {
	/***
	 * 根据试卷id获取题目
	 * @param testPaper
	 * @return
	 */
	List<Question> getQuestionByTestId(TestPaper testPaper);
	/***
	 * 随机出卷
	 * @param subjectId
	 * @param level
	 * @param questionQuantity
	 * @return
	 */
	List<Question> getQuestionByRand(int subjectId,int level,int questionQuantity);
	/***
     *  <h1 style='color:red;'>获取试题列表</h1>
     * 
     * @param paper
     * @return
     */
    List<Question> getQuestionList(String title,Page page);
    
    /***
     *获取题目数
     * @param userTestPaperId
     * @return
     */
    int getQuestionCount(String title);
    
    /***
     * 删除题目
     * @param questionId
     * @return
     */
    int deleteQuestion(int questionId);
    
    /**
     * 根据id获取题目
     * @param questionId
     * @return
     */
    Question selectByQuestionId(Integer questionId);
    
    /**
     * 修改题目
     * @param Question
     * @return
     */
    int updateQuestion(Question question);
    
    /***
     * 添加题目
     * @param Question
     * @return
     */
    int insertQuestion(Question question);
}
