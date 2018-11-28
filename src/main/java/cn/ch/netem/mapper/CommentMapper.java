package cn.ch.netem.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.ch.netem.pojo.Comment;
import cn.ch.netem.pojo.CommentExample;

public interface CommentMapper {
    long countByExample(CommentExample example);

    int deleteByExample(CommentExample example);

    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Integer commentId);

    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
    
    
    List<Comment> selectComment(int note_id);
    
    List<Comment>select(@Param("id")int id,@Param("yeMa")int yeMa,@Param("pageSize")int pageSize);
    
    int CommentDelete(int id);
    
    int count(int id); //查询出该文章下评论的总数
    
    int Notecount(int id);//查询审核过的帖子总和
    
    List<Comment>myselect(int id,int yeMa,int pageSize);
}