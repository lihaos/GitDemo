package cn.ch.netem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.ch.netem.pojo.Answer;
import cn.ch.netem.pojo.AnswerExample;



public interface AnswerMapper {
    long countByExample(AnswerExample example);

    int deleteByExample(AnswerExample example);

    int deleteByPrimaryKey(Integer answerId);

    /***
     * 添加答案
     * @param answer
     * @return
     */
    int insert(Answer record);

    int insertSelective(Answer record);

    List<Answer> selectByExample(AnswerExample example);

    Answer selectByPrimaryKey(Integer answerId);

    int updateByExampleSelective(@Param("record") Answer record, @Param("example") AnswerExample example);

    int updateByExample(@Param("record") Answer record, @Param("example") AnswerExample example);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);
    
    /***
     * 通过题目id查询答案
     * @param questionId
     * @return
     */
    List<Answer> selectByQuestion(@Param("questionId")int questionId);
    
    /***
     * 删除答案
     * @return
     */
    int deleteAnswer(@Param("questionId")int questionId);
    
    /***
     * 修改答案
     * @param answer
     * @return
     */
    int updateAnswer(Answer answer);
    
}