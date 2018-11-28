package cn.ch.netem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.ch.netem.pojo.Note;
import cn.ch.netem.pojo.NoteExample;
import cn.ch.netem.pojo.Page;

public interface NoteService {
	List<Note> selectNote(NoteExample example); //查询精华帖子
	
	int Noteinsert(Note note);  //增加
	
	Note select(int id);  //查询用户评论的帖子
	
	List<Note> selectNewest();
	
	  List<Note>selectMypost(@Param("id")int id,@Param("yeMa")int yeMa,@Param("pageSize")int pageSize);  //查看我的帖子
	
	List<Note>queryAll(int yeMa,int pageSize,String title); //查看所有帖子
	
	int count(String title); //查询总条数
	
	int noteUpdate(Note note);
	
	int noteDelete(int id);
	
	List<Note> queryAllAjax(@Param("page")Page page,@Param("title")String title);
	
	  int mycount(int id);//我的帖子总和
}
