package cn.ch.netem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.ch.netem.mapper.NoteMapper;
import cn.ch.netem.pojo.Note;
import cn.ch.netem.pojo.NoteExample;
import cn.ch.netem.pojo.Page;
import cn.ch.netem.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService  {

    @Autowired
    private NoteMapper noteMapper;

	@Override
	public List<Note> selectNote(NoteExample example) {
		
		return noteMapper.selectNote(example);
	}

	@Override
	public int Noteinsert(Note note) {
		// TODO Auto-generated method stub
		return noteMapper.insert(note);
	}

	@Override
	public Note select(int id) {
		// TODO Auto-generated method stub
		return noteMapper.select(id);
	}

	@Override
	public List<Note> selectNewest() {
		// TODO Auto-generated method stub
		return noteMapper.selectNewest();
	}

	@Override
	public List<Note> queryAll(int yeMa,int pageSize,String title) {
		yeMa=(yeMa-1)*pageSize;
		return noteMapper.queryAll(yeMa,pageSize,title);
	}

	@Override
	public int count(String title) {
		// TODO Auto-generated method stub
		return noteMapper.count(title);
	}

	@Override
	public int noteUpdate(Note note) {
		note.setToexamine(1);
		return noteMapper.noteUpdate(note);
	}

	@Override
	public int noteDelete(int id) {
		// TODO Auto-generated method stub
		return noteMapper.noteDelete(id);
	}

	@Override
	public List<Note> queryAllAjax(Page page, String title) {
		int NoteCount = noteMapper.countAjax(title);
		page.setItemCount(NoteCount);
		return noteMapper.queryAllAjax(page, title);
	}

	@Override
	public int mycount(int id) {
		// TODO Auto-generated method stub
		return noteMapper.mycount(id);
	}

	@Override
	public List<Note> selectMypost(int id, int yeMa, int pageSize) {
		yeMa=(yeMa-1)*pageSize;
		// TODO Auto-generated method stub
		return noteMapper.selectMypost(id, yeMa, pageSize);
	}

	

	

	



	
    
	
}
