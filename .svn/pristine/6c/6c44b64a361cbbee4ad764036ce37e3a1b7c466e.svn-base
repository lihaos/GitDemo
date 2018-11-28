package cn.ch.netem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.ch.netem.pojo.TestPaper;
import cn.ch.netem.pojo.TestPaperExample;

public interface TestPaperMapper {
    long countByExample(TestPaperExample example);

    int deleteByExample(TestPaperExample example);

    int deleteByPrimaryKey(Integer testPaperId);

    int insert(TestPaper record);

    int insertSelective(TestPaper record);

    List<TestPaper> selectByExample(TestPaperExample example);

    TestPaper selectByPrimaryKey(Integer testPaperId);

    int updateByExampleSelective(@Param("record") TestPaper record, @Param("example") TestPaperExample example);

    int updateByExample(@Param("record") TestPaper record, @Param("example") TestPaperExample example);

    int updateByPrimaryKeySelective(TestPaper record);

    int updateByPrimaryKey(TestPaper record);
    
    /***
     * <h1 style="color:red">获取试卷列表</h1>
     * @param testPaperTtile
     * @param pageNo
     * @return
     */
    List<TestPaper> getTestPaperList(@Param("testPaperTitle")String testPaperTtile,@Param("pageNo")int pageNo);
    
    /***
     * <h1 style="color:red">获取试卷数</h1>
     * @param testPaperTtile
     * @return
     */
    int getTestPaperCount(@Param("testPaperTitle")String testPaperTtile);
}