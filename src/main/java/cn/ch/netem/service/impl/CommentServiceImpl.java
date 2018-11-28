package cn.ch.netem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ch.netem.mapper.CommentMapper;
import cn.ch.netem.pojo.Comment;
import cn.ch.netem.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	 @Autowired
	 CommentMapper comment;
	 
	public List<Comment> selectComment(int note_id) {
		// TODO Auto-generated method stub
		return  comment.selectComment(note_id);
	}

	@Override
	public int insert(Comment record) {
		// TODO Auto-generated method stub
		return comment.insert(record);
	}

	
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return comment.CommentDelete(id);
	}

	@Override
	public List<Comment> select(int id, int yeMa, int pageSize) {
	    yeMa=(yeMa-1)*pageSize;
		return comment.select(id, yeMa, pageSize);
	}

	@Override
	public int count(int id) {
		// TODO Auto-generated method stub
		return comment.count(id);
	}

	@Override
	public int deletePostComment(int noteId) {
		// TODO Auto-generated method stub
		return comment.CommentDelete(noteId);
	}

	@Override
	public int Notecount(int id) {
		// TODO Auto-generated method stub
		return comment.Notecount(id);
	}

	@Override
	public List<Comment> myselect(int id, int yeMa, int pageSize) {
		yeMa=(yeMa-1)*pageSize;
		return comment.myselect(id, yeMa, pageSize);
	}

}
