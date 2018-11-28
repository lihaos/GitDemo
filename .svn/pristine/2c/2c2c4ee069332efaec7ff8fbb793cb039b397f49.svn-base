package cn.ch.netem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import cn.ch.netem.pojo.Answer;
import cn.ch.netem.pojo.Page;
import cn.ch.netem.pojo.Question;
import cn.ch.netem.pojo.TestPaper;
import cn.ch.netem.pojo.UserTestPaper;
import cn.ch.netem.pojo.UserTestPaperQuestion;
import cn.ch.netem.service.AnswerService;
import cn.ch.netem.service.QuestionService;
import cn.ch.netem.service.UserTestPaperQuestionService;

@Controller
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private AnswerService answerService;

	@RequestMapping("selectTestQuestion")
	private String selectTestQuestion(@RequestParam(value="paperId",required = false) int paperId,
			@RequestParam(value="subjectId",required = false)int subjectId,
			@RequestParam(value="level",required = false)int level,
			@RequestParam("userTestPaper")String userTestPaper,
			Model model,HttpSession session) {
		TestPaper paper = new TestPaper();
		paper.setTestPaperId(paperId);
		List<Question> listQuestion = questionService.getQuestionByTestId(paper);
		model.addAttribute("listQuestion", listQuestion);
		model.addAttribute("questionQuantity", listQuestion.size());
		session.setAttribute("action","online");
		model.addAttribute("subjectId", subjectId);
		model.addAttribute("level", level);
		model.addAttribute("userTestPaper", userTestPaper);
		return "/pre/dati";
	}

	/*@ResponseBody randomTest
	@RequestMapping("/testdemo")
	public String Demo(HttpSession session) {
		TestPaper paper = new TestPaper();
		paper.setTestPaperId(1);
		List<Question> listQuestion = questionService.getQuestionByTestId(paper);
		for (Question question : listQuestion) {
			System.out.println(question.getTitle());
			System.out.println(question.getSubject().getSubjectName());
			List<Answer> listAnswer = question.getAnswerList();
			for (Answer answer : listAnswer) {
				System.out.println(answer.getContent());
			}
		}
		return listQuestion.size() + "";

	}*/
	@RequestMapping("randomTest")
	private String randomTest(
			@RequestParam(value="subject",required = false)int subjectId,
			@RequestParam(value="level",required = false)int level,
			@RequestParam(value="questionQuantityRandom",required = false)int questionQuantity,
			Model model,HttpSession session) {
		List<Question> listQuestion = questionService.getQuestionByRand(subjectId, level, questionQuantity);
		for (Question question : listQuestion) {
			question.setAnswerList(answerService.selectByQuestion(question.getQuestionId()));
		}
		
		
		model.addAttribute("listQuestion", listQuestion);
		model.addAttribute("questionQuantity", listQuestion.size());
		session.setAttribute("action","random");
		model.addAttribute("subjectId", subjectId);
		model.addAttribute("level", level);
		return "/pre/dati";
	}
	
	@ResponseBody
	@RequestMapping("findQuestion")
	private Map getQuestionList(@RequestParam(value="title",required=false)String title,
			@RequestParam(value="pageIndex",required=false,defaultValue="1")int pageIndex) {
		Page page = new Page();
		page.setCurrentPage(pageIndex);
		List<Question> questionList = questionService.getQuestionList(title, page);
		Map map = new HashMap();
		map.put("questionList", questionList);
		map.put("page", page);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("findQuestionCount")
	private int findQuestionCount(@RequestParam(value="title",required=false)String title) {
		return questionService.getQuestionCount(title);
		
	}
	
	
	@ResponseBody
	@RequestMapping("deleteQuestion")
	private int deleteQuestion(@RequestParam(value="questionId",required=false)int questionId) {
		int delAnswerCount = answerService.deleteAnswer(questionId);
		int delQuestionCount = 0;
		if (delAnswerCount>=4) {
			delQuestionCount = questionService.deleteQuestion(questionId);
		}
		return delQuestionCount;
		
	}
	
	@ResponseBody
	@RequestMapping("selectQuestion")
	private Question selectQuestion(@RequestParam(value="questionId",required=false)int questionId) {
		Question question = questionService.selectByQuestionId(questionId);
		return question;
	}
	
	@ResponseBody
	@RequestMapping("updateQuestion")
	private int updateQuestion(@RequestBody List<Question> questionList) {
		Question question = questionList.get(0);		
		List<Answer> answer = question.getAnswerList();
		int flag = 0;
		for (Answer ans : answer) {
			flag+=answerService.updateAnswer(ans);
		}
		int count = 0;
		if (flag>=4) {
			count = questionService.updateQuestion(question);
		}
		return count;
	}
	
	@ResponseBody
	@RequestMapping("insertQuestion")
	private int insertQuestion(@RequestBody List<Question> questionList) {
		Question question = questionList.get(0);		
		List<Answer> answerList = question.getAnswerList();
		int count = 0;
		if (questionService.insertQuestion(question)>0) {
			for (Answer answer : answerList) {
				answer.setQuestionId(question.getQuestionId());
				count+=answerService.insertAnswer(answer);
			}
		}
		return count;
	}
}
