package cn.ch.netem.service;

import java.util.List;

import cn.ch.netem.pojo.Comment;

public interface CommentService {
         
	List<Comment>selectComment(int note_id);
	
	int insert(Comment record);
	
	List<Comment>select(int id,int yeMa,int pageSize);
	
	int delete(int id);
	
	int count(int id); //查询我的评论数
	
	int Notecount(int id);//查询审核过的帖子总和
	
	int deletePostComment(int noteId);
	
	List<Comment>myselect(int id,int yeMa,int pageSize);
}
