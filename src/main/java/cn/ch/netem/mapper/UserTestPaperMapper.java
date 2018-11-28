package cn.ch.netem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.ch.netem.pojo.UserTestPaper;
import cn.ch.netem.pojo.UserTestPaperExample;

public interface UserTestPaperMapper {
    long countByExample(UserTestPaperExample example);

    int deleteByExample(UserTestPaperExample example);

    int deleteByPrimaryKey(Integer userTestPaperId);

    int insert(UserTestPaper record);

    int insertSelective(UserTestPaper record);

    List<UserTestPaper> selectByExample(UserTestPaperExample example);

    UserTestPaper selectByPrimaryKey(Integer userTestPaperId);

    int updateByExampleSelective(@Param("record") UserTestPaper record, @Param("example") UserTestPaperExample example);

    int updateByExample(@Param("record") UserTestPaper record, @Param("example") UserTestPaperExample example);

    int updateByPrimaryKeySelective(UserTestPaper record);

    int updateByPrimaryKey(UserTestPaper record);
    
    /***
     *根据id获取用户试卷
     * @param userTestPaperId
     * @return
     */
    UserTestPaper selectByUserTestPaperId(int userTestPaperId);
    
    
    /***
     *根据用户id获取用户试卷列表
     * @param userTestPaperId
     * @return
     */
    List<UserTestPaper> selectByUserId(@Param("testPaperTitle")String testPaperTtile,@Param("pageNo")int pageNo, @Param("userId")int userId);
    
    /***
     *根据用户id获取用户试卷数
     * @param userTestPaperId
     * @return
     */
    int getTestPaperCount(@Param("testPaperTitle")String testPaperTtile, @Param("userId")int userId);
}