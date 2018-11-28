package cn.ch.netem.controller;

import java.io.PrintWriter;
import java.io.Reader;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

import cn.ch.netem.pojo.Subject;
import cn.ch.netem.service.SubjectService;

@Controller
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@RequestMapping("selectSubjectList")
	public void selectSubjectList(HttpServletResponse response) {
		List<Subject> subjectList = subjectService.getSubjectList();
		String json = JSON.toJSONString(subjectList);
		PrintWriter printWriter = null;
		try {
			response.setContentType("text/html;charset=UTF-8");
			printWriter = response.getWriter();
			printWriter.print(json);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if (printWriter!=null) {
				printWriter.flush();
		        printWriter.close();
			}
		}
	}
}
