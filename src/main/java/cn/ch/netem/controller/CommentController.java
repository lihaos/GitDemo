package cn.ch.netem.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.ch.netem.pojo.Comment;
import cn.ch.netem.pojo.User;
import cn.ch.netem.service.CommentService;

@Controller
public class CommentController { 
  
 @Autowired
  private CommentService  comment;
 

 
 @RequestMapping("/comment")
 public String  selectComment(int id) { //查看全部评论
	 
	 List<Comment>list=comment.selectComment(id);
	 for (Comment comment : list) {
		System.out.println(comment.getContent());
	}
	 return "";
 }
 
 @RequestMapping("/CommentInsert")       //对帖子进行评论
 public ModelAndView insert(Comment comment) {
	 User user=(User) SecurityUtils.getSubject().getPrincipal();
	 comment.setUserId(user.getUserId());
	 comment.setCreatedate(new java.sql.Date(new Date().getTime()));
	 System.out.println(new java.sql.Date(new Date().getTime()));
	 
	 this.comment.insert(comment);
	 return new ModelAndView("redirect:/query?noteId="+comment.getNoteId());
 }
 @RequestMapping("/CommentSelect")       //查询要删除的评论和帖子
 public String select(Model model,@RequestParam(value="yeMa",defaultValue="1",required=false)int yeMa) {
     
     User user=(User) SecurityUtils.getSubject().getPrincipal();

	 List<Comment> list = comment.myselect(user.getUserId(),yeMa,5);
    
	int count = comment.count(user.getUserId());
	int total = count%5==0?count/5:count/5+1;
    model.addAttribute("list", list);
    model.addAttribute("ye", yeMa);
	model.addAttribute("total", total);
	 return "/pre/dongtaiHuif";
 }
 
 @RequestMapping("/CommentDelete")       //删除评论
 @ResponseBody
 public void delete(int id,HttpServletResponse response) {
	 
	 int pd=comment.delete(id);
	 try {
		response.getWriter().println(pd);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  
 }
}
