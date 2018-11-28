package cn.ch.netem.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.ch.netem.pojo.UserTestPaper;

public interface UserTestPaperService {
	boolean addUserTestPaper(UserTestPaper paper);
	
	UserTestPaper selectByUserTestPaperId(int userTestPaperId);
	
	List<UserTestPaper> selectByUserId(String testPaperTtile,int pageNo, int userId);
	
	int getUserTestPaperCount(String testPaperTtile,int userId);
}
