package cn.ch.netem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.ch.netem.configuration.ShiroConfiguration;
import cn.ch.netem.pojo.Question;
import cn.ch.netem.pojo.TestPaper;
import cn.ch.netem.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping("selectTestPaper")
	public String selectTestPaper(@RequestParam(value="paperTitle",required=false)String paperTitle,
			@RequestParam(value="pageNo",required=false,defaultValue="1")int pageNo,Model model) {
		List<TestPaper> paperList = new ArrayList<TestPaper>();
		
		paperList = testService.getTestPaperList(paperTitle,pageNo);
		int paperCount = testService.getTestPaperCount(paperTitle);
		int pageTotal = paperCount%3==0?paperCount/3:paperCount/3+1;
		
		model.addAttribute("pageNum", pageNo);
		model.addAttribute("pageTotal", pageTotal);
		model.addAttribute("paperList", paperList);
		model.addAttribute("paperSize", paperList.size());
		model.addAttribute("paperTitle", paperTitle);
		return "/pre/home-categories-description";
		
	}
	/*
	@ResponseBody
	@RequestMapping("/testdemo")
	public String Demo(HttpSession session)
	{
		List<TestPaper> paperList = testService.getTestPaperList(null);
		for (TestPaper testPaper : paperList) {
			System.out.println(testPaper.getTestPaperTitle());
			System.out.println(testPaper.getSubject().getSubjectName());
			List<Question> listQuestion = testPaper.getQuestionList();  
			for (Question question : listQuestion) {
				System.out.println(question.getTitle());
			}
		}
		return paperList.size()+"";
	}*/
	
}
