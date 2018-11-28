package cn.ch.netem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.ch.netem.pojo.UserTestPaperQuestion;
import cn.ch.netem.pojo.UserTestPaperQuestionExample;

public interface UserTestPaperQuestionMapper {
    long countByExample(UserTestPaperQuestionExample example);

    int deleteByExample(UserTestPaperQuestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserTestPaperQuestion record);

    int insertSelective(UserTestPaperQuestion record);

    List<UserTestPaperQuestion> selectByExample(UserTestPaperQuestionExample example);

    UserTestPaperQuestion selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserTestPaperQuestion record, @Param("example") UserTestPaperQuestionExample example);

    int updateByExample(@Param("record") UserTestPaperQuestion record, @Param("example") UserTestPaperQuestionExample example);

    int updateByPrimaryKeySelective(UserTestPaperQuestion record);

    int updateByPrimaryKey(UserTestPaperQuestion record);
    
    List<UserTestPaperQuestion> getQuestionByTestId(@Param("userTestPaperId") Integer userTestPaperId);
}