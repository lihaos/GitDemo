package cn.ch.netem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.ch.netem.pojo.Page;
import cn.ch.netem.pojo.Question;
import cn.ch.netem.pojo.QuestionExample;
import cn.ch.netem.pojo.TestPaper;

public interface QuestionMapper {
    long countByExample(QuestionExample example);

    int deleteByExample(QuestionExample example);

    int deleteByPrimaryKey(Integer questionId);

    int insert(Question record);

    int insertSelective(Question record);

    List<Question> selectByExample(QuestionExample example);

    Question selectByPrimaryKey(Integer questionId);

    int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
    
    /***
     *  <h1 style='color:red;'>获取试卷题目</h1>
     * 
     * @param paper
     * @return
     */
    List<Question> getQuestionByTestId(TestPaper paper);
    
    /***
     *    随机生成试卷
     * @param subjectId
     * @param level
     * @param questionQuantity
     * @return
     */
    List<Question> getQuestionByRand(@Param("subjectId") int subjectId,@Param("level")int level,@Param("questionQuantity")int questionQuantity);
    
    /***
     *  <h1 style='color:red;'>获取试题列表</h1>
     * 
     * @param paper
     * @return
     */
    List<Question> getQuestionList(@Param("title")String title,@Param("page")Page page);
    
    /***
     *获取题目数
     * @param userTestPaperId
     * @return
     */
    int getQuestionCount(@Param("title")String title);
    
    /***
     * 删除题目
     * @param questionId
     * @return
     */
    int deleteQuestion(@Param("questionId")int questionId);
    
    /**
     * 修改题目
     * @param Question
     * @return
     */
    int updateQuestion(Question Question);
}