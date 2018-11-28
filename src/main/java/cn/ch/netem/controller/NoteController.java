package cn.ch.netem.controller;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.ch.netem.pojo.Comment;
import cn.ch.netem.pojo.Note;
import cn.ch.netem.pojo.NoteExample;
import cn.ch.netem.pojo.Page;
import cn.ch.netem.pojo.User;
import cn.ch.netem.service.CommentService;
import cn.ch.netem.service.NoteService;



@Controller
public class NoteController {
	
	@Autowired
	private NoteService noteService;
   
	private int pageSize=11;
	
	
	@Autowired
	private CommentService commentService;
	
    @RequestMapping("/posta")
    public String test(Model model) {   //查看精华帖子和最新的帖子
    	NoteExample example = new NoteExample();
    	List<Note> list=  noteService.selectNote(example);
    	List<Note> list1= noteService.selectNewest();
    	model.addAttribute("list1", list1);
        model.addAttribute("list", list);
        return "/pre/index";
    }
    
    
    @RequestMapping("/queryAll")
    public String queryAll(@RequestParam(value="yeMa",defaultValue="1",required=false)int yeMa,@RequestParam(required=false)String title, Model model) {   //查看所有帖子
    	
    	int count = noteService.count(title);
    	
    	int total = count%7==0?count/7:count/7+1;
    	
    	List<Note> list=  noteService.queryAll(yeMa,7,title);
        model.addAttribute("total", total);
        model.addAttribute("list", list);
        model.addAttribute("ye", yeMa);
        return "/pre/note";
    }
    
    @RequestMapping("/queryAllAjax")
    @ResponseBody
    public Map queryAllAjax(@RequestParam(required=false,value="title")String title,@RequestParam(value="currentPage",required=false)Integer  currentPage, Model model) {   //查看所有帖子
    	
    	 Page page = new Page();
		 page.setCurrentPage(currentPage);
    	 page.setPageSize(5);
    	
    	
    	List<Note> list=  noteService.queryAllAjax(page,title);

    	Map map = new HashMap();
		map.put("list", list);
		map.put("page", page);
    	
      return map;
       
    }
    
    
    @RequestMapping("/query")  
    public String query(int noteId,Model model,@RequestParam(value="yeMa",defaultValue="1",required=false)int yeMa) { //查看帖子内容和评论
    	 
    	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	 if(yeMa==1) {
    		 Note note = noteService.select(noteId);
             String sDate=sdf.format(note.getCreatedate());
             model.addAttribute("date", sDate);
    		 model.addAttribute("note", note);
    	 }
    	 
    	 int  count = commentService.count(noteId);
    	 
    	 int total = count%pageSize==0?count/pageSize:count/pageSize+1;
    	 
    	 List<Comment> list = commentService.select(noteId,yeMa,pageSize);
    	for (Comment comment : list) {
    		comment.setCreatedate(new java.sql.Date(comment.getCreatedate().getTime()));
    		
		}
	 
        model.addAttribute("size", list.size());
    	model.addAttribute("list", list);
    	model.addAttribute("ye", yeMa);
    	model.addAttribute("nid", noteId);
    	model.addAttribute("total", total);
        return "/pre/noteXs";
    }
    
    @RequestMapping("/fatie")
    public String fatie() {  //跳转
    	
    	
    	return "/pre/faTie";
    }
    
    
    @RequestMapping("/NoteInsert")
    public String NoteInsert(Note note,HttpServletResponse response) {  //发表帖子
    	
    	User user=(User) SecurityUtils.getSubject().getPrincipal();
    	note.setUserId(user.getUserId());
    	note.setCreatedate(new Date());
    	note.setIsessence(0);
    	note.setToexamine(0);
    	
    	noteService.Noteinsert(note);

    	return "redirect:/queryAll";
    }
    
    
    @RequestMapping("/selectMypost")
    public String selectMypost(@RequestParam(defaultValue="2",value="noteId") int id,Model model,@RequestParam(value="yeMa",defaultValue="1",required=false)int yeMa) {  //查看我的帖子
        List<Note> list = noteService.selectMypost(id,yeMa,8);
        
        int count = noteService.mycount(id);          
        
        int total = count%8==0?count/8:count/8+1;
        
        model.addAttribute("total", total);
    	model.addAttribute("list", list);
    	model.addAttribute("ye", yeMa);
    	model.addAttribute("nid", id);
    	return "/pre/dongtaiPost";
    }
    @RequestMapping("/noteUpdate")
    @ResponseBody
    public int  noteUpdate(@RequestBody List<Note> questionList) {  //修改我的帖子
        
    	Note note = questionList.get(0);
    	
        int pd = noteService.noteUpdate(note);
    	
    	return pd;	
    }
    @RequestMapping("/noteDelete")
    @ResponseBody
    public void noteDelete(int id,HttpServletResponse response) {  //删除我的帖子		
        
    	int pd=noteService.noteDelete(id);
    	if(pd==1) {		
    		
    		commentService.deletePostComment(id);
    		
    	}
    	try {         
			response.getWriter().println(pd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
    }
    
    @RequestMapping("/noteAjaxSelect")
    @ResponseBody
    public Note noteAjaxSelect(int id) {  //ajax查询我的帖子	
        
    	 Note note = noteService.select(id);
     return note;
    }
}

