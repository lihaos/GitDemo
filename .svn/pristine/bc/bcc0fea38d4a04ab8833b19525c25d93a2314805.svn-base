package cn.ch.netem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.ch.netem.pojo.Comment;
import cn.ch.netem.pojo.Note;
import cn.ch.netem.pojo.NoteExample;
import cn.ch.netem.pojo.Page;


public interface NoteMapper {
    long countByExample(NoteExample example);

    int deleteByExample(NoteExample example);

    int deleteByPrimaryKey(Integer noteId);

    int insert(Note record);

    int insertSelective(Note record);

    List<Note> selectNote(NoteExample example);

    Note selectByPrimaryKey(Integer noteId);

    int updateByExampleSelective(@Param("record") Note record, @Param("example") NoteExample example);

    int updateByExample(@Param("record") Note record, @Param("example") NoteExample example);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKey(Note record);
    
    int Noteinsert(Note note);  //发表帖子
    
    Note select(int id); //查看用户评论的帖子 
    
    List<Note> selectNewest(); //查看最新的帖子 
    
    List<Note>selectMypost(@Param("id")int id,@Param("yeMa")int yeMa,@Param("pageSize")int pageSize);  //查看我的帖子
    
    int noteUpdate(@Param("note")Note note);  //修改我的帖子
    
    int noteDelete(int  id);  //删除我的帖子
    
    List<Note>queryAll(@Param("yeMa")int yeMa,@Param("pageSize")int pageSize,String title); //查看所有帖子
    
    int count(String title);//查询审核过的帖子总和
    
    
    
    int deletePostComment(int noteId);
    
    List<Note> queryAllAjax(@Param("page")Page page,@Param("title")String title);
    
    int countAjax(@Param("title")String title);//查询审核过的帖子总和
    
    int mycount(int id);//我的帖子总和
}